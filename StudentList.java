import java.io.*;
import java.text.*;
import java.util.*;

public class StudentList {

    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("Please provide a command: a, r, ?, +, or c");
            return;
        }

        String command = args[0];

        String fileContents = LoadData(Constants.STUDENT_FILE);

        if (command.equals(Constants.SHOW_ALL)) {
            System.out.println("Loading data ...");
            try {
                String[] words = fileContents.split(",");
                for (String word : words) {
                    System.out.println(word.trim());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("Data Loaded.");
        }

        else if (command.equals(Constants.SHOW_RANDOM)) {
            System.out.println("Loading data ...");
            try {
                String[] words = fileContents.split(",");
                Random random = new Random();
                int word = random.nextInt(words.length);
                System.out.println(words[word].trim());
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("Data Loaded.");
        }

        else if (command.startsWith(Constants.ADD_ENTRY)) {
            System.out.println("Loading data ...");
            try {
                String newStudent = command.substring(1).trim();

                // Remove old "List last updated on ..." if exists
                String[] parts = fileContents.split("\n");
                String studentsLine = parts[0].trim(); // first line has all students
                studentsLine += Constants.STUDENT_DELIMITER + " " + newStudent;

                // Get current date
                Date date = new Date();
                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy - hh:mm:ss a");
                String formatDate = dateFormat.format(date);

                // Write back to file: students line + single update line
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(Constants.STUDENT_FILE))) {
                    writer.write(studentsLine);
                    writer.newLine();
                    writer.write("List last updated on " + formatDate);
                }

                System.out.println("Data Loaded.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        else if (command.startsWith(Constants.FIND_ENTRY)) {
            System.out.println("Loading data ...");
            try {
                String[] words = fileContents.split(",");
                String argValue = command.substring(1).trim();
                boolean found = false;

                for (String word : words) {
                    if (word.trim().equals(argValue)) {
                        System.out.println("We found it!");
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    System.out.println(argValue + " not found!");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("Data Loaded.");
        }

        else if (command.equals(Constants.SHOW_COUNT)) {
            System.out.println("Loading data ...");
            try {
                if (fileContents == null || fileContents.trim().isEmpty()) {
                    System.out.println("0 word(s) found 0");
                } else {
                    String[] words = fileContents.split(",");
                    System.out.println(words.length + " word(s) found.");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("Data Loaded.");
        }

        else {
            System.out.println("Invalid argument! Use a, r, ?, +, or c");
        }
    }

    public static String LoadData(String fileName) {
        try (BufferedReader fileStream = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)))) {
            return fileStream.readLine();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
            return "";
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}
