/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet.folder;

import Entity.Filme;
import facade.Facade;
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

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Filme filme = new Filme();
        String acao = req.getParameter("acao");
        System.out.println(acao);
        if (acao.equals("novo")) {
            RequestDispatcher rd = req.getRequestDispatcher("/cadastrarFilme.jsp");
            rd.forward(req, resp);
        }
        if (acao.equals("salvar")) {
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
            RequestDispatcher rd = req.getRequestDispatcher("servlet?acao=listar");
            rd.forward(req, resp);
        }
        if (acao.equals("listar")) {
            Facade facade = new Facade();
            List<Filme> lista = facade.getAll();
            req.setAttribute("listaFilme", lista);
            RequestDispatcher rd = req.getRequestDispatcher("/listarFilmes.jsp");
            rd.forward(req, resp);
        }

        if (acao.equals("excluir")) {
            Facade facade = new Facade();
            Integer id = Integer.parseInt(req.getParameter("idFilme"));
            facade.deletar(id);
            RequestDispatcher rd = req.getRequestDispatcher("servlet?acao=listar");
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

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

}
