package vista;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JButton;

public class InterfazTresNRayaTrabajoso extends JFrame {

	protected JPanel contentPane;
	protected JPanel panel;
	protected JLabel lblAnomalia;
	
	/**
	 * Create the frame.
	 */
	public InterfazTresNRayaTrabajoso() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 446, 427);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTresEnRaya = new JLabel("Tres en raya");
		lblTresEnRaya.setBounds(52, 11, 312, 14);
		contentPane.add(lblTresEnRaya);
		
		panel = new JPanel();
		panel.setBounds(37, 61, 353, 213);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(3, 3, 0, 0));
		
		JButton btn00 = new JButton("");
		btn00.setName("00");
		panel.add(btn00);
		
		JButton btn01 = new JButton("");
		btn01.setName("01");
		panel.add(btn01);
		
		JButton btn02 = new JButton("");
		btn02.setName("02");
		panel.add(btn02);
		
		JButton btn10 = new JButton("");
		btn10.setName("10");
		panel.add(btn10);
		
		JButton btn11 = new JButton("O");
		btn11.setName("11");
		panel.add(btn11);
		
		JButton btn12 = new JButton("");
		btn12.setName("12");
		panel.add(btn12);
		
		JButton btn20 = new JButton("");
		btn20.setName("20");
		panel.add(btn20);
		
		JButton btn21 = new JButton("");
		btn21.setName("21");
		panel.add(btn21);
		
		JButton btn22 = new JButton("");
		btn22.setName("22");
		panel.add(btn22);
		
		JLabel lblAnomaliaNo = new JLabel("Anomalia");
		lblAnomaliaNo.setBounds(37, 344, 81, 14);
		contentPane.add(lblAnomaliaNo);
		
		lblAnomalia = new JLabel("");
		lblAnomalia.setBounds(35, 369, 361, 14);
		contentPane.add(lblAnomalia);
	}
}
