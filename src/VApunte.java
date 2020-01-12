import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.TextArea;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.awt.event.ActionEvent;

public class VApunte extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VApunte frame = new VApunte();
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
	public VApunte() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 763, 503);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);

		JTextArea textArea = new JTextArea();
		contentPane.add(textArea, BorderLayout.CENTER);

		FileReader reader;
		try {
			reader = new FileReader("Apunte.txt");
			BufferedReader br = new BufferedReader(reader);
			textArea.read(br, null);
			br.close();
			textArea.requestFocus();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				File writeFile;
				Writer writer = null;

				writeFile = new File("Apunte.txt");

				try {
					writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(writeFile), "utf-8"));
					textArea.write(writer);

				} catch (IOException ex) {

				} finally {
					try {
						writer.close();
					} catch (Exception ex) {
					}
				}
			}
		});
		panel.add(btnGuardar);

		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		panel.add(btnEliminar);

		JButton btnAtrs = new JButton("Atr\u00E1s");
		btnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VAcceso log = new VAcceso();
				log.setVisible(true);
				closeWin();
			}
		});
		panel.add(btnAtrs);

	}

}
