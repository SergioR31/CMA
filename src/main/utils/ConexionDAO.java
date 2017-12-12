/**
 *
 */
package main.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.sun.media.jfxmedia.logging.Logger;

/**
 * @author sergio
 *
 */
public class ConexionDAO {

    /**
     *
     * @return La conxion establecida
     * @throws NamingException
     *             Si el nombre no es correcto
     * @throws SQLException
     *             Si hay problema con la conexion
     */
    protected final Connection crearConexion() throws NamingException, SQLException {

        Connection connection;

        Context initContex = new InitialContext();
        Context envContext = (Context) initContex.lookup("java:/comp/env");

        DataSource ds = (DataSource) envContext.lookup("jdbc/conexionCMA");

        connection = ds.getConnection();

        Logger.logMsg(1, "conexion creada");

        return connection;
    }

    /**
     *
     * @param rs
     *            Indica el ResultSet
     * @param st
     *            Indica el Statement
     * @param conn
     *            Indica la Conexion
     * @throws SQLException
     *             si falla el cierre de conexion
     */
    protected final void cerrarConexion(final ResultSet rs, final Statement st, final Connection conn)
            throws SQLException {
        if (rs != null && st != null && conn != null) {
            rs.close();
            st.close();
            conn.close();
        }
    }
}
