package presentacion.vista;

import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import entidad.Persona;
import negocioImpl.PersonaNegocioImpl;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;

public class PanelModificarPersonas extends JPanel {
	
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDni;
	private JList list;

	public PanelModificarPersonas() {
		super();
		initialize();
	}


	private void initialize() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 430, 278);
		add(panel);
		panel.setLayout(null);
		
		list = new JList();
		list.setBounds(10, 33, 410, 150);
		
		panel.add(list);
		
		JLabel lblTitulo = new JLabel("Seleccione la persona que desee modificar");
		lblTitulo.setBounds(10, 11, 336, 24);
		panel.add(lblTitulo);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(23, 208, 86, 20);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(119, 208, 86, 20);
		panel.add(txtApellido);
		txtApellido.setColumns(10);
		
		txtDni = new JTextField();
		txtDni.setBounds(215, 208, 86, 20);
		panel.add(txtDni);
		txtDni.setColumns(10);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setBounds(311, 207, 89, 23);
		panel.add(btnModificar);
		
	}
	
	public void show() {this.setVisible(true);}
	
	public void mostrarMensaje(String mensaje) {JOptionPane.showMessageDialog(null, mensaje);}
	

}
