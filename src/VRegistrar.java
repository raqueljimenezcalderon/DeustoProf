import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class VRegistrar extends JFrame {

	private JPanel contentPane;

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
		setBounds(100, 100, 517, 361);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelRegistrar = new JLabel("Registrar:");
		labelRegistrar.setForeground(Color.BLACK);
		labelRegistrar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 21));
		labelRegistrar.setBounds(15, 35, 174, 26);
		contentPane.add(labelRegistrar);
	}

}
