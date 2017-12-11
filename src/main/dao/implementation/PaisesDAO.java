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

		} catch (Exception e) {

			System.out.println("Error en consultarPaises de PaisesDAO. Mensaje: " + e);

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
			System.out.println("Error en insertarPais de PaisesDAO. Mensaje: " + e);
			respuesta = "Error al agregar Pais";
		}

		return respuesta;
	}

	@Override
	public PaisVO consultarPais(int id) {
		// TODO Auto-generated method stub

		PaisVO pais = new PaisVO();

		String query = "SELECT * FROM PAISES WHERE ID = " + id;

		try {

			Connection connection = null;
			connection = crearConexion(connection);

			Statement statement = connection.createStatement();

			statement.execute(query);

			ResultSet resultSet = statement.getResultSet();

			resultSet.next();

			pais.setId(resultSet.getInt("ID"));
			pais.setNombre(resultSet.getString("NOMBRE"));
			pais.setStatus(resultSet.getString("STATUS"));

			cerrarConexion(resultSet, statement, connection);
		} catch (Exception e) {
			System.out.println("Error en consultarPais de PaisesDAO. Mensage: "+e);
		}

		return pais;
	}

	@Override
	public String actualizarPais(PaisVO pais) {
		// TODO Auto-generated method stub

		String respuesta = "";

		try {

			Connection connection = null;
			connection = crearConexion(connection);

			String query = "UPDATE PAISES SET NOMBRE = ?, STATUS = ? WHERE ID = ?";

			PreparedStatement statement = connection.prepareStatement(query);

			statement.setString(1, pais.getNombre());
			statement.setString(2, pais.getStatus());
			statement.setInt(3, pais.getId());

			statement.executeUpdate();

			ResultSet resultSet = statement.getResultSet();

			cerrarConexion(resultSet, statement, connection);

			respuesta = "Pais actualizado con exito";


		} catch (Exception e) {

			System.out.println("Error en actualizarPais en PaisesDAO. Mensaje :" + e);
			respuesta = "Error al actualizar pais";
		}

		return respuesta;
	}

	@Override
	public String eliminarPais(PaisVO pais) {
		// TODO Auto-generated method stub

		String respuesta = "";

		try {

			Connection connection = null;
			connection = crearConexion(connection);

			String query = "UPDATE PAISES SET STATUS = ? WHERE ID = ?";

			PreparedStatement statement = connection.prepareStatement(query);

			statement.setString(1, pais.getStatus());
			statement.setInt(2, pais.getId());

			statement.executeUpdate();

			ResultSet resultSet = statement.getResultSet();

			cerrarConexion(resultSet, statement, connection);

			respuesta = "Pais eliminado con exito";

		} catch (Exception e) {
			System.out.println("Error en eliminarPais en ProgramasDAO. Mensaje :" + e);
			respuesta = "Error al eliminar pais";
		}

		return respuesta;
	}

}
