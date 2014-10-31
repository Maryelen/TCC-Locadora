/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.Reserva;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jorgeluiz
 */
public class ReservaDaoMySqlTest {
    
    public ReservaDaoMySqlTest() {
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
     * Test of salvar method, of class ReservaDaoMySql.
     */
    @Test
    public void testSalvar() {
        System.out.println("salvar");
        Reserva reserva = null;
        ReservaDaoMySql instance = new ReservaDaoMySql();
        int expResult = -1;
        int result = instance.salvar(reserva);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of deletar method, of class ReservaDaoMySql.
     */
    @Test
    public void testDeletar() {
        System.out.println("deletar");
        int id = 0;
        ReservaDaoMySql instance = new ReservaDaoMySql();
        boolean expResult = true;
        boolean result = instance.deletar(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getAll method, of class ReservaDaoMySql.
     */
    @Test
    public void testGetAll() {
        System.out.println("getAll");
        ReservaDaoMySql instance = new ReservaDaoMySql();
        List expResult = null;
        List result = instance.getAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getById method, of class ReservaDaoMySql.
     */
    @Test
    public void testGetById() {
        System.out.println("getById");
        int id = 0;
        ReservaDaoMySql instance = new ReservaDaoMySql();
        Reserva expResult = null;
        Reserva result = instance.getById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of update method, of class ReservaDaoMySql.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Reserva reserva = null;
        ReservaDaoMySql instance = new ReservaDaoMySql();
        boolean expResult = false;
        boolean result = instance.update(reserva);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }
}