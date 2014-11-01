/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import DAO.LocadoraDaoMySql;
import Interface.IUsuarioDao;
import DAO.UsuarioDaoMySql;
import Entity.Locadora;
import Entity.Usuario;
import java.util.List;

/**
 *
 * @author maryelen_cassia
 */
public class FacadeReserva {

    public void salvar(Locadora locadora) {

        //falta validações de campo

        LocadoraDaoMySql dao = new LocadoraDaoMySql();
        dao.salvar(locadora);
    }

    public List<Locadora> getAll() {
        LocadoraDaoMySql dao = new LocadoraDaoMySql();
        return dao.getAll();
    }

    public void deletar(int id) {
        LocadoraDaoMySql dao = new LocadoraDaoMySql();
        dao.deletar(id);
    }

    public Locadora getById(int id) {
        LocadoraDaoMySql dao = new LocadoraDaoMySql();
        return dao.getById(id);
    }
}
