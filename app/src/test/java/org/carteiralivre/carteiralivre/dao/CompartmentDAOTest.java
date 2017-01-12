package org.carteiralivre.carteiralivre.dao;

import org.carteiralivre.carteiralivre.BuildConfig;
import org.carteiralivre.carteiralivre.model.Compartment;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import java.math.BigDecimal;
import java.util.List;

import static android.os.Build.VERSION_CODES.M;
import static org.junit.Assert.assertEquals;


@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk=M)
public class CompartmentDAOTest {

    private CompartmentDAO compartmentDAO;

    @Before
    public void setUp() throws Exception {
        System.out.println("=== Setting up for a test");
        compartmentDAO = new CompartmentDAO(RuntimeEnvironment.application);

        System.out.println("==== 1. Removing all initial compartments");
        compartmentDAO.getWritableDatabase().delete(CompartmentDAO.TABLE_NAME, null, null);
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("=== Tearing down a test");
        compartmentDAO.close();
    }

    @Test
    public void onCreate_ShouldHaveInitialCompartmentsSetUp() throws Exception {

    }

    @Test
    public void add_ShouldSaveACompartment() throws Exception {
        Compartment newCompartment = new Compartment();
        newCompartment.setName("Coin compartment");
        newCompartment.setBalance(new BigDecimal("42.89"));
        newCompartment.setDescription("Compartment for a few coins");

        Long id = compartmentDAO.add(newCompartment);
        Compartment savedCompartment = compartmentDAO.findById(id);

        assertEquals(id, savedCompartment.getId());
        assertEquals(newCompartment.getName(), savedCompartment.getName());
        assertEquals(newCompartment.getBalance().toString(),
                savedCompartment.getBalance().toString());
        assertEquals(newCompartment.getDescription(), savedCompartment.getDescription());
    }

    @Test
    public void removeAll_ShouldDeleteAllCompartments() throws Exception {
        addTwoCompartments();
        int removedItens = compartmentDAO.removeAll();
        assertEquals("2", String.valueOf(removedItens));
    }

    private void addTwoCompartments(){
        Compartment firstCompartment = new Compartment();
        firstCompartment.setName("Saving compartment");
        firstCompartment.setBalance(new BigDecimal("600.00"));
        firstCompartment.setDescription(
                "Savings of an everyday normal guy: https://youtu.be/5PsnxDQvQpw");
        compartmentDAO.add(firstCompartment);

        Compartment secondCompartment = new Compartment();
        secondCompartment.setName("Cash compartment");
        secondCompartment.setBalance(new BigDecimal("12.00"));
        firstCompartment.setDescription("12 bucks/hour. That's all an everyday normal guy needs.");
        compartmentDAO.add(secondCompartment);
    }


}