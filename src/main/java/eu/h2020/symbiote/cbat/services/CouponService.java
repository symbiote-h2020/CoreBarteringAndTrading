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
        return couponRepo.save(cupon);
    }

    public Coupon findByIdentifier(String identifier){
        return couponRepo.findByCIdentifier(identifier);
    }

    public Coupon update(Coupon coupon){
        return couponRepo.save(coupon);
    }


}
