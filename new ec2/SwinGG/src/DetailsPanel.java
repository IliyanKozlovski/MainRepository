import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.event.EventListenerList;

public class DetailsPanel extends JPanel {

	private static final long serialVersionUID = 6915622549267792262L;
	final String[] genresStrings = { "comedy", "action", "drama", "thriller", "documentary" };
	private EventListenerList listenerList = new EventListenerList();
	private static String text;

	public DetailsPanel() {
		Dimension size = getPreferredSize();
		size.width = 350;
		setPreferredSize(size);

		setBorder(BorderFactory.createTitledBorder("personal Details"));

		JLabel namelabel = new JLabel("MovieName: ");
		JLabel occupationlabel = new JLabel("Genre: ");
		JLabel timelabel = new JLabel("Time: ");
		JLabel directorlabel = new JLabel("Director N/S/P: ");
		JLabel suitablelabel = new JLabel("Suitable 18+: ");

		final JTextField nameField = new JTextField(10);
		final JComboBox occupationField = new JComboBox(genresStrings);
		final JTextField timeField = new JTextField(10);
		final JTextField directorField = new JTextField(10);
		final JTextField directorSurname = new JTextField(10);
		final JTextField directorPopularity = new JTextField(1);
		final JRadioButton suitableField = new JRadioButton("Yes" , true);
		final JRadioButton suitable2Field = new JRadioButton("No", false);
		final ButtonGroup btnGroup = new ButtonGroup();
		 btnGroup.add(suitableField);
		 btnGroup.add(suitable2Field);
		JButton addBtn = new JButton("Add");

	
		addBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				String name = nameField.getText();
				String occupation = occupationField.getSelectedItem().toString();
				String time = timeField.getText();
				String director = directorField.getText() + " " + directorSurname.getText() + " " + directorPopularity.getText();
				String suitable = "";
						if(suitableField.isSelected())
							suitable =	"Yes";
				else suitable = "No";
				
				text = name + ": " + occupation + " " + time + " " + director + " " + suitable + "\n";

				fireDetailEvent(new DetailEvent(this, text));
				Dbsave dbsave = new Dbsave();
				dbsave.DoWrite();
			}
		});

		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();

		// First column

		gc.anchor = GridBagConstraints.LINE_END;
		gc.weightx = 0.5;
		gc.weighty = 0.5;

		gc.gridx = 0;
		gc.gridy = 0;

		add(namelabel, gc);
		gc.gridx = 0;
		gc.gridy = 1;
		add(occupationlabel, gc);

		// second column
		gc.anchor = GridBagConstraints.LINE_END;
		gc.gridx = 1;
		gc.gridy = 0;
		add(nameField, gc);

		gc.gridx = 1;
		gc.gridy = 1;
		add(occupationField, gc);

		// third column
		gc.anchor = GridBagConstraints.LINE_END;
		gc.gridx = 1;
		gc.gridy = 2;
		add(timeField, gc);

		gc.gridx = 0;
		gc.gridy = 2;
		add(timelabel, gc);

		// fourth column
		gc.anchor = GridBagConstraints.LINE_END;
		gc.gridx = 1;
		gc.gridy = 3;
		add(directorField, gc);
		gc.gridx = 2;
		add(directorSurname, gc);
		gc.gridx = 3;
		add(directorPopularity, gc);

		gc.gridx = 0;
		gc.gridy = 3;
		add(directorlabel, gc);
		// fifth column
		gc.anchor = GridBagConstraints.LINE_END;
		gc.gridx = 1;
		gc.gridy = 4;
		add(suitableField, gc);
		gc.gridx = 2;
		add(suitable2Field, gc);

		gc.gridx = 0;
		gc.gridy = 4;
		add(suitablelabel, gc);
		
		// final row

		gc.weighty = 10;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.gridx = 1;
		gc.gridy = 6;
		add(addBtn, gc);
	}

	public void fireDetailEvent(DetailEvent event) {
		Object[] listeners = listenerList.getListenerList();
		for (int i = 0; i < listeners.length; i += 2) {
			if (listeners[i] == DetailListener.class) {
				((DetailListener) listeners[i + 1]).detailEventOccured(event);
			}
		}
	}

	public void addDetailListener(DetailListener listener) {
		listenerList.add(DetailListener.class, listener);
	}

	public void removeDetailListener(DetailListener listener) {
		listenerList.remove(DetailListener.class, listener);
	}

	public static String getText() {
		return text;
	}
	

}
