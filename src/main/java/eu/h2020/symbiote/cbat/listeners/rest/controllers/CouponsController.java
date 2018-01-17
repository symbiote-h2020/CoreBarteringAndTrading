package eu.h2020.symbiote.cbat.listeners.rest.controllers;

import eu.h2020.symbiote.cbat.listeners.rest.interfaces.ICoupons;
import eu.h2020.symbiote.cbat.models.Coupon;
import eu.h2020.symbiote.cbat.services.CouponService;
import io.swagger.annotations.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Coupon controller
 *
 * @author jamsellem
 */

@RestController
public class CouponsController implements ICoupons {

    private static Log logger = LogFactory.getLog(CouponsController.class);

    @Autowired
    private CouponService couponService;

    @ApiOperation(value = "Notify the core that a coupon has been created")
    @ApiResponses({
            @ApiResponse(code = 404, message = "Invalid coupon!"),
            @ApiResponse(code = 200, message = "success")})
    public ResponseEntity<Void> notifyCouponCreation(
            @RequestBody
            @ApiParam(value = "Request required coupon", required = true)
                Coupon coupon) {

        if (couponService.createCoupon(coupon) != null ){
            return new ResponseEntity<Void>(HttpStatus.OK);
        }

        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);

    }



    @ApiOperation(value = "Validate if the coupon is still usable")
    @ApiResponses({
            @ApiResponse(code = 404, message = "Coupon not be found!"),
            @ApiResponse(code = 200, message = "success")})
    public ResponseEntity<Boolean> validateCoupon(
            @RequestBody
            @ApiParam(value = "Request required coupon", required = true)
                Coupon coupon) {

        Coupon c = couponService.findByIdentifier(coupon.getcIdentifier());

        if ( c!= null ){
            // if cannot be used
            if ((c.isSingleUse() && c.getUsedByList().size()>0) || c.getExpirationDate().after(new Date())){
                return new ResponseEntity<Boolean>(false, null, HttpStatus.OK);
            }else{
                return new ResponseEntity<Boolean>(true, null, HttpStatus.OK);
            }
        }

        return new ResponseEntity<Boolean>(false, null, HttpStatus.NOT_FOUND);
    }



    @ApiOperation(value = "Notify the Core B&T that the coupon has been used, so that it is possible for a centralized entity can validate which coupons have been used or not.")
    @ApiResponses({
            @ApiResponse(code = 404, message = "Coupon not be found!"),
            @ApiResponse(code = 400, message = "Invalid coupon!"),
            @ApiResponse(code = 200, message = "success")})
    public ResponseEntity<Void> useCoupon(
            @RequestBody
            @ApiParam(value = "Request required coupon", required = true)
                    Coupon coupon,
            @PathVariable
            @ApiParam(value = "Request required user identifier", required = true)
                    String userIdentifier) {

        Coupon c = couponService.findByIdentifier(coupon.getcIdentifier());
        if ( c!= null ){

            if ((c.isSingleUse() && c.getUsedByList().size()>0) || c.getExpirationDate().after(new Date())){
                return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
            }
            c.addToUsedByList(userIdentifier);
            couponService.update(c);

            return new ResponseEntity<Void>(HttpStatus.OK);
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }



    public ResponseEntity<Coupon> couponUsageStatistic() {
        Coupon c = couponService.findByIdentifier("1");

        return new ResponseEntity<Coupon>(c, null, HttpStatus.OK);
    }
}

