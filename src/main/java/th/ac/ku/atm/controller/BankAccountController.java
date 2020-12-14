package th.ac.ku.atm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import th.ac.ku.atm.model.BankAccount;
import th.ac.ku.atm.service.BankAccountService;
import th.ac.ku.atm.service.CustomerService;

import java.util.ArrayList;

@Controller
@RequestMapping("/bankaccount")
public class BankAccountController {

    private BankAccountService accountService;

    public BankAccountController(BankAccountService bankAccountService) {
        this.accountService = bankAccountService;
    }

    @GetMapping
    public String getAllBankAccount(Model model) {
        model.addAttribute("allBankAccount", accountService.getBankAccount());
        return "bankaccount";
    }

    @PostMapping
    public String registerBankAccount(@ModelAttribute BankAccount bankAccount, Model model) {
        accountService.createBankAccount(bankAccount);
        model.addAttribute("allBankAccount", accountService.getBankAccount());
        return "redirect:bankaccount";
    }

}
