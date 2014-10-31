/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Entity.Filme;
import java.util.List;

/**
 *
 * @author maryelen_cassia
 */
public interface IFilmeDao {

    public int salvar(Filme filme);

    public List<Filme> getAll();

    public boolean deletar(int id);

    public Filme getById(int id);

    public boolean update(Filme filme);
}
