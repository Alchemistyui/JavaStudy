import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;

import javax.swing.JTextArea;

public class AWTtest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Frame f = new Frame();

		f.setLayout(new BorderLayout());

		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setText(
				"cjdnckjenwkvjcnerkjvn rekjnvkjrenvkjrebnkjgbrnekjgrekjngkjernkfjnrekfjnrekjfnbrkejfnkjernfkjenr");
		f.add(textArea, BorderLayout.CENTER);

		MenuItem mi1 = new MenuItem("Open");
		MenuItem mi2 = new MenuItem("close");
		MenuItem mi3 = new MenuItem("save");
		MenuItem mi4 = new MenuItem("save to");
		mi4.setEnabled(false);

		Menu subMenu = new Menu("subMenu");
		subMenu.add(new MenuItem("subMenu1"));
		subMenu.add(new MenuItem("subMenu2"));

		Menu menuFile = new Menu("File");
		menuFile.add(mi1);
		menuFile.add(mi2);
		menuFile.add(subMenu);
		menuFile.add(mi3);
		menuFile.add(mi4);

		MenuBar menuBar = new MenuBar();
		menuBar.add(menuFile);

		f.setMenuBar(menuBar);

		f.setSize(320, 240);
		f.show();

		// System.out.println(button0.getWidth() + " " + button0.getHeight());

	}

}
