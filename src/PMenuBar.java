/**
 *    PMenuBar is part of the ManyPolygons project
 *    Copyright (C) 2020  TJ Leone
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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import acm.program.Program;
import acm.program.ProgramMenuBar;

@SuppressWarnings("serial")
public class PMenuBar extends ProgramMenuBar {
	
	private List<String> shapesKeys = null;
	private List<Integer> shapesValues = null;
	private Map<String, Integer> shapesMap = null;
	
	public PMenuBar(Program program) {
		super(program);
	}

//	see http://zetcode.com/javaswing/menusandtoolbars/
//	public JRadioButtonMenuItem createProgramItem(String action) {
//		JRadioButtonMenuItem item = new JRadioButtonMenuItem(action);
//		item.setActionCommand(action);
//		item.addActionListener(menuBarListener);
//		return item;
//	}

	/**
	 * Initializes the menu bar. Subclasses can override this method to change the
	 * set of menus.
	 */
	public void addMenus() {
//		addFileMenu();
//		addEditMenu();
		addRowsMenu();
		addColumnsMenu();
		addShapesMenu();
		addSpiralDepthMenu();
	}
	
	public void addRowsMenu() {
		JMenu menu = new JMenu("Rows");
		menu.setMnemonic('R');
		addRowMenuItems(menu);
		add(menu);
	}
	
	public void addColumnsMenu() {
		JMenu menu = new JMenu("Columns");
		menu.setMnemonic('C');
		addColumnMenuItems(menu);
		add(menu);
	}

	
	public void addShapesMenu() {
		JMenu menu = new JMenu("Shapes");
		menu.setMnemonic('S');
		addShapeMenuItems(menu);
		add(menu);
	}

	
	public void addSpiralDepthMenu() {
		JMenu menu = new JMenu("Spiral Depth");
		menu.setMnemonic('D');
		addSpiralDepthMenuItems(menu);
		add(menu);
	}

	/**
	 * Adds the standard File items to the specified menu. Subclasses can override
	 * this method to change the list of items.
	 */
	public void addFileMenuItems(JMenu menu) {
		menu.add(createStandardItem("Save"));
		menu.add(createStandardItem("Save As"));
		menu.addSeparator();
		menu.add(createStandardItem("Print"));
		menu.add(createStandardItem("Print Console"));
		menu.add(createStandardItem("Script"));
		menu.addSeparator();
		menu.add(createStandardItem("Quit"));
	}

	
	public void addRowMenuItems(JMenu menu) {
		JMenuItem rowsItem = null;
		for (int i = 1; i < 11; i++) {
			rowsItem = createProgramItem("" + i);
			rowsItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					((PProgram) getProgram()).updateRows(Integer.parseInt(e.getActionCommand()));
				}
			});
			menu.add(rowsItem);
		}
	}

//	public void addColumnMenuItems(JMenu menu) {
//		JRadioButtonMenuItem colsItem = null;
//		for (Map.Entry<JRadioButtonMenuItem, Integer> me : columItems.entrySet()) {
//			System.out.println("Key: " + me.getKey() + " & Value: " + me.getValue());
//			colsItem = me.getKey();
//			colsItem.addItemListener((e) -> {
//				if (e.getStateChange() == ItemEvent.SELECTED) {
//					System.out.println("e.toString() = " + e.toString());
//					System.out.println("e.getItem() = " + e.getItem());
//					System.out.println("e.getItemSelectable() = " + e.getItemSelectable());
//					System.out.println("e.paramString() = " + e.paramString());
//					((PProgram) getProgram()).updateColumns(columItems.get(e.getItem()));
//				}
//			});
//			menu.add(colsItem);
//		}
//	}

	
	public void addColumnMenuItems(JMenu menu) {
		JMenuItem colsItem = null;
		for (int i = 1; i < 11; i++) {
			colsItem = createProgramItem("" + i);
			colsItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					((PProgram) getProgram()).updateColumns(Integer.parseInt(e.getActionCommand()));
				}
			});
			menu.add(colsItem);
		}
	}

	
	public void addSpiralDepthMenuItems(JMenu menu) {
		JMenuItem item = null;
		for (int i = 1; i < 11; i++) {
			item = createProgramItem("" + i);
			item.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					((PProgram) getProgram()).updateSpiralDepth(Integer.parseInt(e.getActionCommand()));
				}
			});
			menu.add(item);
		}
	}
	
	
	public void setupShapesMenuData() {
		if (shapesMap == null) {
			shapesMap = new HashMap<>();
		} else {
			shapesMap.clear();
		}
		shapesKeys = List.of("Triangle", "Square", "Pentagon", "Hexagon", "Heptagon", "Octagon", "Nonagon",
				"Decagon", "Circle");
		shapesValues = List.of(3, 4, 5, 6, 7, 8, 9, 10, 360);

		for (int i = 0; i < shapesKeys.size(); i++) {
			shapesMap.put(shapesKeys.get(i), shapesValues.get(i));
		}
	}
	
	public void addShapeMenuItems(JMenu menu) {
		setupShapesMenuData();
		JMenuItem shapesItem = null;
		for (int i = 0; i < shapesKeys.size(); i++) {
			shapesItem = createProgramItem("" + shapesKeys.get(i));
			shapesItem.addActionListener(new ShapesActionListener(shapesMap,((PProgram) getProgram())));
			menu.add(shapesItem);
		}
	}
}

class ShapesActionListener implements ActionListener {
	
	private Map<String, Integer> shapesMap;
	private PProgram program;
	public ShapesActionListener(Map<String, Integer>shapesMap, PProgram program) {
		this.shapesMap = shapesMap;
		this.program = program;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String shapeName = e.getActionCommand();
		int numPolySides = shapesMap.get(shapeName);
		program.updateShape(numPolySides);
	}
	
}
