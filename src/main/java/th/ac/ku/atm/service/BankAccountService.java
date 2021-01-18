package th.ac.ku.atm.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import th.ac.ku.atm.model.BankAccount;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class BankAccountService {
//    private List<BankAccount> bankAccountList;
//    @PostConstruct
//    public void postConstruct(){
//        this.bankAccountList = new ArrayList<>();
//    }
//
//    public void createBankAccount(BankAccount bankAccount){
//        bankAccountList.add(bankAccount);
//    }
//
//    public List<BankAccount> getBankAccounts(){
//        return new ArrayList<>(this.bankAccountList);
//    }
    private RestTemplate restTemplate;

    public BankAccountService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<BankAccount> getCustomerBankAccounts(int customerId){
        //connect to bank account api service
        String url = "http://localhost:8091/api/bankaccount/customer/" + customerId;
        ResponseEntity<BankAccount[]> response = restTemplate.getForEntity(url, BankAccount[].class);
        BankAccount[] accounts = response.getBody();
        return Arrays.asList(accounts);
    }
}
