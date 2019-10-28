import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.JScrollPane;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VAcceso extends JFrame {

	private JPanel contentPane;

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
		setBounds(100, 100, 693, 477);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panelBotones = new JPanel();
		contentPane.add(panelBotones, BorderLayout.EAST);
		panelBotones.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnA�adirAsignatura = new JButton("A\u00F1adir Asignatura");
		btnA�adirAsignatura.setForeground(new Color(0, 102, 153));
		btnA�adirAsignatura.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelBotones.add(btnA�adirAsignatura);
		
		JButton btnA�adirAlumno = new JButton("A\u00F1adir Alumno");
		btnA�adirAlumno.setForeground(new Color(0, 102, 153));
		btnA�adirAlumno.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelBotones.add(btnA�adirAlumno);
		
		JButton btnA�adirNotas = new JButton("A\u00F1adir Notas");
		btnA�adirNotas.setForeground(new Color(0, 102, 153));
		btnA�adirNotas.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelBotones.add(btnA�adirNotas);
		
		JButton btnEditarInformacin = new JButton("Editar Informaci\u00F3n Personal");
		btnEditarInformacin.setForeground(new Color(0, 102, 153));
		btnEditarInformacin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelBotones.add(btnEditarInformacin);
		
		JButton btnEditarInformaconAsignatura = new JButton("Editar Informaci\u00F3n Asignatura");
		btnEditarInformaconAsignatura.setForeground(new Color(0, 102, 153));
		btnEditarInformaconAsignatura.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelBotones.add(btnEditarInformaconAsignatura);
		
		JButton btnEditarInformacinAlumno = new JButton("Editar Informaci\u00F3n Alumno");
		btnEditarInformacinAlumno.setForeground(new Color(0, 102, 153));
		btnEditarInformacinAlumno.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelBotones.add(btnEditarInformacinAlumno);
		
		JButton btnEditarNotas = new JButton("Editar Notas");
		btnEditarNotas.setForeground(new Color(0, 102, 153));
		btnEditarNotas.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelBotones.add(btnEditarNotas);
		
		JButton btnTomarApuntes = new JButton("Tomar Apuntes");
		btnTomarApuntes.setForeground(new Color(0, 102, 153));
		btnTomarApuntes.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelBotones.add(btnTomarApuntes);
		
		JPanel panelTabla = new JPanel();
		contentPane.add(panelTabla, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		JButton btnAtras = new JButton("Atr\u00E1s");
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
		panel.add(btnAtras);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWin();
			}
		});
		btnSalir.setForeground(new Color(0, 102, 153));
		btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(btnSalir);
	}

}
