package testers;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import userClasses.Index;

class IndexInitTester {

	private Index idx = new Index();
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@Test
	void test() throws IOException {
		File existingIndex = new File("./tests/index");
		existingIndex.delete();
		File objDir = new File("./tests/objects");
		objDir.delete();
		
		idx.init();
		
		File objectsFolder = new File("./tests/objects");
		assertTrue(objectsFolder.exists());
		File indexFile = new File("./tests/index");
		assertTrue(indexFile.exists());
	}

}
