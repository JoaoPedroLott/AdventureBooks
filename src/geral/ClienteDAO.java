package geral;

import java.sql.ResultSet;
import java.util.ArrayList;
import beans.Cliente;

public class ClienteDAO {

	public static void Incluir(Cliente cliente) throws Exception{
		String sql = "insert into Cliente (nome, email, senha, chaveFunc) "+
				"values('"+cliente.getNomeCliente()+"',"
						+ " '"+cliente.getEmailCliente()+"', '"+cliente.getSenhaCliente()+"','C')";
		Conexao.execSql(sql);;
	}
	
	public static void Delete(Cliente cliente) throws Exception{
		String sql = "delete from Cliente where codigo ="+cliente.getCodigoCliente()+"";
		Conexao.execSql(sql);
	}
	
	public static ArrayList<Cliente> getData() throws Exception {
		String sql = "select * from Cliente order by nome";
		ResultSet rs = Conexao.getList(sql);
		
		if (rs == null)
			throw new Exception("Não existe registros");
		
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		
		while (rs.next()) {
			Cliente cliente = new Cliente();
			cliente.setCodigoCliente(rs.getInt("codigo"));
			cliente.setNomeCliente(rs.getString("nome"));
			cliente.setEmailCliente(rs.getString("email"));
			cliente.setSenhaCliente(rs.getString("senha"));
			clientes.add(cliente);
		}
		return clientes;
	}
	
	public static String FuncionarioEx(String email) throws Exception {
		String sql = "select chaveFunc from Cliente where email='"+email+"'";
		ResultSet rs = Conexao.getList(sql);
		if (rs == null)
			throw new Exception("Não existe registros");
		
		String chave = rs.getString("chaveFunc");
		return chave;
	}
	
	
	public static void Alterar(Cliente cliente) throws Exception {
		String sql = "update Cliente set nome ='"+cliente.getNomeCliente()+"',set email ='"+cliente.getEmailCliente()+"'"
				+"',set senha ='"+cliente.getSenhaCliente()+"'"+ " where codigo = '"+cliente.getCodigoCliente()+"'";
		Conexao.execSql(sql);
	}
}
