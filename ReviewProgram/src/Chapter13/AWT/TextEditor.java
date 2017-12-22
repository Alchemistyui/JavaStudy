package Chapter13.AWT;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class TextEditor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame f = new JFrame();
		f.setLayout(new FlowLayout());

		JTextField textField = new JTextField();
		textField.setText("Alchemist");
		f.add(textField);

		textField.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (e.getSource() == textField) {
					textField.setText(""); // 在文本框按下回车键，将文本框内容清空，并在其中显示"Hello World!
					textField.setText("233");
				}
			}

		});

		f.setSize(200, 200);
		f.setVisible(true);

	}

}
