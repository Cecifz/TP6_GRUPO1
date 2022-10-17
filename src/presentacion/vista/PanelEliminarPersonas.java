package presentacion.vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import entidad.Persona;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class PanelEliminarPersonas extends JPanel {
	/**
	 * Create the panel.
	 */
	public PanelEliminarPersonas() {
		setLayout(null);

	}
	public void mostrarMensaje(String mensaje)
	{
		JOptionPane.showMessageDialog(null, mensaje);
	}
}
