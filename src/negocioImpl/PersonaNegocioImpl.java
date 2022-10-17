package negocioImpl;

import java.util.List;

import dao.PersonaDao;
import daoImpl.PersonaDaoImpl;
import entidad.Persona;
import negocio.PersonaNegocio;

public class PersonaNegocioImpl implements PersonaNegocio{

PersonaDao pdao = new PersonaDaoImpl();
	
	@Override
	public boolean insert(Persona persona) {
		
		boolean estado=false;
		if(persona.getNombre().trim().length()>0 && persona.getDni().trim().length()>0  && persona.getApellido().trim().length()>0)
		{
			estado=pdao.insert(persona);
		}
		return estado;
	}

	@Override
	public boolean delete(Persona persona_a_eliminar) {
		boolean estado=false;
		try
		{
			if(  Integer.parseInt(persona_a_eliminar.getDni())  > 0 )
			{
				estado=pdao.delete(persona_a_eliminar);
			}
		}
		catch(Exception e) {
            e.printStackTrace();
}
		return estado;
	}

	@Override
	public List<Persona> readAll() {
		
		List<Persona> lPersona;
		lPersona = pdao.readAll();
		return lPersona;
	}

}

