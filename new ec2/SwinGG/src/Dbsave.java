import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Dbsave {
	String text;

	public Dbsave() {
		text = DetailsPanel.getText();
		}
		
	public void DoWrite(){
		System.out.println(text);
		   try {
	           
	            

	            FileWriter fw = new FileWriter("DB.txt" , true);
	          
	            BufferedWriter out = new BufferedWriter(fw);
	            out.write(text);
	            //Close the output stream
	            out.close();

	        } catch (IOException iox) {
	            //do stuff with exception
	            iox.printStackTrace();
	        }
	    }
	}

