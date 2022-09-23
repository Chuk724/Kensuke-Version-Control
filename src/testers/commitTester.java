package testers;

import userClasses.Commit;
import userClasses.Tree;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class commitTester {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@Test
	void test() throws IOException {
		Commit commie=new Commit("tests/first.txt","tis the og commit","joe",null);
		System.out.println(commie.sha1TreeContent());
		System.out.println(commie);
		System.out.println(commie.getDate());
		commie.printCommitInfo();
		Commit commiesKid=new Commit("tests/second.txt","this is child","beanLord",commie);
		commiesKid.printCommitInfo();
		commie.printCommitInfo();
	}

}
