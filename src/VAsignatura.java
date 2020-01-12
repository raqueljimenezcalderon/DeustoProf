import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import principales.GestorBD;

public class VAsignatura {

	//Constantes
	public static final int ALTURA = 60, ANCHURA = 150;
	public static final int T_LETRA = 30;
	//Variables
	private String cod_asig;
	private String nombre;
	private String descripcion;
	
	private static JFrame frame;
	private JPanel pane;
	
	private JLabel codLabel, nombreLabel, descripcionLabel;
	
	private JTextField codAsigTxt;
	private JTextField nombreTxt;
	private JTextField descripcionTxt;
	
	private JButton crearAsignatura;
	
	public VAsignatura() {
		init();
	}
	
	private void init() {
		//Inicializar el Panel
				pane = new JPanel();
				pane.setSize(700, 700);
				
				//Label del codigo
				codLabel = new JLabel("Codigo asignatura: ");
				codLabel.setBounds(30, 60, ANCHURA, ALTURA);
				pane.add(codLabel);
				
				//Textfield del codigo
				codAsigTxt = new JTextField();
				codAsigTxt.setBounds(300, 60, 309, 60);
				pane.add(codAsigTxt);
				
				//Label del nombre
				nombreLabel = new JLabel("Nombre: ");
				nombreLabel.setBounds(30, 158, ANCHURA, ALTURA);
				pane.add(nombreLabel);
				
				//Textfield del nombre
				nombreTxt = new JTextField();
				nombreTxt.setBounds(300, 158, 309, 60);
				pane.add(nombreTxt);
				
				//Label del nombre
				descripcionLabel = new JLabel("Descripcion: ");
				descripcionLabel.setBounds(30, 238, ANCHURA, ALTURA);
				pane.add(descripcionLabel);
				
				//Textfield del codigo
				descripcionTxt = new JTextField();
				descripcionTxt.setBounds(300, 251, 309, 238);
				pane.add(descripcionTxt);
				
				//Boton para submitar
				crearAsignatura = new JButton("Crear");
				crearAsignatura.setBounds(350, 500, ANCHURA, ALTURA);
				crearAsignatura.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
//						if("crearAsignatura".equals(e.getSource())){
							crearAsignatura();
							frame.dispose();
//						}
						
					}
					
				});
				pane.add(crearAsignatura);
				
				//Inicializar el frame
				frame = new JFrame();
				frame.setTitle("Asignaturas");
				frame.setSize(1000, 1000);
						
				//Add el pane al frame
				pane.setLayout(null);
				frame.getContentPane().add(pane);
				frame.setVisible(true);
				frame.getContentPane().setLayout(null);
				//EXIT ON CLOSE
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
	}

	private void crearAsignatura() {
		final String consulta = "INSERT INTO asignatura (cod_asig, nombre, descripcion) VALUES (?, ?, ?);";
		cod_asig = codAsigTxt.getText();
		nombre = nombreTxt.getText();
		descripcion = descripcionTxt.getText();
		try(Connection conn = GestorBD.getConn();
			PreparedStatement pst = conn.prepareStatement(consulta, Statement.RETURN_GENERATED_KEYS)
			){
			pst.setString(1, cod_asig);
			pst.setString(2, nombre);
			pst.setString(3, descripcion);
			int filasAfectadas = pst.executeUpdate();
			if(filasAfectadas == 1) {
				
				System.out.println("Datos Insertados!");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	

	public static JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	
	
	
}
