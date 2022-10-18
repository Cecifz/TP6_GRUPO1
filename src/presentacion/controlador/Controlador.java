package presentacion.controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;

import entidad.Persona;
import negocio.PersonaNegocio;
import presentacion.vista.PanelEliminarPersonas;
import presentacion.vista.PanelListarPersonas;
import presentacion.vista.PanelModificarPersonas;
import presentacion.vista.VentanaPrincipal;
import presentacion.vista.PanelAgregarPersonas;


public class Controlador implements ActionListener {

	private VentanaPrincipal ventanaPrincipal;
	private PanelAgregarPersonas pnlIngresoPersonas;
	private PanelEliminarPersonas pnlEliminarPersonas;
	private PanelModificarPersonas pnlModificarPersonas;
	private PanelListarPersonas pnlListarPersonas;
	private PersonaNegocio pNeg;
	private ArrayList<Persona> personasEnTabla;
	
	//Constructor
	public Controlador(VentanaPrincipal vista, PersonaNegocio pNeg)
	{
		//Guardo todas las instancias que recibo en el constructor
		this.ventanaPrincipal = vista;
		this.pNeg = pNeg;
		
		//Instancio los paneles
		this.pnlIngresoPersonas = new PanelAgregarPersonas();
		this.pnlEliminarPersonas = new PanelEliminarPersonas();
		this.pnlModificarPersonas = new PanelModificarPersonas();
		this.pnlListarPersonas = new PanelListarPersonas();
		//Enlazo todos los eventos
		
		//Eventos menu del Frame principal llamado Ventana
		this.ventanaPrincipal.getMenuAgregar().addActionListener(a->EventoClickMenu_AbrirPanel_AgregarPersona(a));
		this.ventanaPrincipal.getMenuEliminar().addActionListener(a->EventoClickMenu_AbrirPanel_EliminarPersona(a));
		this.ventanaPrincipal.getMenuModificar().addActionListener(a->EventoClickMenu_AbrirPanel_ModificarPersona(a));
		this.ventanaPrincipal.getMenuListar().addActionListener(a->EventoClickMenu_AbrirPanel_ListarPersona(a));
		//Eventos PanelAgregarPersonas
		 this.pnlIngresoPersonas.getBtnAgregar().addActionListener(a->EventoClickBoton_AgregarPesona_PanelAgregarPersonas(a));
		
		//Eventos PanelEliminarPersonas
		 
		 this.pnlEliminarPersonas.getList().addListSelectionListener(a->EventoClickList_EliminarPesona_PanelEliminarPersonas(a));
		 this.pnlEliminarPersonas.getBtnBorrar().addActionListener(a->EventoClickBoton_EliminarPesona_PanelEliminarPersonas(a));
		///Eventos Modificar Personas
		 this.pnlModificarPersonas.getBtnModificar().addActionListener(a->EventoClickBoton_ModificarPesona_PanelModificarPersonas(a));
		 this.pnlModificarPersonas.getList().addListSelectionListener(a->EventoClickList_ModificarPesona_PanelModificarPersonas(a));
		 
		}
	
	
	
	public void  EventoClickMenu_AbrirPanel_ListarPersona(ActionEvent a)
	{
		ventanaPrincipal.getContentPane().removeAll();
		ventanaPrincipal.getContentPane().add(pnlListarPersonas);
		refrescarTabla();
		ventanaPrincipal.getContentPane().repaint();
		ventanaPrincipal.getContentPane().revalidate();
	}
	
	//EventoClickMenu abrir PanelAgregarPersonas
	public void  EventoClickMenu_AbrirPanel_AgregarPersona(ActionEvent a)
	{		
		ventanaPrincipal.getContentPane().removeAll();
		ventanaPrincipal.getContentPane().add(pnlIngresoPersonas);
		ventanaPrincipal.getContentPane().repaint();
		ventanaPrincipal.getContentPane().revalidate();
	}
	
	//EventoClickMenu abrir PanelModificarPersonas
	public void EventoClickBoton_ModificarPesona_PanelModificarPersonas(ActionEvent a)
	{
		try {
			String nombre = this.pnlModificarPersonas.getTxtNombre().getText();
			String apellido = this.pnlModificarPersonas.getTxtApellido().getText();
			String dni = this.pnlModificarPersonas.getTxtDni().getText();
			Persona nuevaPersona = new Persona(dni, nombre,apellido);
			
			boolean estado=false;
			if(!pNeg.isNumber(nombre)) {
				if(!pNeg.isNumber(apellido)) {
					if(pNeg.isNumber(dni)) { 
						estado = pNeg.update(nuevaPersona);
						}
					else{ this.pnlIngresoPersonas.mostrarMensaje("Por favor, ingrese numeros en el campo DNI");}
				}else{ this.pnlIngresoPersonas.mostrarMensaje("Por favor, ingrese letras en el campo apellido");}
			}else{ this.pnlIngresoPersonas.mostrarMensaje("Por favor, ingrese letras en el campo nombre");}

			String mensaje;
			if(estado==true)
			{
				mensaje="Persona modificada con exito";
			}
			else
				mensaje="Persona no modificada";
			
			this.pnlModificarPersonas.mostrarMensaje(mensaje);
		
			}
			catch(Exception e) {
				this.pnlModificarPersonas.mostrarMensaje("Error al querer Modificar elemento seleccionado");
			}
		this.pnlModificarPersonas.setTxtNombre("");
		this.pnlModificarPersonas.setTxtApellido("");
		this.pnlModificarPersonas.settxtDni("");
		refrescarTabla();
	}
	
	public void EventoClickBoton_EliminarPesona_PanelEliminarPersonas(ActionEvent a)
	{
		if(!this.pnlEliminarPersonas.getList().isSelectionEmpty())
		try {
			String cadena[] = this.pnlEliminarPersonas.getList().getSelectedValue().toString().split("-");
			Persona persona = new Persona(cadena[2].trim(),cadena[0].trim(),cadena[1].trim());
			
			boolean estado = pNeg.delete(persona);
			String mensaje;
			if(estado==true)
			{
				mensaje="Persona eliminada con exito";
			}
			else
				mensaje="Persona no eliminada";
			
			this.pnlEliminarPersonas.mostrarMensaje(mensaje);
		
			}
			catch(Exception e) {
				this.pnlEliminarPersonas.mostrarMensaje("Error al querer eliminar elemento seleccionado");
			}
		refrescarTabla();
	}
	
	///Evento Seleccionar Persona
	public void EventoClickList_EliminarPesona_PanelEliminarPersonas(ListSelectionEvent a)
	{
		if(!this.pnlEliminarPersonas.getList().isSelectionEmpty())
		{
			
		}
		
	}
	
	
	
	
	
	
	
	
	///Evento Seleccionar Persona
	public void EventoClickList_ModificarPesona_PanelModificarPersonas(ListSelectionEvent a)
	{
		if(!this.pnlModificarPersonas.getList().isSelectionEmpty())
		{
			try {
				String cadena[] = this.pnlModificarPersonas.getList().getSelectedValue().toString().split("-");
				Persona persona = new Persona(cadena[2].trim(),cadena[0].trim(),cadena[1].trim());
				this.pnlModificarPersonas.setTxtApellido(persona.getApellido());
				this.pnlModificarPersonas.setTxtNombre(persona.getNombre());
				this.pnlModificarPersonas.settxtDni(persona.getDni());
				}
				catch(Exception e) {
					this.pnlModificarPersonas.mostrarMensaje("Error al querer mostrar elemento seleccionado");
				}
		}
		
	}
	
	//EventoClickMenu abrir PanelEliminarPersonas
	public void EventoClickMenu_AbrirPanel_EliminarPersona(ActionEvent a)
	{		
		ventanaPrincipal.getContentPane().removeAll();
		ventanaPrincipal.getContentPane().add(pnlEliminarPersonas);
		refrescarTabla();
		ventanaPrincipal.getContentPane().repaint();
		ventanaPrincipal.getContentPane().revalidate();
	}
	
	//EventoClickMenu abrir PanelModificarPersonas
	public void EventoClickMenu_AbrirPanel_ModificarPersona(ActionEvent a) 
	{
		ventanaPrincipal.getContentPane().removeAll();
		ventanaPrincipal.getContentPane().add(pnlModificarPersonas);
		refrescarTabla();
		ventanaPrincipal.getContentPane().repaint();
		ventanaPrincipal.getContentPane().revalidate();
		
	}

	//EventoClickBoton agregar persona en PanelAgregarPersonas
	private void EventoClickBoton_AgregarPesona_PanelAgregarPersonas(ActionEvent a) {
		
		String nombre = this.pnlIngresoPersonas.getTxtNombre().getText();
		String apellido = this.pnlIngresoPersonas.getTxtApellido().getText();
		String dni = this.pnlIngresoPersonas.getTxtDni().getText();
		Persona nuevaPersona = new Persona(dni, nombre,apellido);
		
		boolean estado=false;
		if(!pNeg.isNumber(nombre)) {
			if(!pNeg.isNumber(apellido)) {
				if(pNeg.isNumber(dni)) {
					estado = pNeg.insert(nuevaPersona);					
				}else { this.pnlIngresoPersonas.mostrarMensaje("Por favor, ingrese numeros en el campo DNI");}
			}else{ this.pnlIngresoPersonas.mostrarMensaje("Por favor, ingrese letras en el campo apellido");}
		} else{ this.pnlIngresoPersonas.mostrarMensaje("Por favor, ingrese letras en el campo nombre");}

		String mensaje;
		if(estado==true)
		{
			mensaje="Persona agregada con exito";
			this.pnlIngresoPersonas.getTxtNombre().setText("");
			this.pnlIngresoPersonas.getTxtApellido().setText("");
			this.pnlIngresoPersonas.getTxtDni().setText("");
		}
		else
			mensaje="Persona no agregada, complete todos los campos";
		
		
		this.pnlIngresoPersonas.mostrarMensaje(mensaje);
		
	}


	
	private void refrescarTabla()
	{
		this.personasEnTabla = (ArrayList<Persona>) pNeg.readAll();
		this.pnlModificarPersonas.llenarTabla(this.personasEnTabla);
		this.pnlEliminarPersonas.llenarTabla(this.personasEnTabla);
		this.pnlListarPersonas.llenarTabla(this.personasEnTabla);
	
	}
	
	public void inicializar()
	{
		this.ventanaPrincipal.setVisible(true);;
	}
	

	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
