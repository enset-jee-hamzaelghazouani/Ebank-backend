package ma.enset.glsid.hamzaelghazouani.ebankapp.controller;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.enset.glsid.hamzaelghazouani.ebankapp.entities.Customer;
import ma.enset.glsid.hamzaelghazouani.ebankapp.services.BankAccountService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
public class CustomerRestController {
    private BankAccountService bankAccountService;

    @RequestMapping("/customers")
    public List<Customer> getCustomer(){
        log.info("Customer Rest Controller");
        return bankAccountService.findAllCustomers();
    }
}
