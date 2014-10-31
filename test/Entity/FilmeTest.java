/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

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
public class FilmeTest {
    
    public FilmeTest() {
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
     * Test of getIdFilme method, of class Filme.
     */
    @Test
    public void testGetIdFilme() {
        System.out.println("getIdFilme");
        Filme instance = new Filme();
        Integer expResult = null;
        Integer result = instance.getIdFilme();
        assertEquals(expResult, result);
    }

    /**
     * Test of setIdFilme method, of class Filme.
     */
    @Test
    public void testSetIdFilme() {
        System.out.println("setIdFilme");
        Integer idFilme = null;
        Filme instance = new Filme();
        instance.setIdFilme(idFilme);

    }

    /**
     * Test of getNome method, of class Filme.
     */
    @Test
    public void testGetNome() {
        System.out.println("getNome");
        Filme instance = new Filme();
        String expResult = "";
        String result = instance.getNome();
        assertEquals(expResult, result);

    }

    /**
     * Test of setNome method, of class Filme.
     */
    @Test
    public void testSetNome() {
        System.out.println("setNome");
        String nome = "";
        Filme instance = new Filme();
        instance.setNome(nome);

    }

    /**
     * Test of getDescricao method, of class Filme.
     */
    @Test
    public void testGetDescricao() {
        System.out.println("getDescricao");
        Filme instance = new Filme();
        String expResult = "";
        String result = instance.getDescricao();
        assertEquals(expResult, result);

    }

    /**
     * Test of setDescricao method, of class Filme.
     */
    @Test
    public void testSetDescricao() {
        System.out.println("setDescricao");
        String descricao = "";
        Filme instance = new Filme();
        instance.setDescricao(descricao);
    }

    /**
     * Test of getFoto method, of class Filme.
     */
    @Test
    public void testGetFoto() {
        System.out.println("getFoto");
        Filme instance = new Filme();
        String expResult = "";
        String result = instance.getFoto();
        assertEquals(expResult, result);

    }

    /**
     * Test of setFoto method, of class Filme.
     */
    @Test
    public void testSetFoto() {
        System.out.println("setFoto");
        String foto = "";
        Filme instance = new Filme();
        instance.setFoto(foto);

    }
}