package main.services.implementation;

import java.util.ArrayList;

import main.dao.implementation.PaisesDAO;
import main.dao.interfaces.IPaisesDAO;
import main.services.interfaces.IPaisesService;
import main.vo.PaisVO;

public class PaisesService implements IPaisesService {

	@Override
	public ArrayList<PaisVO> listarPaises() {
		// TODO Auto-generated method stub

		ArrayList<PaisVO> listaPaises = new ArrayList<PaisVO>();

		IPaisesDAO paisesDAO = new PaisesDAO();

		try {

			listaPaises = paisesDAO.consultarPaises();

			for (int i = 0; i<listaPaises.size(); i++) {
				if(listaPaises.get(i).getStatus().equals("Eliminado") || listaPaises.get(i).getStatus().equals("Inactivo")) {
					listaPaises.remove(i);
				}
			}

		} catch (Exception e) {
			System.out.println("Error en listarPaises de PaisService. Mensaje: "+e);
		}

		return listaPaises;
	}

	@Override
	public ArrayList<PaisVO> consultarPaises() {
		// TODO Auto-generated method stub

		ArrayList<PaisVO> listaPaises = new ArrayList<PaisVO>();

		IPaisesDAO paisesDAO = new PaisesDAO();

		try {

			listaPaises = paisesDAO.consultarPaises();

			for (int i = 0; i<listaPaises.size(); i++) {
				if(listaPaises.get(i).getStatus().equals("Eliminado")) {
					listaPaises.remove(i);
				}
			}

		} catch (Exception e) {
			System.out.println("Error en consultarPaises de PaisService. Mensaje: "+e);
		}

		return listaPaises;

	}

	@Override
	public String insertarPais(PaisVO pais) {
		// TODO Auto-generated method stub

		ArrayList<PaisVO> listaPaises = new ArrayList<PaisVO>();

		IPaisesDAO paisesDAO = new PaisesDAO();

		boolean realizarInsert = true;

		String respuesta ="";

		int id_encontrado = 0;

		try {

			listaPaises = consultarPaises();

			for(int i=0; i<listaPaises.size();i++) {
				if(listaPaises.get(i).getNombre().equalsIgnoreCase(pais.getNombre())) {
					realizarInsert = false;
					System.out.println("Pais a insertar: " + pais.getNombre() + " || Pais en DB: " + listaPaises.get(i).getNombre());

					id_encontrado = listaPaises.get(i).getId();
					System.out.println("id Programa en DB: " + id_encontrado);
				}
			}

			if (realizarInsert == true) {

				respuesta = paisesDAO.insertarPais(pais);

			}else {
				System.out.println("Pais ya existe");
				String status = "Disponible";
				pais.setStatus(status);
				pais.setId(id_encontrado);
				respuesta = "Pais ya existe";
				//				respuesta = actualizarPrograma(programa);
			}
		} catch (Exception e) {
			System.out.println("Error en insertarPais de PaisesService. Mensaje: "+e);
		}
		return respuesta;
	}


}