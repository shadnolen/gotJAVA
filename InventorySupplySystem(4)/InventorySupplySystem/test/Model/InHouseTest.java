/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author shadn
 */
public class InHouseTest {
    
    public InHouseTest() {
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
     * Test of setMachineID method, of class InHouse.
     */
    @Test
    public void testSetMachineID() {
        System.out.println("setMachineID");
        int id = 0;
        InHouse instance = null;
        instance.setMachineID(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMachineID method, of class InHouse.
     */
    @Test
    public void testGetMachineID() {
        System.out.println("getMachineID");
        InHouse instance = null;
        int expResult = 0;
        int result = instance.getMachineID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
