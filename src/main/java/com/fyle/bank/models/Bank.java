package com.fyle.bank.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "BANKS")
public class Bank {
    @javax.persistence.Id
    private Long Id;
    private String name;
}
