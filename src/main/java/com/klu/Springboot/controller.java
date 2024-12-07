package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    private List<String> customers = new ArrayList<>(); // In-memory list for simplicity

    @GetMapping("/getAllCustomers")
    public String getAllCustomers(Model model) {
        model.addAttribute("customers", customers);
        return "customerList"; // Points to `customerList.html`
    }

    @GetMapping("/register")
    public String registerCustomerForm(Model model) {
        model.addAttribute("customerName", "");
        return "registerCustomer"; // Points to `registerCustomer.html`
    }

    @PostMapping("/save")
    public String saveCustomer(@RequestParam("name") String name) {
        customers.add(name);
        return "redirect:/customer/getAllCustomers";
    }

    @PostMapping("/delete")
    public String deleteCustomer(@RequestParam("name") String name) {
        customers.remove(name);
        return "redirect:/customer/getAllCustomers";
    }
}
