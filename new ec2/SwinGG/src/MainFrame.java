import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileReader;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;

public class MainFrame extends JFrame {

	private DetailsPanel detailsPanel;

	public MainFrame(String title) {
		super("moviesFrame");

		// set layout manager
		setLayout(new BorderLayout());
		// create swing components
		final JTextArea textArea = new JTextArea();
		JButton button = new JButton("AddMovie");
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		fileMenu.setMnemonic(KeyEvent.VK_F);
		menuBar.add(fileMenu);

		// File->New, N - Mnemonic
		JMenuItem newMenuItem = new JMenuItem("New/Close", KeyEvent.VK_N);
		fileMenu.add(newMenuItem);
		// Fine->ShowDb, D=Mnemonic
		JMenuItem showMenuItem = new JMenuItem("ShowDB", KeyEvent.VK_D);
		fileMenu.add(showMenuItem);
		//Fine->Search, S=Mnemonic
		JMenuItem searchMenuItem = new JMenuItem("Search", KeyEvent.VK_S);
		fileMenu.add(searchMenuItem);
		

		detailsPanel = new DetailsPanel();
		detailsPanel.setVisible(false);
		detailsPanel.addDetailListener(new DetailListener() {
			public void detailEventOccured(DetailEvent event) {
				String text = event.getText();
				textArea.append(text);
			}
		});

		// add swing components to content pane
		Container c = getContentPane();
		c.add(textArea, BorderLayout.CENTER);
		c.add(button, BorderLayout.SOUTH);
		c.add(detailsPanel, BorderLayout.WEST);
		c.add(menuBar, BorderLayout.NORTH);

		// add behavior
		button.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				if (detailsPanel.isVisible() == false)
					detailsPanel.setVisible(true);
				else
					detailsPanel.setVisible(false);

			}
		});
		// Show hide menu
		newMenuItem.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				if (detailsPanel.isVisible() == false)
					detailsPanel.setVisible(true);
				else
					detailsPanel.setVisible(false);

			}
		});
		// Show DB in textArea
		showMenuItem.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				try {
					FileReader reader = new FileReader("DB.txt");
					BufferedReader br = new BufferedReader(reader);
					textArea.read(br, null);
					br.close();
					textArea.requestFocus();
				} catch (Exception e2) {
					System.out.println(e2);
				}
			}
		});
		// Search in DB
		searchMenuItem.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				Search srh = new Search();
				srh.newSearch();
			
			}
		});

	}
}
