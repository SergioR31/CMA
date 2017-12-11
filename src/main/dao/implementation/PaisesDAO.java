package main.dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
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

	@Override
	public String insertarPais(PaisVO pais) {
		// TODO Auto-generated method stub

		String queryId = "SELECT id_pai_seq.nextval AS nextId FROM DUAL";

		String respuesta = "";

		try {

			Connection connection = null;
			connection = crearConexion(connection);

			Statement stId = connection.createStatement();

			stId.executeQuery(queryId);

			ResultSet rsId = stId.getResultSet();
			rsId.next();
			int id = rsId.getInt("nextId");

			String query = "INSERT INTO PAISES VALUES(?, ?, ?)";
			//ID, NOMBRE

			PreparedStatement statement = connection.prepareStatement(query);

			statement.setInt(1, id);
			statement.setString(2, pais.getNombre());
			statement.setString(3, pais.getStatus());

			statement.executeUpdate();

			ResultSet resultSet = statement.getResultSet();

			cerrarConexion(resultSet, statement, connection);

			respuesta = "Pais agregado con exito";
		} catch (Exception e) {
			System.out.println("Error en insertarPais de PaisDAO. Mensaje: " + e);
			respuesta = "Error al agregar Pais";
		}

		return respuesta;
	}
}
