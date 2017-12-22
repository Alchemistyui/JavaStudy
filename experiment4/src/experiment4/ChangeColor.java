package experiment4;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ChangeColor {

	public static void main(String[] args) {
		Frame f = new Frame();
		f.setLayout(new FlowLayout());
		
		Button red = new Button("set red");
		JButton green = new JButton("set green");
		Button blue = new Button("set blue");
		
		green.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	green.setForeground(Color.green);
            	red.setForeground(Color.green);
            	blue.setForeground(Color.green);
            }
            }
		);
		
		red.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	green.setForeground(Color.red);
            	red.setForeground(Color.red);
            	blue.setForeground(Color.red);
            }
            }
		);
		
		blue.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	green.setForeground(Color.blue);
            	red.setForeground(Color.blue);
            	blue.setForeground(Color.blue);
            }
            }
		);

		
		
		f.add(red);
		f.add(green);
		f.add(blue);
		
		f.setSize(320, 240);
		f.setVisible(true);
	}

}
