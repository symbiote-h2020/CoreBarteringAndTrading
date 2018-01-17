package eu.h2020.symbiote.cbat.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.Id;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Coupon model
 *
 * @author jamsellem
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Coupon {

    @Id
    public String id;

    /**
     * coupon identifier
     */
    private String cIdentifier;

    /**
     * user history
     */
    private List<String> usedBy;

    /**
     * (platformId): Who issued the coupon.
     */
    private String issuer;

    /**
     * (platformId) (optional): Who is the beneficiary of the coupon. This is an optional field and, if left as such, it can be passed around through several platforms
     */
    private String beneficiary;

    /**
     * (federationId): The federation this coupon belongs to
     */
    private String fedIdentifier;

    /**
     * Type of resources being bartered
     */
    private String resourceType;

    /**
     * Expiry date of the coupon
     */
    private Date expirationDate;

    /**
     * Boolean indicating if the coupon can be used only once, or several times
     */
    private boolean singleUse;




    public String getId(){ return id;}

    public String getIssuer() { return issuer; }

    public void setIssuer(String issuer) { this.issuer = issuer; }

    public String getBeneficiary() { return beneficiary; }

    public void setBeneficiary(String beneficiary) { this.beneficiary = beneficiary; }

    public String getFedIdentifier() { return fedIdentifier; }

    public void setFedIdentifier(String fedIdentifier) { this.fedIdentifier = fedIdentifier; }

    public String getResourceType() { return resourceType; }

    public void setResourceType(String resourceType) { this.resourceType = resourceType; }

    public Date getExpirationDate() { return expirationDate; }

    public void setExpirationDate(Date expirationDate) { this.expirationDate = expirationDate; }

    public boolean isSingleUse() { return singleUse; }

    public void setSingleUse(boolean singleUse) { this.singleUse = singleUse; }

    public String getcIdentifier() { return cIdentifier; }

    public void setcIdentifier(String cIdentifier) { this.cIdentifier = cIdentifier; }

    public List<String> getUsedByList() {
        if(usedBy == null){
            usedBy = new ArrayList<>();
        }
        return usedBy;
    }

    public void addToUsedByList(String usedBy) {
        if(this.usedBy == null){
            this.usedBy = new ArrayList<>();
        }
        this.usedBy.add(usedBy);
    }
}
