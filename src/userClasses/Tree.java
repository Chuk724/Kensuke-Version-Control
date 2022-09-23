package userClasses;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class Tree {
	public Tree(ArrayList<String> input) throws Exception {
		StringBuilder sb = new StringBuilder();
		
		for (String s : input) {
			sb.append(s + "\n");
		}
		
		File tree = new File("./tests/objects/" + hash(sb.toString()));
		tree.createNewFile();
		PrintWriter pw = new PrintWriter(tree);
		File index = new File ("./tests/index");
		
		//HashMap of fileNames and sha1s in index for folder - <sha1, fileName>
		HashMap<String, String> newIndex = new HashMap<String, String>();
		Scanner reader = new Scanner (index);
		while (reader.hasNextLine()) {
			String line = reader.nextLine();
			String fileName = line.substring(0, line.indexOf(" "));
			String sha1 = line.substring(line.indexOf(":") + 1);
			newIndex.put(sha1, fileName);
		}
		reader.close();
		
		
		for (String s : input) {
			String inputSha = s.substring(s.indexOf(":") + 1);
			String ogFileName = newIndex.get(inputSha);
			pw.println(s + " " + ogFileName);
		}
		//pw.write(sb.toString());
		pw.close();
	}
	
	public String hash (String input) { // copy pasted from blob
		try {
			// getInstance() method is called with algorithm SHA-1
			MessageDigest md = MessageDigest.getInstance("SHA-1");

			// digest() method is called
			// to calculate message digest of the input string
			// returned as array of byte
			byte[] messageDigest = md.digest(input.getBytes());

			// Convert byte array into signum representation
			BigInteger no = new BigInteger(1, messageDigest);

			// Convert message digest into hex value
			String hashtext = no.toString(16);

			// Add preceding 0s to make it 32 bit
			while (hashtext.length() < 32) {
				hashtext = "0" + hashtext;
			}

			// return the HashText
			return hashtext;
		}

		// For specifying wrong message digest algorithms
		catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}
}
