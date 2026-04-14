package br.ulbra.dao;

import br.ulbra.model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class UsuarioDAO {

    Connection con;

    public UsuarioDAO() throws SQLException {
        con = ConnectionFactory.getConnection();
    }

    public boolean checkLogin(String email, String senha) {

        PreparedStatement stmt = null;
        ResultSet rs = null;

        boolean check = false;

        try {

            stmt = con.prepareStatement("SELECT * FROM tbusuario WHERE email = ? and senha = ?");
            stmt.setString(1, email);
            stmt.setString(2, senha);

            rs = stmt.executeQuery();

            if (rs.next()) {
                check = true;
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return check;

    }

    public ArrayList<Usuario> read() {

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Usuario> usuarios = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM tbUsuario");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setEmail(rs.getString("email"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setSexo(rs.getString("sexo"));
                usuario.setFone(rs.getString("fone"));
                usuarios.add(usuario);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return (ArrayList<Usuario>) usuarios;
    }

    public void deleteAllUsers() {
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("TRUNCATE tbusuario");
            stmt.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public void deleteUser(int idAlvo) {
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("DELETE FROM tbusuario WHERE id = ?");
            stmt.setInt(1, idAlvo);

            stmt.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public void create(Usuario u) {
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("INSERT INTO tbusuario (nome, email, senha, sexo, fone) VALUES (?,?,?,?,?)");

            stmt.setString(1, u.getNome());
            stmt.setString(2, u.getEmail());
            stmt.setString(3, u.getSenha());
            stmt.setString(4, u.getSexo());
            stmt.setString(5, u.getFone());

            stmt.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro:" + ex.getMessage());

        } finally {
            //ConnectionFactory.closeConnection(con, stmt);
        }

    }

}
