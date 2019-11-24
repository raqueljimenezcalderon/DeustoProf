import java.awt.BorderLayout;
import java.awt.Color;
//alberto
import java.awt.EventQueue;
import java.awt.Dimension;
//

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VAcceso extends JFrame {

	private JPanel contentPane;
	private JPanel panelBotones;
	private JButton btnAñadirAsignatura;
	private JButton btnAñadirAlumno;
	private JButton btnAñadirNotas;
	private JButton btnEditarInformacin;
	private JButton btnEditarInformaconAsignatura;
	private JButton btnEditarInformacinAlumno;
	private JButton btnEditarNotas;
	private JButton btnTomarApuntes;
	private JScrollPane panelTabla;
	private JPanel panel;
	private JButton btnAtras;
	private JButton btnSalir;
	private JTable tabla;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					VAcceso frame = new VAcceso();
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
	public VAcceso() {
		setTitle("DeustoProf");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 100, 1500, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		panelBotones = new JPanel();
		contentPane.add(panelBotones, BorderLayout.EAST);
		panelBotones.setLayout(new GridLayout(0, 1, 0, 0));
		
		btnAñadirAsignatura = new JButton("A\u00F1adir Asignatura");
		btnAñadirAsignatura.setForeground(new Color(0, 102, 153));
		btnAñadirAsignatura.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelBotones.add(btnAñadirAsignatura);
		
		btnAñadirAlumno = new JButton("A\u00F1adir Alumno");
		btnAñadirAlumno.setForeground(new Color(0, 102, 153));
		btnAñadirAlumno.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelBotones.add(btnAñadirAlumno);
		
		btnAñadirNotas = new JButton("A\u00F1adir Notas");
		btnAñadirNotas.setForeground(new Color(0, 102, 153));
		btnAñadirNotas.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelBotones.add(btnAñadirNotas);
		
		btnEditarInformacin = new JButton("Editar Informaci\u00F3n Personal");
		btnEditarInformacin.setForeground(new Color(0, 102, 153));
		btnEditarInformacin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelBotones.add(btnEditarInformacin);
		
		btnEditarInformaconAsignatura = new JButton("Editar Informaci\u00F3n Asignatura");
		btnEditarInformaconAsignatura.setForeground(new Color(0, 102, 153));
		btnEditarInformaconAsignatura.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelBotones.add(btnEditarInformaconAsignatura);
		
		btnEditarInformacinAlumno = new JButton("Editar Informaci\u00F3n Alumno");
		btnEditarInformacinAlumno.setForeground(new Color(0, 102, 153));
		btnEditarInformacinAlumno.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelBotones.add(btnEditarInformacinAlumno);
		
		btnEditarNotas = new JButton("Editar Notas");
		btnEditarNotas.setForeground(new Color(0, 102, 153));
		btnEditarNotas.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelBotones.add(btnEditarNotas);
		
		btnTomarApuntes = new JButton("Tomar Apuntes");
		btnTomarApuntes.setForeground(new Color(0, 102, 153));
		btnTomarApuntes.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelBotones.add(btnTomarApuntes);
		
			
		
//alberto
		JPanel panelBotonesAbajo = new JPanel();
		contentPane.add(panelBotonesAbajo, BorderLayout.SOUTH);
		tabla = new JTable(20,8);
//		tabla.setBounds(0,0,panelTabla.getWidth(),panelTabla.getHeight());
		tabla.setRowHeight(50);
		//setJTableColumnsWidth(tabla, 480, 10, 30, 30, 30);
		
		TableColumnModel columnModel = tabla.getColumnModel();
//		columnModel.getColumn(0).setPreferredWidth(100);
		
//		columnModel.getColumn(0).set
		panelTabla = new JScrollPane(tabla);
		//panelTabla.setBounds(0, 0, contentPane.getWidth()/2, contentPane.getHeight()/2);
		panelTabla.setPreferredSize(new Dimension(600, 600));
		contentPane.add(panelTabla);

		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);

		
		btnAtras = new JButton("Atr\u00E1s");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAtras.setForeground(new Color(0, 102, 153));
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VLogin log = new VLogin();
				log.setVisible(true);
				closeWin();
			}
		});
		btnAtras.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelBotonesAbajo.add(btnAtras);
		
		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWin();
			}
		});
		btnSalir.setForeground(new Color(0, 102, 153));
		btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelBotonesAbajo.add(btnSalir);
	}

	 public static void setJTableColumnsWidth(JTable table, int tablePreferredWidth, 
	    		double... percentages) {
	        double total = 0;
	        for (int i = 0; i < table.getColumnModel().getColumnCount(); i++) {
	            total += percentages[i];
	        }
	        
	        for (int i = 0; i < table.getColumnModel().getColumnCount(); i++) {
	            TableColumn column = table.getColumnModel().getColumn(i);
	            column.setPreferredWidth((int)
	                    (tablePreferredWidth * (percentages[i] / total)));
	        }
	    }	
}
