import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.SystemColor;

public class VRegistrar extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNombreUsuario;
	private JPasswordField passwordFieldContraseña;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VRegistrar frame = new VRegistrar();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VRegistrar() {
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
		
		JLabel labelNombreUsuario = new JLabel("Introduce tu nombre de usuario:");
		labelNombreUsuario.setForeground(new Color(0, 102, 153));
		labelNombreUsuario.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelNombreUsuario.setBounds(15, 84, 313, 18);
		contentPane.add(labelNombreUsuario);
		
		textFieldNombreUsuario = new JTextField();
		textFieldNombreUsuario.setForeground(Color.GRAY);
		textFieldNombreUsuario.setFont(new Font("Tahoma", Font.ITALIC, 19));
		textFieldNombreUsuario.setColumns(10);
		textFieldNombreUsuario.setBounds(15, 119, 179, 25);
		contentPane.add(textFieldNombreUsuario);
		
		JLabel labelContraseña = new JLabel("Introduce tu contrase\u00F1a:");
		labelContraseña.setForeground(new Color(0, 102, 153));
		labelContraseña.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelContraseña.setBounds(15, 160, 313, 18);
		contentPane.add(labelContraseña);
		
		passwordFieldContraseña = new JPasswordField();
		passwordFieldContraseña.setForeground(Color.GRAY);
		passwordFieldContraseña.setBounds(15, 194, 179, 29);
		contentPane.add(passwordFieldContraseña);
		
		JLabel label = new JLabel("Introduce tu nombre:");
		label.setForeground(new Color(0, 102, 153));
		label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label.setBounds(422, 84, 313, 18);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setForeground(Color.GRAY);
		textField.setFont(new Font("Tahoma", Font.ITALIC, 19));
		textField.setColumns(10);
		textField.setBounds(422, 119, 179, 25);
		contentPane.add(textField);
		
		JLabel label_1 = new JLabel("Introduce tu apellido:");
		label_1.setForeground(new Color(0, 102, 153));
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_1.setBounds(422, 161, 313, 18);
		contentPane.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setForeground(Color.GRAY);
		textField_1.setFont(new Font("Tahoma", Font.ITALIC, 19));
		textField_1.setColumns(10);
		textField_1.setBounds(422, 195, 179, 25);
		contentPane.add(textField_1);
		
		JLabel label_2 = new JLabel("Introduce tu n\u00FAmero de tel\u00E9fono:");
		label_2.setForeground(new Color(0, 102, 153));
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_2.setBounds(15, 250, 313, 18);
		contentPane.add(label_2);
		
		textField_2 = new JTextField();
		textField_2.setForeground(Color.GRAY);
		textField_2.setFont(new Font("Tahoma", Font.ITALIC, 19));
		textField_2.setColumns(10);
		textField_2.setBounds(15, 284, 179, 25);
		contentPane.add(textField_2);
		
		JLabel label_3 = new JLabel("Sexo:");
		label_3.setForeground(new Color(0, 102, 153));
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_3.setBounds(422, 251, 313, 18);
		contentPane.add(label_3);
		
		JRadioButton rdbtnMasculino = new JRadioButton("Masculino");
		rdbtnMasculino.setBounds(422, 284, 135, 29);
		contentPane.add(rdbtnMasculino);
		
		JRadioButton radioButton = new JRadioButton("Femenino");
		radioButton.setBounds(567, 284, 155, 29);
		contentPane.add(radioButton);
		
		JButton button = new JButton("Registrarse");
		button.setForeground(SystemColor.activeCaption);
		button.setFont(new Font("Tahoma", Font.PLAIN, 19));
		button.setBounds(418, 366, 139, 27);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Atr\u00E1s");
		button_1.setForeground(SystemColor.activeCaption);
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		button_1.setBounds(15, 366, 139, 29);
		contentPane.add(button_1);
	}
}
