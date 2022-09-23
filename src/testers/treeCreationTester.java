package testers;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import userClasses.Tree;

class treeCreationTester {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@Test
	void test() throws Exception {
		ArrayList<String> info=new ArrayList<String>();
		info.add("shrek : alkdfjadasd");
		info.add("beans : adlfjasdkf");
		info.add("kuro : ;lj;lkj;kj");
		
		Tree tree=new Tree(info);
		
		File treeFile = new File("./tests/objects/900f7e1e74899e06767f554eff1c99471b9e2ae6");
		assertTrue(treeFile.exists());
		
		Path treePath= Paths.get("./tests/objects/900f7e1e74899e06767f554eff1c99471b9e2ae6");
		String indexContent=Files.readString(treePath);
		assertTrue(indexContent.equals("shrek : alkdfjadasd"+"\n"+"beans : adlfjasdkf"+"\n"+"kuro : ;lj;lkj;kj"+"\n"));
	}

}
