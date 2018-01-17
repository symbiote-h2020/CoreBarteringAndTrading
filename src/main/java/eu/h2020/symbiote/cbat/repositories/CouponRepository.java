package eu.h2020.symbiote.cbat.repositories;

import eu.h2020.symbiote.cbat.models.Coupon;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Coupon  repository
 *
 * @author jamsellem
 */
public interface CouponRepository extends MongoRepository<Coupon, String> {
    public Coupon findByCIdentifier(String cIdentifier);
}
