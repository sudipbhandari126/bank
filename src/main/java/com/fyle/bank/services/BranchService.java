package com.fyle.bank.services;

import com.fyle.bank.models.Branch;
import com.fyle.bank.repositories.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BranchService {
    @Autowired
    BranchRepository branchRepository;


    public Branch branchByIfscCode(String ifscCode) {
        return branchRepository.findById(ifscCode).get();
    }
}
