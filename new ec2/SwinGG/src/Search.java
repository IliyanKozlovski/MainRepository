import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

public class Search {
	static String search;

	public void newSearch() {

		search = JOptionPane.showInputDialog(null, "Search: ");

		try {
			// Open the file c:\test.txt as a buffered reader
			BufferedReader bf = new BufferedReader(new FileReader(
					"DB.txt"));

			// Start a line count and declare a string to hold our current line.
			int linecount = 0;
			String line;

			// Let the user know what we are searching for
			System.out.println("Searching for " + search + " in file...");

			// Loop through each line, slashing the line into our line variable.
			while ((line = bf.readLine()) != null) {
				// Increment the count and find the index of the word
				linecount++;
				int indexfound = line.indexOf(search);

				// If greater than -1, means we found the word
				if (indexfound > -1) {
					System.out.println("Word was found at position "
							+ indexfound + " on line " + linecount);
				}
			}

			// Close the file after done searching
			bf.close();
		} catch (IOException e) {
			System.out.println("IO Error Occurred: " + e.toString());
		}
	}
}
