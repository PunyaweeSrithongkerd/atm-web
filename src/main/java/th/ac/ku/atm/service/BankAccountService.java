package th.ac.ku.atm.service;

import org.springframework.http.ResponseEntity;
import th.ac.ku.atm.model.BankAccount;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BankAccountService {
    private List<BankAccount> bankAccountList;

    private RestTemplate restTemplate;

    public BankAccountService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<BankAccount> getCustomerBankAccount(int customerId) {
        String url = "http://localhost:8080/api/bankaccount/customer/" +
                customerId;
        ResponseEntity<BankAccount[]> response =
                restTemplate.getForEntity(url, BankAccount[].class);

        BankAccount[] accounts = response.getBody();

        return Arrays.asList(accounts);
    }


    @PostConstruct
    public void postConstruct() {
        this.bankAccountList = new ArrayList<>();
    }

    public void createBankAccount(BankAccount bankAccount) {
        bankAccountList.add(bankAccount);
    }

    public List<BankAccount> getBankAccount() {
        return new ArrayList<>(this.bankAccountList);
    }
    }

