package interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class formulaborrar extends JFrame {
	
	JPanel panel1;
	JLabel lbl1;
	
	JTextField txt1;
	
	JButton boton1;
	JButton boton2;
	
	Connection conexion = null;
	
	public formulaborrar() {
		setSize(300,225);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Eliminar registro");
		setLocationRelativeTo(null);
		crearcomp();
		
		getContentPane().add(panel1);
	}
	
	public void crearcomp() {
		
		panel1 = new JPanel();
		panel1.setLayout(null);
		
		lbl1 = new JLabel("Id a eliminar:");
		lbl1.setBounds(110, 25, 120, 30);
		panel1.add(lbl1);
		
		txt1 = new JTextField();
		txt1.setBounds(110, 70, 50, 25);
		panel1.add(txt1);
		
		boton1 = new JButton("Borrar");
		boton1.setBounds(150, 115, 75, 25);
		panel1.add(boton1);
		
		boton1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				BorrarDatos();
			}
			
		});
		
		boton2 = new JButton("Volver");
		boton2.setBounds(50, 115, 75, 25);
		panel1.add(boton2);
		
		boton2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				formula2 ventana1 = new formula2();
				ventana1.setVisible(true);
				dispose();
			}
			
		});
		
				
	}
	
	public void BorrarDatos() {
		
		crearconexion();
		
		String ID = txt1.getText();
		String SQL = "delete from registros2 where ID='"+ID+"'"; 
		
		try {
			if(txt1.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null,"Campo ID vacio");
			}
			else {
			Statement stm = conexion.createStatement();
			stm.executeUpdate(SQL);
			JOptionPane.showMessageDialog(null, "Registro borrado");
			}	
		}
		catch(Exception Ex) {
			JOptionPane.showMessageDialog(null, "Error, " + Ex);
			
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
		
		formulaborrar ventana1 = new formulaborrar(); 
		ventana1.setVisible(true);
		
	}**/
	
}
