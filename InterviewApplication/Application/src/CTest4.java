import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.Test;


public class CTest4 {

	@Test
	public void test() {
		Connectionclass test = new Connectionclass();
		
		Connection result = test.Connect();
		if(result != null)assertTrue(true);
		//System.out.print(result);
		
		
			
		
	}

}
