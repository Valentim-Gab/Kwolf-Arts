package br.csi.dao;

import br.csi.model.Usuario;

import java.sql.*;

public class UsuarioDAO {

    private String sql;

    private Statement statement;

    private ResultSet resultSet;

    private PreparedStatement preparedStatement;

    private String status;

//    public ArrayList<Usuario> getUsuarios() {
//        ArrayList<Usuario> usuarios = new ArrayList<>();
//
//        try(Connection connection = new ConectaDBPostgres().getConexao()){
//
//            this.sql = "select * from" +
//                    " USUARIO U, PERMISSAO P " +
//                    "where" +
//                    " U.ID_PERMISSAO = P.ID_PERMISSAO ";
//
//            this.statement = connection.createStatement();
//            this.resultSet = this.statement.executeQuery(this.sql);
//
//
//            while (this.resultSet.next()) {
//                Usuario usuario = new Usuario();
//                usuario.setId(this.resultSet.getInt("ID_USUARIO"));
//                usuario.setNome(this.resultSet.getString("NOME"));
//                usuario.setEmail(this.resultSet.getString("EMAIL"));
//                usuario.setAtivo(this.resultSet.getBoolean("ATIVO"));
//
//                Permissao permissao = new Permissao(
//                        this.resultSet.getInt("ID_PERMISSAO"),
//                        this.resultSet.getString("NOME_PERMISSAO")
//                );
//
//                usuario.setPermissao(permissao);
//
//                System.out.println(usuario.getId());
//                System.out.println(usuario.getNome());
//                System.out.println(usuario.getEmail());
//                System.out.println(usuario.isAtivo());
//                System.out.println(usuario.getPermissao().getId_permissao());
//                System.out.println(usuario.getPermissao().getNome_permissao());
//
//                usuarios.add(usuario);
//            }
//
//        }catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return usuarios;
//    }

    public Usuario getComprador(String email, String senha) {
        //Usuario u = new Usuario("Usuario", email, "123123", new Date(2022, 06, 05), true, new Permissao(1, "ADMIN"));
        //return u;

        Usuario usuario = null;

        try (Connection connection = new ConectaDBPostgres().getConexao()) {

            this.sql = " select * from" +
                    "    COMPRADOR C " +
                    "where" +
                    "    C.EMAIL = ? " +
                    "and" +
                    "    C.SENHA = ? ";

            preparedStatement = connection.prepareStatement(this.sql);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, senha);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                usuario = new Usuario();
                usuario.setId_comprador((resultSet.getInt("id_comprador")));
                usuario.setPrimeiro_nome(resultSet.getString("primeiro_nome"));
                usuario.setSegundo_nome(resultSet.getString("segundo_nome"));
                usuario.setEmail(resultSet.getString("email"));
                usuario.setCpf(resultSet.getString("cpf"));
                usuario.setSenha(resultSet.getString("senha"));
                usuario.setTipo_conta(resultSet.getString("tipo_conta"));
                usuario.setTelefone(resultSet.getString("telefone"));
                usuario.setNacionalidade(resultSet.getString("nacionalidade"));
                usuario.setData_nascimento(resultSet.getDate("data_nascimento"));
                usuario.setData_cadastro(resultSet.getDate("data_cadastro"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuario;
    }

    public Usuario getArtista(String email, String senha) {
        //Usuario u = new Usuario("Usuario", email, "123123", new Date(2022, 06, 05), true, new Permissao(1, "ADMIN"));
        //return u;

        Usuario usuario = null;

        try (Connection connection = new ConectaDBPostgres().getConexao()) {

            this.sql = " select * from" +
                    "    ARTISTA A " +
                    "where" +
                    "    A.EMAIL = ? " +
                    "and" +
                    "    A.SENHA = ? ";

            preparedStatement = connection.prepareStatement(this.sql);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, senha);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                usuario = new Usuario();
                usuario.setId_comprador((resultSet.getInt("id_artista")));
                usuario.setPrimeiro_nome(resultSet.getString("primeiro_nome"));
                usuario.setSegundo_nome(resultSet.getString("segundo_nome"));
                usuario.setEmail(resultSet.getString("email"));
                usuario.setCpf(resultSet.getString("cpf"));
                usuario.setSenha(resultSet.getString("senha"));
                usuario.setTipo_conta(resultSet.getString("tipo_conta"));
                usuario.setTelefone(resultSet.getString("telefone"));
                usuario.setNacionalidade(resultSet.getString("nacionalidade"));
                usuario.setData_nascimento(resultSet.getDate("data_nascimento"));
                usuario.setData_cadastro(resultSet.getDate("data_cadastro"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuario;
    }

    public Usuario getCompradorUnico(int id) {

        Usuario usuario = null;

        try (Connection connection = new ConectaDBPostgres().getConexao()) {

            this.sql = " select * from" +
                    "    COMPRADOR C " +
                    "where" +
                    "    C.id_comprador = ? ";

            preparedStatement = connection.prepareStatement(this.sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                usuario = new Usuario();
                usuario.setId_comprador((resultSet.getInt("id_comprador")));
                usuario.setPrimeiro_nome(resultSet.getString("primeiro_nome"));
                usuario.setSegundo_nome(resultSet.getString("segundo_nome"));
                usuario.setEmail(resultSet.getString("email"));
                usuario.setCpf(resultSet.getString("cpf"));
                usuario.setSenha(resultSet.getString("senha"));
                usuario.setTipo_conta(resultSet.getString("tipo_conta"));
                usuario.setTelefone(resultSet.getString("telefone"));
                usuario.setNacionalidade(resultSet.getString("nacionalidade"));
                usuario.setData_nascimento(resultSet.getDate("data_nascimento"));
                usuario.setData_cadastro(resultSet.getDate("data_cadastro"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuario;
    }

    public Usuario getArtistaUnico(int id) {

        Usuario usuario = null;

        try (Connection connection = new ConectaDBPostgres().getConexao()) {

            this.sql = " select * from" +
                    "    ARTISTA A " +
                    "where" +
                    "    A.id_artista = ? ";

            preparedStatement = connection.prepareStatement(this.sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                usuario = new Usuario();
                usuario.setId_comprador((resultSet.getInt("id_artista")));
                usuario.setPrimeiro_nome(resultSet.getString("primeiro_nome"));
                usuario.setSegundo_nome(resultSet.getString("segundo_nome"));
                usuario.setEmail(resultSet.getString("email"));
                usuario.setCpf(resultSet.getString("cpf"));
                usuario.setSenha(resultSet.getString("senha"));
                usuario.setTipo_conta(resultSet.getString("tipo_conta"));
                usuario.setTelefone(resultSet.getString("telefone"));
                usuario.setNacionalidade(resultSet.getString("nacionalidade"));
                usuario.setData_nascimento(resultSet.getDate("data_nascimento"));
                usuario.setData_cadastro(resultSet.getDate("data_cadastro"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuario;
    }

    public String cadastrarComprador(Usuario u) {

        try (Connection connection = new ConectaDBPostgres().getConexao()){

            //BEGIN
            connection.setAutoCommit(false);

            this.sql = "insert into COMPRADOR (primeiro_nome, segundo_nome, email, cpf, senha, tipo_conta, data_cadastro) " +
                    "values (?,?,?,?,?,?,CURRENT_DATE);";

            this.preparedStatement = connection.prepareStatement(this.sql, PreparedStatement.RETURN_GENERATED_KEYS);
            this.preparedStatement.setString(1, u.getPrimeiro_nome());
            this.preparedStatement.setString(2, u.getSegundo_nome());
            this.preparedStatement.setString(3, u.getEmail());
            this.preparedStatement.setString(4, u.getCpf());
            this.preparedStatement.setString(5, u.getSenha());
            this.preparedStatement.setString(6, u.getTipo_conta());

            this.preparedStatement.execute();
            this.resultSet = this.preparedStatement.getGeneratedKeys();
            this.resultSet.next();

            if (this.resultSet.getInt(1) > 0) {
                this.status = "OK";
                connection.commit();
                System.out.println(this.status);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            this.status = "ERROR";
            System.out.println(this.status);
        }
        return this.status;
    }

    public String cadastrarArtista(Usuario u) {

        try (Connection connection = new ConectaDBPostgres().getConexao()){

            //BEGIN
            connection.setAutoCommit(false);

            this.sql = "insert into ARTISTA (primeiro_nome, segundo_nome, email, cpf, senha, tipo_conta, data_cadastro) " +
                    "values (?,?,?,?,?,?,CURRENT_DATE);";

            this.preparedStatement = connection.prepareStatement(this.sql, PreparedStatement.RETURN_GENERATED_KEYS);
            this.preparedStatement.setString(1, u.getPrimeiro_nome());
            this.preparedStatement.setString(2, u.getSegundo_nome());
            this.preparedStatement.setString(3, u.getEmail());
            this.preparedStatement.setString(4, u.getCpf());
            this.preparedStatement.setString(5, u.getSenha());
            this.preparedStatement.setString(6, u.getTipo_conta());

            this.preparedStatement.execute();
            this.resultSet = this.preparedStatement.getGeneratedKeys();
            this.resultSet.next();

            if (this.resultSet.getInt(1) > 0) {
                this.status = "OK";
                connection.commit();
                System.out.println(this.status);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            this.status = "ERROR";
            System.out.println(this.status);
        }
        return this.status;
    }

    public String editarComprador(Usuario u) {

        try (Connection connection = new ConectaDBPostgres().getConexao()) {

            connection.setAutoCommit(false);

            this.sql = "update" +
                    "    COMPRADOR " +
                    "set" +
                    "    primeiro_nome = ?, " +
                    "    segundo_nome = ?, " +
                    "    email = ?, " +
                    "    cpf = ?, " +
                    "    senha = ?, " +
                    "    telefone = ?, " +
                    "    nacionalidade = ? " +
                    "where" +
                    "    id_comprador = ?";
            this.preparedStatement = connection.prepareStatement(this.sql);
            this.preparedStatement.setString(1, u.getPrimeiro_nome());
            this.preparedStatement.setString(2, u.getSegundo_nome());
            this.preparedStatement.setString(3, u.getEmail());
            this.preparedStatement.setString(4, u.getCpf());
            this.preparedStatement.setString(5, u.getSenha());
            this.preparedStatement.setString(6, u.getTelefone());
            this.preparedStatement.setString(7, u.getNacionalidade());
            this.preparedStatement.setInt(8, u.getId_comprador());
            this.preparedStatement.executeUpdate();

            if (this.preparedStatement.getUpdateCount() > 0) {
                this.status = "OK";
                connection.commit();
            }

        } catch (SQLException e) {
            e.printStackTrace();
            this.status = "OK";
        }
        return "";
    }

    public String editarArtista(Usuario u) {

        try (Connection connection = new ConectaDBPostgres().getConexao()) {

            connection.setAutoCommit(false);

            this.sql = "update" +
                    "    ARTISTA " +
                    "set" +
                    "    primeiro_nome = ?, " +
                    "    segundo_nome = ?, " +
                    "    email = ?, " +
                    "    cpf = ?, " +
                    "    senha = ?, " +
                    "    telefone = ?, " +
                    "    nacionalidade = ? " +
                    "where" +
                    "    id_artista = ?";
            this.preparedStatement = connection.prepareStatement(this.sql);
            this.preparedStatement.setString(1, u.getPrimeiro_nome());
            this.preparedStatement.setString(2, u.getSegundo_nome());
            this.preparedStatement.setString(3, u.getEmail());
            this.preparedStatement.setString(4, u.getCpf());
            this.preparedStatement.setString(5, u.getSenha());
            this.preparedStatement.setString(6, u.getTelefone());
            this.preparedStatement.setString(7, u.getNacionalidade());
            this.preparedStatement.setInt(8, u.getId_comprador());
            this.preparedStatement.executeUpdate();

            if (this.preparedStatement.getUpdateCount() > 0) {
                this.status = "OK";
                connection.commit();
            }

        } catch (SQLException e) {
            e.printStackTrace();
            this.status = "OK";
        }
        return "";
    }

    public String deletarComprador(int id) {
        try (Connection connection = new ConectaDBPostgres().getConexao()) {

            connection.setAutoCommit(false);

            this.sql = "delete from COMPRADOR where ID_COMPRADOR = ?";
            this.preparedStatement = connection.prepareStatement(this.sql);
            this.preparedStatement.setInt(1, id);
            this.preparedStatement.executeUpdate();

            if (this.preparedStatement.getUpdateCount() > 0) {
                this.status = "OK";
                System.out.println(this.status);
                connection.commit();
            }

        } catch (SQLException e) {
            e.printStackTrace();
            this.status = "OK";
        }
        return "";
    }

    public String deletarArtista(int id) {
        try (Connection connection = new ConectaDBPostgres().getConexao()) {

            connection.setAutoCommit(false);

            this.sql = "delete from ARTISTA where ID_ARTISTA = ?";
            this.preparedStatement = connection.prepareStatement(this.sql);
            this.preparedStatement.setInt(1, id);
            this.preparedStatement.executeUpdate();

            if (this.preparedStatement.getUpdateCount() > 0) {
                this.status = "OK";
                System.out.println(this.status);
                connection.commit();
            }

        } catch (SQLException e) {
            e.printStackTrace();
            this.status = "OK";
        }
        return "";
    }
}
