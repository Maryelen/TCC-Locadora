/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import DAO.AcessoDaoMySql;
import DAO.FilmeDao;
import DAO.FilmeDaoMySql;
import Entity.Acesso;
import Entity.Filme;
import java.util.List;

/**
 *
 * @author jorge_filho
 */
public class FacadeAcesso {

    public void validarAcesso(Acesso acesso) {
        if ((acesso.getLogin() != null) && (acesso.getSenha() != null)) {
            AcessoDaoMySql dao = new AcessoDaoMySql();
            
        }
    }
}
