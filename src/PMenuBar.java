import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;

import acm.program.Program;
import acm.program.ProgramMenuBar;

public class PMenuBar extends ProgramMenuBar {
	
	Map<String, Integer> shapes = Map.of("Triangle", 3, "Square", 4, "Pentagon", 5, "Hexagon", 6, "Heptagon", 7,
			"Octagon", 8, "Nonagon", 9, "Decagon", 10, "Circle", 360);

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
	}

	public void addRowsMenu() {
		JMenu rowsMenu = new JMenu("Rows");
		rowsMenu.setMnemonic('R');
		addRowMenuItems(rowsMenu);
		add(rowsMenu);
	}

	public void addColumnsMenu() {
		JMenu colsMenu = new JMenu("Columns");
		colsMenu.setMnemonic('C');
		addColumnMenuItems(colsMenu);
		add(colsMenu);
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
}
