package testers;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import userClasses.Index;

class indexRemoveTester {
	
	private Index idx = new Index();
	
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@Test
	void test() throws IOException {
		String firstSHA = idx.indeces.get("first.txt");
		String secondSHA = idx.indeces.get("second.txt");
		String thirdSHA = idx.indeces.get("third.txt");
		
		Path indexFile = Path.of("./tests/index");
		
		idx.remove("first.txt");
		File firstBlob = new File("./tests/objects/" + firstSHA);
		assertFalse(firstBlob.exists());
		assertFalse(Files.readString(indexFile).contains("first.txt : "+idx.indeces.get("first.txt")));
	}

}
