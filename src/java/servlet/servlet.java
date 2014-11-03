/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;


import controller.Controller;
import controller.ControllerFilme;
import controller.ControllerLocadora;
import controller.ControllerReserva;
import controller.ControllerUsuario;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Andre
 */
public class servlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Controller vObjeto = null;
        if (request.getParameter("txtObjeto").equals("usuario")) {
            vObjeto = new ControllerUsuario();
        }else if (request.getParameter("txtObjeto").equals("locadora")){
            vObjeto = new ControllerLocadora();
        }else if (request.getParameter("txtObjeto").equals("filme")){
            vObjeto = new ControllerFilme();
        }else if (request.getParameter("txtObjeto").equals("reserva")){
            vObjeto = new ControllerReserva();
        }

        if (request.getParameter("txtMetodo").equals("principal")) {
            
            if (vObjeto != null) {
                vObjeto.principal(request, response);
            }

        } else if (request.getParameter("txtMetodo").equals("salvar")) {

            vObjeto.salvar(request, response);

        } else if (request.getParameter("txtMetodo").equals("alterar")) {

            vObjeto.alterar(request, response);

        } else if (request.getParameter("txtMetodo").equals("deletar")) {

            vObjeto.deletar(request, response);

        } else if (request.getParameter("txtMetodo").equals("listar")) {

            vObjeto.listar(request, response);

        } else if (request.getParameter("txtMetodo").equals("detalhe")) {

            vObjeto.detalhe(request, response);

        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

}
