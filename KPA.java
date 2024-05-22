package CryptographyMidterm;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;


import java.util.Iterator;
import java.util.LinkedList;

public class KPA {
    public static void main(String[] args) {
    	// An instance of Rotor96Crypto class
    	Rotor96Crypto myRotor = new Rotor96Crypto();
    	
    	// Search for the keys from the common passwords file
    	List<String> passwordsCollection = loadKeys("C:\\Users\\abeda\\Desktop\\Semester Two Material\\Cryptography & Secure Development\\Cryptography Midterm Assignment\\passwords.txt"); // replace with the provided passwords collection file
    	
    	// Initialising the ciphertext and first two letters of the plain text.
        String cipherText2419103a = "pA>!oo#$Cv!P7?6,NJ|K5MUqhTCD2\\yA4+`LgQh|ajQgXK\\`5gI~Gp&i0aH2KL>dZnW+13r <Y_nS)|jn9t\\7CR{H,z#TF_>jH0E#r}6!ayP<h]SS'5oS*Lo5d9.4ysT]SF)Q}3~/Q8O&D]0&)b6W*QR@D|@Xt3deGgWt|`DjMowdt\\PAH2Onp%&%)n9>G\"A(Hi\\D(5i9dIEZx>Kv8y6p/D"; // Ciphertext for student with student ID 2419103a
        String firstTwoLetters = "Hi";
        

        Iterator<String> passwordsIterator = passwordsCollection.iterator();
        
        // Loop through the common passwords in the given passwords collection
        while(passwordsIterator.hasNext()) {
        	String password = passwordsIterator.next();
            String decryption = myRotor.encdec(Rotor96Crypto.DEC, password, cipherText2419103a);
            if (decryption.startsWith(firstTwoLetters)) {
                System.out.println("Key: " + password);
                System.out.println("Decoded message: " + decryption);
            }
        }
    }
    
    // A method to load the keys found in the common passwords file
    private static List<String> loadKeys(String filePath) {
    	List<String> myPasswords = new LinkedList<String>();
    	try {
    		BufferedReader reader = new BufferedReader(new FileReader(filePath));
    		String line;
    		while((line = reader.readLine()) != null) {
    			myPasswords.add(line.trim());
    		}
    		reader.close();
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	return myPasswords;
    	}
}

