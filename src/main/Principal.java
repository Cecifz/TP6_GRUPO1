package main;

import entidad.Persona;
import negocio.PersonaNegocio;
import negocioImpl.PersonaNegocioImpl;
import presentacion.vista.VentanaPrincipal;


public class Principal {

    public static void main(String[] args) {
  
        VentanaPrincipal vPrinc = new VentanaPrincipal();
        vPrinc.setVisible(true);
        
        
        Persona p = new Persona("44444", "aasd", "Fernandez");
        PersonaNegocioImpl PNeg = new PersonaNegocioImpl();
        
        try {
        	 if (PNeg.insert(p))
                 System.out.println("Persona agregada.");
        	 else
        		 System.out.println("Persona No agregada.");
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        
        
        
        //PARA PROBAR CONEXION A BD
     /*   Persona p = new Persona("12345678", "Cecilia", "Fernandez");
        String insert = "Insert into Personas(Dni,Nombre,Apellido) values ('"+p.getDni()+"','"+p.getNombre()+"','"+p.getApellido()+"')";
        String read = "SELECT * FROM personas";

        try {
            PreparedStatement statement;
            Connection conexion = Conexion.getConexion().getSQLConexion();
            //INSERTA LA PERSONA:
            statement = conexion.prepareStatement(insert);

            if (statement.executeUpdate() > 0) {
                conexion.commit();
                System.out.println("Persona agregada.");

                //LEE Y MUESTRA EN CONSOLA:
                Persona pAgregada = new Persona();
                ResultSet rs= statement.executeQuery(read);
                rs.next();
                pAgregada.setApellido((rs.getString(3)));
                pAgregada.setNombre((rs.getString(2)));
                pAgregada.setDni((rs.getString(1)));
                System.out.println(pAgregada.toString());
            }
        }
            catch(Exception e) {
                    e.printStackTrace();
        }*/

    }

}