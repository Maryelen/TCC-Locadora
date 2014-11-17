/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.FilmeDaoMySql;
import DAO.LocadoraDaoMySql;
import Entity.Filme;
import Entity.Locadora;
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
public class ControllerFilme implements Controller {

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

    private Filme requestForm(HttpServletRequest pRequest) {

        Filme retorno = new Filme();

        if (pRequest.getParameter("txtId") != null) {
            retorno.setId(Integer.parseInt(pRequest.getParameter("txtId")));
        }

        if (pRequest.getParameter("txtIdLocadora") != null) {
            retorno.getLocadora().setId(Integer.parseInt(pRequest.getParameter("txtIdLocadora")));
        }

        if (pRequest.getParameter("txtNome") != null) {
            retorno.setNome(pRequest.getParameter("txtNome"));
        }

        if (pRequest.getParameter("txtDescricao") != null) {
            retorno.setDescricao(pRequest.getParameter("txtDescricao"));
        }

        if (pRequest.getParameter("txtAno") != null) {
            retorno.setAno(Integer.parseInt(pRequest.getParameter("txtAno")));
        }

        if (pRequest.getParameter("txtAno") != null) {
            retorno.setGenero(pRequest.getParameter("txtGenero"));
        }

        return retorno;
    }

    @Override
    public void principal(HttpServletRequest pRequest, HttpServletResponse pResponse) throws ServletException, IOException {

        RequestDispatcher rd = pRequest.getRequestDispatcher("/cadastrarFilme.jsp");
        rd.forward(pRequest, pResponse);

    }

    @Override
    public void salvar(HttpServletRequest pRequest, HttpServletResponse pResponse) throws ServletException, IOException {

        FilmeDaoMySql filmeDao = new FilmeDaoMySql();
        Filme filme = requestForm(pRequest);

        int retorno = filmeDao.salvar(filme);

        if (retorno > 0) {
            mostraAlertMsg(pRequest, pResponse, "OK", "Cadastro de Filme", "Registro salvo com sucesso!", "filme", "listar");
        } else {
            mostraAlertMsg(pRequest, pResponse, "ERRO", "Cadastro de Filme", "Erro ao salvar o registro, por favor, tente novamente!", "filme", "listar");
        }
    }

    @Override
    public void alterar(HttpServletRequest pRequest, HttpServletResponse pResponse) throws ServletException, IOException {
        FilmeDaoMySql filmeDao = new FilmeDaoMySql();
        Filme filme = requestForm(pRequest);

        boolean retorno = filmeDao.update(filme);

        if (retorno) {
            mostraAlertMsg(pRequest, pResponse, "OK", "Alteração de Filme", "Registro salvo com sucesso!", "filme", "listar");
        } else {
            mostraAlertMsg(pRequest, pResponse, "ERRO", "Alteração de Filme", "Erro ao salvar o registro, por favor, tente novamente!", "filme", "listar");
        }

    }

    @Override
    public void deletar(HttpServletRequest pRequest, HttpServletResponse pResponse) throws ServletException, IOException {

        FilmeDaoMySql filmeDao = new FilmeDaoMySql();
        Filme filme = requestForm(pRequest);

        boolean retorno = filmeDao.deletar(filme.getId());

        if (retorno) {
            mostraAlertMsg(pRequest, pResponse, "OK", "Excluir de Filme", "Registro excluido com sucesso!", "filme", "listar");
        } else {
            mostraAlertMsg(pRequest, pResponse, "ERRO", "Excluir de Filme", "Erro ao excluir o registro, por favor, tente novamente!", "filme", "listar");
        }
    }

    @Override
    public void listar(HttpServletRequest pRequest, HttpServletResponse pResponse) throws ServletException, IOException {

        FilmeDaoMySql filmeDao = new FilmeDaoMySql();
        List<Filme> lista = filmeDao.getAll();

        if (lista != null) {

            List<Map> resultado = new ArrayList<Map>();

            for (Filme filme : lista) {
                HashMap<String, String> map = new HashMap<String, String>();
                map.put("id", (filme.getId()) + "");
                map.put("nome", filme.getNome());
                map.put("descricao", filme.getDescricao());
                map.put("Ano", filme.getAno()+"");
                map.put("Genero", filme.getGenero());
                map.put("nomeLocadora", filme.getLocadora().getNome());
                map.put("telefoneComercial", filme.getLocadora().getTelefoneComercial());
                resultado.add(map);

            }

            pRequest.setAttribute("filmes", resultado);

            RequestDispatcher rd = pRequest.getRequestDispatcher("/listarFilmes.jsp");
            rd.forward(pRequest, pResponse);

        } else {
            mostraAlertMsg(pRequest, pResponse, "ERRO", "Lista de Filme", "Erro ao localizar os registros, por favor, tente novamente!", "filme", "principal");
        }

    }

    @Override
    public void detalhe(HttpServletRequest pRequest, HttpServletResponse pResponse) throws ServletException, IOException {

        FilmeDaoMySql filmeDao = new FilmeDaoMySql();

        Filme filme = filmeDao.getById(requestForm(pRequest).getId());

        if (filme != null) {

            HashMap<String, String> map = new HashMap<String, String>();
            map.put("id", (filme.getId()) + "");
            map.put("nome", filme.getNome());
            map.put("descricao", filme.getDescricao());
            map.put("Ano", filme.getAno()+"");
            map.put("Genero", filme.getGenero());
            map.put("nomeLocadora", filme.getLocadora().getNome());
            map.put("telefoneComercial", filme.getLocadora().getTelefoneComercial());

            pRequest.setAttribute("filme", map);

            RequestDispatcher rd = pRequest.getRequestDispatcher("/editarFilme.jsp");
            rd.forward(pRequest, pResponse);

        } else {
            mostraAlertMsg(pRequest, pResponse, "ERRO", "Detalhe de Filme", "Erro ao localizar o registro, por favor, tente novamente!", "filme", "principal");
        }

    }
}
