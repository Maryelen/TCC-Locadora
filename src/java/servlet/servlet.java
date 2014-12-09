/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import Entity.Usuario;
import controller.Controller;
import controller.ControllerFilme;
import controller.ControllerLocadora;
import controller.ControllerLocadoraFilme;
import controller.ControllerReserva;
import controller.ControllerUsuario;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jorge
 */
public class servlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Controller vObjeto = null;
        ControllerUsuario usuario = null;

        if (request.getParameter("txtObjeto").equals("usuario")) {
            vObjeto = new ControllerUsuario();
        } else if (request.getParameter("txtObjeto").equals("locadora")) {
            vObjeto = new ControllerLocadora();
        } else if (request.getParameter("txtObjeto").equals("filme")) {
            vObjeto = new ControllerFilme();
        } else if (request.getParameter("txtObjeto").equals("reserva")) {
            vObjeto = new ControllerReserva();
        } else if (request.getParameter("txtObjeto").equals("locadorafilme")) {
            vObjeto = new ControllerLocadoraFilme();
        } else if (request.getParameter("txtObjeto").equals("login")) {
            usuario = new ControllerUsuario();
        } else if (request.getParameter("txtObjeto").equals("minhas_reservas")) {
            vObjeto = new ControllerReserva();
            vObjeto.detalhe(request, response);
        }

        if (request.getParameter("txtMetodo").equals("principal")) {

            if (vObjeto != null) {
                vObjeto.principal(request, response);
            }

        } else if (request.getParameter("txtMetodo").equals("principalCadastro")) {
            Usuario retorno = (Usuario) request.getSession().getAttribute("usuarioLogin");
             RequestDispatcher rd = null;
            
            if (retorno.getTipoUsuario().equals("comum")) {
                rd = request.getRequestDispatcher("/menu_Usuario.jsp");
            } else if (retorno.getTipoUsuario().equals("adm")) {
                rd = request.getRequestDispatcher("/menu.jsp");
            } else {
                rd = request.getRequestDispatcher("/menu_Locadora.jsp");
            }
           
            rd.forward(request, response);

        } else if (request.getParameter("txtMetodo").equals("login")) {

            RequestDispatcher rd = request.getRequestDispatcher("/loginESenha.jsp");
            rd.forward(request, response);

        } else if (request.getParameter("txtMetodo").equals("salvar")) {

            vObjeto.salvar(request, response);

        } else if (request.getParameter(
                "txtMetodo").equals("alterar")) {

            vObjeto.alterar(request, response);

        } else if (request.getParameter(
                "txtMetodo").equals("deletar")) {

            vObjeto.deletar(request, response);

        } else if (request.getParameter(
                "txtMetodo").equals("listar")) {

            vObjeto.listar(request, response);

        } else if (request.getParameter(
                "txtMetodo").equals("detalhe")) {

            vObjeto.detalhe(request, response);

        } else if (request.getParameter(
                "txtMetodo").equals("validarAcesso")) {

            usuario.validarAcesso(request, response);

        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
