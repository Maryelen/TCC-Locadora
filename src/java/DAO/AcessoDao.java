/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import Entity.Acesso;

/**
 *
 * @author maryelen_cassia
 */
public interface AcessoDao {
    
    public void salvar(Acesso acesso);

    public void deletar(int idAcesso);

    public Acesso getById(int idAcesso)throws ClassNotFoundException;
    
}
