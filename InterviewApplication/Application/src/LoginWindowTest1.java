import static org.junit.Assert.*;

import java.io.File;

import junit.framework.Assert;

import org.junit.Test;

public class LoginWindowTest1 {

	@Test
	public void test() {
		FileTypeFilter test = new FileTypeFilter(".docx", "Microsoft Word Documents");
		
		File file = new File("C:\\Users\\choprv1\\Documents\\new doc.docx");
		String des = test.getDescription();
		
		assertEquals("Microsoft Word Documents (*.docx)",des);
	}

}
