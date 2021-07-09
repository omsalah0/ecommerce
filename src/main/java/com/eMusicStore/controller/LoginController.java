package com.eMusicStore.controller;

import com.eMusicStore.entity.BillingAddress;
import com.eMusicStore.entity.Customer;
import com.eMusicStore.entity.ShoppingAddress;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class LoginController {

    @RequestMapping("/loginPage")
    public String getLoginUrl() {
        return "loginForm";
    }


}
