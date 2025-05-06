package ma.enset.glsid.hamzaelghazouani.ebankapp.entities;

import jakarta.persistence.DiscriminatorValue;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("SA")
public class SavingAccount extends BankAccount {
    private double interestRate;
}
