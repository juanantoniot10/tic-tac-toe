package vista;

import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Botones extends JPanel {
	public JButton botones[][];
	public JPanel panelCentral;

	/**
	 * Create the panel.
	 */
	public Botones(int cantidadFilas,int cantidadColumnas) {
		this.botones = new JButton[cantidadFilas][cantidadColumnas];
		this.panelCentral=iniciarBotonera(cantidadFilas, cantidadColumnas);
	}
	private JPanel iniciarBotonera(int filas, int columnas){
		this.panelCentral = new JPanel();
		panelCentral.setLayout(new BoxLayout(panelCentral, BoxLayout.Y_AXIS));
		for (int i = 0; i < filas; i++) {
			JPanel PanelesFilas[] = new JPanel[filas];
			PanelesFilas[i]=new JPanel();
			PanelesFilas[i].setLayout(new BoxLayout(PanelesFilas[i], BoxLayout.X_AXIS));
			PanelesFilas[i].setName("fila "+i);
			this.panelCentral.add(PanelesFilas[i]);
			for (int j = 0; j < this.botones[i].length; j++) {
				this.botones[i][j] = new JButton(" ");
				this.botones[i][j].setName(String.valueOf(i)+String.valueOf(j));
				this.botones[i][j].setFont(new Font("Wide Latin", Font.PLAIN, 20));
				this.botones[i][j].setHorizontalTextPosition(SwingConstants.CENTER);
				JPanel panelBoton = new JPanel();
				panelBoton.setLayout(new CardLayout(0, 0));
				panelBoton.add(this.botones[i][j]);
				PanelesFilas[i].add(panelBoton);
			}
		}
		return panelCentral;
	}
}
