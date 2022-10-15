package presentacion.vista;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class VentanaPrincipal extends JFrame {
    private JPanel contentPanel;

    public VentanaPrincipal(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPanel = new JPanel();

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        JMenu menu = new JMenu("Persona");
        menuBar.add(menu);
        JMenuItem menuItemAgregar = new JMenuItem("Agregar");
        menu.add(menuItemAgregar);
        JMenuItem menuItemModificar = new JMenuItem("Modificar");
        menu.add(menuItemModificar);
        JMenuItem menuItemEliminar = new JMenuItem("Eliminar");
        menu.add(menuItemEliminar);
        JMenuItem menuItemListar = new JMenuItem("Listar");
        menu.add(menuItemListar);

/*        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPanel.setLayout(new BorderLayout(0,0));
        setContentPane(contentPanel);
        contentPanel.setLayout(null);*/

    }

}
