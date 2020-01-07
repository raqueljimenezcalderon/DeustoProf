import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import principales.BDException;
import principales.GestorBD;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class VLogin extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldDNI;
	private JPasswordField passwordField;

	// BBDD
	private Connection conn;
	private Statement st;
	private PreparedStatement pst;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					VLogin frame = new VLogin();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	public void closeWin() {
		this.dispose();
		
	}

	/**
	 * Create the frame.
	 */
	public VLogin() {

		// BBDD
		try {
			conn = GestorBD.iniciarConexion();
			st = GestorBD.usarBD(conn);
			GestorBD.createPofesorTable();
			GestorBD.createAlumnoTable();
			GestorBD.createAsignaturaTable();
			GestorBD.createMatriculaTable();

		} catch (BDException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		setIconImage(Toolkit.getDefaultToolkit().getImage("logo.png"));
		setBackground(new Color(0, 0, 255));
		this.setUndecorated(true); // Ventana sin marcos de java predefinidos
		setTitle("DeustoProf");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 507, 428);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblBenvenidoADeustoprof = new JLabel("Bienvenido a DeustoProf");
		lblBenvenidoADeustoprof.setBounds(5, 14, 418, 29);
		lblBenvenidoADeustoprof.setForeground(Color.BLACK);
		lblBenvenidoADeustoprof.setFont(new Font("Times New Roman", Font.BOLD, 25));
		contentPane.add(lblBenvenidoADeustoprof);

		JLabel labelIniciaSesion = new JLabel("Login:");
		labelIniciaSesion.setForeground(Color.BLACK);
		labelIniciaSesion.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 21));
		labelIniciaSesion.setBounds(15, 59, 174, 29);
		contentPane.add(labelIniciaSesion);

		JLabel labelUsuario = new JLabel("DNI:");
		labelUsuario.setForeground(new Color(0, 102, 153));
		labelUsuario.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelUsuario.setBounds(52, 106, 128, 18);
		contentPane.add(labelUsuario);

		textFieldDNI = new JTextField();
		textFieldDNI.setForeground(Color.GRAY);
		textFieldDNI.setFont(new Font("Tahoma", Font.ITALIC, 19));
		textFieldDNI.setColumns(10);
		textFieldDNI.setBounds(52, 140, 179, 25);
		contentPane.add(textFieldDNI);

		JLabel labelContraseña = new JLabel("Contrase\u00F1a:");
		labelContraseña.setForeground(new Color(0, 102, 153));
		labelContraseña.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelContraseña.setBounds(52, 182, 179, 25);
		contentPane.add(labelContraseña);

		passwordField = new JPasswordField();
		passwordField.setForeground(Color.GRAY);
		passwordField.setBounds(52, 223, 179, 29);
		contentPane.add(passwordField);

		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

			}
		});
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VAcceso acc = new VAcceso();
				acc.setVisible(true);
				closeWin();	
				
				if(textFieldDNI.getText().isEmpty() || textFieldDNI.getText() == null
						&& passwordField.getPassword() == null || String.valueOf(passwordField.getPassword()).isEmpty()) {
						System.out.println("Introduce un DNI o contrasena valido");
					}else {
						if(GestorBD.login(textFieldDNI.getText(), String.valueOf(passwordField.getPassword())) ==0) {
						//	VAcceso acc = new VAcceso();
							acc.setVisible(true);
							closeWin();
						}else {
							JOptionPane.showConfirmDialog(null, "Introduce un usuario y contrasena valido");
						}
							
					}

			}
		});
		btnEntrar.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnEntrar.setForeground(new Color(0, 102, 153));
		btnEntrar.setBounds(52, 306, 115, 29);
		contentPane.add(btnEntrar);

		JButton buttonRegistrarse = new JButton("Registrarse");
		buttonRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VRegistrar reg = new VRegistrar();
				reg.setVisible(true);
				closeWin();
			}
		});
		buttonRegistrarse.setForeground(new Color(0, 102, 153));
		buttonRegistrarse.setFont(new Font("Tahoma", Font.PLAIN, 19));
		buttonRegistrarse.setBounds(182, 306, 139, 29);
		contentPane.add(buttonRegistrarse);

		JButton buttonSalir = new JButton("Salir");
		buttonSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					GestorBD.desconectar();
				} catch (BDException e) {
					e.printStackTrace();
				}
				closeWin();
			}
		});
		buttonSalir.setForeground(new Color(0, 102, 153));
		buttonSalir.setFont(new Font("Tahoma", Font.PLAIN, 19));
		buttonSalir.setBounds(336, 306, 115, 29);
		contentPane.add(buttonSalir);
	}
}
