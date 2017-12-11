package main.services.interfaces;

import java.util.ArrayList;

import main.vo.PaisVO;

/**
 * @author Sergio Ramos
 *
 */

public interface IPaisesService {
	public ArrayList<PaisVO> listarPaises ();
	public ArrayList<PaisVO> consultarPaises ();
	public PaisVO consultarPais(int id);
	public String insertarPais(PaisVO pais);
	public String actualizarPais(PaisVO pais);
	public String eliminarPais(PaisVO pais);

}
