package ma.enset.glsid.hamzaelghazouani.ebankapp.repositories;

import ma.enset.glsid.hamzaelghazouani.ebankapp.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {
}
