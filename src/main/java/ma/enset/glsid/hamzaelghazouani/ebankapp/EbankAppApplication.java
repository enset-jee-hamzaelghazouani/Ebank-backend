package ma.enset.glsid.hamzaelghazouani.ebankapp;

import ma.enset.glsid.hamzaelghazouani.ebankapp.entities.BankAccount;
import ma.enset.glsid.hamzaelghazouani.ebankapp.entities.CurrentAccount;
import ma.enset.glsid.hamzaelghazouani.ebankapp.entities.Customer;
import ma.enset.glsid.hamzaelghazouani.ebankapp.entities.SavingAccount;
import ma.enset.glsid.hamzaelghazouani.ebankapp.enums.AccountStatus;
import ma.enset.glsid.hamzaelghazouani.ebankapp.repositories.BankAccountRepository;
import ma.enset.glsid.hamzaelghazouani.ebankapp.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class EbankAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(EbankAppApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository, BankAccountRepository bankAccountRepository){
        return args -> {
          Stream.of("Hamza","Yassine","Ahmed").forEach(name -> {
              Customer customer = new Customer();
              customer.setName(name);
              customer.setEmail(name+"@gmail.com");
              customerRepository.save(customer);
          });

          customerRepository.findAll().forEach(
                  customer -> {
                      CurrentAccount currentAccount = new CurrentAccount();
                      currentAccount.setBalance(Math.random()*90000);
                      currentAccount.setCreateAt(new Date());
                      currentAccount.setStatus(AccountStatus.CREATED);
                      currentAccount.setCustomer(customer);
                      currentAccount.setOverDraft(9000);
                      bankAccountRepository.save(currentAccount);

                      SavingAccount savingAccount = new SavingAccount();
                      savingAccount.setBalance(Math.random()*90000);
                      savingAccount.setCreateAt(new Date());
                      savingAccount.setStatus(AccountStatus.CREATED);
                      savingAccount.setCustomer(customer);
                      savingAccount.setInterestRate(5.05);
                      bankAccountRepository.save(savingAccount);
                  }
          );
        };
    }


}
