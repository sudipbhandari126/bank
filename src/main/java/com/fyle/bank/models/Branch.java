package com.fyle.bank.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "BRANCHES")
@Data
public class Branch {
    @Id
    private String ifsc;

    private String address;

    private String city;

    private String district;

    private String state;

    @Column(insertable = false, updatable = false, name = "BANK_ID")
    private Long bankId;

    @ManyToOne
    @JoinColumn(name = "BANK_ID")
    @JsonBackReference
    private Bank bank;


}
