
import java.io.*;
import java.text.*;
import java.util.*;

public class StudentList {

    public static void main(String[] args) {

        // check if argument is provided
        // if (args.length == 0) {
        //     System.out.println("Please provide a, r, ?, +, or c argument");
        //     return;
        // }

        String command = args[0];

        if (command.equals("a")) {

        } else if (command.equals("r")) {

        } else if (command.startsWith("+")) {

        } else if (command.startsWith("?")) {

        } else if (command.equals("c")) {

        } else {

            System.out.println("Invalid argument! Use a, r, ?, +, or c");
        }

        String fileContents = LoadData("students.txt");

//		Check arguments
        if (command.equals("a")) {
            System.out.println("Loading data ...");

            try {
                String words[] = fileContents.split(",");

                for (String word : words) {
                    System.out.println(word);
                }

            } catch (Exception e) {

            }

            System.out.println("Data Loaded.");

        } else if (command.equals("r")) {

            System.out.println("Loading data ...");

            try {
                String words[] = fileContents.split(",");

                Random random = new Random();
                int word = random.nextInt(0, words.length);
                System.out.println(words[word]);

            } catch (Exception e) {

            }

            System.out.println("Data Loaded.");
        } else if (command.contains("+")) {

            System.out.println("Loading data ...");

            try {
                BufferedWriter fileStream = new BufferedWriter(
                        new FileWriter("students.txt", true));
                String argValue = args[0].substring(1);
                Date date = new Date();
                String dateFormatObj = "dd/mm/yyyy-hh:mm:ss a";
                DateFormat dateFormat = new SimpleDateFormat(dateFormatObj);
                String formatDate = dateFormat.format(date);
                fileStream.write(", " + argValue + "\nList last updated on " + formatDate);
                fileStream.close();
            } catch (Exception e) {

            }

            System.out.println("Data Loaded.");

        } 
		
		else if (command.contains("?")) {
            System.out.println("Loading data ...");

            try {
                String words[] = fileContents.split(",");

                boolean done = false;
                String argValue = args[0].substring(1);

                for (int idx = 0; idx < words.length && !done; idx++) {

                    if (words[idx].equals(argValue)) {
                        System.out.println("We found it!");
                        done = true;
                    }
                }
				if (!done) {
					System.out.println(argValue + " not found!");
				}
            } catch (Exception e) {

            }

            System.out.println("Data Loaded.");

        } else if (command.contains("c")) {System.out.println("Loading data ...");

		try {
			if (fileContents == null || fileContents.trim().isEmpty()) {
				System.out.println("0 word(s) found 0");
			} else {
				// Count words separated by commas
				String[] words = fileContents.split(",");
				System.out.println(words.length + " word(s) found." );
			}
	
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		System.out.println("Data Loaded.");

        }
    }

    public static String LoadData(String fileName) {
        BufferedReader fileStream = null;
        try {
            fileStream = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream("students.txt")));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        String reader = null;
        try {
            reader = fileStream.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return reader;
    }

}
