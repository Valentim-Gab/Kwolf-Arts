package br.csi.service;

import br.csi.dao.UsuarioDAO;
import br.csi.model.Usuario;

import java.sql.SQLException;

public class UsuarioService {

    private UsuarioDAO dao;

    public Usuario autenticado(String email, String senha, String tipo_conta) {

        dao = new UsuarioDAO();

        Usuario u = tipo_conta.equals("C") ? dao.getComprador(email, senha) : dao.getArtista(email, senha);

        try {
            if (u.getEmail().equals(email) && u.getSenha().equals(senha)) {
                return u;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
