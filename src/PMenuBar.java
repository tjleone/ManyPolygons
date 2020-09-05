import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import acm.program.Program;
import acm.program.ProgramMenuBar;

@SuppressWarnings({ "ucd", "serial" })
public class PMenuBar extends ProgramMenuBar {

	@SuppressWarnings("ucd")
	private List<String> shapesKeys = null;
	@SuppressWarnings("ucd")
	private List<Integer> shapesValues = null;
	@SuppressWarnings("ucd")
	private Map<String, Integer> shapesMap = null;

	@SuppressWarnings("ucd")
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

	@SuppressWarnings("ucd")
	public void addRowsMenu() {
		JMenu menu = new JMenu("Rows");
		menu.setMnemonic('R');
		addRowMenuItems(menu);
		add(menu);
	}

	@SuppressWarnings("ucd")
	public void addColumnsMenu() {
		JMenu menu = new JMenu("Columns");
		menu.setMnemonic('C');
		addColumnMenuItems(menu);
		add(menu);
	}

	@SuppressWarnings("ucd")
	public void addShapesMenu() {
		JMenu menu = new JMenu("Shapes");
		menu.setMnemonic('S');
		addShapeMenuItems(menu);
		add(menu);
	}

	@SuppressWarnings("ucd")
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

	@SuppressWarnings("ucd")
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

	@SuppressWarnings("ucd")
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

	@SuppressWarnings("ucd")
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
	
	@SuppressWarnings("ucd")
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
		int numPolySides = shapesMap.get("Triangle");
		System.out.println("numPolySides=" + numPolySides);
	}

	@SuppressWarnings("ucd")
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
	
	@SuppressWarnings("ucd")
	private Map<String, Integer> shapesMap;
	@SuppressWarnings("ucd")
	private PProgram program;

	public ShapesActionListener(Map<String, Integer>shapesMap, PProgram program) {
		this.shapesMap = shapesMap;
		this.program = program;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
//		int parseInt = Integer.parseInt(e.getActionCommand());
		System.out.println("e.getActionCommand()=" + e.getActionCommand());
		String shapeName = e.getActionCommand();
		int numPolySides = shapesMap.get(shapeName);
		System.out.println("numPolySides=" + numPolySides);
		program.updateShape(numPolySides);
	}
	
}
