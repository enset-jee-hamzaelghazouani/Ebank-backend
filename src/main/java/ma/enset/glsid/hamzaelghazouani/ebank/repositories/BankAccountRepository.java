package ma.enset.glsid.hamzaelghazouani.ebank.repositories;

import ma.enset.glsid.hamzaelghazouani.ebank.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccount,String> {
}
