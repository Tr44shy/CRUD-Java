package interfaz;

import java.awt.Font;
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
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class login extends JFrame {
	
	JPanel panel1;
	
	JLabel lbl1;
	JLabel lbl2;
	JLabel lbl3;
	
	JTextField txt1;

	JPasswordField txt2;
	
	JButton boton1;
	JButton boton2;
	
	Connection conexion = null;
	
	public login() {
		setSize(350,350);
		setTitle("Log in");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		crearcomponentes();
		
		getContentPane().add(panel1);
	}
	
	public void crearcomponentes() {
		panel1 = new JPanel();
		panel1.setLayout(null);
		
		lbl1 = new JLabel("Log In");
		lbl1.setBounds(35,20,100,30);
		lbl1.setFont(new Font("Default",Font.PLAIN, 25));
		panel1.add(lbl1);
		
		lbl2 = new JLabel("Usuario:");
		lbl2.setBounds(61,75,100,30);		
		panel1.add(lbl2);
		
		lbl2 = new JLabel("Contraseña:");
		lbl2.setBounds(61,160,100,30);	
		panel1.add(lbl2);
		
		txt1 = new JTextField();
		txt1.setBounds(61, 100, 220, 30);
		panel1.add(txt1);
		
		txt2 = new JPasswordField();
		txt2.setBounds(61, 185, 220, 30);
		panel1.add(txt2);
		
		boton1 = new JButton("Aceptar");
		boton1.setBounds(185, 240, 95, 30);
		panel1.add(boton1);
		
		boton1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				verificar();
			}
			
		});
		
		boton2 = new JButton("Registrar");
		boton2.setBounds(61, 240, 100, 30);
		panel1.add(boton2);
		
		boton2.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				formula ventana1 = new formula();
				ventana1.setVisible(true);
				dispose();
			}
			
		});
		
	}
	
	public void verificar() {
		crearconexion();
		
		int resultado=0;
		String Usuario = txt1.getText();
		String Contraseña = String.valueOf(txt2.getPassword());
		
		String SQL = "Select*from registros2 where Nusuario= '"+Usuario+"' and Contraseña = '"+Contraseña+"' ";
				
		try {
			if(txt1.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Campo usuario vacio");
			}
			else if (String.valueOf(txt2.getPassword()).isEmpty()) {
				JOptionPane.showMessageDialog(null, "Campo contraseña vacio");
			}
			else {
			Statement stm = conexion.createStatement();
			ResultSet rs = stm.executeQuery(SQL);
			
			if(rs.next()) {
				
				resultado = 1;
				
				if(resultado == 1) {
					JOptionPane.showMessageDialog(null, "Usuario encontrado.");
					formula2 ventana1 = new formula2();
					ventana1.setVisible(true);
					dispose();
				}		
			}
			else{
				JOptionPane.showMessageDialog(null, "Error, usuario no encontrado.");
			}
			
		}
			
	}
			
			
		
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Error " + ex);
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
	/*
	public static void main(String[]args) {
		login ventana1 = new login();
		ventana1.setVisible(true);
	}*/
}
