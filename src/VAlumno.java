import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import principales.Alumno;
import principales.BDException;
import principales.GestorBD;
import principales.Profesor;

public class VAlumno {

	JFrame frame;
	JPanel panel;
	JTextField dniProfeTxt, nombreTxt, apellidoTxt, birthdateTxt,
	sexoTxt, ciudadTxt, intoleranciaTxt;
	JLabel dniProfeLabel, nombreLabel, apellidoLabel, birthdateLabel,
	sexoLabel, ciudadLabel, intoleranciaLabel;
	int anchura = 80, altura = 40;
	
	
	
	public VAlumno() {
		panel = new JPanel();
		panel.setLocation(0, 0);
		panel.setLayout(null);
		panel.setSize(new Dimension(413, 311)); //width -- height
		
		dniProfeLabel = new JLabel("DNI: ");
		dniProfeLabel.setBounds(30, 40, anchura, altura);
		panel.add(dniProfeLabel);
		
		dniProfeTxt = new JTextField();
		dniProfeTxt.setBounds(110, 40, anchura, altura);
		panel.add(dniProfeTxt);
		
		nombreLabel = new JLabel("Nombre: ");
		nombreLabel.setBounds(205, 40, anchura, altura);
		panel.add(nombreLabel);
		
		nombreTxt = new JTextField();
		nombreTxt.setBounds(290, 40, anchura, altura);
		panel.add(nombreTxt);
		
		apellidoLabel = new JLabel("Apellido: ");
		apellidoLabel.setBounds(30, 96, anchura, altura);
		panel.add(apellidoLabel);
		
		apellidoTxt = new JTextField();
		apellidoTxt.setBounds(110, 96, anchura, altura);
		panel.add(apellidoTxt);
		
		birthdateLabel = new JLabel("Birthdate: ");
		birthdateLabel.setBounds(205, 96, anchura, altura);
		panel.add(birthdateLabel);
		
		birthdateTxt = new JTextField();
		birthdateTxt.setBounds(290, 96, anchura, altura);
		panel.add(birthdateTxt);
		
		sexoLabel = new JLabel("Sexo: ");
		sexoLabel.setBounds(30, 152, anchura, altura);
		panel.add(sexoLabel);
		
		sexoTxt = new JTextField();
		sexoTxt.setBounds(110, 152, anchura, altura);
		panel.add(sexoTxt);
		
		ciudadLabel = new JLabel("Ciudad: ");
		ciudadLabel.setBounds(205, 152, anchura, altura);
		panel.add(ciudadLabel);
		
		ciudadTxt = new JTextField();
		ciudadTxt.setBounds(290, 152, anchura, altura);
		panel.add(ciudadTxt);
		
		intoleranciaLabel = new JLabel("Intolerancia:");
		intoleranciaLabel.setBounds(30, 208, 89, 40);
		panel.add(intoleranciaLabel);
		
		intoleranciaTxt = new JTextField();
		intoleranciaTxt.setBounds(134, 208, 236, 40);
		panel.add(intoleranciaTxt);
		
		JButton buttonRegistrarse = new JButton("Anadir alumno");
		buttonRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GestorBD GBD = new GestorBD();
				String nDNI = dniProfeTxt.getText();
				String nombre = nombreTxt.getText();
				String apellido = apellidoTxt.getText();
				String intolerancia = intoleranciaTxt.getText();
				String sexo =sexoTxt.getText(); 
				String ciudad = ciudadTxt.getText();
				String birthdate = birthdateTxt.getText();
				Alumno a;
				a = new Alumno(nDNI, nombre, apellido, birthdate, sexo, ciudad, intolerancia);
				try {
					GBD.guardarAlumno(a);
				} catch (BDException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				frame.dispose();
				
			}

			
		});
		buttonRegistrarse.setForeground(SystemColor.activeCaption);
		buttonRegistrarse.setForeground(new Color(0, 102, 153));
		buttonRegistrarse.setFont(new Font("Tahoma", Font.PLAIN, 19));
		buttonRegistrarse.setBounds(213, 264, 169, 27);
		panel.add(buttonRegistrarse);
		
		JButton buttonAtras = new JButton("Atr\u00E1s");
		buttonAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		buttonAtras.setForeground(SystemColor.activeCaption);
		buttonAtras.setForeground(new Color(0, 102, 153));
		buttonAtras.setFont(new Font("Tahoma", Font.PLAIN, 19));
		buttonAtras.setBounds(40, 263, 139, 29);
		panel.add(buttonAtras);
		
		frame = new JFrame();
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		frame.setBounds(50, 50, 435, 367);
		frame.getContentPane().add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	

	
}
