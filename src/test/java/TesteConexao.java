import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.Test;

import dao.DbMySql;

public class TesteConexao {

	@Test
	public void TesteDeConexao() {
		
		int conn = new DbMySql().ConectarBanco();
		
		if(conn > 0) {
			System.out.println(conn);
			assertTrue(true);
		}
		else {
			fail("erro na conexao com o banco de dados");
		}
	}

}
