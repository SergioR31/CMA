package main.services.implementation;

import java.util.ArrayList;
import java.util.Collection;

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

		Collection<PaisVO> paisesNoMostrar = new ArrayList<PaisVO>();

		try {

			listaPaises = paisesDAO.consultarPaises();

			for (int i = 0; i<listaPaises.size(); i++) {
				if(listaPaises.get(i).getStatus().equals("Eliminado") || listaPaises.get(i).getStatus().equals("Inactivo")) {
					paisesNoMostrar.add(listaPaises.get(i));
				}
			}

			listaPaises.removeAll(paisesNoMostrar);

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

		int idEncontrado = 0;

		try {

			listaPaises = paisesDAO.consultarPaises();

			for(int i=0; i<listaPaises.size();i++) {
				if(listaPaises.get(i).getNombre().equalsIgnoreCase(pais.getNombre())) {

					realizarInsert = false;

					idEncontrado = listaPaises.get(i).getId();
				}
			}

			if (realizarInsert) {

				respuesta = paisesDAO.insertarPais(pais);

			}else {

				String status = "Disponible";
				pais.setStatus(status);
				pais.setId(idEncontrado);
				respuesta = actualizarPais(pais);
			}
		} catch (Exception e) {
			System.out.println("Error en insertarPais de PaisesService. Mensaje: "+e);
		}
		return respuesta;
	}

	@Override
	public PaisVO consultarPais(int id) {
		// TODO Auto-generated method stub

		PaisVO pais = new PaisVO();

		IPaisesDAO paisDAO = new PaisesDAO();

		pais = paisDAO.consultarPais(id);

		return pais;
	}

	@Override
	public String actualizarPais(PaisVO pais) {
		// TODO Auto-generated method stub

		ArrayList<PaisVO> listaPaises = new ArrayList<PaisVO>();

		String respuesta = "";

		IPaisesDAO paisDAO = new PaisesDAO();

		boolean realizarUpdate= true;

		int idEncontrado = 0;

		try {

			listaPaises = paisDAO.consultarPaises();

			for(int i=0; i<listaPaises.size();i++) {
				if(listaPaises.get(i).getNombre().equalsIgnoreCase(pais.getNombre())) {

					idEncontrado = listaPaises.get(i).getId();

					realizarUpdate = false;

					respuesta = "Pais ya existe.";

					if(pais.getId() == (idEncontrado)) {
						if(listaPaises.get(i).getStatus().equals("Eliminado")) {

							realizarUpdate = true;

							respuesta = "Pais ya existe. Actualizando estado a Disponible... ";
						}
					}
				}
			}

			if (realizarUpdate) {

				respuesta += paisDAO.actualizarPais(pais);

			}


		} catch (Exception e) {
			System.out.println("Error en actualizarPais de PaisesService. Mensaje: " + e);
		}

		return respuesta;
	}

	@Override
	public String eliminarPais(PaisVO pais) {
		// TODO Auto-generated method stub

		String respuesta ="";

		IPaisesDAO paisDAO = new PaisesDAO();

		try {

			respuesta = paisDAO.eliminarPais(pais);

		}catch(Exception e) {
			System.out.println("Error en eliminarPais de PaisesService. Mensaje: "+e);
		}

		return respuesta;
	}

}