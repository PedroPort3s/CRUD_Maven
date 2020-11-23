package helper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class db {

	public static int ProximaID(Connection conexao, String nomeCampo, String nomeTabela) throws SQLException {

		int proxNumero = 0;

		try {

			PreparedStatement statement = conexao
					.prepareStatement("select ifnull(max(" + nomeCampo + "),0) as 'maior' from " + nomeTabela + "");

			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				proxNumero = resultSet.getInt("maior");
			}

			if (proxNumero < 0)
				throw new SQLException("Nï¿½o foi possï¿½vel recuperar o proximo nï¿½mero da(o) " + nomeTabela + "");

			statement.close();

		} catch (SQLException sqlEx) {
			/* sqlEx.printStackTrace(); */
			throw sqlEx;
		} 

		return proxNumero + 1;
	}

	public static void VerificarPeriodo(Date dataIni, Date dataFim) throws Exception {
		if (dataIni == null)
			throw new Exception("Informe uma data inicial válida.");

		if (dataFim == null)
			throw new Exception("Informe uma data final válida.");

		if (dataFim.before(dataIni))
			throw new Exception("A data inicial não pode ser maior que a data final.");
	}

}
