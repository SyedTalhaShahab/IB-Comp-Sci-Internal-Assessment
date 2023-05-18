package views;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Tools {
    private String[] tempClientAry = new String[] { "", "", "", "", "", "" };
    private static List<User> theUserClassList = new LinkedList<User>();// Static because it needs to be
                                                                        // the same for all objects
    private static List<Admin> theAdminClassList = new LinkedList<Admin>(); // Static because it needs to
                                                                            // be the same for all
                                                                            // objects
    private static String[] adminArr = new String[2];
    private BufferedReader theBuffedReader;
    private FileReader theFileReader;
    private FileWriter theFileWriter;
    private PrintWriter thePrintWriter;

    public List<User> getUserList() { // Public method's parameter does not need arguments and returns a
                                      // List of UserClass objects;
        return theUserClassList;
    }

    public List<Admin> getAdminList() { // Public method's parameter does not need arguments and returns a
                                        // List of AdminClass objects;
        return theAdminClassList;
    }

    public boolean isAcceptedTermsNCon(String password) { // Public method's parameter needs a String argument and
                                                          // returns a boolean; finds out if user has accepted terms
                                                          // and conditions from userLogin.txt file.
        for (int i = 0; i < getUserList().size(); i++)
            if ((getUserList().get(i).getPassword()).equals(password))
                return getUserList().get(i).isAccept();
        return false;
    }

    public void readFile() { // Public method's parameter does not need arguments and returns nothing; reads
                             // userLogin.txt file at start of program becucase that is when this is called.
        AlphabetizeUserFl("userLogin.txt", "userLogin.txt");
        String txtLine;
        try {
            theFileReader = new FileReader("userLogin.txt");
            theBuffedReader = new BufferedReader(theFileReader);
            while ((txtLine = theBuffedReader.readLine()) != null) {
                tempClientAry = txtLine.split(" ", 12);
                getUserList().add(new User(tempClientAry[0], tempClientAry[1], tempClientAry[2],
                        Integer.parseInt(tempClientAry[3]), Integer.parseInt(tempClientAry[4]),
                        Boolean.parseBoolean(tempClientAry[5])));
            }

            theFileReader.close();
            theBuffedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void registerTotFile(User person) { // Public method's parameter needs a UserClass argument and returns
                                               // nothing; registers registers new person from RegisterGUi to
                                               // userLogin.txt file.
        getUserList().add(person);
        int index = getUserList().indexOf(person);
        try {
            theFileWriter = new FileWriter("userLogin.txt", true);
            thePrintWriter = new PrintWriter(theFileWriter);
            thePrintWriter.println(getUserList().get(index).toString());
            theFileWriter.close();
            thePrintWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        AlphabetizeUserFl("userLogin.txt", "userLogin.txt");
    }

    public String searchU(String username, String password) { // Public method's parameter needs 2 String arguments and
                                                              // returns a String; searches for user in userLogin.txt
                                                              // file.
        AlphabetizeUserFl("userLogin.txt", "userLogin.txt");
        for (int i = 0; i < getUserList().size(); i++) {
            boolean user = (username.toUpperCase()).equals(getUserList().get(i).getUsername().toUpperCase());
            boolean pass = password.equals(getUserList().get(i).getPassword());
            if (user && pass)
                return "Both";
            else if (user && !pass)
                return "OnlyUsername";
            else if (!user && pass)
                return "OnlyPassword";
        }
        return "None";
    }

    public void updateTxtFromList() {// Private method's parameter does not need arguments and does not return
                                     // anything; writes the user's information into userLogin.txt file.
        try {
            theFileWriter = new FileWriter("userLogin.txt", false); // FileWriter: false == overwirteFile
            thePrintWriter = new PrintWriter(theFileWriter);
            for (int i = 0; i < getUserList().size(); i++) {
                thePrintWriter.println(getUserList().get(i));
            }
            theFileWriter.close();
            thePrintWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        AlphabetizeUserFl("userLogin.txt", "userLogin.txt");
    }

    // https://stackoverflow.com/questions/57976366/reading-a-portion-of-a-line-from-a-file-and-then-deleting-it
    public static void AlphabetizeUserFl(String fromFIle, String toFile) { // Public static method's parameter needs 2
                                                                           // String
                                                                           // arguments and does not return anything;
                                                                           // sorts the userLogin.txt file in ABC
                                                                           // order, major credit to StackOverflow.
        Path thePath = Paths.get(fromFIle);
        Charset theCharset = Charset.forName("UTF-8");
        List<String> lines;
        try {
            lines = Files.readAllLines(thePath, theCharset);
            lines.removeAll(Arrays.asList("", null)); // Removes all empty lines
            Collections.sort(lines, new IgnoreCase());
            Path toPath = Paths.get(toFile);
            Files.write(toPath, lines, theCharset);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean searchA(String username, String password) { // Private method's parameter needs 2 String arguments
                                                               // and returns a boolean searches for admin in
                                                               // adminLogin.txt file.
        readAdminLoginFile();
        if ((getAdminList().get(0).getUsername()).equalsIgnoreCase(username)
                && (getAdminList().get(0).getPassword()).equals(password))
            return true;
        else
            return false;

    }

    private void readAdminLoginFile() { // Private method's parameter does not need arguments and does not return
                                        // anything; reads adminLogin.txt file at start of program.
        String txtLine = "";
        try {
            theFileReader = new FileReader("adminLogin.txt");
            theBuffedReader = new BufferedReader(theFileReader);
            while ((txtLine = theBuffedReader.readLine()) != null) {
                adminArr = txtLine.split(" ", 2);
                getAdminList().add(new Admin(adminArr[0], adminArr[1]));
            }
            theFileReader.close();
            theBuffedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}