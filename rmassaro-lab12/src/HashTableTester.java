import java.io.File;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Scanner;

public class HashTableTester {	
	private Hashtable<String, Integer> passwords;

    public HashTableTester(File f) {
        passwords = new Hashtable<>();
        read(f);
        crack();
    }
    
    private void read(File f) {
    	System.out.println("Reading password file...");
    	try {
    		Scanner reader = new Scanner(f);
    		while(reader.hasNextLine()) {
    			String line = reader.nextLine();
    			if(!line.startsWith("#"))
    				passwords.put(line.substring(0, line.indexOf(':')), Integer.valueOf(line.substring(line.indexOf(':') + 1)));
    		}
    		reader.close();
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    }
    
    private void crack() {
    	System.out.println("Cracking passwords...");
    	for(String username : passwords.keySet()) {
    		boolean found = false;
    		for (char c1 = 'a'; c1 <= 'z'; c1++)
	            for (char c2 = 'a'; c2 <= 'z'; c2++)
	                for (char c3 = 'a'; c3 <= 'z'; c3++)
	                    for (char c4 = 'a'; c4 <= 'z'; c4++)
	                    	for(char c5 = 'a'; c5 <= 'z'; c5++) 
	                    		for(char c6 = 'a'; c6 <= 'z'; c6++){
	                    			String password = "" + c1 + c2 + c3 + c4 + c5 + c6;
	                    			if (passwords.get(username) == Math.abs(password.hashCode())) {
	                    				System.out.println("Found password " + password + " for username " + username);
	                    				found = true;
	                    				break;
	                    			}
	                    		}
    		if(!found)
    			System.out.println(username + "'s password not found");
    	}
    	System.out.println("Done.");
    }

    public static void main(String[] args) {
        HashTableTester tester = new HashTableTester(new File("src/passwords.txt"));
    }
}
