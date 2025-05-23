package ma.enset.glsid.hamzaelghazouani.ebankapp.repositories;

import ma.enset.glsid.hamzaelghazouani.ebankapp.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}

