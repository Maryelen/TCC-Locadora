/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.LocadoraDaoMySql;
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
public class ControllerLocadora implements Controller {

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

    private Locadora requestForm(HttpServletRequest pRequest) {

        Locadora retorno = new Locadora();

        if (pRequest.getParameter("txtId") != null) {
            retorno.setId(Integer.parseInt(pRequest.getParameter("txtId")));
        }

        if (pRequest.getParameter("txtNome") != null) {
            retorno.setNome(pRequest.getParameter("txtNome"));
        }

        if (pRequest.getParameter("txtCnpj") != null) {
            retorno.setEmail(pRequest.getParameter("txtCnpj"));
        }

        if (pRequest.getParameter("txtRua") != null) {
            retorno.setEmail(pRequest.getParameter("txtRua"));
        }

        if (pRequest.getParameter("txtNumero") != null) {
            retorno.setEmail(pRequest.getParameter("txtNumero"));
        }

        if (pRequest.getParameter("txtComplemento") != null) {
            retorno.setEmail(pRequest.getParameter("txtComplemento"));
        }

        if (pRequest.getParameter("txtBairro") != null) {
            retorno.setEmail(pRequest.getParameter("txtBairro"));
        }

        if (pRequest.getParameter("txtCidade") != null) {
            retorno.setEmail(pRequest.getParameter("txtCidade"));
        }
        if (pRequest.getParameter("txtEstado") != null) {
            retorno.setEmail(pRequest.getParameter("txtEstado"));
        }

        if (pRequest.getParameter("txtCep") != null) {
            retorno.setEmail(pRequest.getParameter("txtCep"));
        }

        if (pRequest.getParameter("txtTelefoneComercial") != null) {
            retorno.setEmail(pRequest.getParameter("txtTelefoneComercial"));
        }

        if (pRequest.getParameter("txtTelefoneContato") != null) {
            retorno.setEmail(pRequest.getParameter("txtTelefoneContato"));
        }

        if (pRequest.getParameter("txtEmail") != null) {
            retorno.setEmail(pRequest.getParameter("txtEmail"));
        }


        if (pRequest.getParameter("txtSite") != null) {
            retorno.setEmail(pRequest.getParameter("txtSite"));
        }

        return retorno;
    }

    @Override
    public void principal(HttpServletRequest pRequest, HttpServletResponse pResponse) throws ServletException, IOException {

        RequestDispatcher rd = pRequest.getRequestDispatcher("/cadastrarLocadora.jsp");
        rd.forward(pRequest, pResponse);

    }

    @Override
    public void salvar(HttpServletRequest pRequest, HttpServletResponse pResponse) throws ServletException, IOException {

        LocadoraDaoMySql locadoraDao = new LocadoraDaoMySql();
        Locadora locadora = requestForm(pRequest);

        int retorno = locadoraDao.salvar(locadora);

        if (retorno > 0) {
            mostraAlertMsg(pRequest, pResponse, "OK", "Cadastro de Locadora", "Registro salvo com sucesso!", "locadora", "listar");
        } else {
            mostraAlertMsg(pRequest, pResponse, "ERRO", "Cadastro de Locadora", "Erro ao salvar o registro, por favor, tente novamente!", "locadora", "listar");
        }
    }

    @Override
    public void alterar(HttpServletRequest pRequest, HttpServletResponse pResponse) throws ServletException, IOException {
        LocadoraDaoMySql locadoraDao = new LocadoraDaoMySql();
        Locadora locadora = requestForm(pRequest);

        boolean retorno = locadoraDao.update(locadora);

        if (retorno) {
            mostraAlertMsg(pRequest, pResponse, "OK", "Alteração de Locadora", "Registro salvo com sucesso!", "locadora", "listar");
        } else {
            mostraAlertMsg(pRequest, pResponse, "ERRO", "Alteração de Locadora", "Erro ao salvar o registro, por favor, tente novamente!", "locadora", "listar");
        }

    }

    @Override
    public void deletar(HttpServletRequest pRequest, HttpServletResponse pResponse) throws ServletException, IOException {

        LocadoraDaoMySql locadoraDao = new LocadoraDaoMySql();
        Locadora locadora = requestForm(pRequest);

        boolean retorno = locadoraDao.deletar(locadora.getId());

        if (retorno) {
            mostraAlertMsg(pRequest, pResponse, "OK", "Excluir de Locadora", "Registro excluido com sucesso!", "locadora", "listar");
        } else {
            mostraAlertMsg(pRequest, pResponse, "ERRO", "Excluir de Locadora", "Erro ao excluir o registro, por favor, tente novamente!", "locadora", "listar");
        }
    }

    @Override
    public void listar(HttpServletRequest pRequest, HttpServletResponse pResponse) throws ServletException, IOException {

        LocadoraDaoMySql locadoraDao = new LocadoraDaoMySql();
        List<Locadora> lista = locadoraDao.getAll();

        if (lista != null) {

            List<Map> resultado = new ArrayList<Map>();

            for (Locadora locadora : lista) {

                HashMap<String, String> map = new HashMap<String, String>();
                map.put("id", Integer.toString(locadora.getId()));
                map.put("nome", locadora.getNome());
                map.put("Cnpj", locadora.getCnpj());
                map.put("rua", locadora.getRua());
                map.put("numero", locadora.getNumero()+"");
                map.put("complemento", locadora.getComplemento());
                map.put("bairro", locadora.getBairro());
                map.put("cidade", locadora.getCidade());
                map.put("estado", locadora.getEstado());
                map.put("cep", locadora.getCep());
                map.put("telefoneComercial", locadora.getTelefoneComercial());
                map.put("telefoneContato", locadora.getTelefoneContato());
                map.put("email", locadora.getEmail());
                map.put("site", locadora.getSite());
                resultado.add(map);

            }

            pRequest.setAttribute("locadora", resultado);

            RequestDispatcher rd = pRequest.getRequestDispatcher("/listarLocadoras.jsp");
            rd.forward(pRequest, pResponse);

        } else {
            mostraAlertMsg(pRequest, pResponse, "ERRO", "Lista de Locadora", "Erro ao localizar os registros, por favor, tente novamente!", "locadora", "principal");
        }

    }

    @Override
    public void detalhe(HttpServletRequest pRequest, HttpServletResponse pResponse) throws ServletException, IOException {

        LocadoraDaoMySql locadoraDao = new LocadoraDaoMySql();

        Locadora locadora = locadoraDao.getById(requestForm(pRequest).getId());

        if (locadora != null) {

            HashMap<String, String> map = new HashMap<String, String>();
                map.put("id", Integer.toString(locadora.getId()));
                map.put("nome", locadora.getNome());
                map.put("Cnpj", locadora.getCnpj());
                map.put("rua", locadora.getRua());
                map.put("numero", locadora.getNumero()+"");
                map.put("complemento", locadora.getComplemento());
                map.put("bairro", locadora.getBairro());
                map.put("cidade", locadora.getCidade());
                map.put("estado", locadora.getEstado());
                map.put("cep", locadora.getCep());
                map.put("telefoneComercial", locadora.getTelefoneComercial());
                map.put("telefoneContato", locadora.getTelefoneContato());
                map.put("email", locadora.getEmail());
                map.put("site", locadora.getSite());

            pRequest.setAttribute("locadora", map);

            RequestDispatcher rd = pRequest.getRequestDispatcher("/editarLocadora.jsp");
            rd.forward(pRequest, pResponse);

        } else {
            mostraAlertMsg(pRequest, pResponse, "ERRO", "Detalhe de Locadora", "Erro ao localizar o registro, por favor, tente novamente!", "locadora", "principal");
        }

    }
}
