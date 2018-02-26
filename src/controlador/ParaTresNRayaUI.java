package controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

import vista.Botones;
import vista.TresNRayaUI;

public class ParaTresNRayaUI extends TresNRayaUI{
	TresNRaya control;
	MyActionListener listener=new MyActionListener(control,this);
	String coordenada;
	
	
	public ParaTresNRayaUI() {
		super();
		this.control= new TresNRaya();
		pintarBotonera();
		this.mensaje.setText(this.control.muestraLetrero());
		for (int i = 0; i < this.botones.botones.length; i++) {
			for (int j = 0; j < this.botones.botones[i].length; j++) {
 				this.botones.botones[i][j].addActionListener(listener);
			}
		}
	}

	private void pintarBotonera() {
		for (int i = 0; i < this.botones.botones.length; i++) {
			for (int j = 0; j < this.botones.botones[i].length; j++) {
				if(control.tablero[i][j]==1)botones.botones[i][j].setText("X");
				if(control.tablero[i][j]==2)botones.botones[i][j].setText("O");
				if(control.tablero[i][j]==0)botones.botones[i][j].setText(" ");
			}
		}
		
	}

	public void jugar(String coordenada) {
	
			control.destinox=Integer.valueOf(String.valueOf(coordenada.charAt(0)));
			control.destinoy=Integer.valueOf(String.valueOf(coordenada.charAt(1)));
			if(control.realizarJugada()) {
				this.mensaje.setText(this.control.muestraLetrero());
				this.anomaliaDos.setText("");
				this.anomaliaUno.setText("");
				if(control.comprobarTresEnRaya()) {
					finalizar();
				}
			}
			else {
				indicarAnomalia();
			}
			pintarBotonera();
		
//		else if (control.numerojugada>7) {
//			control.origenx=Integer.valueOf(String.valueOf(coordenada.charAt(0)));
//			control.origeny=Integer.valueOf(String.valueOf(coordenada.charAt(1)));
//			if(control.realizarJugada()) {
//				this.mensaje.setText(control.muestraLetrero());
//			}	
//			else {
//				this.anomaliaUno.setText(control.indicarAnomalia());
//			}
//		}
	}

	private void finalizar() {
		if(control.verTurno()==1) {
			this.anomaliaUno.setText("HAS GANADO");
			this.panelJugadorDos.setBackground(new Color(255, 160, 122));
			this.panelJugadorUno.setBackground(new Color(144, 238, 144));
			this.panelFotoJugador1.setBackground(new Color(144, 238, 144));
			this.panelFotoJugador2.setBackground(new Color(255, 160, 122));
			this.panelFotoJugador2.add(this.sarumanEnfadado);
			this.panelFotoJugador2.remove(this.sarumanNormal);
			this.panelFotoJugador1.remove(this.gandalfNormal);
			this.panelFotoJugador1.add(this.gandalfGanador);
		}
		if(control.verTurno()==2) {
			this.anomaliaDos.setText("HAS GANADO");
			this.panelJugadorUno.setBackground(new Color(255, 160, 122));
			this.panelJugadorDos.setBackground(new Color(144, 238, 144));
			this.panelFotoJugador2.setBackground(new Color(144, 238, 144));
			this.panelFotoJugador1.setBackground(new Color(255, 160, 122));
			this.panelFotoJugador1.add(this.galdalfEnfadado);
			this.panelFotoJugador1.remove(this.gandalfNormal);
		}
	}

	private void indicarAnomalia() {
		if(control.verTurno()==1)this.anomaliaUno.setText(this.control.indicarAnomalia());
		if(control.verTurno()==2)this.anomaliaDos.setText(this.control.indicarAnomalia());
	}	
}

