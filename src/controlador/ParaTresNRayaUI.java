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
	private boolean finalizado;
	
	
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
		if(finalizado)reiniciar();
		finalizado=false;
		extraerDestino(coordenada);
		eliminarColorAnomalia();
		if(control.realizarJugada()) {
			this.mensaje.setText(this.control.muestraLetrero());
			if(!this.control.mover) {
				this.botones.botones[this.control.origenx][this.control.origeny].setBackground(new Color(152, 251, 152));
				mensaje.getParent().setBackground(null);
			}
			else {
				this.botones.botones[this.control.origenx][this.control.origeny].setBackground(null);
				mensaje.getParent().setBackground(null);
			}
			if(control.comprobarTresEnRaya()) {
				finalizar();
				finalizado=true;
			}
		}
		else {
			gestionarAnomalia();
		}
		pintarBotonera();
	}

	/**
	 * 
	 */
	private void gestionarAnomalia() {
		mensaje.getParent().setBackground(new Color(255, 235, 205));
		mensaje.setText(this.control.indicarAnomalia());
		coordenadaAnomaliax=this.control.destinox;
		coordenadaAnomaliay=this.control.destinoy;
		this.botones.botones[coordenadaAnomaliax][coordenadaAnomaliay].setBackground(new Color(255, 235, 205));
	}

	/**
	 * 
	 */
	private void eliminarColorAnomalia() {
		mensaje.getParent().setBackground(null);
		this.botones.botones[coordenadaAnomaliax][coordenadaAnomaliay].setBackground(null);
	}

	/**
	 * @param coordenada
	 */
	private void extraerDestino(String coordenada) {
		control.destinox=Integer.valueOf(String.valueOf(coordenada.charAt(0)));
		control.destinoy=Integer.valueOf(String.valueOf(coordenada.charAt(1)));
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
//			this.panelFotoJugador1.remove(this.gandalfNormal);
//			this.panelFotoJugador1.add(this.gandalfGanador);
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
	private void reiniciar() {
		if(control.verTurno()==1) {
			this.anomaliaUno.setText("");
			this.panelJugadorDos.setBackground(null);
			this.panelJugadorUno.setBackground(null);
			this.panelFotoJugador1.setBackground(null);
			this.panelFotoJugador2.setBackground(null);
			this.panelFotoJugador2.remove(this.sarumanEnfadado);
			this.panelFotoJugador2.add(this.sarumanNormal);
			this.panelFotoJugador1.add(this.gandalfNormal);
			this.panelFotoJugador1.remove(this.gandalfGanador);
		}
		if(control.verTurno()==2) {
			this.anomaliaDos.setText("HAS GANADO");
			this.panelJugadorUno.setBackground(null);
			this.panelJugadorDos.setBackground(null);
			this.panelFotoJugador2.setBackground(null);
			this.panelFotoJugador1.setBackground(null);
			this.panelFotoJugador1.remove(this.galdalfEnfadado);
			this.panelFotoJugador1.add(this.gandalfNormal);
		}
		control = new TresNRaya();
	}
}

