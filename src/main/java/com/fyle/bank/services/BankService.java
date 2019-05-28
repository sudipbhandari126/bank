package com.fyle.bank.services;

import com.fyle.bank.models.Bank;
import com.fyle.bank.models.BankBranch;
import com.fyle.bank.models.Branch;
import com.fyle.bank.repositories.BankBranchRepository;
import com.fyle.bank.repositories.BankRepository;
import com.fyle.bank.repositories.BranchRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class BankService {
    @Autowired
    BranchRepository branchRepository;

    @Autowired
    BankRepository bankRepository;

    @Autowired
    BankBranchRepository bankBranchRepository;


    public List<Bank> fetchAllBanks() {
        List<Bank> all = bankRepository.findAll();
        log.info("fetching all the bank details");
        return all;
    }

    public List<Branch> fetchAllBranches() {
        List<Branch> all = branchRepository.findAll();
        log.info("fetching all the  branch details");
        return all;
    }

    public Optional<Bank> findBankById(Long bankId) {
        log.info("fetching bank details with id {}",bankId);
        return bankRepository.findById(bankId);
    }

    public Optional<Branch> branchByIfsc(String ifscCode) {
        log.info("fetching branch details for ifsc: {}", ifscCode);
        return branchRepository.findById(ifscCode);
    }

    public List<BankBranch> fetchBankBranches(String city, String bankName) {
        log.info("fetching bank and branch details for city: {} and bankName: {}",city,bankName);
        return bankBranchRepository.findByBankNameAndCity(bankName,city);
    }
}
