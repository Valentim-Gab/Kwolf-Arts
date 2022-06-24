package br.csi.controller;

import br.csi.dao.ArteDAO;
import br.csi.dao.UsuarioDAO;
import br.csi.model.Arte;
import br.csi.model.Usuario;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("arte")
public class ArteController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ArteDAO dao = new ArteDAO();
        String retorno = "";
        String opcao = req.getParameter("opcao");
        String caminho = "arte?opcao=index";

        switch (opcao) {
            case "deletar": {
                int id_arte = Integer.parseInt(req.getParameter("id_arte"));
                retorno = dao.deletarArte(id_arte);
                break;
            }
            case "editar": {
                int id_arte = Integer.parseInt(req.getParameter("id_arte"));
                String nome = req.getParameter("nome");
                String copyright = req.getParameter("copyright");
                float valor = Float.parseFloat(req.getParameter("valor"));
                String adicional = req.getParameter("adicional");

                Arte arte = new Arte(id_arte, nome, copyright, valor, adicional);

                retorno = dao.editarArte(arte);

                break;
            }
            case "comprarArte": {
                int id_arte = Integer.parseInt(req.getParameter("id_arte"));
                HttpSession session = req.getSession();
                Usuario usuario_logado = (Usuario) session.getAttribute("usuario_logado");


                if (usuario_logado != null) {
                    req.setAttribute("arte", new ArteDAO().getArteUnica(id_arte));
                    caminho =  "WEB-INF/sections/comprarArte.jsp";
                } else {
                    caminho = "WEB-INF/sections/login.jsp";
                }

                break;
            }

            case "comprar": {
                int id_arte = Integer.parseInt(req.getParameter("id_arte"));
                HttpSession session = req.getSession();
                Usuario usuario_logado = (Usuario) session.getAttribute("usuario_logado");

                retorno = dao.confirmarCompra(usuario_logado.getId_comprador(), id_arte);
                caminho =  "arte?opcao=arteComprada";

                break;
            }
            case "index": {
                caminho = "indexArtista";
                resp.sendRedirect(req.getContextPath()+"/"+caminho);
                return;
            }
            case "arteComprada": {
                HttpSession session = req.getSession();
                Usuario usuario_logado = (Usuario) session.getAttribute("usuario_logado");
                req.setAttribute("artesCompradas", new ArteDAO().getArtesCompradas(usuario_logado.getId_comprador()));
                caminho = "WEB-INF/sections/arteComprada.jsp";

                break;
            }
            case "verArtes": {
                int id_arte_c = Integer.parseInt(req.getParameter("id_arte_comprada"));
                req.setAttribute("arte", new ArteDAO().getVerArte(id_arte_c));
                caminho = "WEB-INF/sections/verArte.jsp";
                break;
            }
            case "registrarArte": {
                String nome = req.getParameter("nome");
                String copyright = req.getParameter("copyright");
                float valor = Float.parseFloat(req.getParameter("valor"));
                String adicional = req.getParameter("adicional");
                String imagem = req.getParameter("imagem");

                HttpSession session = req.getSession();
                Usuario usuario_logado = (Usuario) session.getAttribute("usuario_logado");
                Usuario usuario;

                usuario = new UsuarioDAO().getArtistaUnico(usuario_logado.getId_comprador());

                Arte arte = new Arte(nome, copyright, valor, adicional, imagem, usuario);

                retorno = dao.cadastrarArte(arte);

                break;
            }
        }

        req.setAttribute("retorno", retorno);
        RequestDispatcher rd = req.getRequestDispatcher(caminho);
        rd.forward(req, resp);
    }
}
