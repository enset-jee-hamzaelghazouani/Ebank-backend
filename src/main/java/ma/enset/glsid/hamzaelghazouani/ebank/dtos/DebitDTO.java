package ma.enset.glsid.hamzaelghazouani.ebank.dtos;

import lombok.Data;

@Data
public class DebitDTO {
    private String accountId;
    private double amount;
    private String description;
}
