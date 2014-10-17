/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.Cliente;
import java.util.List;

/**
 *
 * @author maryelen_cassia
 */
public interface ClienteDao {

    public void salvar(Cliente cliente);

    public List<Cliente> getAll();

    public void deletar(int idCliente);

    public Cliente getById(int idCliente)throws ClassNotFoundException;

}
