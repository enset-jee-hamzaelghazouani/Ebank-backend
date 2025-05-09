package ma.enset.glsid.hamzaelghazouani.ebankapp.services;

import lombok.AllArgsConstructor;
import ma.enset.glsid.hamzaelghazouani.ebankapp.entities.AccountOperation;
import ma.enset.glsid.hamzaelghazouani.ebankapp.entities.BankAccount;
import ma.enset.glsid.hamzaelghazouani.ebankapp.entities.Customer;
import ma.enset.glsid.hamzaelghazouani.ebankapp.enums.OperationType;
import ma.enset.glsid.hamzaelghazouani.ebankapp.exceptions.CustomerNotFoundException;
import ma.enset.glsid.hamzaelghazouani.ebankapp.repositories.AccountOperationRepository;
import ma.enset.glsid.hamzaelghazouani.ebankapp.repositories.BankAccountRepository;
import ma.enset.glsid.hamzaelghazouani.ebankapp.repositories.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class BankAccountServiceImpl implements BankAccountService {
    private final BankAccountRepository bankAccountRepository;
    private final CustomerRepository customerRepository;
    private AccountOperationRepository accountOperationRepository;
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public Customer saveCustomer(Customer customer) {
        log.info("Saving customer : {}",customer);
        return customerRepository.save(customer);
    }

    @Override
    public BankAccount saveBankAccount(double initialBalance, String type, Long customerId) throws CustomerNotFoundException {
        Customer customer = customerRepository.findById(customerId).orElse(null);
        if(customer == null) throw new CustomerNotFoundException("Customer not found");
        BankAccount bankAccount = new BankAccount();
        bankAccount.setBalance(initialBalance);
        bankAccount.setCreateAt(null);
        bankAccount.setStatus(null);
        bankAccount.setCustomer(customer);
        log.info("Saving bank account : {}",bankAccount);
        return bankAccountRepository.save(bankAccount);
    }

    @Override
    public List<Customer> findAllCustomers() {
        log.info("Finding all customers");
        return customerRepository.findAll();
    }

    @Override
    public BankAccount findBankAccountById(Long id) {
        log.info("Finding bank account by id : {}",id);
        return bankAccountRepository.findById(id).orElse(null);

    }

    @Override
    public void debit(Long id, double amount) {
        BankAccount bankAccount = findBankAccountById(id);
        if (bankAccount.getBalance() < amount) throw new IllegalArgumentException("Insufficient balance");
        AccountOperation accountOperation = new AccountOperation();
        accountOperation.setType(OperationType.DEBIT);
        accountOperation.setAmount(amount);
        accountOperation.setBankAccount(bankAccount);
        accountOperationRepository.save(accountOperation);
        log.info("Debiting amount : {} from account : {}",amount,bankAccount);
    }

    @Override
    public void credit(Long id, double amount) {
        BankAccount bankAccount = findBankAccountById(id);
        AccountOperation accountOperation = new AccountOperation();
        accountOperation.setType(OperationType.CREDIT);
        accountOperation.setAmount(amount);
        accountOperation.setBankAccount(bankAccount);
        accountOperationRepository.save(accountOperation);
        log.info("Crediting amount : {} to account : {}",amount,bankAccount);
    }

    @Override
    public void transfer(Long id, double amount, Long targetId) {
        debit(id,amount);
        credit(targetId,amount);
        log.info("Transferred amount : {} from account : {} to account : {}",amount,id,targetId);
    }
}
