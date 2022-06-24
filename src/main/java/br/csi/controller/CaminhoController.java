package br.csi.controller;

import br.csi.dao.ArteDAO;
import br.csi.dao.UsuarioDAO;
import br.csi.model.Usuario;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("caminho")
public class CaminhoController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url;
        String opcao = req.getParameter("opcao");

        url = "index.html";

        switch (opcao) {
            case "cadastro":
                url = "WEB-INF/sections/cadastro.jsp";

                break;
            case "login":
                url = "WEB-INF/sections/login.jsp";

                break;
            case "comprarArte":
                url = "WEB-INF/sections/comprarArte.jsp";

                break;
            case "editar":
                HttpSession session = req.getSession();
                Usuario usuario_logado = (Usuario) session.getAttribute("usuario_logado");
                Usuario usuario;

                usuario = (usuario_logado.getTipo_conta().equals("C")) ?
                        new UsuarioDAO().getCompradorUnico(usuario_logado.getId_comprador()) :
                        new UsuarioDAO().getArtistaUnico(usuario_logado.getId_comprador());

                req.setAttribute("usuario", usuario);
                req.getSession().getAttribute("usuario_logado");
                url = "WEB-INF/sections/perfilUsuario.jsp";

                break;

            case "editarArte":
                int id_arte = Integer.parseInt(req.getParameter("id_arte"));
                req.setAttribute("arte", new ArteDAO().getArteUnica(id_arte));
                url = "WEB-INF/sections/editarArte.jsp";

                break;
            case "registrarArte":
                url = "WEB-INF/sections/registrarArte.jsp";

                break;
            case "logout":
                req.getSession().invalidate();
                url = "index.html";
                break;
        }

        RequestDispatcher rd = req.getRequestDispatcher(url);
        rd.forward(req, resp);
    }
}
