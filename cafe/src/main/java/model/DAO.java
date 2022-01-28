package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class DAO.
 */
public class DAO {

	/** The driver. */
	private String driver = "com.mysql.cj.jdbc.Driver";
	
	/** The url. */
	private String url = "jdbc:mysql://127.0.0.1:3306/dbcafe?useTimezone=true&serverTimezone=UTC";
	
	/** The user. */
	private String user = "root";
	
	/** The password. */
	private String password = "Flapendeusa1806";

	/**
	 * Conectar.
	 *
	 * @return the connection
	 */
	private Connection conectar() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	/**
	 * Teste conexao.
	 */
	public void testeConexao() {
		try {
			Connection con = conectar();
			System.out.println(con);
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * Inserir cadastro.
	 *
	 * @param cadastro the cadastro
	 */
	public void inserirCadastro(JavaBeans cadastro) {

		String create = "insert into colaborador (nome,cpf,alimento,alimento2) values (?,?,?,?)";
		try {

			Connection con = conectar();

			PreparedStatement pst = con.prepareStatement(create);

			pst.setString(1, cadastro.getNome());
			pst.setString(2, cadastro.getCpf());
			pst.setString(3, cadastro.getAlimento());
			pst.setString(4, cadastro.getAlimento2());

			pst.executeUpdate();

			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * Listar cadastros.
	 *
	 * @return the array list
	 */
	public ArrayList<JavaBeans> listarCadastros() {

		ArrayList<JavaBeans> cadastro = new ArrayList<>();
		String read = "select * from colaborador order by nome";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {

				String idcon = rs.getString(1);
				String nome = rs.getString(2);
				String cpf = rs.getString(3);
				String alimento = rs.getString(4);
				String alimento2 = rs.getString(5);

				cadastro.add(new JavaBeans(idcon, nome, cpf, alimento, alimento2));
			}
			con.close();
			return cadastro;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	/**
	 * Selecionar cadastro.
	 *
	 * @param cadastro the cadastro
	 */
	public void selecionarCadastro(JavaBeans cadastro) {
		String read2 = "select * from colaborador where idcon = ?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read2);
			pst.setString(1, cadastro.getIdcon());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {

				cadastro.setIdcon(rs.getString(1));
				cadastro.setNome(rs.getString(2));
				cadastro.setCpf(rs.getString(3));
				cadastro.setAlimento(rs.getString(4));
				cadastro.setAlimento2(rs.getString(5));
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * Alterar cadastro.
	 *
	 * @param cadastro the cadastro
	 */
	public void alterarCadastro(JavaBeans cadastro) {
		String update = "update colaborador set nome=?,cpf=?,alimento=?,alimento2=? where idcon=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(update);
			pst.setString(1, cadastro.getNome());
			pst.setString(2, cadastro.getCpf());
			pst.setString(3, cadastro.getAlimento());
			pst.setString(4, cadastro.getAlimento2());
			pst.setString(5, cadastro.getIdcon());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * Deletar cadastro.
	 *
	 * @param cadastro the cadastro
	 */
	public void deletarCadastro(JavaBeans cadastro) {
		String delete = "delete from colaborador where idcon=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(delete);
			pst.setString(1, cadastro.getIdcon());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
