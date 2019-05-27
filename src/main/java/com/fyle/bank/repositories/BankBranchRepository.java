package com.fyle.bank.repositories;

import com.fyle.bank.models.BankBranch;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BankBranchRepository extends JpaRepository<BankBranch, String> {
    List<BankBranch> findByBankNameAndCity(String bankName,String city);
}
