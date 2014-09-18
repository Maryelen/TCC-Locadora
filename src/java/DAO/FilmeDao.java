/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.Filme;

/**
 *
 * @author maryelen_cassia
 */
public interface FilmeDao {

    public void salvar(Filme filme);
    
    public void getAll();

}
