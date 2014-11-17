/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Entity.Usuario;
import java.util.List;

/**
 *
 * @author maryelen_cassia
 */
public interface IUsuarioDao {

    public int salvar(Usuario cliente);

    public List<Usuario> getAll();

    public boolean deletar(int idCliente);

    public Usuario getById(int idCliente);

    public boolean update(Usuario usuario);
    
}
