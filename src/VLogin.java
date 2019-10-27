import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.UIManager;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class VLogin extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldUsuario;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VLogin frame = new VLogin();
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
	public VLogin() {
		setBackground(new Color(0, 0, 255));
		setTitle("DeustoProf");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 370, 428);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBenvenidoADeustoprof = new JLabel("Bienvenido a DeustoProf");
		lblBenvenidoADeustoprof.setBounds(5, 14, 418, 29);
		lblBenvenidoADeustoprof.setForeground(UIManager.getColor("Menu.selectionBackground"));
		lblBenvenidoADeustoprof.setFont(new Font("Times New Roman", Font.BOLD, 25));
		contentPane.add(lblBenvenidoADeustoprof);
		
		JLabel labelIniciaSesion = new JLabel("Inicia sesi\u00F3n:");
		labelIniciaSesion.setForeground(Color.BLACK);
		labelIniciaSesion.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 21));
		labelIniciaSesion.setBounds(5, 59, 174, 18);
		contentPane.add(labelIniciaSesion);
		
		JLabel labelUsuario = new JLabel("Usuario:");
		labelUsuario.setForeground(new Color(0, 102, 153));
		labelUsuario.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelUsuario.setBounds(5, 107, 128, 18);
		contentPane.add(labelUsuario);
		
		textFieldUsuario = new JTextField();
		textFieldUsuario.setForeground(Color.GRAY);
		textFieldUsuario.setFont(new Font("Tahoma", Font.ITALIC, 19));
		textFieldUsuario.setColumns(10);
		textFieldUsuario.setBounds(5, 141, 179, 25);
		contentPane.add(textFieldUsuario);
		
		JLabel labelContraseña = new JLabel("Contrase\u00F1a:");
		labelContraseña.setForeground(new Color(0, 102, 153));
		labelContraseña.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelContraseña.setBounds(5, 182, 179, 25);
		contentPane.add(labelContraseña);
		
		passwordField = new JPasswordField();
		passwordField.setForeground(Color.GRAY);
		passwordField.setBounds(5, 223, 179, 29);
		contentPane.add(passwordField);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnEntrar.setForeground(SystemColor.activeCaption);
		btnEntrar.setBounds(18, 306, 115, 29);
		contentPane.add(btnEntrar);
		
		JButton button = new JButton("Registrarse");
		button.setForeground(SystemColor.activeCaption);
		button.setFont(new Font("Tahoma", Font.PLAIN, 19));
		button.setBounds(164, 306, 139, 29);
		contentPane.add(button);
	}
}
