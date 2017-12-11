package main.dao.interfaces;

import java.util.ArrayList;

import main.vo.PaisVO;

public interface IPaisesDAO {
	public ArrayList<PaisVO> consultarPaises();

	public String insertarPais(PaisVO pais);
}
