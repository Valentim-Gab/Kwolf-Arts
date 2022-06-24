package br.csi.controller;

import br.csi.dao.ArteDAO;
import br.csi.model.Usuario;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/indexArtista")
public class IndexArtistaController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Usuario usuario_logado = (Usuario) session.getAttribute("usuario_logado");
        req.setAttribute("artes", new ArteDAO().getArtes(usuario_logado.getId_comprador()));

        RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/indexArtista.jsp");
        rd.forward(req, resp);
    }
}
