package com.fyle.bank.controllers;

import com.fyle.bank.models.Bank;
import com.fyle.bank.models.BankBranch;
import com.fyle.bank.models.Branch;
import com.fyle.bank.repositories.BankBranchRepository;
import com.fyle.bank.repositories.BankRepository;
import com.fyle.bank.repositories.BranchRepository;
import com.fyle.bank.services.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class BankController {
    @Autowired
    BankRepository bankRepository;

    @Autowired
    BranchService branchService;

    @Autowired
    BankBranchRepository bankBranchRepository;

    @Autowired
    BranchRepository branchRepository;

    @GetMapping("/banks")
    public List<Bank> getBanks(){
    return bankRepository.findAll();
    }


    @GetMapping("/branches")
    public List<Branch> getBranches(){
        return branchRepository.findAll();
    }

    @GetMapping("/banks/{bankId}")
    public Bank getBank(@PathVariable("bankId") Long bankId){
        Optional<Bank> byId = bankRepository.findById(bankId);
        return byId.get();
    }

    @GetMapping("/banks/ifsc/{ifscCode}")
    public Branch getBranch(@PathVariable("ifscCode") String ifscCode){
       return branchService.branchByIfscCode(ifscCode);
    }


    @GetMapping("/banks/{city}/{bankName}")
    public List<BankBranch> getBankBranches(@PathVariable("city") String city,
                                            @PathVariable("bankName") String bankName){
        return bankBranchRepository.findByBankNameAndCity(bankName,city);
    }


}
