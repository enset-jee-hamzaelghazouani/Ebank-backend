package ma.enset.glsid.hamzaelghazouani.ebankapp.repositories;

import ma.enset.glsid.hamzaelghazouani.ebankapp.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}

