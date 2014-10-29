/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.Usuario;
import java.util.List;

/**
 *
 * @author maryelen_cassia
 */
public interface UsuarioDao {

    public void salvar(Usuario cliente);

    public List<Usuario> getAll();

    public void deletar(int idCliente);

    public Usuario getById(int idCliente);

}
