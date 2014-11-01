/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet.folder;

import Entity.Locadora;
import Entity.Reserva;
import facade.FacadeLocadora;
import facade.FacadeReserva;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author maryelen_cassia
 */
public class Servlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        /* ********************ACAO LOCAODORA - INICIO************************************************
         * *************************************************************************************************
         */
        Locadora locadora = new Locadora();
        String acaoLocadora = req.getParameter("acao");

        if (acaoLocadora.equals("salvarLocadora")) {
            locadora.setBairro(req.getParameter("bairro"));
            locadora.setCep(req.getParameter("cep"));
            locadora.setCidade(req.getParameter("cidade"));
            locadora.setCnpj(req.getParameter("cnpj"));
            locadora.setComplemento(req.getParameter("complemento"));
            locadora.setEmail(req.getParameter("email"));
            locadora.setEstado(req.getParameter("estado"));
            locadora.setNome(req.getParameter("nome"));
            locadora.setNumero(Integer.parseInt(req.getParameter("numero")));
            locadora.setRua(req.getParameter("rua"));
            locadora.setSite(req.getParameter("site"));
            locadora.setTelefoneComercial(req.getParameter("telefoneComercial"));
            locadora.setTelefoneContato(req.getParameter("telefoneContato"));

            FacadeLocadora fc = new FacadeLocadora();
            fc.salvar(locadora);
            RequestDispatcher rd = req.getRequestDispatcher("/listarLocadora.jsp");
            rd.forward(req, resp);
        }

        if (acaoLocadora.equals("listarLocadoras")) {
            locadora = new Locadora();
            FacadeLocadora fc = new FacadeLocadora();
            List<Locadora> lista = fc.getAll();
            req.setAttribute("listarLocadoras", lista);
            RequestDispatcher rd = req.getRequestDispatcher("/listarLocadoras.jsp");
            rd.forward(req, resp);
        }

        if (acaoLocadora.equals("excluirLocadora")) {
            locadora = new Locadora();
            FacadeLocadora fc = new FacadeLocadora();
            Integer id = Integer.parseInt(req.getParameter("id"));
            fc.deletar(id);
            RequestDispatcher rd = req.getRequestDispatcher("servlet?acao=listarLocadoras");
            rd.forward(req, resp);
        }

        if (acaoLocadora.equals("editarLocadora")) {
            locadora = new Locadora();
            FacadeLocadora fc = new FacadeLocadora();
            Integer id = Integer.parseInt(req.getParameter("id"));
            locadora = fc.getById(id);
            req.setAttribute("editarLocadora", locadora);
            RequestDispatcher rd = req.getRequestDispatcher("/editarLocadora.jsp");
            rd.forward(req, resp);
        }

    }
}
    /* ********************ACAO LOCAODORA - FIM************************************************
     * *************************************************************************************************
     */
    /*
     Reserva reserva = new Reserva();
     String acaoReserva = req.getParameter("acao");

     if (acaoReserva.equals("salvarReserva")) {

     reserva.setIdFilmeLocadora(Integer.parseInt(req.getParameter("idFilmeLocadora")));
     reserva.setIdUsuario(Integer.parseInt(req.getParameter("idUsuario")));
     reserva.setSituacao(req.getParameter("situacao"));
     reserva.setMotivo(req.getParameter("motivo"));

     FacadeReserva fc = new FacadeReserva();
     fc.salvar(reserva);
     RequestDispatcher rd = req.getRequestDispatcher("/listarReservas.jsp");
     rd.forward(req, resp);
     }

     if (acaoReserva.equals("listarReservas")) {
     FacadeReserva fc = new FacadeReserva();
     List<Reserva> lista = fc.getAll();
     req.setAttribute("listaReservas", lista);
     RequestDispatcher rd = req.getRequestDispatcher("/listarLocadoras.jsp");
     rd.forward(req, resp);
     }

     if (acaoReserva.equals("excluirLocadora")) {
     FacadeReserva fc = new FacadeReserva();
     Integer id = Integer.parseInt(req.getParameter("id"));
     fc.deletar(id);
     RequestDispatcher rd = req.getRequestDispatcher("servlet?acao=listarReserva");
     rd.forward(req, resp);
     }

     if (acaoReserva.equals("editarReserva")) {
     reserva = new Reserva();
     FacadeReserva fc = new FacadeReserva();
     Integer id = Integer.parseInt(req.getParameter("id"));
     reserva = fc.getById(id);
     req.setAttribute("editaReserva", reserva);
     RequestDispatcher rd = req.getRequestDispatcher("/editarReserva.jsp");
     rd.forward(req, resp);
     }

     }

     @Override
     protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     doPost(req, resp);
     }
     }
     */