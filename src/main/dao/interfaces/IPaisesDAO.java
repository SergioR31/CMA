package main.dao.interfaces;

import java.util.ArrayList;

import main.vo.PaisVO;

/**
 * @author Sergio Ramos
 *
 */

public interface IPaisesDAO {
	public ArrayList<PaisVO> consultarPaises();
	public PaisVO consultarPais(int id);
	public String insertarPais(PaisVO pais);
	public String actualizarPais(PaisVO pais);
}
