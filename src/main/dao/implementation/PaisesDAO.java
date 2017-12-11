package main.dao.implementation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import main.dao.interfaces.IPaisesDAO;
import main.utils.ConexionDAO;
import main.vo.PaisVO;

public class PaisesDAO extends ConexionDAO implements IPaisesDAO {

	@Override
	public ArrayList<PaisVO> consultarPaises() {
		// TODO Auto-generated method stub

		ArrayList<PaisVO> listaPaises = new ArrayList<PaisVO>();

		String query = "SELECT * FROM PAISES ORDER BY NOMBRE ASC";

		try {

			Connection connection = null;
			connection = crearConexion(connection);

			Statement statement = connection.createStatement();

			statement.execute(query);

			ResultSet resultSet = statement.getResultSet();

			while(resultSet.next()) {

				PaisVO paisVO = new PaisVO();

				paisVO.setId(resultSet.getInt("ID"));
				paisVO.setNombre(resultSet.getString("NOMBRE"));
				paisVO.setStatus(resultSet.getString("STATUS"));

				listaPaises.add(paisVO);
			}

			cerrarConexion(resultSet, statement, connection);

		}catch(Exception e) {

			System.out.println("Error en consultaProgramas de ProgramasDAO. Mensaje: " + e);

		}

		return listaPaises;
	}

}
