import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestMyPoint {
	private MyPoint p;
	
	@Before
	public void setup() {
		this.p = new MyPoint();
	}
	
	@Test
	public void testDefaultConstructor() {
		// Test XY values with the getters
		assertEquals(0d, this.p.getX(), 0.001);
		assertEquals(0d, this.p.getY(), 0.001);
	}
	
	@Test
	public void testParamateredConstructor() {
		// Creation of the point
		MyPoint p1 = new MyPoint(6d, 9d);
		// Test XY values with the getters
		assertEquals(6d, p1.getX(), 0.001);
		assertEquals(9d, p1.getY(), 0.001);
	}
	
	@Test
	public void testSetGetX() {
		// Setting X value
		this.p.setX(4d);
		assertEquals(4d, this.p.getX(), 0.001);		
	}
	
	@Test
	public void testSetGetY() {
		// Setting Y value
		this.p.setY(4d);
		assertEquals(4d, this.p.getY(), 0.001);		
	}
	
	@Test
	public void testSetGetXNaN() {
		// Setting X value
		this.p.setX(Double.NaN);
		assertEquals(Double.NaN, this.p.getX(), 0.001);		
	}
	
	@Test
	public void testSetGetYNaN() {
		// Setting Y value
		this.p.setY(Double.NaN);
		assertEquals(Double.NaN, this.p.getY(), 0.001);		
	}
	
	@Test
	public void testScale() {
		//Setting values
		this.p.setX(4d);
		this.p.setY(2d);
		// Initalisation of a new point to store results.
		MyPoint p2 = this.p.scale(2d);
		assertEquals(8d, p2.getX(), 0.001);	
		assertEquals(4d, p2.getY(), 0.001);		
	}
	
	@Test
	public void testCentralSymmetry() {
		//Setting values
		this.p.setX(4d);
		this.p.setY(2d);
		MyPoint pOrigin = new MyPoint(1d,-1d);
		// Initalisation of a new point to store results.
		MyPoint p2 = this.p.centralSymmetry(pOrigin);
		assertEquals(-2d, p2.getX(), 0.001);		
		assertEquals(0d, p2.getY(), 0.001);		
	}
	

	@Test(expected = IllegalArgumentException.class)
	public void testCentralSymmetryException() throws IllegalArgumentException{
		MyPoint pOrigin = null;
		// Initalisation of a new point to store results.
		MyPoint p2 = this.p.centralSymmetry(pOrigin);	
	}
	

	@Test(expected = IllegalArgumentException.class)
	public void testHorizontalSymmetryException() throws IllegalArgumentException{
		//Setting values
		MyPoint pOrigin = null;
		MyPoint p1 = p.horizontalSymmetry(pOrigin);
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testCentralSymmetryNULL ( ) {
	    new MyPoint(1.0,2.0).centralSymmetry(null);
	}
	
	@Test 
	public void testHorizontalSymmetry() throws IllegalArgumentException{
		//Setting values
		MyPoint pOrigin = new MyPoint(1d,-1d);
		this.p.setX(4d);
		this.p.setY(2d);
		MyPoint p3 = this.p.horizontalSymmetry(pOrigin);
		assertEquals(-2d, p3.getX(), 0.001);	
		assertEquals(2d, p3.getY(), 0.001);
		MyPoint p4 = pOrigin.horizontalSymmetry(pOrigin);
	}

	
}
