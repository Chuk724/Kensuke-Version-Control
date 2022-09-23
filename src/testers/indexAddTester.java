package testers;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import userClasses.Index;

class indexAddTester {

	private Index idx = new Index();
	
	File makeFile(String name, String content) throws Exception {
		File newFile = new File("./tests/" + name);
		newFile.createNewFile();
		PrintWriter pw = new PrintWriter(newFile);
		pw.write(content);
		pw.close();
		return newFile;
	}
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@Test
	void test() throws Exception {
		File file1 = makeFile("first.txt", "First file test content");
		File file2 = makeFile("second.txt", "Second file test content");
		File file3 = makeFile("third.txt", "This confers essentially no additional benefit from just having two test files but idk man i like having stuff in groups of three");
		
		Path indexFile = Path.of("./tests/index");
				
		idx.add("first.txt");
		String firstSHA = idx.indeces.get("first.txt");
		File firstBlob = new File("./tests/objects/" + firstSHA);
		assertTrue(firstBlob.exists());
		assertTrue(Files.readString(indexFile).contains("first.txt : "+idx.indeces.get("first.txt")));
		
		idx.add("second.txt");
		String secondSHA = idx.indeces.get("second.txt");
		File secondBlob = new File("./tests/objects/" + secondSHA);
		assertTrue(secondBlob.exists());
		assertTrue(Files.readString(indexFile).contains("first.txt : "+idx.indeces.get("first.txt")) && Files.readString(indexFile).contains("second.txt : "+idx.indeces.get("second.txt")));
		
		idx.add("third.txt");
		String thirdSHA = idx.indeces.get("third.txt");
		File thirdBlob = new File("./tests/objects/" + thirdSHA);
		assertTrue(thirdBlob.exists());
		assertTrue(Files.readString(indexFile).contains("first.txt : "+idx.indeces.get("first.txt")) && Files.readString(indexFile).contains("second.txt : "+idx.indeces.get("second.txt")) && Files.readString(indexFile).contains("third.txt : "+idx.indeces.get("third.txt")));
	}

}
