package org.carteiralivre.carteiralivre.model;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;


public class CompartmentTest {
    private Compartment compartment = new Compartment();

    @Test
    public void setBalance_ThreeDecimalDigits_RoundToTwoDecimalDigits() throws Exception {
        compartment.setBalance(new BigDecimal("23.450"));
        assertEquals("23.45", compartment.getBalance().toString());
    }

    @Test
    public void setBalance_ThreeDecimalDigits_RoundUpToTwoDecimalDigits() throws Exception {
        compartment.setBalance(new BigDecimal("23.456"));
        assertEquals("23.46", compartment.getBalance().toString());

        compartment.setBalance(new BigDecimal("23.455"));
        assertEquals("23.46", compartment.getBalance().toString());

        compartment.setBalance(new BigDecimal("23.454"));
        assertEquals("23.45", compartment.getBalance().toString());
    }

}