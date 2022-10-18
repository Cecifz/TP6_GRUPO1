package presentacion.vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import entidad.Persona;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListModel;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class PanelEliminarPersonas extends JPanel {

	private JButton btnBorrar;
	private JTextField txtDni;
	private DefaultListModel <Persona>modelPersonas;
	private JList list;
	
	
	private JScrollPane scrollPane;
	public PanelEliminarPersonas() {
		super();
		initialize();
	}
	
	private void initialize() {

		setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 33, 410, 150);
		
		
		modelPersonas = new DefaultListModel<>();
		list = new JList(modelPersonas);
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
			}
		});
		list.setBounds(0, 31, 408, 148);
		add(list);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBorrar.setBounds(144, 209, 89, 23);
		add(btnBorrar);
	}
	
	public JList getList() {
		return list;
	}
	
	public void show() {this.setVisible(true);}
	
	public JButton getBtnBorrar() {
		return btnBorrar;
	}


	public void setBtnBorrar(JButton btnBorrar) {
		this.btnBorrar = btnBorrar;
	}

	
	public DefaultListModel getModelPersonas() 
	{
		return modelPersonas;
	}
	
	public void llenarTabla(List<Persona> personasEnTabla)
	{
		modelPersonas.clear();
		for (Persona p : personasEnTabla)
			modelPersonas.addElement(p);
	}
	public void mostrarMensaje(String mensaje)
	{
		JOptionPane.showMessageDialog(null, mensaje);
	}
	
	public JTextField getTxtDni() {
		return txtDni;
	}
}
