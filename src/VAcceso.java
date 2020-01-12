import java.awt.BorderLayout;
import java.awt.Color;
//alberto
import java.awt.EventQueue;
import java.awt.Dimension;
//

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import principales.Alumno;
import principales.Asignatura;
import principales.BDException;
import principales.GestorBD;
import principales.Matricula;

import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

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
	private JTabbedPane panelTabla;
	private JPanel panel;
	private JButton btnAtras;
	private JButton btnSalir;
	private JTable tablaAlum;
	private JTable tablaAsig;
	private JTable tablaNota;
	private JButton buttoSalir;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VAcceso frame = new VAcceso();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void closeWin() {
		this.dispose();

	}

	/**
	 * Create the frame.
	 */
	public VAcceso() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("logo.png"));
		setTitle("DeustoProf");
		this.setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1021, 575);
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
		btnAñadirAsignatura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VAsignatura a = new VAsignatura();
				// v.getFrame().setVisible(true);
				VAsignatura.getFrame().setVisible(true);
			}
		});
		panelBotones.add(btnAñadirAsignatura);

		btnAñadirAlumno = new JButton("A\u00F1adir Alumno");
		btnAñadirAlumno.setForeground(new Color(0, 102, 153));
		btnAñadirAlumno.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAñadirAlumno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VAlumno alu = new VAlumno();
				// v.getFrame().setVisible(true);
				alu.frame.setVisible(true);

			}
		});
		panelBotones.add(btnAñadirAlumno);

		btnAñadirNotas = new JButton("A\u00F1adir Notas");
		btnAñadirNotas.setForeground(new Color(0, 102, 153));
		btnAñadirNotas.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAñadirNotas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VNota n = new VNota();
				// v.getFrame().setVisible(true);
				VNota.getFrame().setVisible(true);
			}
		});
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
		btnTomarApuntes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VLogin log = new VLogin();
				log.setVisible(true);
				closeWin();

			}
		});
		btnTomarApuntes.setForeground(new Color(0, 102, 153));
		btnTomarApuntes.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelBotones.add(btnTomarApuntes);

		buttoSalir = new JButton("Salir");
		buttoSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					GestorBD.desconectar();
				} catch (BDException e1) {
					e1.printStackTrace();
				}
				closeWin();
			}
		});
		buttoSalir.setBackground(new Color(0, 102, 153));
		buttoSalir.setForeground(Color.WHITE);
		buttoSalir.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelBotones.add(buttoSalir);

		JPanel panelBotonesAbajo = new JPanel();
		contentPane.add(panelBotonesAbajo, BorderLayout.SOUTH);
		tablaAlum = new JTable();
		visualizarAlumno();
		tablaAlum.setRowHeight(50);
		tablaAlum.setEnabled(false);

		tablaAsig = new JTable();
		visualizarAsignatura();
		tablaAsig.setRowHeight(50);
		tablaAsig.setEnabled(false);

		tablaNota = new JTable();
		visualizarNota();
		tablaNota.setRowHeight(50);
		tablaNota.setEnabled(false);

		panelTabla = new JTabbedPane();
		JScrollPane tablaPaneAlu = new JScrollPane(tablaAlum);
		JScrollPane tablaPaneAsig = new JScrollPane(tablaAsig);
		JScrollPane tablaPaneNota = new JScrollPane(tablaNota);

		panelTabla.addTab("alumno", tablaPaneAlu);
		panelTabla.addTab("asignatura", tablaPaneAsig);
		panelTabla.addTab("matricula", tablaPaneNota);
		panelTabla.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				System.out.println("Tab: " + panelTabla.getSelectedIndex());
				if (panelTabla.getSelectedIndex() == 0) { // Tabla Alumno
					visualizarAlumno();
					System.out.println("Pestaña alumno");
				}

				if (panelTabla.getSelectedIndex() == 1) { // Tabla Asignatura
					visualizarAsignatura();
					System.out.println("Pestaña asignatura");
				}

				if (panelTabla.getSelectedIndex() == 2) { // Tabla Matricula
					visualizarNota();
					System.out.println("Pestaña matricula");
				}
			}
		});

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

	/**
	 * Crea la tabla.
	 * 
	 * @param table
	 * @param tablePreferredWidth
	 * @param percentages
	 */
	public static void setJTableColumnsWidth(JTable table, int tablePreferredWidth, double... percentages) {
		double total = 0;
		for (int i = 0; i < table.getColumnModel().getColumnCount(); i++) {
			total += percentages[i];
		}

		for (int i = 0; i < table.getColumnModel().getColumnCount(); i++) {
			TableColumn column = table.getColumnModel().getColumn(i);
			column.setPreferredWidth((int) (tablePreferredWidth * (percentages[i] / total)));
		}
	}

	/**
	 * Visualiza los datos del alumno en una pestaña de la tabla.
	 */
	private void visualizarAlumno() {

		Object[] header = new Object[] { "dni", "Nombre", "apellido", "birthdate", "sexo", "ciudad", "intolerancia" };
		DefaultTableModel model = new DefaultTableModel(header, 0);

		ArrayList<Alumno> alumnos = GestorBD.visualizarAlumno();

		for (int i = 0; i < alumnos.size(); i++) {
			Object[] rowData = new Object[7];
			rowData[0] = alumnos.get(i).getdni();
			rowData[1] = alumnos.get(i).getNombre();
			rowData[2] = alumnos.get(i).getApellido();
			rowData[3] = alumnos.get(i).getBirthdate();
			rowData[4] = alumnos.get(i).getSexo();
			rowData[5] = alumnos.get(i).getCiudad();
			rowData[6] = alumnos.get(i).getIntolerancia();
			model.addRow(rowData);
		}
		tablaAlum.setModel(model);
	}

	/**
	 * Visualiza los datos de la Asignatura en una pestaña de la tabla.
	 */
	private void visualizarAsignatura() {

		Object[] header = new Object[] { "cod_asig", "nombre", "descripcion" };
		DefaultTableModel model = new DefaultTableModel(header, 0);
		ArrayList<Asignatura> asignaturas = GestorBD.visualizarAsignatura();

		for (int i = 0; i < asignaturas.size(); i++) {
			Object[] rowData = new Object[7];
			rowData[0] = asignaturas.get(i).getCodAsignatura();
			rowData[1] = asignaturas.get(i).getNombreAsignatura();
			rowData[2] = asignaturas.get(i).getDescripcion();
			model.addRow(rowData);
		}

		tablaAsig.setModel(model);
	}

	/**
	 * Visualiza los datos de las notas en una pestaña de la tabla.
	 */
	private void visualizarNota() {

		Object[] header = new Object[] { "dni_alumno", "cod_asig", "nota" };
		DefaultTableModel model = new DefaultTableModel(header, 0);
		ArrayList<Matricula> matriculas = GestorBD.visualizarMatricula();

		for (int i = 0; i < matriculas.size(); i++) {
			Object[] rowData = new Object[3];
			rowData[0] = matriculas.get(i).getDni_alumno();
			rowData[1] = matriculas.get(i).getCod_asig();
			rowData[2] = matriculas.get(i).getNota();
			model.addRow(rowData);
		}

		tablaNota.setModel(model);
	}
}
