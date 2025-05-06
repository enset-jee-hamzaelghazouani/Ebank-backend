package ma.enset.glsid.hamzaelghazouani.ebankapp.repositories;

import ma.enset.glsid.hamzaelghazouani.ebankapp.entities.AccountOperation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountOperationRepository extends JpaRepository<AccountOperation, Long> {
}
