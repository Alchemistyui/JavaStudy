package experiment4;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Panel;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class Calculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JFrame f = new JFrame();
		Panel grid = new Panel();

		f.setLayout(new BorderLayout());

		GridBagLayout layout = new GridBagLayout();
		grid.setLayout(layout);

		GridBagConstraints s = new GridBagConstraints();// 定义一个GridBagConstraints，
		// 是用来控制添加进的组件的显示位置
		s.fill = GridBagConstraints.BOTH;

		JTextField text = new JTextField();
		text.setText("0");
		text.setFont(new Font("Dialog", 1, 15));
		text.setPreferredSize(new Dimension(0, 50));
		f.add(text, BorderLayout.NORTH);
		f.add(grid, BorderLayout.CENTER);

		Button[] btn = new Button[19];

		btn[0] = new Button("AC");
		btn[1] = new Button("+/-");
		btn[2] = new Button("%");
		btn[3] = new Button("/");

		btn[4] = new Button("7");
		btn[5] = new Button("8");
		btn[6] = new Button("9");
		btn[7] = new Button("X");

		btn[8] = new Button("4");
		btn[9] = new Button("5");
		btn[10] = new Button("6");
		btn[11] = new Button("-");

		btn[12] = new Button("1");
		btn[13] = new Button("2");
		btn[14] = new Button("3");
		btn[15] = new Button("+");

		btn[16] = new Button("0");
		btn[17] = new Button(".");
		btn[18] = new Button("=");

		for (int i = 0; i < 19; i++) {
			grid.add(btn[i]);
			layout.setConstraints(btn[i], s);
			if((i+2)%4 == 0) {
				s.gridwidth = 0;
			}
			else {
				s.gridwidth = 1;
			}
			
			s.weightx = 0;
			s.weighty = 0;
		}
		s.gridwidth = 2;
		
		for (int i = 16;i<19;i++) {
			layout.setConstraints(btn[i], s);
			s.gridwidth = 1;
			s.weightx = 0;
			s.weighty = 0;
		}
		

		f.setSize(320, 240);
		f.setVisible(true);
	}

}
