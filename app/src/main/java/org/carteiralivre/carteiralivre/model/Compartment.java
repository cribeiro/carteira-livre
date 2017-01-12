package org.carteiralivre.carteiralivre.model;


import java.io.Serializable;
import java.math.BigDecimal;

public class Compartment implements Serializable {
    private Long id;
    private String name;
    private BigDecimal balance;
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
