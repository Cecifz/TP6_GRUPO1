package presentacion.vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import daoImpl.Conexion;
import entidad.Persona;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelAgregarPersonas extends JPanel {
	private JTextField txtNombre;
	


	private JTextField txtDni;

	
	 public PanelAgregarPersonas() {
	
		super();
		initialize();
	}
	 public JTextField getTxtApellido() {
			return txtApellido;
		}
		
		
		public void setTxtApellido(JTextField txtApellido) {
			this.txtApellido = txtApellido;
		}

	public JTextField getTxtNombre() {
		return txtNombre;
	}
	
	
	public void setTxtNombre(JTextField txtNombre) {
		this.txtNombre = txtNombre;
	}

	public JTextField getTxtDni() {
		return txtDni;
	}

	public void settxtDni(JTextField txtDni) {
		this.txtDni = txtDni;
	}
	
	public JButton getBtnAgregar() {
		return btnAgregar;
	}


	public void setBtnAgregar(JButton btnAgregar) {
		this.btnAgregar = btnAgregar;
	}




	private JButton btnAgregar;
	private JTextField txtApellido;

	
	private void initialize() 
	{
	
		this.setBounds(100, 100, 514, 455);
		this.setLayout(null);
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(15, 37, 438, 118);
		this.add(panel_1);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(30, 16, 170, 14);
		panel_1.add(lblNombre);
		
		JLabel lblDni = new JLabel("DNI");
		lblDni.setBounds(30, 53, 113, 14);
		panel_1.add(lblDni);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(204, 13, 164, 20);
		panel_1.add(txtNombre);
		
		txtDni = new JTextField();
		txtDni.setColumns(10);
		txtDni.setBounds(204, 50, 164, 20);
		panel_1.add(txtDni);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAgregar.setBounds(30, 78, 89, 23);
		panel_1.add(btnAgregar);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(30, 35, 170, 14);
		panel_1.add(lblApellido);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(204, 32, 164, 20);
		panel_1.add(txtApellido);
	}
	
	public void show()
	{
		this.setVisible(true);
	}
	

	


	
	public void mostrarMensaje(String mensaje)
	{
		JOptionPane.showMessageDialog(null, mensaje);
	}
	

}
