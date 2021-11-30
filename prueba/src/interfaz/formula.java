package interfaz;

import java.awt.Color;
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

import conexion.conexion;

public class formula extends JFrame {
	JFrame ventana;
	JPanel panel1;
	
	JTextField txt1;
	JTextField txt2;
	JTextField txt3;
	JTextField txt4;
	JTextField txt5;
	JPasswordField txt6;
	JPasswordField txt7;
	
	
	JLabel lbl1;
	JLabel lbl2;
	JLabel lbl3;
	JLabel lbl4;
	JLabel lbl5;
	JLabel lbl6;
	JLabel lbl7;
	
	JButton boton1;
	JButton boton2;
	
	Connection conexion = null;
	
	public formula() {
		setSize(650,330);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Registrarse");
		setLocationRelativeTo(null);
		IniciarComp();
		
		getContentPane().add(panel1);
	}
	
	public void IniciarComp() {
		
		panel1 = new JPanel();
		panel1.setLayout(null);
		
		txt1 = new JTextField();
		txt1.setBounds(130,50,150,30);
		panel1.add(txt1);
		
		txt2 = new JTextField();
		txt2.setBounds(130,100,150,30);
		panel1.add(txt2);
		
		txt3 = new JTextField();
		txt3.setBounds(130,150,150,30);
		panel1.add(txt3);
		
		txt4 = new JTextField();
		txt4.setBounds(400,50,150,30);
		panel1.add(txt4);
		
		txt5 = new JTextField();
		txt5.setBounds(400,100,150,30);
		panel1.add(txt5);
		
		txt6 = new JPasswordField();
		txt6.setBounds(400,150,150,30);
		panel1.add(txt6);
		
		txt7 = new JPasswordField();
		txt7.setBounds(400,200,150,30);
		panel1.add(txt7);
		
		lbl1 = new JLabel("Usuario:");
		lbl1.setBounds(60,50,50,30);
		panel1.add(lbl1);
		
		lbl2 = new JLabel("Nombre:");
		lbl2.setBounds(59,100,60,30);
		panel1.add(lbl2);
		
		lbl3 = new JLabel("Apellido:");
		lbl3.setBounds(60,150,60,30);
		panel1.add(lbl3);
		
		lbl4 = new JLabel("Telefono:");
		lbl4.setBounds(325,50,100,30);
		panel1.add(lbl4);
		
		lbl5 = new JLabel("Correo:");
		lbl5.setBounds(335,100,60,30);
		panel1.add(lbl5);
		
		lbl6 = new JLabel("Contraseña:");
		lbl6.setBounds(311,150,80,30);
		panel1.add(lbl6);
		
		lbl7 = new JLabel("Confirmar contraseña:");
		lbl7.setBounds(252,200,150,30);
		panel1.add(lbl7);
		
		
		boton1 = new JButton("Registrarse");
		boton1.setBounds(449, 250, 100, 30);
		panel1.add(boton1);
		
		
		boton1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub		
				insertarDatos();
				
			}
		});	
		
		boton2 = new JButton("Volver");
		boton2.setBounds(132, 250, 100, 30);
		panel1.add(boton2);
		
		boton2.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				login ventana1 = new login();
				ventana1.setVisible(true);
				dispose();
			}
			
		});
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

	public void insertarDatos() {
		
			crearconexion();
				
				try {
				String Nusuario = txt1.getText();
				String Nombre = txt2.getText();
				String Apellido = txt3.getText();
				String Numerotel = txt4.getText();
				String Correo = txt5.getText();
				String Contraseña = String.valueOf(txt6.getPassword());
				
				if(txt1.getText().trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Campo usuario vacio", "Error",JOptionPane.WARNING_MESSAGE);
				}
				
				else if(txt2.getText().trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Campo nombre vacio", "Error",JOptionPane.WARNING_MESSAGE);
				}
				
				else if(txt3.getText().trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Campo apellido vacio", "Error",JOptionPane.WARNING_MESSAGE);
				}
				else if(txt4.getText().trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Campo numerotel vacio", "Error",JOptionPane.WARNING_MESSAGE);
				}
				else if(txt5.getText().trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Campo correo vacio", "Error",JOptionPane.WARNING_MESSAGE);
				}
				
				else if(String.valueOf(txt6.getPassword()).trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Campo contraseña vacio", "Error",JOptionPane.WARNING_MESSAGE);
				}
				
				else {
				if(String.valueOf(txt6.getPassword()).equals(String.valueOf(txt7.getPassword()))) {
					
				int resultado=0;
				String Query = ("Insert into registros2 (Nusuario, Nombre, Apellido, Numerotel, Correo, Contraseña) values ('"+Nusuario+"', '"+Nombre+"','"+Apellido+"','"+Numerotel+"','"+Correo+"','"+Contraseña+"')");
				String SQL ="Select Nusuario from registros2 where Nusuario ='"+Nusuario+"' "; 
				
				Statement stm = conexion.createStatement();
				ResultSet rs = stm.executeQuery(SQL);
				
				if(rs.next()) {
					resultado = 1;
					if(resultado==1) {
						JOptionPane.showMessageDialog(null, "Nombre de usuario en uso");
					}
				}
				else {
					stm.executeUpdate(Query);
					JOptionPane.showMessageDialog(null,"Datos enviados");
					
					login ventana1 = new login();
					ventana1.setVisible(true);
					dispose();
				}
			}
				else {
					JOptionPane.showMessageDialog(null, "Contraseña no coincide");
				}
				
				}
		}
			
			catch(Exception ex) {
				System.out.println("Error" + ex);
				JOptionPane.showMessageDialog(null,"Error " + ex);
			}	
	}
	/**
	public static void main(String[]args) {
		formula ventana1 = new formula();
		//conexion con = new conexion();
		
		ventana1.setVisible(true);
	}**/

}
