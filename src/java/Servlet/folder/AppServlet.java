/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet.folder;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author maryelen_cassia
 */
public class AppServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String nomeFilme = req.getParameter("nomeFilme");
        String anoFilme = req.getParameter("anoFilme");
        String generoFilme = req.getParameter("generoFilme");
        String diretorFilme = req.getParameter("diretorFilme");
        String codigoFilme = req.getParameter("codigoFilme");
        String midiaFilme = req.getParameter("midiaFilme");
        String sinopseFilme = req.getParameter("sinopseFilme");
        String produtoraFilme = req.getParameter("produtoraFilme");
        String classificacaoIndicativaFilme = req.getParameter("classificacaoFilme");
        String valorFilmePagoLocadora = req.getParameter("valorFilmePagoLocadora");
        String classificacaoValorFilme = req.getParameter("classificacaoValorFilme");
        
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

}
