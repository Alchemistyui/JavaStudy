package experiment4;

import java.awt.BorderLayout;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class TextEditor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JFrame f = new JFrame();
		f.setLayout(new BorderLayout());
		
		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setText(
				"Alchemist~");
		f.add(textArea, BorderLayout.CENTER);
		
		Menu menu1 = new Menu("TextEditor");
		MenuItem mi1 = new MenuItem("About");
		MenuItem mi2 = new MenuItem("Preferences");
		MenuItem mi3 = new MenuItem("New");
		MenuItem mi4 = new MenuItem("Save");
		MenuItem mi5 = new MenuItem("Open");
		
		Menu subMenu = new Menu("Open Recent");
		MenuItem mi6 = new MenuItem("233.txt");
		MenuItem mi7 = new MenuItem("666.txt");
		
		subMenu.add(mi6);
		subMenu.add(mi7);
		
		menu1.add(mi1);
		menu1.add(mi2);
		menu1.add(mi3);
		menu1.add(mi4);
		menu1.add(mi5);
		menu1.add(subMenu);
		
		
		
		Menu menu2 = new Menu("Edit");
		
		MenuItem mi8 = new MenuItem("Copy");
		MenuItem mi9 = new MenuItem("Paste");
		mi6.setEnabled(false);
		
		menu2.add(mi8);
		menu2.add(mi9);
		
		MenuBar menuBar = new MenuBar();
		menuBar.add(menu1);
		menuBar.add(menu2);	
		
		f.setMenuBar(menuBar);
		
		
		f.setSize(320, 240);
		f.setVisible(true);
		
	}

}
