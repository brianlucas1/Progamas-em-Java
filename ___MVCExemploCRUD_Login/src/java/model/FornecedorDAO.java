package model;

import model.bean.Fornecedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utils.ConnectionFactory;

// fazer FornecedorDAO
public class FornecedorDAO {

    private final Connection conexao;
    PreparedStatement ps = null;
    String sqlSel = "SELECT * FROM CliFor ORDER BY nome ASC;";

    public FornecedorDAO() throws SQLException {
        this.conexao = ConnectionFactory.getInstance().getConnection();
    }

    public String inserir(Fornecedor f) throws SQLException {
            String sql = "INSERT INTO CliFor "
                + "(nome, telefone , tipo, valorUltOper) "
                + "VALUES (?, ?, ?,?) ";
        try {
            PreparedStatement psI = conexao.prepareStatement(sql);
            psI.setString(1, f.getNome());
            psI.setString(2, f.getTelefone());
            psI.setString(3, f.getTipo());
            psI.setFloat(4, f.getValorUltimaCompra());
            psI.execute();
            conexao.close();
            return "Registro incluído com sucesso!";
        } catch (SQLException e) {
            return e.getMessage();
        }
    }

    public List<Fornecedor> editar(Fornecedor f) throws SQLException {
        String sql = "SELECT * FROM CliFor WHERE id = ?;";

        List lstFornecedor = new ArrayList();

        try {
            PreparedStatement psC = conexao.prepareStatement(sql);
            psC.setInt(1, f.getId());

            ResultSet rs = psC.executeQuery();
            rs.next();

            f = new Fornecedor();
            f.setId(rs.getInt("id"));
            f.setNome(rs.getString("nome"));
            f.setTelefone(rs.getString("telefone"));
            f.setTipo(rs.getString("tipo"));
            f.setValorUltimaCompra(rs.getFloat("valorUltOper"));

            lstFornecedor.add(f);
            conexao.close();
        } catch (SQLException e) {
            return null;
        }
        return lstFornecedor;
    }


    public String excluir(Fornecedor f) throws SQLException {
        String sql = "DELETE FROM CliFor WHERE id = ?;";
        try {
            PreparedStatement psE = conexao.prepareStatement(sql);
            psE.setInt(1, f.getId());
            psE.executeUpdate();
            conexao.close();
        } catch (SQLException e) {
            return e.getMessage();
        }
        return "Registro excluído com sucesso!";
    }

    public String alterar(Fornecedor f) {
        String sql = "UPDATE CliFor SET "
                + "nome = ? , telefone = ?, tipo = ?, valorUltOper = ?"
                + "WHERE id = ?;";
        try {
            PreparedStatement psA = conexao.prepareStatement(sql);
                        psA.setString(1, f.getNome());
            psA.setString(2, f.getTelefone());
            psA.setString(3, f.getTipo());
            psA.setFloat(4, f.getValorUltimaCompra());
            psA.setInt(5, f.getId());
            psA.executeUpdate();
            conexao.close();
        } catch (SQLException e) {
            return e.getMessage();
        }
        return "Registro alterado com sucesso!";
    }

    public List<Fornecedor> pesquisar(Fornecedor f) throws SQLException {
        List lista = listar(f);
        return lista;
    }

    private List listar(Fornecedor f) throws SQLException {
        sqlSel = "SELECT * FROM CliFor "
                + "WHERE nome like ?   "
                + "ORDER BY nome ASC;  ";
        ps = conexao.prepareStatement(sqlSel);
        ps.setString(1, f.getNome());
        return listar();
    }

    public List<Fornecedor> listar() {
        List lista = new ArrayList();
        try {
            if (ps == null) {
                this.ps = conexao.prepareStatement(sqlSel);
            }
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Fornecedor p = new Fornecedor();

                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setTelefone(rs.getString("telefone"));
                p.setTipo(rs.getString("tipo"));
                p.setValorUltimaCompra(rs.getFloat("valorUltOper"));

                lista.add(p);
            }
            conexao.close();
        } catch (SQLException e) {
            lista = null;
        }
        return lista;
    }
}
