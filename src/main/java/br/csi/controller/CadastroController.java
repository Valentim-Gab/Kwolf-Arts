package br.csi.controller;

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

@WebServlet("cadastro")
public class CadastroController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UsuarioDAO dao = new UsuarioDAO();
        String retorno = "";
        String opcao = req.getParameter("opcao");
        String caminho = "cadastro?opcao=home";

        switch (opcao) {
            case "deletar": {

                int id = Integer.parseInt(req.getParameter("id"));
                System.out.println(id);
                String tipo_conta = req.getParameter("tipo_conta");

                if (tipo_conta.equals("C")) {
                    retorno = dao.deletarComprador(id);
                } else if (tipo_conta.equals("A")) {
                    retorno = dao.deletarArtista(id);
                }

                req.getSession().invalidate();

                break;
            }
            case "home":
                caminho = "index.html";
                resp.sendRedirect(req.getContextPath() + "/" + caminho);
                return;
            case "editar": {

                int id_comprador = Integer.parseInt(req.getParameter("id"));
                String primeiro_nome = req.getParameter("primeiro_nome");
                String segundo_nome = req.getParameter("segundo_nome");
                String email = req.getParameter("email").toLowerCase();
                String cpf = req.getParameter("cpf");
                String senha = req.getParameter("senha");
                String tipo_conta = req.getParameter("tipo_conta");
                String telefone = req.getParameter("telefone");
                String nacionalidade = req.getParameter("nacionalidade");
                Usuario usuario = new Usuario(
                        id_comprador, primeiro_nome, segundo_nome,
                        email, cpf, senha, tipo_conta, telefone,
                        nacionalidade
                );

                if (tipo_conta.equals("C")) {
                    retorno = dao.editarComprador(usuario);
                } else if (tipo_conta.equals("A")) {
                    caminho = "arte?opcao=index";
                    retorno = dao.editarArtista(usuario);
                }

                HttpSession session = req.getSession();
                Usuario usuario_logado = (Usuario) session.getAttribute("usuario_logado");
                usuario_logado = (usuario_logado.getTipo_conta().equals("C")) ?
                        new UsuarioDAO().getCompradorUnico(usuario_logado.getId_comprador()) :
                        new UsuarioDAO().getArtistaUnico(usuario_logado.getId_comprador());
                req.getSession().setAttribute("usuario_logado", usuario_logado);

                break;
            }
            default: {
                String primeiro_nome = req.getParameter("primeiro_nome");
                String segundo_nome = req.getParameter("segundo_nome");
                String email = req.getParameter("email").toLowerCase();
                String cpf = req.getParameter("cpf");
                String senha = req.getParameter("senha");
                String tipo_conta = opcao.equals("cadastrarComprador") ? "C" : "A";
                caminho = "WEB-INF/sections/login.jsp";
                Usuario usuario = new Usuario(primeiro_nome, segundo_nome, email, cpf, senha, tipo_conta);

                if (opcao.equals("cadastrarComprador")) {
                    retorno = dao.cadastrarComprador(usuario);
                } else if (opcao.equals("cadastrarArtista")) {
                    retorno = dao.cadastrarArtista(usuario);
                }
                break;
            }
        }

        req.setAttribute("retorno", retorno);
        RequestDispatcher rd = req.getRequestDispatcher(caminho);
        rd.forward(req, resp);
    }
}
