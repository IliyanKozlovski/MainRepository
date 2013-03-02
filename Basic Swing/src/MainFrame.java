import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;


public class MainFrame extends JFrame {
	public MainFrame(String title){
		super(title);
		
		//set layout manager
		setLayout(new BorderLayout());
		//create swing components
		final JTextArea textArea = new JTextArea();
		JButton button = new JButton("Click me");
		// add swing components to content pane
		Container c = getContentPane();
		c.add(textArea , BorderLayout.CENTER);
		c.add(button, BorderLayout.SOUTH);
		
		//add behavior 
		button.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				textArea.append("Hi\n");
				
			}
		});
	}
}
