package eu.h2020.symbiote.cbat.listeners.rest.interfaces;

import eu.h2020.symbiote.cbat.models.Coupon;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
/**
 * Coupon controller interface
 *
 * @author jamsellem
 */

@RequestMapping("/coupon")
public interface ICoupons {

    @PostMapping("/create")
    ResponseEntity<Void> notifyCouponCreation(@RequestBody Coupon coupon);

    @PostMapping("/isvalid")
    ResponseEntity<Boolean> validateCoupon(@RequestBody Coupon coupon);

    @PostMapping("/use/{userIdentifier}")
    ResponseEntity<Void> useCoupon(@RequestBody Coupon coupon, @PathVariable String userIdentifier);

    @GetMapping("/stats")
    ResponseEntity<Coupon> couponUsageStatistic();


}
