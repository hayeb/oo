package fractals;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.Insets;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ConfigWindow extends JFrame {

	private GridFiller grid;
	private static final long serialVersionUID = 1L;
	private JFormattedTextField xtextfield;
	private JFormattedTextField ytextfield;
	private JFormattedTextField scaletextfield;

	public ConfigWindow(String title, GridFiller grid, MainWindow fractal_window) throws HeadlessException {
		super(title);
		setSize(300, 120);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new GridBagLayout());
		this.grid = grid;
		createLabels();
		createTextFields();
		createApplyButton();
	}

	private void createApplyButton() {
		GridBagConstraints gbc = new GridBagConstraints();
		JButton applybutton = new JButton("Apply");
		applybutton.addActionListener(new ApplyButtonListener(xtextfield,
				ytextfield, scaletextfield, grid));
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 2;
		gbc.insets = new Insets(7, 0, 0, 0);
		add(applybutton, gbc);
	}

	private void createLabels() {
		GridBagConstraints gbc = new GridBagConstraints();
		JLabel xlabel = new JLabel("X coordinate of center:");
		JLabel ylabel = new JLabel("Y coordinate of center:");
		JLabel scalelabel = new JLabel("Scale factor:");
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets(0, 0, 0, 5);
		add(xlabel, gbc);
		gbc.gridy = 1;
		add(ylabel, gbc);
		gbc.gridy = 2;
		add(scalelabel, gbc);
	}

	private void createTextFields() {
		GridBagConstraints gbc = new GridBagConstraints();
		NumberFormat coordinateformat = NumberFormat.getNumberInstance();
		coordinateformat.setMaximumFractionDigits(0);
		coordinateformat.setMaximumIntegerDigits(100);
		coordinateformat.setGroupingUsed(false);
		NumberFormat scaleformat = NumberFormat.getNumberInstance();
		scaleformat.setMaximumIntegerDigits(100);
		scaleformat.setGroupingUsed(false);

		xtextfield = new JFormattedTextField(coordinateformat);
		xtextfield.setText("0");
		xtextfield.setColumns(10);
		ytextfield = new JFormattedTextField(coordinateformat);
		ytextfield.setText("0");
		ytextfield.setColumns(10);
		scaletextfield = new JFormattedTextField(scaleformat);
		scaletextfield.setText("1");
		scaletextfield.setColumns(10);
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.insets = new Insets(0, 0, 0, 0);
		add(xtextfield, gbc);
		gbc.gridy = 1;
		add(ytextfield, gbc);
		gbc.gridy = 2;
		add(scaletextfield, gbc);

	}
}
