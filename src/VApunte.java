import java.awt.BorderLayout;
import java.awt.Color;
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
import java.awt.Font;

public class VApunte extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					VApunte frame = new VApunte();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//
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

		// carga la información almacenada en el txt
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
		btnGuardar.setForeground(new Color(0, 102, 153));
		btnGuardar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//guarda l ainformación introducida por el usuario en el txt
				File writeFile;
				Writer writer = null;
				writeFile = new File("Apunte.txt");

				try {
					writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(writeFile), "utf-8"));
					textArea.write(writer);

				} catch (IOException ex) {
					ex.printStackTrace();
				} finally {
					try {
						writer.close();
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			}
		});
		panel.add(btnGuardar);

		JButton btnAtrs = new JButton("Atr\u00E1s");
		btnAtrs.setForeground(new Color(0, 102, 153));
		btnAtrs.setFont(new Font("Tahoma", Font.PLAIN, 20));
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
