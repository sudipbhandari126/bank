package com.fyle.bank.controllers;

import com.fyle.bank.models.Bank;
import com.fyle.bank.repositories.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BankController {
    @Autowired
    BankRepository bankRepository;


    @GetMapping("/banks")
    public List<Bank> getBanks(){
    return bankRepository.findAll();
    }
}
