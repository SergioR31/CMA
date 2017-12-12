package main.dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import main.dao.interfaces.IPaisesDAO;
import main.utils.ConexionDAO;
import main.vo.PaisVO;

/**
 *
 * @author Sergio Ramos
 *
 */
public class PaisesDAO extends ConexionDAO implements IPaisesDAO {

    /**
     *
     */
    private static final Logger LOGGER = Logger.getLogger("main.dao.implementation.PaisesDAO");

    @Override
    public final ArrayList<PaisVO> consultarPaises() throws Exception {

        ArrayList<PaisVO> listaPaises = new ArrayList<>();

        String query = "SELECT * FROM PAISES ORDER BY NOMBRE ASC";

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {

            connection = crearConexion();

            statement = connection.createStatement();

            statement.execute(query);

            resultSet = statement.getResultSet();

            while (resultSet.next()) {

                PaisVO paisVO = new PaisVO();

                paisVO.setId(resultSet.getInt("ID"));
                paisVO.setNombre(resultSet.getString("NOMBRE"));
                paisVO.setStatus(resultSet.getString("STATUS"));

                listaPaises.add(paisVO);
            }

        } catch (Exception e) {

            LOGGER.log(Level.SEVERE, "Error consultarPaises PaisesDAO: " + e);

        } finally {

            cerrarConexion(resultSet, statement, connection);
        }

        return listaPaises;
    }

    @Override
    public final String insertarPais(final PaisVO pais) throws SQLException {

        String queryId = "SELECT id_pai_seq.nextval AS nextId FROM DUAL";

        String query = "INSERT INTO PAISES VALUES(?, ?, ?)";
        // ID, NOMBRE

        String respuesta = "";

        Connection connection = null;
        Statement stId = null;
        ResultSet rsId = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {

            connection = crearConexion();

            stId = connection.createStatement();

            stId.executeQuery(queryId);

            rsId = stId.getResultSet();
            rsId.next();
            int id = rsId.getInt("nextId");

            statement = connection.prepareStatement(query);

            statement.setInt(1, id);
            statement.setString(2, pais.getNombre());
            statement.setString(3, pais.getStatus());

            statement.executeUpdate();

            resultSet = statement.getResultSet();

            respuesta = "Pais agregado con exito";

        } catch (Exception e) {

            LOGGER.log(Level.SEVERE, "Error insertarPais PaisesDAO: " + e);
            respuesta = "Error al agregar Pais";

        } finally {

            cerrarConexion(rsId, stId, connection);
            cerrarConexion(resultSet, statement, connection);

        }

        return respuesta;
    }

    @Override
    public final PaisVO consultarPais(final int id) throws SQLException {

        PaisVO pais = new PaisVO();

        String query = "SELECT * FROM PAISES WHERE ID = ?";

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {

            connection = crearConexion();

            statement = connection.prepareStatement(query);

            statement.setInt(1, id);

            statement.executeUpdate();

            resultSet = statement.getResultSet();

            resultSet.next();

            pais.setId(resultSet.getInt("ID"));
            pais.setNombre(resultSet.getString("NOMBRE"));
            pais.setStatus(resultSet.getString("STATUS"));

        } catch (Exception e) {

            LOGGER.log(Level.SEVERE, "Error consultarPais PaisesDAO: " + e);

        } finally {

            cerrarConexion(resultSet, statement, connection);

        }

        return pais;
    }

    @Override
    public final String actualizarPais(final PaisVO pais) throws SQLException {

        String query = "UPDATE PAISES SET NOMBRE = ?, STATUS = ? WHERE ID = ?";

        String respuesta = "";

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {

            connection = crearConexion();

            statement = connection.prepareStatement(query);

            statement.setString(1, pais.getNombre());
            statement.setString(2, pais.getStatus());
            statement.setInt(3, pais.getId());

            statement.executeUpdate();

            resultSet = statement.getResultSet();

            respuesta = "Pais actualizado con exito";

        } catch (Exception e) {

            LOGGER.log(Level.SEVERE, "Error actualizarPais PaisesDAO:" + e);
            respuesta = "Error al actualizar pais";

        } finally {

            cerrarConexion(resultSet, statement, connection);
        }

        return respuesta;
    }

    @Override
    public final String eliminarPais(final PaisVO pais) throws SQLException {

        String query = "UPDATE PAISES SET STATUS = ? WHERE ID = ?";

        String respuesta = "";

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {

            connection = crearConexion();

            statement = connection.prepareStatement(query);

            statement.setString(1, pais.getStatus());
            statement.setInt(2, pais.getId());

            statement.executeUpdate();

            resultSet = statement.getResultSet();

            respuesta = "Pais eliminado con exito";

        } catch (Exception e) {

            LOGGER.log(Level.SEVERE, "Error eliminarPais ProgramasDAO: " + e);
            respuesta = "Error al eliminar pais";

        } finally {

            cerrarConexion(resultSet, statement, connection);

        }

        return respuesta;
    }

}
