package KensukeNonJUnitTests;
import java.io.IOException;

import userClasses.Index;

public class IndexTester {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Index indy=new Index();
		indy.init();
		indy.add("something.txt");
		indy.add("another.txt");
		indy.remove("another.txt");
	}
}