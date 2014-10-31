///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package Servlet.folder;
//
//import Entity.Usuario;
//import Entity.Filme;
//import facade.FacadeUsuario;
//import java.io.IOException;
//import java.util.List;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// *
// * @author maryelen_cassia
// */
//
//public class Servlet extends HttpServlet {
//
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//         /* ********************VALIDACAO USUARIO************************************************
//         * *************************************************************************************************
//         */
//        Usuario usuario = new Usuario();
//        String acaoUsuario = req.getParameter("acao");
//
//        if (acaoUsuario.equals("novoUsuario")) {
//            RequestDispatcher rd = req.getRequestDispatcher("/cadastrarUsuario.jsp");
//            rd.forward(req, resp);
//        }
//
//        if (acaoUsuario.equals("salvarUsuario")) {
//            usuario.setId(Integer.parseInt(req.getParameter("id")));
//            usuario.setLogin(req.getParameter("login"));
//            usuario.setSenha(req.getParameter("senha"));
//            usuario.setPerguntaDeSeguranca(req.getParameter("perguntaDeSeguranca"));
//
//            FacadeUsuario facade = new FacadeUsuario();
//            facade.salvar(usuario);
//            RequestDispatcher rd = req.getRequestDispatcher("servlet?acao=listarUsuarios");
//            rd.forward(req, resp);
//        }
//
//        if (acaoUsuario.equals("listarUsuarios")) {
//            FacadeUsuario facade = new FacadeUsuario();
//            List<Usuario> lista = facade.getAll();
//            req.setAttribute("listarUsuario", lista);
//            RequestDispatcher rd = req.getRequestDispatcher("/listarUsuarios.jsp");
//            rd.forward(req, resp);
//        }
//
//        if (acaoUsuario.equals(
//                "excluirUsuario")) {
//            FacadeUsuario facade = new FacadeUsuario();
//            Integer id = Integer.parseInt(req.getParameter("id"));
//            facade.deletar(id);
//            RequestDispatcher rd = req.getRequestDispatcher("servlet?acao=listarUsuarios");
//            rd.forward(req, resp);
//        }
//
//        if (acaoUsuario.equals(
//                "editarUsuario")) {
//            FacadeUsuario facade = new FacadeUsuario();
//            Usuario edit = new Usuario();
//            Integer id = Integer.parseInt(req.getParameter("id"));
//                edit = facade.getById(id);
//            
//            req.setAttribute("editarUsuario", edit);    
//            RequestDispatcher rd = req.getRequestDispatcher("/editarUsuario.jsp");
//            rd.forward(req, resp);
//        }
//
//    }
//    
//    /************************VALIDACAO PESQUISA FILME*********************************************************/
//
//    Filme filme = new Filme();
//   
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        doPost(req, resp);
//    }
//}
