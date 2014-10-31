/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Entity.Reserva;
import java.util.List;

/**
 *
 * @author maryelen_cassia
 */
public interface IReservaDao {

    public int salvar(Reserva reserva);

    public List<Reserva> getAll();

    public boolean deletar(int id);

    public Reserva getById(int id);

    public boolean update(Reserva reserva);
}
