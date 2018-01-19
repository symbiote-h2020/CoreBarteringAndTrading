package eu.h2020.symbiote.cbat.services;

import eu.h2020.symbiote.cbat.models.Coupon;
import eu.h2020.symbiote.cbat.repositories.CouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Coupon service
 *
 * @author jamsellem
 */
@Service
public class CouponService {

    @Autowired
    private CouponRepository couponRepo;


    public List<Coupon> getCoupons(){
        return couponRepo.findAll();
    }

    public Coupon createCoupon(Coupon cupon){
        try{
            return couponRepo.save(cupon);
        }catch (javax.validation.ConstraintViolationException ex){
            return null;
        }

    }

    public Coupon findById(String id){
        return couponRepo.findById(id);
    }

    public Coupon update(Coupon coupon){
        return couponRepo.save(coupon);
    }


}
