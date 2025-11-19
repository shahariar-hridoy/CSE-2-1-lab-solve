
import java.io.*;
import java.text.*;
import java.util.*;

public class StudentList {
    public static void main(String[] args) {
		
		// check if argument is provided
		if (args.length == 0) {
			System.out.println("Please provide a, r, ?, +, or c argument");
			return;
		}
	
		String command = args[0];
	
		if (command.equals("a")) {
			
		}
		else if (command.equals("r")) {
			
		}
		else if (command.startsWith("+")) {
			
		}
		else if (command.startsWith("?")) {
			
		}
		else if (command.equals("c")) {
			
		}
		else {
			
			System.out.println("Invalid argument! Use a, r, ?, +, or c");
		}

//		Check arguments
        if (args[0].equals("a")) {
            System.out.println("Loading data ...");

            try {
                BufferedReader s = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream("students.txt")));
                String r = s.readLine();
                String i[] = r.split(",");

                for (String j : i) {
                    System.out.println(j);
                }

            } catch (Exception e) {

            }

            System.out.println("Data Loaded.");
	
        } 
		else if (args[0].equals("r")) {

            System.out.println("Loading data ...");

            try {
                BufferedReader s = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream("students.txt")));
                String r = s.readLine();
                String i[] = r.split(",");
                Random x = new Random();
                int y = x.nextInt(0, i.length);
                System.out.println(i[y]);

            } catch (Exception e) {

            }

            System.out.println("Data Loaded.");
        } 
		else if (args[0].contains("+")) {

            System.out.println("Loading data ...");

            try {
                BufferedWriter s = new BufferedWriter(
                        new FileWriter("students.txt", true));
                String t = args[0].substring(1);
                Date d = new Date();
                String df = "dd/mm/yyyy-hh:mm:ss a";
                DateFormat dateFormat = new SimpleDateFormat(df);
                String fd = dateFormat.format(d);
                s.write(", " + t + "\nList last updated on " + fd);
                s.close();
            } catch (Exception e) {

            }

            System.out.println("Data Loaded.");

        } 

		else if (args[0].contains("?")) {
            System.out.println("Loading data ...");

            try {
                BufferedReader s = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream("students.txt")));
                String r = s.readLine();
                String i[] = r.split(",");
                boolean done = false;
                String t = args[0].substring(1);

                for (int idx = 0; idx < i.length && !done; idx++) {

                    if (i[idx].equals(t)) {
                        System.out.println("We found it!");
                        done = true;
                    }
                }
            } catch (Exception e) {

            }

            System.out.println("Data Loaded.");

        } 

		else if (args[0].contains("c")) {
            System.out.println("Loading data ...");

            try {
                BufferedReader s = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream("students.txt")));
                String D = s.readLine();
                char a[] = D.toCharArray();
                boolean in_word = false;
                int count = 0;

                for (char c : a) {
                    if (c == ' ') {
                        if (!in_word) {
                            count++;
                            in_word = true;
                        } else {
                            in_word = false;
                        }
                    }
                }

                System.out.println(count + " word(s) found " + a.length);

            }
			 catch (Exception e) {

            }

            System.out.println("Data Loaded.");
			
        }
    }
}
