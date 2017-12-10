/**
 *
 */
package main.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.sun.media.jfxmedia.logging.Logger;

/**
 * @author sergio
 *
 */
public class ConexionDAO {

	protected Connection crearConexion(Connection connection) throws Exception{

		Context initContex = new InitialContext();
		Context envContext = (Context) initContex.lookup("java:/comp/env");

		DataSource ds = (DataSource) envContext.lookup("jdbc/conexionCMA");

		connection = ds.getConnection();

		Logger.logMsg(1, "conexion creada");

		return connection;
	}

	protected void cerrarConexion(ResultSet resultSet, Statement statement, Connection connection) throws Exception{
		if (resultSet != null && statement != null && connection != null) {
			resultSet.close();
			statement.close();
			connection.close();
		}
	}
}
