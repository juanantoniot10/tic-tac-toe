package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import java.awt.SystemColor;
import java.awt.Dimension;
import javax.swing.border.LineBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;

public class TresNRayaUI extends JFrame {

	/**
	 * 
	 */
	private JPanel contentPane;
	protected Botonera botonera;
	protected Botones botones;
	protected JLabel mensaje;
	protected JLabel nombreJugadorUno;
	protected JLabel nombreJugadorDos;
	protected JLabel anomaliaUno;
	protected JLabel anomaliaDos;
	protected JLabel lblTresEnRaya;
	protected JPanel panelJugadorUno;
	protected JPanel panelJugadorDos;
	protected JPanel panelFotoJugador1;
	protected JPanel panelFotoJugador2;
	protected JLabel galdalfEnfadado;
	protected JLabel gandalfNormal;
	protected JLabel sarumanEnfadado;
	protected JLabel sarumanNormal;
	protected JLabel gandalfGanador;



	/**
	 * Create the frame.
	 */
	public TresNRayaUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		JPanel panelSuperior = new JPanel();
		panelSuperior.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		contentPane.add(panelSuperior);
		panelSuperior.setBackground(new Color(173, 216, 230));
		
		lblTresEnRaya = new JLabel("TRES EN RAYA");
		lblTresEnRaya.setFont(new Font("Plantagenet Cherokee", Font.PLAIN, 18));
		panelSuperior.add(lblTresEnRaya);
		
		JPanel panelBody = new JPanel();
		contentPane.add(panelBody);
		panelBody.setLayout(new BoxLayout(panelBody, BoxLayout.X_AXIS));
		
		JPanel panelIzquierda = new JPanel();
		panelBody.add(panelIzquierda);
		panelIzquierda.setBackground(new Color(173, 216, 230));
		panelIzquierda.setLayout(new BoxLayout(panelIzquierda, BoxLayout.Y_AXIS));
		
		panelJugadorUno = new JPanel();
		panelJugadorUno.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelIzquierda.add(panelJugadorUno);
		panelJugadorUno.setLayout(new BoxLayout(panelJugadorUno, BoxLayout.Y_AXIS));
		
		nombreJugadorUno=new JLabel("                     JUGADOR 1                     ");
		panelJugadorUno.add(nombreJugadorUno);
		nombreJugadorUno.setBackground(new Color(100, 149, 237));
		
		panelFotoJugador1 = new JPanel();
		Icon icon = new ImageIcon("imagenes/gandalf.jpg");
		panelJugadorUno.add(panelFotoJugador1);
		Icon icon2 = new ImageIcon("imagenes/gandalInterrogante.jpg");
		galdalfEnfadado = new JLabel(icon2);
		gandalfNormal = new JLabel(icon);
		Icon iconGanador = new ImageIcon("imagenes/gandalfGanador.gif");
		gandalfGanador = new JLabel(iconGanador);
		panelFotoJugador1.add(gandalfNormal);
		
		anomaliaUno= new JLabel(""); 
		panelJugadorUno.add(anomaliaUno);
		
		panelJugadorDos = new JPanel();
		panelJugadorDos.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelIzquierda.add(panelJugadorDos);
		panelJugadorDos.setLayout(new BoxLayout(panelJugadorDos, BoxLayout.Y_AXIS));
		
		nombreJugadorDos= new JLabel("JUGADOR 2");
		panelJugadorDos.add(nombreJugadorDos);
		nombreJugadorDos.setBackground(new Color(143, 188, 143));
		
		panelFotoJugador2 = new JPanel();
		Icon icon3 = new ImageIcon("imagenes/sarumanNormal.jpg");
		panelJugadorDos.add(panelFotoJugador2);
		Icon icon4 = new ImageIcon("imagenes/sarumanEnfadado.jpg");
		sarumanEnfadado = new JLabel(icon4);
		sarumanNormal = new JLabel(icon3);
		panelFotoJugador2.add(sarumanNormal);
		panelJugadorDos.add(panelFotoJugador2);
		
		anomaliaDos=new JLabel("");
		panelJugadorDos.add(anomaliaDos);
		
		JPanel panelCentral = new JPanel();
		botones= new Botones(3,3);
		panelCentral=botones.panelCentral;
		panelBody.add(panelCentral);
		
		JPanel panelInferior = new JPanel();
		panelInferior.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		contentPane.add(panelInferior);
		
		mensaje=new JLabel("ho");
		panelInferior.add(mensaje);
	}

}
