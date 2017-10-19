import static org.junit.Assert.*;

import org.junit.Test;

import shapes.Rectangle;
public class RectTest {
	
	public void testConstrSetsDataMembers(){
		int width = 10, len = 5;
		int retrivedWidth,retrivedLen;
		Rectangle newrect = new Rectangle(width,len);
		retrivedWidth = newrect.getWidth();
		retrivedLen = newrect.getLen();
		assertEquals(width,retrivedWidth);
		assertEquals(len,retrivedLen);
	}
	
	public void testGetAreaMethod(){
		int width = 10 ,len =5;
		int retrievedArea;
		Rectangle newrect = new Rectangle(width,len);
		assertEquals(newrect.getArea(),width*len);
	}
	@Test
	public void testLargerRectIsGreater(){
		int width=10,len=5;
		int retriveComparedto;
		Rectangle smallrect = new Rectangle(width,len);
		Rectangle bigrect = new Rectangle(width,9);
		assertTrue(bigrect.compareTo(smallrect)>0);
	}
}
