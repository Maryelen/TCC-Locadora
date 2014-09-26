/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.Filme;
import java.util.List;

/**
 *
 * @author maryelen_cassia
 */
public interface FilmeDao {

    public void salvar(Filme filme);
    
    public List<Filme> getAll();
    
    public void excluir (int idFilme);
    
   
    public Filme getById(int id) throws ClassNotFoundException;

}
