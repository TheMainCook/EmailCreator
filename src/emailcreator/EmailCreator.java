package emailcreator;

import com.sun.xml.internal.ws.util.StringUtils;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.System.*;

public class EmailCreator {

    public static void main(String[] args) {

        //email template 
        String template = "";

        // The name of the file to open.
        String fileName = "Emails.txt";
        String filez = "template.txt";
        String line = null;
        String line2 = null;

        out.println("Email Creator\n");
        out.println("===========================================================");
        
        // read throuh the Emails file and the template file
        try {

            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            FileReader fr = new FileReader(filez);
            BufferedReader br = new BufferedReader(fr);
            
             // loops through each line of the file template
            while ((line2 = br.readLine()) != null) {

                template += line2 + "\n";
            }

            // loops through each line of the file email
            while ((line = bufferedReader.readLine()) != null) {
                String[] a = line.split(",");

                String first = StringUtils.capitalize(a[0]);
                String email = a[2].toLowerCase();
                String replacedString = template.replace("{email}", email);
                String replaced = replacedString.replace("{first_name}", first);
                out.print(replaced);
                out.println("===========================================================");
            }

            //close both files
            br.close();
            bufferedReader.close();
            
        } // catch statement for when file is not found within the project
        catch (FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '"
                    + fileName + "'");
        } // catch for when the file is unreadable
        catch (IOException ex) {
            System.out.println(
                    "Error reading file '"
                    + fileName + "'");
        }
    }
}
