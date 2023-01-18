/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankmanagement.model;

import java.sql.Connection;
import java.sql.Date;
import java.time.LocalDate;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 14388
 */
public class accountsModelTest {
    
    public accountsModelTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getAccountNumber method, of class accountsModel.
     */
    @Test
    public void testGetAccountNumber() {
        System.out.println("getAccountNumber");
        accountsModel instance = new accountsModel();
        int expResult = 0;
        int result = instance.getAccountNumber();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of setAccountNumber method, of class accountsModel.
     */
    @Test
    public void testSetAccountNumber() {
        System.out.println("setAccountNumber");
        int AccountNumber = 0;
        accountsModel instance = new accountsModel();
        instance.setAccountNumber(AccountNumber);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getAccountType method, of class accountsModel.
     */
    @Test
    public void testGetAccountType() {
        System.out.println("getAccountType");
        accountsModel instance = new accountsModel();
        String expResult = "";
        String result = instance.getAccountType();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of setAccountType method, of class accountsModel.
     */
    @Test
    public void testSetAccountType() {
        System.out.println("setAccountType");
        String AccountType = "";
        accountsModel instance = new accountsModel();
        instance.setAccountType(AccountType);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getOpenDate method, of class accountsModel.
     */
    @Test
    public void testGetOpenDate() {
        System.out.println("getOpenDate");
        accountsModel instance = new accountsModel();
        Date expResult = null;
        Date result = instance.getOpenDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of setOpenDate method, of class accountsModel.
     */
    @Test
    public void testSetOpenDate() {
        System.out.println("setOpenDate");
        Date OpenDate = null;
        accountsModel instance = new accountsModel();
        instance.setOpenDate(OpenDate);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getBalance method, of class accountsModel.
     */
    @Test
    public void testGetBalance() {
        System.out.println("getBalance");
        int AccountNumber = 0;
        accountsModel instance = new accountsModel();
        int expResult = 0;
        int result = instance.getBalance(AccountNumber);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of setBalance method, of class accountsModel.
     */
    @Test
    public void testSetBalance() {
        System.out.println("setBalance");
        int Balance = 0;
        accountsModel instance = new accountsModel();
        instance.setBalance(Balance);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of isIsActive method, of class accountsModel.
     */
    @Test
    public void testIsIsActive() {
        System.out.println("isIsActive");
        accountsModel instance = new accountsModel();
        boolean expResult = false;
        boolean result = instance.isIsActive();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of setIsActive method, of class accountsModel.
     */
    @Test
    public void testSetIsActive() {
        System.out.println("setIsActive");
        boolean isActive = false;
        accountsModel instance = new accountsModel();
        instance.setIsActive(isActive);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getClientId method, of class accountsModel.
     */
    @Test
    public void testGetClientId() {
        System.out.println("getClientId");
        accountsModel instance = new accountsModel();
        int expResult = 0;
        int result = instance.getClientId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of setClientId method, of class accountsModel.
     */
    @Test
    public void testSetClientId() {
        System.out.println("setClientId");
        int ClientId = 0;
        accountsModel instance = new accountsModel();
        instance.setClientId(ClientId);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of displayAllAccounts method, of class accountsModel.
     */
    @Test
    public void testDisplayAllAccounts() {
        System.out.println("displayAllAccounts");
        accountsModel instance = new accountsModel();
        instance.displayAllAccounts();
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of convertToDateViaSqlDate method, of class accountsModel.
     */
    @Test
    public void testConvertToDateViaSqlDate() {
        System.out.println("convertToDateViaSqlDate");
        LocalDate dateToConvert = null;
        accountsModel instance = new accountsModel();
        Date expResult = null;
        Date result = instance.convertToDateViaSqlDate(dateToConvert);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of createAccount method, of class accountsModel.
     */
    @Test
    public void testCreateAccount() {
        System.out.println("createAccount");
        Connection con = null;
        accountsModel instance = new accountsModel();
        instance.createAccount(con);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of viewAccountsTable method, of class accountsModel.
     */
    @Test
    public void testViewAccountsTable() {
        System.out.println("viewAccountsTable");
        accountsModel instance = new accountsModel();
        instance.viewAccountsTable();
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of deactivateAccount method, of class accountsModel.
     */
    @Test
    public void testDeactivateAccount() {
        System.out.println("deactivateAccount");
        accountsModel instance = new accountsModel();
        instance.deactivateAccount();
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of userInput method, of class accountsModel.
     */
    @Test
    public void testUserInput() {
        System.out.println("userInput");
        accountsModel instance = new accountsModel();
        int expResult = 0;
        int result = instance.userInput();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of verifyClientId method, of class accountsModel.
     */
    @Test
    public void testVerifyClientId() {
        System.out.println("verifyClientId");
        int cliId = 0;
        accountsModel instance = new accountsModel();
        instance.verifyClientId(cliId);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
    
}
