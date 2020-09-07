/**
 *    <one line to give the program's name and a brief idea of what it does.>
 *    Copyright (C) <year>  <name of author>
 *
 *    This program is free software: you can redistribute it and/or modify
 *    it under the terms of the GNU General Public License as published by
 *    the Free Software Foundation, either version 3 of the License, or
 *    (at your option) any later version.
 *
 *    This program is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *    GNU General Public License for more details.
 *
 *    You should have received a copy of the GNU General Public License
 *    along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import acm.graphics.GDimension;
import acm.graphics.GTurtle;
import acm.program.GraphicsProgram;
import acm.program.ProgramMenuBar;

@SuppressWarnings("serial")
public class PProgram extends GraphicsProgram implements ChangeListener {

	@SuppressWarnings("ucd")
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	private final static int DISP_MIN = 0;
	private final static int DISP_MAX = 100;
	private final static int DISP_INIT = 20;
	private PParameters parameters;
	private GTurtle turtle;
	private PIsotropicGrid renderingBounds = null;
	private JLabel displacementText;

	protected ProgramMenuBar createMenuBar() {
		return new PMenuBar(this);
	}

	private void addSlider() {
		JPanel southPanel = getRegionPanel(SOUTH);
		JLabel label = new JLabel("Spiral Slider");
		JSlider spiralDisplacement = new JSlider(JSlider.HORIZONTAL, DISP_MIN, DISP_MAX, DISP_INIT);
		spiralDisplacement.addChangeListener(this);
		displacementText = new JLabel("" + (DISP_INIT / 100.0));
		southPanel.add(label);
		southPanel.add(spiralDisplacement);
		southPanel.add(displacementText);
	}

	public void init() {
		initLogging();
		LOGGER.log(Level.FINEST, "Logging initialized in Main");
		initParameters();
		initTurtle();
		initRenderingInfo();
		addSlider();
		initListeners();
	}

	private void initLogging() {
		LogUtil.setupLogging(LOGGER.getName(), LOGGER, Level.ALL);
	}

	private void initParameters() {
		// int rows, int columns, int numPolySides, int polysInSpiral, double
		// displacementPortion
//		parameters = new PParameters(2, 2, 3, 10, 0.2, 0.9);
//		parameters = new PParameters(2, 2, 3, 10, 0.8, 0.9);
//		parameters = new PParameters(2, 2, 4, 10, 0.2, 0.9);
		parameters = new PParameters(8, 8, 4, 10, 0.8, 0.9);
//		parameters = new PParameters(2, 2, 8, 10, 0.2, 0.9);
	}

	@SuppressWarnings("ucd")
	public void updateRows(int rows) {
		parameters.setRows(rows);
		update();
	}

	@SuppressWarnings("ucd")
	public void updateColumns(int cols) {
		parameters.setColumns(cols);
		update();
	}

	@SuppressWarnings("ucd")
	public void updateShape(int numPolySides) {
		parameters.setNumPolySides(numPolySides);
		update();
	}

	@SuppressWarnings("ucd")
	public void updateSpiralDepth(int spiralDepth) {
		parameters.setSpiralDepth(spiralDepth);
		update();
	}

	private void initRenderingInfo() {
		assert turtle != null;
		assert parameters != null;
//		programRectangle = new GRectangle(0,0,getWidth(), getHeight());
		renderingBounds = new PIsotropicGrid(getSize(), parameters);
		renderingBounds.getRenderer(turtle);
	}

	private void initTurtle() {
		turtle = new GTurtle();
		turtle.hideTurtle();
		turtle.setSpeed(1);
		add(turtle);
	}

	private void initListeners() {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				update();
			}
		});
	}

	private void update() {
		double scaleFactor = parameters.getScaleFactor();
		int numPolySides = parameters.getNumPolySides();
		double aspectRatio = PAspectCalculatorFactory.calculator(numPolySides).aspectRatio();
		renderingBounds.fitFrame(getWidth(), getHeight());
		GDimension newSize = renderingBounds.recalculateSize(scaleFactor, aspectRatio);
		renderingBounds.resize(newSize);
		renderingBounds.initPolygon(newSize.getWidth(), newSize.getHeight(), parameters);
		renderingBounds.getSpiral().setDepth(parameters.getSpiralDepth());
		renderingBounds.getSpiral().setDisplacementFactor(parameters.getDisplacementPortion());

		renderingBounds.getRenderer(turtle).render();
	}

	public void run() {

		finish();
	}

	private void finish() {
		LogUtil.tearDownLogging();
	}

	/* Standard Java entry point */
	/* This method can be eliminated in most Java environments */
	public static void main(String[] args) {
		new PProgram().start(args);
	}

	// To do: add label "Spiral" and label to reflect spiral factor
	@Override
	public void stateChanged(ChangeEvent e) {
		JSlider source = (JSlider) e.getSource();
		double displacement = (int) source.getValue() / 100.0;
		displacementText.setText("" + displacement);
		parameters.setDisplacementPortion(displacement);
		update();
	}

}
