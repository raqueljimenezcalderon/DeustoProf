import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import principales.BDException;
import principales.GestorBD;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VRegistrar extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldDNI;
	private JPasswordField passwordFieldContraseña;
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private JTextField textFieldTelefono;


	public void closeWin() {
		this.dispose();
		
		
	}
	
	/**
	 * Create the frame.
	 */
	public VRegistrar() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("logo.png"));
		setTitle("DeustoProf");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 714, 465);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelRegistrar = new JLabel("Registrar:");
		labelRegistrar.setForeground(Color.BLACK);
		labelRegistrar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 21));
		labelRegistrar.setBounds(15, 35, 174, 26);
		contentPane.add(labelRegistrar);
		
		JLabel labelDNI = new JLabel("Introduce tu DNI:");
		labelDNI.setForeground(new Color(0, 102, 153));
		labelDNI.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelDNI.setBounds(15, 84, 313, 18);
		contentPane.add(labelDNI);
		
		textFieldDNI = new JTextField();
		textFieldDNI.setForeground(Color.GRAY);
		textFieldDNI.setFont(new Font("Tahoma", Font.ITALIC, 19));
		textFieldDNI.setColumns(10);
		textFieldDNI.setBounds(15, 119, 179, 25);
		contentPane.add(textFieldDNI);
		
		JLabel labelContraseña = new JLabel("Introduce tu contrase\u00F1a:");
		labelContraseña.setForeground(new Color(0, 102, 153));
		labelContraseña.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelContraseña.setBounds(15, 160, 313, 18);
		contentPane.add(labelContraseña);
		
		passwordFieldContraseña = new JPasswordField();
		passwordFieldContraseña.setForeground(Color.GRAY);
		passwordFieldContraseña.setBounds(15, 194, 179, 29);
		contentPane.add(passwordFieldContraseña);
		
		JLabel labelNombre = new JLabel("Introduce tu nombre:");
		labelNombre.setForeground(new Color(0, 102, 153));
		labelNombre.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelNombre.setBounds(422, 84, 313, 18);
		contentPane.add(labelNombre);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setForeground(Color.GRAY);
		textFieldNombre.setFont(new Font("Tahoma", Font.ITALIC, 19));
		textFieldNombre.setColumns(10);
		textFieldNombre.setBounds(422, 119, 179, 25);
		contentPane.add(textFieldNombre);
		
		JLabel labelApellido = new JLabel("Introduce tu apellido:");
		labelApellido.setForeground(new Color(0, 102, 153));
		labelApellido.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelApellido.setBounds(422, 161, 313, 18);
		contentPane.add(labelApellido);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setForeground(Color.GRAY);
		textFieldApellido.setFont(new Font("Tahoma", Font.ITALIC, 19));
		textFieldApellido.setColumns(10);
		textFieldApellido.setBounds(422, 195, 179, 25);
		contentPane.add(textFieldApellido);
		
		JLabel labelTelefono = new JLabel("Introduce tu n\u00FAmero de tel\u00E9fono:");
		labelTelefono.setForeground(new Color(0, 102, 153));
		labelTelefono.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelTelefono.setBounds(15, 250, 313, 18);
		contentPane.add(labelTelefono);
		
		textFieldTelefono = new JTextField();
		textFieldTelefono.setForeground(Color.GRAY);
		textFieldTelefono.setFont(new Font("Tahoma", Font.ITALIC, 19));
		textFieldTelefono.setColumns(10);
		textFieldTelefono.setBounds(15, 284, 179, 25);
		contentPane.add(textFieldTelefono);
		
		JLabel labelSexo = new JLabel("Sexo:");
		labelSexo.setForeground(new Color(0, 102, 153));
		labelSexo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelSexo.setBounds(422, 251, 313, 18);
		contentPane.add(labelSexo);
		
		JRadioButton rdbtnMasculino = new JRadioButton("Masculino");
		rdbtnMasculino.setBounds(422, 284, 135, 29);
		contentPane.add(rdbtnMasculino);
		
		JRadioButton radioButtonFemenino = new JRadioButton("Femenino");
		radioButtonFemenino.setBounds(567, 284, 155, 29);
		contentPane.add(radioButtonFemenino);
		
		JButton buttonRegistrarse = new JButton("Registrarse");
		buttonRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nDNI = textFieldDNI.getText();
				String nombre = textFieldNombre.getText();
				String apellido = textFieldApellido.getText();
				String contrasena = String.valueOf(passwordFieldContraseña.getPassword());
				String telefono = textFieldTelefono.getText();
				String sexo =""; 
				if(rdbtnMasculino.isSelected()) {
					sexo = "Masculino";
				}else if (radioButtonFemenino.isSelected()){
					sexo = "Femenino";
				}
				
				
				
			}

			
		});
		buttonRegistrarse.setForeground(SystemColor.activeCaption);
		buttonRegistrarse.setForeground(new Color(0, 102, 153));
		buttonRegistrarse.setFont(new Font("Tahoma", Font.PLAIN, 19));
		buttonRegistrarse.setBounds(418, 366, 139, 27);
		contentPane.add(buttonRegistrarse);
		
		JButton buttonAtras = new JButton("Atr\u00E1s");
		buttonAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VLogin log = new VLogin();
				log.setVisible(true);
				closeWin();
			}
		});
		buttonAtras.setForeground(SystemColor.activeCaption);
		buttonAtras.setForeground(new Color(0, 102, 153));
		buttonAtras.setFont(new Font("Tahoma", Font.PLAIN, 19));
		buttonAtras.setBounds(15, 366, 139, 29);
		contentPane.add(buttonAtras);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(radioButtonFemenino);
		bg.add(rdbtnMasculino);
	}
}
