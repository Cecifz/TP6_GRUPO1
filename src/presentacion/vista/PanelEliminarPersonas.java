package presentacion.vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import entidad.Persona;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelEliminarPersonas extends JPanel {
	/**
	 * Create the panel.
	 */
	Jlist list;
	JButton btnEliminar;
	private DefaultListModel <Persona> modelPersonas;
	private JScrollPane scrollPane_1;

	public PanelEliminarPersonas() {
		super();
		initialize();
	}
	
	private void initialize() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 430, 278);
		add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 33, 410, 150);
		panel.add(scrollPane_1);
		
		JLabel lblEliminarUsuarios = new JLabel("Eliminar Usuarios");
		lblEliminarUsuarios.setBounds(13, 19, 182, 14);
		panel.add(lblEliminarUsuarios);
		
		list = new JList(modelPersonas);
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
			}
		});
		scrollPane_1.setViewportView(list);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnEliminar.setBounds(137, 214, 182, 20);
		panel.add(btnEliminar);
	
	}
	
	public JList getList() {
		return list;
	}
	public void setBtnModificar(JButton btnEliminar) {
		this.btnEliminar = btnEliminar;
	}
	
	public JButton getBtnEliminar() {
		return btnEliminar;
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
