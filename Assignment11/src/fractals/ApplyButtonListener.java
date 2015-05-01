package fractals;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class ApplyButtonListener implements ActionListener {

	private JTextField xfield;
	private JTextField yfield;
	private JTextField scalefield;
	private GridFiller filler;

	public ApplyButtonListener(JTextField xfield, JTextField yfield,
			JTextField scalefield, GridFiller filler) {
		this.xfield = xfield;
		this.yfield = yfield;
		this.scalefield = scalefield;
		this.filler = filler;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		/*
		 * Change the scale of the filler according to the current values in the
		 * text fields.
		 */
		//double x_field = Double.parseDouble(this.xfield.getText());
		//double y_field = Double.parseDouble(this.yfield.getText());
		String s = scalefield.getText();
		double scalefield = Double.parseDouble(s);
		double x = Double.parseDouble(xfield.getText());
		double y = Double.parseDouble(yfield.getText());
		filler.resetScale();
		filler.setCenter(x, y);
		filler.setScale(scalefield);
		filler.fill();

	}

}
