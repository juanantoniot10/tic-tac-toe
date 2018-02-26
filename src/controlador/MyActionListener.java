package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class MyActionListener implements ActionListener {
	TresNRaya control;
	ParaTresNRayaUI paraTresNRayaUI;
	
	public MyActionListener(TresNRaya control, ParaTresNRayaUI paraTresNRayaUI) {
		super();
		this.control = control;
		this.paraTresNRayaUI = paraTresNRayaUI;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		paraTresNRayaUI.jugar(((JButton)e.getSource()).getName());
	}
}
