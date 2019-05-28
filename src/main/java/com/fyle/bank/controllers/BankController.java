package com.fyle.bank.controllers;

import com.fyle.bank.models.Bank;
import com.fyle.bank.models.BankBranch;
import com.fyle.bank.models.Branch;
import com.fyle.bank.services.BankService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Response;
import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
public class BankController {

    @Autowired
    BankService bankService;

    @GetMapping("/banks")
    public ResponseEntity<List<Bank>> getBanks(){
        List<Bank> banks = bankService.fetchAllBanks();
        return banks.isEmpty()?ResponseEntity.noContent().build():
                ResponseEntity.ok(banks);
    }


    @GetMapping("/branches")
    public ResponseEntity<List<Branch>> getBranches(){
        List<Branch> branches = bankService.fetchAllBranches();
        return branches.isEmpty()?ResponseEntity.noContent().build():
                ResponseEntity.ok(branches);
    }

    @GetMapping("/banks/{bankId}")
    public ResponseEntity<Bank> getBank(@PathVariable("bankId") Long bankId){
        Optional<Bank> bankById = bankService.findBankById(bankId);
        return bankById.isPresent()?ResponseEntity.ok(bankById.get()):
                ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/banks/ifsc/{ifscCode}")
    public ResponseEntity<Branch> getBranch(@PathVariable("ifscCode") String ifscCode){
        Optional<Branch> branch = bankService.branchByIfsc(ifscCode);
        return branch.isPresent()?ResponseEntity.ok(branch.get()):
                ResponseEntity.noContent().build();
    }


    @GetMapping("/banks/{city}/{bankName}")
    public ResponseEntity<List<BankBranch>> getBankBranches(@PathVariable("city") String city,
                                                     @PathVariable("bankName") String bankName){
        List<BankBranch> bankBranches = bankService.fetchBankBranches(city, bankName);
        return bankBranches.isEmpty()?ResponseEntity.noContent().build():
                ResponseEntity.ok(bankBranches);
    }


}
