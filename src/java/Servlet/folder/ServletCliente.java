/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Servlet.folder;

import Entity.Cliente;
import facade.Facade;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author maryelen_cassia
 */
@WebServlet(name = "ServletCliente", urlPatterns = {"/ServletCliente"})
public class ServletCliente extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
   @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Cliente cliente = new Cliente();
        String acao = req.getParameter("acao");
        System.out.println(acao);
        if (acao.equals("novo")) {
            RequestDispatcher rd = req.getRequestDispatcher("/cadastrarCliente.jsp");
            rd.forward(req, resp);
        }
        if (acao.equals("salvar")) {
            cliente.setIdCliente(Integer.parseInt(req.getParameter("idCliente")));
            cliente.setNomeCliente(req.getParameter("nomeCliente"));
            cliente.setBairro(req.getParameter("bairro"));
            cliente.setCidade(req.getParameter("cidade"));
            cliente.setComplemento(req.getParameter("complemento"));
            cliente.setCpf(req.getParameter("cpf"));
            cliente.setEmail(req.getParameter("email"));
            cliente.setTelefoneCelular(req.getParameter("telefoneCelular"));
            cliente.setTelefoneRecado(req.getParameter("telefoneRecado"));
            cliente.setTelefoneResidencial(req.getParameter("telefoneResidencial"));
            cliente.setEndereco(req.getParameter("endereco"));
      /*      
            Facade facade = new Facade();
            facade.salvar(cliente);
            RequestDispatcher rd = req.getRequestDispatcher("servlet?acao=listar");
            rd.forward(req, resp);
        }
        if (acao.equals("listar")) {
            Facade facade = new Facade();
            List<Cliente> lista = facade.getAll();
            req.setAttribute("listaCliente", lista);
            RequestDispatcher rd = req.getRequestDispatcher("/listarClientes.jsp");
            rd.forward(req, resp);
        }

        if (acao.equals("excluir")) {
            Facade facade = new Facade();
            Integer id = Integer.parseInt(req.getParameter("idCliente"));
            facade.deletar(id);
            RequestDispatcher rd = req.getRequestDispatcher("servlet?acao=listar");
            rd.forward(req, resp);
        }

        if (acao.equals("editarCliente")) {
            Facade facade = new Facade();
            Cliente edit = new Cliente();
            Integer id = Integer.parseInt(req.getParameter("idCliente"));
            try {
                edit = facade.getById(id);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Servlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            req.setAttribute("editCliente", edit);
            RequestDispatcher rd = req.getRequestDispatcher("/editarCliente.jsp");
            rd.forward(req, resp);
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
*/
}
    }
}