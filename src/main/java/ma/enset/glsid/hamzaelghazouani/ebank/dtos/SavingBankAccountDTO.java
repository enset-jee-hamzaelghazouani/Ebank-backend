package ma.enset.glsid.hamzaelghazouani.ebank.dtos;

import lombok.Data;
import ma.enset.glsid.hamzaelghazouani.ebank.enums.AccountStatus;

import java.util.Date;
@Data
public class SavingBankAccountDTO extends BankAccountDTO {
    private String id;
    private double balance;
    private Date createdAt;
    private AccountStatus status;
    private CustomerDTO customerDTO;
    private double interestRate;
}
