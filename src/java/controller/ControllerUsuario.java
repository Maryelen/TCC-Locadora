/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.UsuarioDaoMySql;
import Entity.Usuario;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.jms.Session;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jboss.weld.servlet.SessionHolder;

/**
 *
 * @author Andre
 */
public class ControllerUsuario implements Controller {

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

    private Usuario requestForm(HttpServletRequest pRequest) {

        Usuario retorno = new Usuario();

        if (pRequest.getParameter("txtId") != null) {
            retorno.setId(Integer.parseInt(pRequest.getParameter("txtId")));
        }

        if (pRequest.getParameter("txtNome") != null) {
            retorno.setNome(pRequest.getParameter("txtNome"));
        }

        if (pRequest.getParameter("txtEmail") != null) {
            retorno.setEmail(pRequest.getParameter("txtEmail"));
        }

        if (pRequest.getParameter("txtLogin") != null) {
            retorno.setLogin(pRequest.getParameter("txtLogin"));
        }

        if (pRequest.getParameter("txtSenha") != null) {
            retorno.setSenha(pRequest.getParameter("txtSenha"));
        }
        
        if (pRequest.getParameter("txtTipo") != null) {
            retorno.setTipoUsuario(pRequest.getParameter("txtTipo"));
        }

        return retorno;
    }

    @Override
    public void principal(HttpServletRequest pRequest, HttpServletResponse pResponse) throws ServletException, IOException {

        RequestDispatcher rd = pRequest.getRequestDispatcher("/cadastrarUsuario.jsp");
        rd.forward(pRequest, pResponse);

    }

    @Override
    public void salvar(HttpServletRequest pRequest, HttpServletResponse pResponse) throws ServletException, IOException {

        UsuarioDaoMySql usuarioDao = new UsuarioDaoMySql();
        Usuario usuario = requestForm(pRequest);

        int retorno = usuarioDao.salvar(usuario);

        if (retorno > 0) {
            mostraAlertMsg(pRequest, pResponse, "OK", "Cadastro de Usuario", "Registro salvo com sucesso!", "usuario", "listar");
        } else {
            mostraAlertMsg(pRequest, pResponse, "ERRO", "Cadastro de Usuario", "Erro ao salvar o registro, por favor, tente novamente!", "usuario", "listar");
        }
    }

    @Override
    public void alterar(HttpServletRequest pRequest, HttpServletResponse pResponse) throws ServletException, IOException {
        UsuarioDaoMySql usuarioDao = new UsuarioDaoMySql();
        Usuario usuario = requestForm(pRequest);

        boolean retorno = usuarioDao.update(usuario);

        if (retorno) {
            mostraAlertMsg(pRequest, pResponse, "OK", "Alteração de Usuario", "Registro salvo com sucesso!", "usuario", "listar");
        } else {
            mostraAlertMsg(pRequest, pResponse, "ERRO", "Alteração de Usuario", "Erro ao salvar o registro, por favor, tente novamente!", "usuario", "listar");
        }

    }

    @Override
    public void deletar(HttpServletRequest pRequest, HttpServletResponse pResponse) throws ServletException, IOException {

        UsuarioDaoMySql usuarioDao = new UsuarioDaoMySql();
        Usuario usuario = requestForm(pRequest);

        boolean retorno = usuarioDao.deletar(usuario.getId());

        if (retorno) {
            mostraAlertMsg(pRequest, pResponse, "OK", "Excluir de Usuario", "Registro excluido com sucesso!", "usuario", "listar");
        } else {
            mostraAlertMsg(pRequest, pResponse, "ERRO", "Excluir de Usuario", "Erro ao excluir o registro, por favor, tente novamente!", "usuario", "listar");
        }
    }

    @Override
    public void listar(HttpServletRequest pRequest, HttpServletResponse pResponse) throws ServletException, IOException {

        UsuarioDaoMySql usuarioDao = new UsuarioDaoMySql();
        List<Usuario> usuarios = usuarioDao.getAll();

        if (usuarios != null) {

            List<Map> resultado = new ArrayList<Map>();

            for (Usuario usuario : usuarios) {

                HashMap<String, String> map = new HashMap<String, String>();
                map.put("id", Integer.toString(usuario.getId()));
                map.put("nome", usuario.getNome());
                map.put("email", usuario.getEmail());
                map.put("login", usuario.getLogin());
                map.put("senha", usuario.getSenha());
                map.put("tipo", usuario.getTipoUsuario());
                resultado.add(map);

            }

            pRequest.setAttribute("usuarios", resultado);

            RequestDispatcher rd = pRequest.getRequestDispatcher("/listarUsuarios.jsp");
            rd.forward(pRequest, pResponse);

        } else {
            mostraAlertMsg(pRequest, pResponse, "ERRO", "Lista de Usuario", "Erro ao localizar os registros, por favor, tente novamente!", "usuario", "principal");
        }

    }

    @Override
    public void detalhe(HttpServletRequest pRequest, HttpServletResponse pResponse) throws ServletException, IOException {

        UsuarioDaoMySql usuarioDao = new UsuarioDaoMySql();

        Usuario usuario = usuarioDao.getById(requestForm(pRequest).getId());

        if (usuario != null) {

            HashMap<String, String> resultado = new HashMap<String, String>();
            resultado.put("id", Integer.toString(usuario.getId()));
            resultado.put("nome", usuario.getNome());
            resultado.put("email", usuario.getEmail());
            resultado.put("login", usuario.getLogin());
            resultado.put("senha", usuario.getSenha());
            resultado.put("tipo", usuario.getTipoUsuario());

            pRequest.setAttribute("usuario", resultado);

            RequestDispatcher rd = pRequest.getRequestDispatcher("/editarUsuario.jsp");
            rd.forward(pRequest, pResponse);

        } else {
            mostraAlertMsg(pRequest, pResponse, "ERRO", "Detalhe de Usuario", "Erro ao localizar o registro, por favor, tente novamente!", "usuario", "principal");
        }

    }

    public void validarAcesso(HttpServletRequest pRequest, HttpServletResponse pResponse) throws ServletException, IOException {

        Usuario retorno = new Usuario();
        UsuarioDaoMySql dao = new UsuarioDaoMySql();

        if (pRequest.getParameter("txtLogin") != null) {
            retorno.setLogin(pRequest.getParameter("txtLogin"));
        }

        if (pRequest.getParameter("txtSenha") != null) {
            retorno.setSenha(pRequest.getParameter("txtSenha"));
        }

        retorno = dao.getByLoginESenha(retorno);
        if (retorno != null) {
            pRequest.getSession().setAttribute("usuarioLogin", retorno);
            
            mostraAlertMsg(pRequest, pResponse, "OK", "Olá, Seja bem vindo Sro "+retorno.getNome()+"!", "Logado", "usuario", "principalCadastro");
        } else {
            mostraAlertMsg(pRequest, pResponse, "ERRO", "Não foi possivel realizar o acesso.", " Login ou senha invalido", "usuario", "login");
        }

    }
}
