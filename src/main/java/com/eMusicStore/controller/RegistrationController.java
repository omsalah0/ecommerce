package com.eMusicStore.controller;


import com.eMusicStore.Exceptions.emailAlreadyExists;
import com.eMusicStore.Exceptions.usernameAlreadyExists;
import com.eMusicStore.Services.customerService;
import com.eMusicStore.entity.BillingAddress;
import com.eMusicStore.entity.Customer;
import com.eMusicStore.entity.ShoppingAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    private final customerService customerService;

    @Autowired
    public RegistrationController(com.eMusicStore.Services.customerService customerService) {
        this.customerService = customerService;
    }


    @GetMapping()
    public String GetRegistrationUrl(Model model) {

        Customer customer = new Customer();
        BillingAddress billingAddress = new BillingAddress();
        ShoppingAddress shoppingAddress = new ShoppingAddress();
        customer.setBillingAddress(billingAddress);
        customer.setShoppingAddress(shoppingAddress);
        model.addAttribute("customer", customer);
        return "registrationForm";
    }

    @PostMapping()
    public String postRegistration(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("passwordNotMatch", "Password Not matched please rewrite again.");
            return "registrationForm";
        }

        customer.setEnabled(1);
        try {
            customerService.addCustomer(customer);
        } catch (usernameAlreadyExists exists) {
            model.addAttribute("message", exists.getMessage());
        } catch (emailAlreadyExists emailAlreadyExists) {
            model.addAttribute("message", emailAlreadyExists.getMessage());
        }


        return "successfullyRegistration";
    }
}
