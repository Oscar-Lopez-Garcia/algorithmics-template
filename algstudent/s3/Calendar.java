package algstudent.s3.Calendar;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Calendar {

	public static void main(String[] args) {
		
		List<String> participants = readParticipants(args[0]);
		
		String[][] calendar = createCalendar(participants);
	}

	private static String[][] createCalendar(List<String> participants) {
		return null;
    }

	private static List<String> readParticipants(String filename) {
		List<String> aux = new ArrayList<>();
		
		
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(filename));

	        int n = Integer.parseInt(reader.readLine());
	            
	        for (int i = 0; i < n; i++) {
	             aux.add(reader.readLine()); 
	        }
		} catch (NumberFormatException|IOException e) {
			System.err.print("Invalid file name");
		}
            
        
        
        return aux;
	}

}
