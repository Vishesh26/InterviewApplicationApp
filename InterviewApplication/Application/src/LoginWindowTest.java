import static org.junit.Assert.*;

import java.io.File;

import junit.framework.Assert;

import org.junit.Test;


public class LoginWindowTest {

	@Test
	public void testFilepicker() {
		
		FileTypeFilter test = new FileTypeFilter(".txt",null);
		
		File file = new File("C:\\Users\\choprv1\\Documents\\sample.txt");
		boolean result = test.accept(file);
		//System.out.print(result);
		
		assertEquals(true,result);
		
	
	}

}
