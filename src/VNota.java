import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import principales.GestorBD;
import principales.Matricula;

public class VNota {

	//Constantes
	public static final int ALTURA = 60, ANCHURA = 150;
	public static final int T_LETRA = 30;
	//Variables
	private String cod_asig;
	private String dni_alumno;
	private String nota;
	
	private static JFrame frame;
	private JPanel pane;
	
	private JLabel DNILabel, codLabel, notaLabel;
	
	private JComboBox DNIcomboBox;
	private JComboBox codComboBox;
	private JTextField notaTxt;
	
	private JButton crearMatricula;
	
	public VNota() {
		init();
	}
	
	private void init() {
		//Inicializar el Panel
				pane = new JPanel();
				pane.setSize(700, 700);
				
				//Label del codigo
				DNILabel = new JLabel("DNI alumno: ");
				DNILabel.setBounds(30, 20, ANCHURA, ALTURA);
				pane.add(DNILabel);
				
				//Textfield del codigo
				llenarDNI();
				DNIcomboBox.setBounds(300, 60, ANCHURA, ALTURA);
				pane.add(DNIcomboBox);
				
				//Label del nombre
				codLabel = new JLabel("Codigo asignatura: ");
				codLabel.setBounds(30, 240, ANCHURA, ALTURA);
				pane.add(codLabel);
				
				//Textfield del nombre
				llenarCod();
				codComboBox.setBounds(300, 240, ANCHURA, ALTURA);
				pane.add(codComboBox);
				
				//Label del nombre
				notaLabel = new JLabel("Nota: ");
				notaLabel.setBounds(30, 390, ANCHURA, ALTURA);
				pane.add(notaLabel);
				
				//Textfield del codigo
				notaTxt = new JTextField();
				notaTxt.setBounds(300, 390, ANCHURA, ALTURA);
				pane.add(notaTxt);
				
				//Boton para submitar
				crearMatricula = new JButton("Crear");
				crearMatricula.setBounds(350, 500, ANCHURA, ALTURA);
				crearMatricula.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {	
						crearMatricula();
						frame.dispose();
					}
					
				});
				pane.add(crearMatricula);
				
				//Inicializar el frame
				frame = new JFrame();
				frame.setTitle("Asignaturas");
				frame.setSize(1000, 1000);
						
				//Add el pane al frame
				pane.setLayout(null);
				frame.add(pane);
				frame.setVisible(true);
				frame.setLayout(null);
				//EXIT ON CLOSE
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
	}

	private void crearMatricula() {
		final String consulta = "INSERT INTO matricula (dni_alumno, cod_asig, nota) VALUES (?, ?, ?);";
		dni_alumno = DNIcomboBox.getSelectedItem().toString();
		cod_asig = codComboBox.getSelectedItem().toString();
		nota = notaTxt.getText();
		try(Connection conn = GestorBD.getConn();
			PreparedStatement pst = conn.prepareStatement(consulta, Statement.RETURN_GENERATED_KEYS)
			){
			pst.setString(1, dni_alumno);
			pst.setString(2, cod_asig);
			pst.setString(3, nota);
			int filasAfectadas = pst.executeUpdate();
			if(filasAfectadas == 1) {
				
				System.out.println("Datos Insertados!");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	

	private void llenarDNI() {
		String sql = "Select dni_alumno from alumno";
		ArrayList<String> dniAlumno= new ArrayList<>();
		
		try(Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/deustoprof", "root", "");
			PreparedStatement st = (PreparedStatement) conexion.prepareStatement(sql);
			ResultSet rs = st.executeQuery(); ){
			while(rs.next()) {
				dni_alumno = rs.getString("dni_alumno");
				dniAlumno.add(dni_alumno);
			} 			
			
			DNIcomboBox = new JComboBox(dniAlumno.toArray());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	private void llenarCod() {
		String sql = "Select cod_asig from asignatura";
		ArrayList<String> codAsig= new ArrayList<>();
		
		try(Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/deustoprof", "root", "");
			PreparedStatement st = (PreparedStatement) conexion.prepareStatement(sql);
			ResultSet rs = st.executeQuery(); ){
			while(rs.next()) {
				cod_asig= rs.getString("cod_asig");
				codAsig.add(cod_asig);
			} 			
			
			codComboBox= new JComboBox(codAsig.toArray());
			
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