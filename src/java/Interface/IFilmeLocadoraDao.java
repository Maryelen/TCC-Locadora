/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Entity.Filme;
import Entity.FilmeLocadora;
import java.util.List;

/**
 *
 * @author maryelen_cassia
 */
public interface IFilmeLocadoraDao {

    public int salvar(FilmeLocadora filmeLocadora);

    public List<FilmeLocadora> getAll();

    public boolean deletar(int id);

    public FilmeLocadora getById(int id);

    public boolean update(FilmeLocadora filmeLocadora);
}
