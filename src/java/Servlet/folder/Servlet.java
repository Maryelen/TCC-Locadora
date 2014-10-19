/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet.folder;

import Entity.Acesso;
import Entity.Cliente;
import Entity.Filme;
import facade.Facade;
import facade.FacadeAcesso;
import facade.FacadeCliente;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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

        Filme filme = new Filme();
        String acao = req.getParameter("acao");
        System.out.println(acao);
        if (acao.equals("novoFilme")) {
            RequestDispatcher rd = req.getRequestDispatcher("/cadastrarFilme.jsp");
            rd.forward(req, resp);
        }
        if (acao.equals("salvarFilme")) {
            filme.setIdFilme(Integer.parseInt(req.getParameter("idFilme")));
            filme.setNomeFilme(req.getParameter("nomeFilme"));
            filme.setAnoFilme(Integer.parseInt(req.getParameter("anoFilme")));
            filme.setGeneroFilme(req.getParameter("generoFilme"));
            filme.setDiretorFilme(req.getParameter("diretorFilme"));
            filme.setCodigoFilme(Integer.parseInt(req.getParameter("codigoFilme")));
            filme.setMidiaFilme(req.getParameter("midiaFilme"));
            filme.setSinopseFilme(req.getParameter("sinopseFilme"));
            filme.setProdutoraFilme(req.getParameter("produtoraFilme"));
            filme.setClassificacaoIndicativaFilme(req.getParameter("classificacaoFilme"));
            filme.setValorPagoLocadora(Double.parseDouble(req.getParameter("valorFilmePagoLocadora")));
            filme.setClassificacaoValorFilme(req.getParameter("classificacaoValorFilme"));
            Facade facade = new Facade();
            facade.salvar(filme);
            RequestDispatcher rd = req.getRequestDispatcher("servlet?acao=listarFilme");
            rd.forward(req, resp);
        }
        if (acao.equals("listarFilme")) {
            Facade facade = new Facade();
            List<Filme> lista = facade.getAll();
            req.setAttribute("listaFilme", lista);
            RequestDispatcher rd = req.getRequestDispatcher("/listarFilmes.jsp");
            rd.forward(req, resp);
        }

        if (acao.equals("excluirFilme")) {
            Facade facade = new Facade();
            Integer id = Integer.parseInt(req.getParameter("idFilme"));
            facade.deletar(id);
            RequestDispatcher rd = req.getRequestDispatcher("servlet?acao=listarFilme");
            rd.forward(req, resp);
        }

        if (acao.equals("editarFilme")) {
            Facade facade = new Facade();
            Filme edit = new Filme();
            Integer id = Integer.parseInt(req.getParameter("idFilme"));
            try {
                edit = facade.getById(id);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Servlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            req.setAttribute("editFilme", edit);
            RequestDispatcher rd = req.getRequestDispatcher("/editarFilme.jsp");
            rd.forward(req, resp);
        }

        if (acao.equals("validaAcesso")) {
            Acesso acesso = new Acesso();
            FacadeAcesso facade = new FacadeAcesso();
            acesso.setLogin(req.getParameter("login"));
            acesso.setSenha(req.getParameter("senha"));
            boolean resposta = facade.validarAcesso(acesso);
            if (resposta == false) {
                req.setAttribute("erroMensagem", "Login ou senha invalido");
                RequestDispatcher rd = req.getRequestDispatcher("/telaDeAcesso.jsp");
                rd.forward(req, resp);
            } else {
                RequestDispatcher rd = req.getRequestDispatcher("/index.html");
                rd.forward(req, resp);
            }
        }
    
 Cliente cliente = new Cliente();
        String acaoCliente = req.getParameter("acaoCliente");
        System.out.println(acao);
        if (acaoCliente.equals("novoCliente")) {
            RequestDispatcher rd = req.getRequestDispatcher("/cadastrarCliente.jsp");
            rd.forward(req, resp);
        }
        if (acaoCliente.equals("salvarCliente")) {
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
           
            FacadeCliente facade = new FacadeCliente();
            facade.salvar(cliente);
            RequestDispatcher rd = req.getRequestDispatcher("servlet?acaoCliente=listarCliente");
            rd.forward(req, resp);
        }
        if (acaoCliente.equals("listarCliente")) {
            FacadeCliente facade = new FacadeCliente();
            List<Cliente> lista = facade.getAll();
            req.setAttribute("listaCliente", lista);
            RequestDispatcher rd = req.getRequestDispatcher("/listarClientes.jsp");
            rd.forward(req, resp);
        }

        if (acaoCliente.equals("excluirCliente")) {
            Facade facade = new Facade();
            Integer id = Integer.parseInt(req.getParameter("idCliente"));
            facade.deletar(id);
            RequestDispatcher rd = req.getRequestDispatcher("servlet?acaoCliente=listarCliente");
            rd.forward(req, resp);
        }

        if (acaoCliente.equals("editarCliente")) {
            FacadeCliente facade = new FacadeCliente();
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
}
              
