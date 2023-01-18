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
public class clientsModelTest {
    
    public clientsModelTest() {
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
     * Test of getClientId method, of class clientsModel.
     */
    @Test
    public void testGetClientId() {
        System.out.println("getClientId");
        clientsModel instance = new clientsModel();
        int expResult = 0;
        int result = instance.getClientId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setClientId method, of class clientsModel.
     */
    @Test
    public void testSetClientId() {
        System.out.println("setClientId");
        int ClientId = 0;
        clientsModel instance = new clientsModel();
        instance.setClientId(ClientId);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getFirstName method, of class clientsModel.
     */
    @Test
    public void testGetFirstName() {
        System.out.println("getFirstName");
        clientsModel instance = new clientsModel();
        String expResult = "";
        String result = instance.getFirstName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setFirstName method, of class clientsModel.
     */
    @Test
    public void testSetFirstName() {
        System.out.println("setFirstName");
        String FirstName = "";
        clientsModel instance = new clientsModel();
        instance.setFirstName(FirstName);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getLastName method, of class clientsModel.
     */
    @Test
    public void testGetLastName() {
        System.out.println("getLastName");
        clientsModel instance = new clientsModel();
        String expResult = "";
        String result = instance.getLastName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setLastName method, of class clientsModel.
     */
    @Test
    public void testSetLastName() {
        System.out.println("setLastName");
        String LastName = "";
        clientsModel instance = new clientsModel();
        instance.setLastName(LastName);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getIdentification method, of class clientsModel.
     */
    @Test
    public void testGetIdentification() {
        System.out.println("getIdentification");
        clientsModel instance = new clientsModel();
        String expResult = "";
        String result = instance.getIdentification();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setIdentification method, of class clientsModel.
     */
    @Test
    public void testSetIdentification() {
        System.out.println("setIdentification");
        String Identification = "";
        clientsModel instance = new clientsModel();
        instance.setIdentification(Identification);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getAddress method, of class clientsModel.
     */
    @Test
    public void testGetAddress() {
        System.out.println("getAddress");
        clientsModel instance = new clientsModel();
        String expResult = "";
        String result = instance.getAddress();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setAddress method, of class clientsModel.
     */
    @Test
    public void testSetAddress() {
        System.out.println("setAddress");
        String Address = "";
        clientsModel instance = new clientsModel();
        instance.setAddress(Address);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of displayAllClients method, of class clientsModel.
     */
    @Test
    public void testDisplayAllClients() {
        System.out.println("displayAllClients");
        clientsModel instance = new clientsModel();
        instance.displayAllClients();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of createClient method, of class clientsModel.
     */
    @Test
    public void testCreateClient() {
        System.out.println("createClient");
        Connection con = null;
        clientsModel instance = new clientsModel();
        instance.createClient(con);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of updateClientInfo method, of class clientsModel.
     */
    @Test
    public void testUpdateClientInfo() {
        System.out.println("updateClientInfo");
        String fname = "";
        String lname = "";
        String identification = "";
        String address = "";
        int clientId = 0;
        clientsModel instance = new clientsModel();
        instance.updateClientInfo(fname, lname, identification, address, clientId);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
