package testers;

import userClasses.Blob;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.PrintWriter;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BlobTester {

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
	void test() throws Exception{
		makeFile("test.txt", "Test Content.");
		
		Blob b = new Blob("test.txt");
		File f = new File("./tests/objects/" + b.getSha1Name());
		assertTrue(f.exists());
		
		File testerFile = new File("./tests/test.txt");
		testerFile.delete();
	}

}
