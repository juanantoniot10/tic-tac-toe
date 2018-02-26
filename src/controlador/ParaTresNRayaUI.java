package controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import vista.Botones;
import vista.TresNRayaUI;

public class ParaTresNRayaUI extends TresNRayaUI{
	TresNRaya control;
	MyActionListener listener=new MyActionListener(control,this);
	String coordenada;
	private int coordenadaAnomaliax;
	private int coordenadaAnomaliay;
	
	
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
		Icon equis = new ImageIcon("imagenes/equisChica.png");
		Icon circulo = new ImageIcon("imagenes/circuloChico.png");
		Icon vacia = new ImageIcon("imagenes/vacia.png");
		
		for (int i = 0; i < this.botones.botones.length; i++) {
			for (int j = 0; j < this.botones.botones[i].length; j++) {
				if(control.tablero[i][j]==1)botones.botones[i][j].setIcon(equis);
				if(control.tablero[i][j]==2)botones.botones[i][j].setIcon(circulo);
				if(control.tablero[i][j]==0)botones.botones[i][j].setIcon(vacia);
			}
		}
		
	}

	public void jugar(String coordenada) {
			control.destinox=Integer.valueOf(String.valueOf(coordenada.charAt(0)));
			control.destinoy=Integer.valueOf(String.valueOf(coordenada.charAt(1)));
			if(control.realizarJugada()) {
				this.botones.botones[coordenadaAnomaliax][coordenadaAnomaliay].setBackground(null);
				this.mensaje.setText(this.control.muestraLetrero());
				if(!this.control.mover) {
					this.botones.botones[this.control.origenx][this.control.origeny].setBackground(new Color(152, 251, 152));
				}
				else {
//					this.botones.botones[coordenadaAnomaliax][coordenadaAnomaliay].setBackground(null);
					this.botones.botones[this.control.origenx][this.control.origeny].setBackground(null);
				}
				if(control.comprobarTresEnRaya()) {
					finalizar();
				}
			}
			else {
				mensaje.setText(this.control.indicarAnomalia());
				coordenadaAnomaliax=this.control.destinox;
				coordenadaAnomaliay=this.control.destinoy;
				this.botones.botones[coordenadaAnomaliax][coordenadaAnomaliay].setBackground(new Color(255, 235, 205));
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
}

