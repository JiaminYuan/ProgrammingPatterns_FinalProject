/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankmanagement.model;

import java.sql.Connection;
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
public class transactionsModelTest {
    
    public transactionsModelTest() {
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
     * Test of getTransactionId method, of class transactionsModel.
     */
    @Test
    public void testGetTransactionId() {
        System.out.println("getTransactionId");
        transactionsModel instance = new transactionsModel();
        int expResult = 0;
        int result = instance.getTransactionId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setTransactionId method, of class transactionsModel.
     */
    @Test
    public void testSetTransactionId() {
        System.out.println("setTransactionId");
        int TransactionId = 0;
        transactionsModel instance = new transactionsModel();
        instance.setTransactionId(TransactionId);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getToAccountNumber method, of class transactionsModel.
     */
    @Test
    public void testGetToAccountNumber() {
        System.out.println("getToAccountNumber");
        transactionsModel instance = new transactionsModel();
        int expResult = 0;
        int result = instance.getToAccountNumber();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setToAccountNumber method, of class transactionsModel.
     */
    @Test
    public void testSetToAccountNumber() {
        System.out.println("setToAccountNumber");
        int ToAccountNumber = 0;
        transactionsModel instance = new transactionsModel();
        instance.setToAccountNumber(ToAccountNumber);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getFromAccountNumber method, of class transactionsModel.
     */
    @Test
    public void testGetFromAccountNumber() {
        System.out.println("getFromAccountNumber");
        transactionsModel instance = new transactionsModel();
        int expResult = 0;
        int result = instance.getFromAccountNumber();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setFromAccountNumber method, of class transactionsModel.
     */
    @Test
    public void testSetFromAccountNumber() {
        System.out.println("setFromAccountNumber");
        int FromAccountNumber = 0;
        transactionsModel instance = new transactionsModel();
        instance.setFromAccountNumber(FromAccountNumber);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getTransactionDetail method, of class transactionsModel.
     */
    @Test
    public void testGetTransactionDetail() {
        System.out.println("getTransactionDetail");
        transactionsModel instance = new transactionsModel();
        String expResult = "";
        String result = instance.getTransactionDetail();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setTransactionDetail method, of class transactionsModel.
     */
    @Test
    public void testSetTransactionDetail() {
        System.out.println("setTransactionDetail");
        String TransactionDetail = "";
        transactionsModel instance = new transactionsModel();
        instance.setTransactionDetail(TransactionDetail);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getValue method, of class transactionsModel.
     */
    @Test
    public void testGetValue() {
        System.out.println("getValue");
        transactionsModel instance = new transactionsModel();
        int expResult = 0;
        int result = instance.getValue();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setValue method, of class transactionsModel.
     */
    @Test
    public void testSetValue() {
        System.out.println("setValue");
        int Value = 0;
        transactionsModel instance = new transactionsModel();
        instance.setValue(Value);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of createTransaction method, of class transactionsModel.
     */
    @Test
    public void testCreateTransaction() {
        System.out.println("createTransaction");
        Connection con = null;
        transactionsModel instance = new transactionsModel();
        instance.createTransaction(con);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of verifyAccountNum method, of class transactionsModel.
     */
    @Test
    public void testVerifyAccountNum() {
        System.out.println("verifyAccountNum");
        int acc = 0;
        transactionsModel instance = new transactionsModel();
        instance.verifyAccountNum(acc);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of makeTransaction method, of class transactionsModel.
     */
    @Test
    public void testMakeTransaction() {
        System.out.println("makeTransaction");
        int fromAcc = 0;
        int toAcc = 0;
        int amt = 0;
        transactionsModel instance = new transactionsModel();
        instance.makeTransaction(fromAcc, toAcc, amt);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of deposit method, of class transactionsModel.
     */
    @Test
    public void testDeposit() {
        System.out.println("deposit");
        int newBal = 0;
        int accNum = 0;
        transactionsModel instance = new transactionsModel();
        instance.deposit(newBal, accNum);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of withdraw method, of class transactionsModel.
     */
    @Test
    public void testWithdraw() {
        System.out.println("withdraw");
        int newBal = 0;
        int accNum = 0;
        transactionsModel instance = new transactionsModel();
        instance.withdraw(newBal, accNum);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }
    
}
