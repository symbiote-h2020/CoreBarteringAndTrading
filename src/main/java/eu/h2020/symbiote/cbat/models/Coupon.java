package eu.h2020.symbiote.cbat.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import eu.h2020.symbiote.cbat.validation.NotEmpty;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;
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

    /**
     * coupon identifier
     */
    @Id
    @NotEmpty
    public String id;

    /**
     * user history
     */
    @NotNull
    private List<String> usedBy;

    /**
     * (platformId): Who issued the coupon.
     */
    @NotEmpty
    private String issuer;

    /**
     * (platformId) (optional): Who is the beneficiary of the coupon. This is an optional field and, if left as such, it can be passed around through several platforms
     */
    private String beneficiary;

    /**
     * (federationId): The federation this coupon belongs to
     */
    @NotEmpty
    private String fedIdentifier;

    /**
     * Type of resources being bartered
     */
    @NotEmpty
    private String resourceType;

    /**
     * Expiry date of the coupon
     */
    @NotNull
    private Date expirationDate;

    /**
     * Boolean indicating if the coupon can be used only once, or several times
     */
    @NotEmpty
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

    public Date getExpirationDate() {
        if (expirationDate == null) {
            expirationDate = new Date(0);
        }
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) { this.expirationDate = expirationDate; }

    public boolean isSingleUse() { return singleUse; }

    public void setSingleUse(boolean singleUse) { this.singleUse = singleUse; }

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
