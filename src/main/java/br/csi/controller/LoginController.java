package br.csi.controller;

import br.csi.dao.ArteDAO;
import br.csi.model.Usuario;
import br.csi.service.UsuarioService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("login")
public class LoginController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email = req.getParameter("email");
        String senha = req.getParameter("senha");
        String tipo_conta = req.getParameter("tipo_conta");
        System.out.println(tipo_conta);
        email = email.toLowerCase();

        RequestDispatcher rd;
        Usuario usuario = new UsuarioService().autenticado(email, senha, tipo_conta);

        if (usuario != null) {
            HttpSession sessao = req.getSession();
            sessao.setAttribute("usuario_logado", usuario);
            Usuario usuario_logado = (Usuario) sessao.getAttribute("usuario_logado");
            if (!usuario_logado.getTipo_conta().equals("A")) {
                req.setAttribute("artes", new ArteDAO().getArtesTotal());
                rd = req.getRequestDispatcher("WEB-INF/index.jsp");
            } else {
                req.setAttribute("artes", new ArteDAO().getArtes(usuario.getId_comprador()));
                rd = req.getRequestDispatcher("WEB-INF/indexArtista.jsp");
            }
        } else {
            req.setAttribute("erro", "Email ou senha incorretos");
            rd = req.getRequestDispatcher("WEB-INF/sections/login.jsp");
        }
        rd.forward(req, resp);
    }
}
