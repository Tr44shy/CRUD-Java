package interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class formula2 extends JFrame {
	
	JFrame ventana;
	JTable nose;
	JScrollPane scroll;
	DefaultTableModel table;
	JPanel panel;
	
	JLabel lbl1;
	
	JButton boton1;
	JButton boton2;
	JButton boton3;
	JButton boton4;
	
	
	Connection conexion = null;
	
	String[] nombrecolumnas = {"Id","Usuario","Nombre","Apellido","Telefono","Correo"};
	String[] registros = new String[6];

	
	public formula2() {
		setSize(900, 340);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Datos");
		setLocationRelativeTo(null);
		iniciarcomponentes();
		mostrardatos();
		
		getContentPane().add(panel);
		
	}
	
	public void iniciarcomponentes() {
		
		panel = new JPanel();
		panel.setLayout(null);
	
		 
		table = new DefaultTableModel(null, nombrecolumnas);
		nose = new JTable(table);
		
		scroll = new JScrollPane(nose);
		scroll.setBounds(40, 40, 800, 200);
		panel.add(scroll);
		
		boton1 = new JButton("Editar");
		boton1.setBounds(339, 250, 100, 40);
		panel.add(boton1);
		
		boton1.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e) {
				formulaeditar ventana1 = new formulaeditar();
				ventana1.setVisible(true);
				dispose();
			}
		});
		
		boton2 = new JButton("Nuevo");
		boton2.setBounds(150, 250, 100, 40);
		panel.add(boton2);
		
		boton2.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e) {
				formulaguardar ventana1 = new formulaguardar();
				ventana1.setVisible(true);
				dispose();
			}
		});
		
		boton3 = new JButton("Borrar");
		boton3.setBounds(520, 250, 100, 40);
		panel.add(boton3);
		
		boton3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				formulaborrar ventana1 = new formulaborrar();
				ventana1.setVisible(true);
				dispose();
			}
			
		});
		
		boton4 = new JButton("Cerrar sesion");
		boton4.setBounds(690, 250, 150, 40);
		panel.add(boton4);
		
		boton4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				login ventana1 = new login();
				ventana1.setVisible(true);
				dispose();
			}
			
		});
		
		lbl1 = new JLabel("Clientes registrados");
		lbl1.setFont(new Font("Default",Font.PLAIN, 25));
		lbl1.setBounds(30,5,280,30);
		panel.add(lbl1);
	}
	
	public void mostrardatos() {
		
		crearconexion();
		
		String SQL ="Select * from registros2";
		
		try {
			Statement stm = conexion.createStatement();
			ResultSet rs = stm.executeQuery(SQL);
		
			while(rs.next()) {
				registros[0]=rs.getString("ID");
				registros[1]=rs.getString("Nusuario");
				registros[2]=rs.getString("Nombre");
				registros[3]=rs.getString("Apellido");
				registros[4]=rs.getString("Numerotel");
				registros[5]=rs.getString("Correo");
				table.addRow(registros);
			}
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Error, " + e);
		}
		
			
		
	}
	
	public void crearconexion() {
		
		String controlador = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/prueba";
		String usuario = "root";
		
		try {
				Class.forName(controlador);
				conexion = DriverManager.getConnection(url, usuario, "");
				System.out.println("te conectaste");
		}
		catch(Exception ex) {
			System.out.println("Error" + ex);
			JOptionPane.showMessageDialog(null,"Error " + ex);
		}		
	}
/**
	public static void main(String[]args) {
		
		formula2 ventana1 = new formula2();
		ventana1.setVisible(true);
	}**/
}
