package presentacion.vista;



import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import entidad.Persona;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelModificarPersonas extends JPanel{

	private JButton btnModificar;

	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDni;
	private DefaultListModel <Persona>modelPersonas;
	
	
	JList list;

	private JScrollPane scrollPane;
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
		modelPersonas = new DefaultListModel<>();
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 33, 410, 150);
		panel.add(scrollPane);
		list = new JList(modelPersonas);
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
			}
		});
		scrollPane.setViewportView(list);
		
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
		txtDni.setEditable(false);
		txtDni.setBounds(215, 208, 86, 20);
		panel.add(txtDni);
		txtDni.setColumns(10);
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnModificar.setBounds(311, 207, 89, 23);
		panel.add(btnModificar);
		
		

		
		
	}
	
	public JList getList() {
		return list;
	}
	
	public void show() {this.setVisible(true);}
	
	public JButton getBtnModificar() {
		return btnModificar;
	}
	 public JTextField getTxtApellido() {
			return txtApellido;
		}
		
		
		public void setTxtApellido(String txtApellido) {
			this.txtApellido.setText(txtApellido);
		}

	public JTextField getTxtNombre() {
		return txtNombre;
	}
	
	
	public void setTxtNombre(String txtNombre) {
		this.txtNombre.setText(txtNombre);
	}

	public JTextField getTxtDni() {
		return txtDni;
	}

	public void settxtDni(String txtDni) {
		this.txtDni.setText(txtDni);
	}

	public void setBtnModificar(JButton btnModificar) {
		this.btnModificar = btnModificar;
	}

	
	public DefaultListModel getModelPersonas() 
	{
		return modelPersonas;
	}
	
	public void llenarTabla(List<Persona> personasEnTabla)
	{
		for (Persona p : personasEnTabla)
			modelPersonas.addElement(p);
	}
	public void mostrarMensaje(String mensaje)
	{
		JOptionPane.showMessageDialog(null, mensaje);
	}

}
