package main.dao.interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

import main.vo.PaisVO;

/**
 * @author Sergio Ramos
 *
 */

public interface IPaisesDAO {

    /**
     * Metodo para consultar paises.
     *
     * @return Arreglo de objetos PaisesVO.
     * @throws Exception
     *             si hay error en el metodo
     */
    ArrayList<PaisVO> consultarPaises() throws Exception;

    /**
     * Metodo para consultar un pais en especifico.
     *
     * @param id
     *            Define el id del pais a consultar.
     * @return El objeto PaisVO con sus respectivos datos.
     * @throws SQLException
     *             si falla cerrar Conexion
     */
    PaisVO consultarPais(int id) throws SQLException;

    /**
     * Metodo para la insercion de un pais.
     *
     * @param pais
     *            Define el objeto que se va a insertar.
     * @return Mensaje confirmando la insercion del pais.
     * @throws SQLException
     *             si falla cerrar Conexion
     */
    String insertarPais(PaisVO pais) throws SQLException;

    /**
     * Metodo para actualizar un pais.
     *
     * @param pais
     *            Define el objeto que se va a actualizar.
     * @return Mensaje confirmando la actualizacion.
     * @throws SQLException
     *             si falla cerrar Conexion
     */
    String actualizarPais(PaisVO pais) throws SQLException;

    /**
     * Metodo para eliminar un pais.
     *
     * @param pais
     *            Define el objeto que se va a eliminar.
     * @return Mensaje confirmando la eliminacion.
     * @throws SQLException
     *             si falla cerrar Conexion
     */
    String eliminarPais(PaisVO pais) throws SQLException;
}
