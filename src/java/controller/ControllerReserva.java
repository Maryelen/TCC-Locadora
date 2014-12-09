/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.FilmeDaoMySql;
import DAO.LocadoraDaoMySql;
import DAO.ReservaDaoMySql;
import Entity.Filme;
import Entity.Locadora;
import Entity.Reserva;
import Entity.Usuario;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Andre
 */
public class ControllerReserva implements Controller {

    private void mostraAlertMsg(HttpServletRequest pRequest, HttpServletResponse pResponse, String pTipo, String pTitulo, String pTexto, String pFormulario, String pAcao) throws ServletException, IOException {

        if (pTipo == "OK") {
            pTipo = "alert-success";
        } else if (pTipo == "INFO") {
            pTipo = "alert-info";
        } else if (pTipo == "ERRO") {
            pTipo = "alert-danger";
        } else {
            pTipo = "alert-warning";
        }

        pRequest.setAttribute("tipo", pTipo);
        pRequest.setAttribute("titulo", pTitulo);
        pRequest.setAttribute("texto", pTexto);
        pRequest.setAttribute("objeto", pFormulario);
        pRequest.setAttribute("metodo", pAcao);

        RequestDispatcher rd = pRequest.getRequestDispatcher("/mensagemAlerta.jsp");
        rd.forward(pRequest, pResponse);
    }

    private void mostraMsg(HttpServletRequest pRequest, HttpServletResponse pResponse, String pTipo, String pTitulo, String pTexto) throws ServletException, IOException {
        if (pTipo == "OK") {
            pTipo = "alert-success";
        } else if (pTipo == "INFO") {
            pTipo = "alert-info";
        } else if (pTipo == "ERRO") {
            pTipo = "alert-danger";
        } else {
            pTipo = "alert-warning";
        }

        pRequest.setAttribute("Tipo", pTipo);
        pRequest.setAttribute("titulo", pTitulo);
        pRequest.setAttribute("texto", pTexto);

        RequestDispatcher rd = pRequest.getRequestDispatcher("/mensagem.jsp");
        rd.forward(pRequest, pResponse);
    }

    private Reserva requestForm(HttpServletRequest pRequest) {

        Filme retorno = new Filme();
        retorno.setLocadora(new Locadora());

        FilmeDaoMySql dao = new FilmeDaoMySql();

        if (pRequest.getParameter("txtId") != null) {
            retorno.setId(Integer.parseInt(pRequest.getParameter("txtId")));
        }

        retorno = dao.getById(retorno.getId());
        Usuario usuario = (Usuario) pRequest.getSession().getAttribute("usuarioLogin");

        Reserva reserva = new Reserva();
        reserva.setFilme(retorno);
        reserva.setUsuario(usuario);
        reserva.setSituacao("Pendente");
        reserva.setMotivo("");

        return reserva;
    }

    @Override
    public void principal(HttpServletRequest pRequest, HttpServletResponse pResponse) throws ServletException, IOException {

        RequestDispatcher rd = pRequest.getRequestDispatcher("/cadastrarFilme.jsp");
        rd.forward(pRequest, pResponse);

    }

    @Override
    public void salvar(HttpServletRequest pRequest, HttpServletResponse pResponse) throws ServletException, IOException {

        ReservaDaoMySql dao = new ReservaDaoMySql();

        Reserva reserva = requestForm(pRequest);

        int retorno = dao.salvar(reserva);

        if (retorno > 0) {
            mostraAlertMsg(pRequest, pResponse, "OK", "Reserva", "Registro salvo com sucesso!", "reserva", "listar");
        } else {
            mostraAlertMsg(pRequest, pResponse, "ERRO", "Reserva", "Erro ao salvar o registro, por favor, tente novamente!", "reserva", "listar");
        }
    }

    @Override
    public void alterar(HttpServletRequest pRequest, HttpServletResponse pResponse) throws ServletException, IOException {
        ReservaDaoMySql dao = new ReservaDaoMySql();
        Reserva reserva = requestForm(pRequest);

        boolean retorno = dao.update(reserva);

        if (retorno) {
            mostraAlertMsg(pRequest, pResponse, "OK", "Alteração de Filme", "Registro salvo com sucesso!", "filme", "listar");
        } else {
            mostraAlertMsg(pRequest, pResponse, "ERRO", "Alteração de Filme", "Erro ao salvar o registro, por favor, tente novamente!", "filme", "listar");
        }

    }

    @Override
    public void deletar(HttpServletRequest pRequest, HttpServletResponse pResponse) throws ServletException, IOException {

        ReservaDaoMySql dao = new ReservaDaoMySql();
        Reserva reserva = requestForm(pRequest);

        boolean retorno = dao.deletar(reserva.getId());

        if (retorno) {
            mostraAlertMsg(pRequest, pResponse, "OK", "Excluir de Filme", "Registro excluido com sucesso!", "filme", "listar");
        } else {
            mostraAlertMsg(pRequest, pResponse, "ERRO", "Excluir de Filme", "Erro ao excluir o registro, por favor, tente novamente!", "filme", "listar");
        }
    }

    @Override
    public void listar(HttpServletRequest pRequest, HttpServletResponse pResponse) throws ServletException, IOException {

        FilmeDaoMySql dao = new FilmeDaoMySql();
        ReservaDaoMySql daoReserva = new ReservaDaoMySql();
        List<Filme> lista = dao.getAll();

        if (lista != null) {

            List<Map> resultado = new ArrayList<Map>();

            for (Filme filme : lista) {
                int qnt = daoReserva.getByNaoReservado(filme.getId());
                if (qnt < filme.getQuantidade()) {
                    HashMap<String, String> map = new HashMap<String, String>();
                    map.put("id", (filme.getId()) + "");
                    map.put("nome", filme.getNome());
                    map.put("descricao", filme.getDescricao());
                    map.put("ano", filme.getAno() + "");
                    map.put("genero", filme.getGenero());
                    map.put("nomeLocadora", filme.getLocadora().getNome());
                    map.put("quantidade", (filme.getQuantidade() - qnt) + "");
                    map.put("situacao", filme.getSituacao());
                    resultado.add(map);
                }

            }

            pRequest.setAttribute("filmes", resultado);

            RequestDispatcher rd = pRequest.getRequestDispatcher("/listarFilmesReserva.jsp");
            rd.forward(pRequest, pResponse);

        } else {
            mostraAlertMsg(pRequest, pResponse, "ERRO", "Lista de Filme", "Erro ao localizar os registros, por favor, tente novamente!", "filme", "principal");
        }

    }

    @Override
    public void detalhe(HttpServletRequest pRequest, HttpServletResponse pResponse) throws ServletException, IOException {

        LocadoraDaoMySql daoLoc = new LocadoraDaoMySql();
        ReservaDaoMySql dao = new ReservaDaoMySql();
        Usuario resultado =  (Usuario) pRequest.getSession().getAttribute("usuarioLogin");
        Locadora locadora = daoLoc.getById(resultado.getNome());
        
        
        List<Reserva> reservas = new ArrayList<>();
        if(resultado.getTipoUsuario().equals("comum")){
        reservas = dao.getByIdUsuario(resultado.getId());
        }else{
        reservas = dao.getByIdLocadora(locadora.getId());    
        }

        List<Map> lista = new ArrayList<Map>();

        if (reservas != null) {
            for (Reserva reserva : reservas) {

                HashMap<String, String> map = new HashMap<String, String>();
                map.put("id", (reserva.getId()) + "");
                map.put("nomeFilme", reserva.getFilme().getNome());
                map.put("genero", reserva.getFilme().getGenero());
                map.put("nomeLocadora", reserva.getLocadora().getNome());
                map.put("situacao", reserva.getSituacao());
                lista.add(map);
            }

            pRequest.setAttribute("reservas", lista);
            RequestDispatcher rd = pRequest.getRequestDispatcher("/minhasReservas.jsp");
            rd.forward(pRequest, pResponse);

        } else {
            mostraAlertMsg(pRequest, pResponse, "ERRO", "Detalhe de Filme", "Erro ao localizar o registro, por favor, tente novamente!", "reserva", "principal");
        }

    }

    public void getByReserva(HttpServletRequest pRequest, HttpServletResponse pResponse) throws ServletException, IOException {

        ReservaDaoMySql dao = new ReservaDaoMySql();
        Reserva reserva = dao.getById(requestForm(pRequest).getId());

        if (reserva != null) {

            HashMap<String, String> map = new HashMap<String, String>();
            map.put("id", (reserva.getId()) + "");
            map.put("nomeFilme", reserva.getFilme().getNome());
            map.put("nomeLocadora", reserva.getLocadora().getNome());
            map.put("nomeUsuario", reserva.getUsuario().getNome());

            pRequest.setAttribute("filme", map);

            RequestDispatcher rd = pRequest.getRequestDispatcher("/editarFilme.jsp");
            rd.forward(pRequest, pResponse);

        } else {
            mostraAlertMsg(pRequest, pResponse, "ERRO", "Detalhe de Filme", "Erro ao localizar o registro, por favor, tente novamente!", "filme", "principal");
        }

    }

    public void getByReservaLocadora(HttpServletRequest pRequest, HttpServletResponse pResponse) throws ServletException, IOException {
        Usuario retorno = (Usuario) pRequest.getSession().getAttribute("usuarioLogin");
        ReservaDaoMySql dao = new ReservaDaoMySql();
        LocadoraDaoMySql daoLoc = new LocadoraDaoMySql();
        Locadora locadora = daoLoc.getById(retorno.getNome());
        Reserva reserva = dao.getById(locadora.getId());

        if (reserva != null) {

            HashMap<String, String> map = new HashMap<String, String>();
            map.put("id", (reserva.getId()) + "");
            map.put("nomeFilme", reserva.getFilme().getNome());
            map.put("nomeLocadora", reserva.getLocadora().getNome());
            map.put("nomeUsuario", reserva.getUsuario().getNome());

            pRequest.setAttribute("filme", map);

            RequestDispatcher rd = pRequest.getRequestDispatcher("/editarFilme.jsp");
            rd.forward(pRequest, pResponse);

        } else {
            mostraAlertMsg(pRequest, pResponse, "ERRO", "Detalhe de Filme", "Erro ao localizar o registro, por favor, tente novamente!", "filme", "principal");
        }

    }
}
