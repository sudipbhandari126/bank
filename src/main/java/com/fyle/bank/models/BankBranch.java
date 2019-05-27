package com.fyle.bank.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "BANK_BRANCHES")
public class BankBranch {
    @Id
    private String ifsc;

    private Long bankId;

    private String bankName;

    private String state;

    private String district;

    private String city;

    private String address;

    private String branch;

}
