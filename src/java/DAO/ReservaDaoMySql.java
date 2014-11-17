/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.Reserva;
import Interface.IReservaDao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author maryelen_cassia
 */
public class ReservaDaoMySql implements IReservaDao {

    public int salvar(Reserva reserva) {
        Connection conn = null;
        PreparedStatement stmt = null;

        int resultado = -1;

        try {
            conn = Conexao.conectar();
            String QUERY_INSERT = "insert into reserva (idUsuario, idFilmeLocadora"
                    + ",situacao, dtCancelamento, dtConcluido, dtConfirmado,motivo, dtReserva)"
                    + " values(?, ?, ?, ?, ?, ?, ?, ?)";

            stmt = conn.prepareStatement(QUERY_INSERT, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, reserva.getId());
            stmt.setInt(2, reserva.getLocadora().getId());
            stmt.setInt(2, reserva.getUsuario().getId());
            stmt.setString(3, reserva.getSituacao());
            stmt.setDate(4, (Date) reserva.getDtCancelado());
            stmt.setDate(5, (Date) reserva.getDtConcluido());
            stmt.setDate(6, (Date) reserva.getDtConfirmacao());
            stmt.setString(7, reserva.getMotivo());

            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            resultado = rs.getInt(1);

            conn.close();

        } catch (SQLException ex) {

            //ex.printStackTrace();
            resultado = -1;

        } finally {

            return resultado;
        }
    }

    public boolean deletar(int id) {
        Connection conn = null;
        PreparedStatement ps = null;
        boolean resultado = false;

        try {
            conn = Conexao.conectar();

            String QUERY_DELETE = "delete from reserva where idReserva = ?";

            PreparedStatement stmt = conn.prepareStatement(QUERY_DELETE);
            stmt.setInt(1, id);

            stmt.executeUpdate();
            conn.close();

            resultado = true;

            return resultado;
        } catch (SQLException ex) {

            //ex.printStackTrace();
            resultado = false;

        } finally {

            return resultado;
        }

    }

    public List<Reserva> getAll() {
        Connection conn = null;
        ResultSet rs = null;
        List<Reserva> lista = null;
        try {
            conn = Conexao.conectar();

            String QUERY_DETALHE = "select idReserva, idUsuario, idFilmeLocadora, situacao,"
                    + "dtReserva, dtConfirmado, dtConcluido, dtCancelado, motivo from reserva ";

            PreparedStatement stmt = conn.prepareStatement(QUERY_DETALHE);
            rs = stmt.executeQuery();

            lista = new ArrayList<Reserva>();

            while (rs.next()) {
                Reserva reserva = new Reserva();
                reserva.setId(rs.getInt("idReserva"));
                UsuarioDaoMySql daoUsuario = new UsuarioDaoMySql();
                reserva.setUsuario(daoUsuario.getById(rs.getInt("idUsuario")));
                LocadoraDaoMySql daoLocadora = new LocadoraDaoMySql();
                reserva.setLocadora(daoLocadora.getById(rs.getInt("idLocadora")));
                reserva.setSituacao(rs.getString("situacao"));
                reserva.setDtReserva(rs.getDate("dtReserva"));
                reserva.setDtConfirmacao(rs.getDate("dtConfirmado"));
                reserva.setDtConcluido(rs.getDate("dtConcluido"));
                reserva.setDtCancelado(rs.getDate("dtCancelado"));
                reserva.setMotivo(rs.getString("motivo"));

                lista.add(reserva);
            }

            conn.close();

        } catch (SQLException ex) {
            //ex.printStackTrace();
        } finally {

            return lista;
        }

    }

    public Reserva getById(int id) {

        Connection conn = null;
        Reserva reserva = null;
        try {
            conn = Conexao.conectar();

            String QUERY_DETALHE = "select idReserva, idUsuario, idFilmeLocadora, situacao,"
                    + " dtReserva, dtConfirmado, dtConcluido, dtCancelado, motivo "
                    + "from reserva where idUsuario = ?";

            PreparedStatement stmt = conn.prepareStatement(QUERY_DETALHE);
            stmt.setInt(1, id);

            ResultSet rs = null;

            rs = stmt.executeQuery();

            while (rs.next()) {

                reserva = new Reserva();
                reserva.setId(rs.getInt("idReserva"));
                UsuarioDaoMySql daoUsuario = new UsuarioDaoMySql();
                reserva.setUsuario(daoUsuario.getById(rs.getInt("idUsuario")));
                LocadoraDaoMySql daoLocadora = new LocadoraDaoMySql();
                reserva.setLocadora(daoLocadora.getById(rs.getInt("idLocadora")));
                reserva.setSituacao(rs.getString("situacao"));
                reserva.setDtReserva(rs.getDate("dtReserva"));
                reserva.setDtConfirmacao(rs.getDate("dtConfirmado"));
                reserva.setDtConcluido(rs.getDate("dtConcluido"));
                reserva.setDtCancelado(rs.getDate("dtCancelado"));
                reserva.setMotivo(rs.getString("motivo"));

            }

            conn.close();
        } catch (SQLException ex) {
            //ex.printStackTrace();
        } finally {

            return reserva;
        }
    }

    public boolean update(Reserva reserva) {

        boolean resultado = false;

        try {
            PreparedStatement stmt = null;
            Connection conn = Conexao.conectar();
            String QUERY_UPDATE = "update reserva set idUsuario = ?, idLocadora = ?"
                    + " situacao = ?, dtCancelamento = ?, dtConcluido =?, dtConfirmacao = ?,"
                    + " dtReserva = ? , motivo = ? where idReserva = ?";

            stmt = conn.prepareStatement(QUERY_UPDATE);
            stmt.setInt(1, reserva.getUsuario().getId());
            stmt.setInt(2, reserva.getLocadora().getId());
            stmt.setString(3, reserva.getSituacao());
            stmt.setDate(4, (Date) reserva.getDtCancelado());
            stmt.setDate(5, (Date) reserva.getDtConcluido());
            stmt.setDate(6, (Date) reserva.getDtConfirmacao());
            stmt.setDate(7, (Date) reserva.getDtReserva());
            stmt.setString(8, reserva.getMotivo());
            
            if (reserva.getId() == null) {
                stmt.setString(9, null);
            } else {
                stmt.setInt(9, reserva.getId());
            }

            stmt.executeUpdate();
            conn.close();

            resultado = true;

        } catch (SQLException ex) {

            //ex.printStackTrace();
            resultado = false;

        } finally {

            return resultado;
        }

    }
}
