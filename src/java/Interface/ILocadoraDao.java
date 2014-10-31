/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Entity.Locadora;
import java.util.List;

/**
 *
 * @author maryelen_cassia
 */
public interface ILocadoraDao {

    public int salvar(Locadora locadora);

    public List<Locadora> getAll();

    public boolean deletar(int id);

    public Locadora getById(int id);

    public boolean update(Locadora locadora);
}
