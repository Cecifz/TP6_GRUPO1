package entidad;

public class Persona {
    private String dni;
    private String nombre;
    private String apellido;

    public Persona() {    }

    public Persona(String nombre, String apellido,String dni) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
    }
    public Persona(Persona p) {
        this.dni = p.getDni();
        this.nombre = p.getNombre();
        this.apellido = p.getApellido();
    }
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String toString() {
       // return "Nombre: " + nombre + ", Apellido: "+ apellido + ", DNI: " + dni;
    	return   nombre + " - "+ apellido + " - " + dni;
    }
}
