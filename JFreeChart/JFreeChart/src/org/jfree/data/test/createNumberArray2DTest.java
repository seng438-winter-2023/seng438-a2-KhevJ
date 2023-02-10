package org.jfree.data.test;
import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.jfree.data.DataUtilities;
import org.junit.*;


public class createNumberArray2DTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	
	@Test
	public void testingWithEmptyArrays() {
		double[][] input = {{}};
		Double[][] expected = {{}};
		Number[][] actual = DataUtilities.createNumberArray2D(input);
		for(Double[] expectedValue : expected) {
			for(Number[] number:  actual) {
				assertArrayEquals("Empty should have been transformed successfully", expectedValue, number);
				break;
			}
		}
	}
	
	@Test
	public void testingWithThreebyThreeArrays() {
		double[][] input =  {{1.0, 2.0, 3.0}, {1.0, 2.0, 3.0}, {1.0, 2.0, 3.0 }};
		Double[][] expected = {{1.0, 2.0, 3.0}, {1.0, 2.0, 3.0}, {1.0, 2.0, 3.0}};
		
		Number[][] actual = DataUtilities.createNumberArray2D(input);
		for(Double[] expectedValue : expected) {
			for(Number[] number:  actual) {
				assertArrayEquals("Array should have been transformed successfully", expectedValue, number);
				break;
			}
		}
	}
	
	@Test
	public void testingWithOnebyOneArrays() {
		double[][] input =  {{1.0} };
		Double[][] expected = {{1.0}};
	
		Number[][] actual = DataUtilities.createNumberArray2D(input);
		for(Double[] expectedValue : expected) {
			for(Number[] number:  actual) {
				assertArrayEquals("Array should have been transformed successfully", expectedValue, number);
				break;
			}
		}
	}
	
	
	@Test
	public void testingFiveByOneArray() {
		double[][] input =  {{1.0},{1.0},{1.0},{1.0},{1.0} };
		Double[][] expected = {{1.0},{1.0},{1.0},{1.0},{1.0}};
	
		Number[][] actual = DataUtilities.createNumberArray2D(input);
		for(Double[] expectedValue : expected) {
			for(Number[] number:  actual) {
				assertArrayEquals("Array should have been transformed successfully", expectedValue, number);
				break;
			}
		}
	}
	
	@Test
	public void testingOneByFiveArray() {
		double[][] input = {{1.0, 1.0, 1.0, 1.0, 1.0}};
		Double[][] expected = {{1.0, 1.0, 1.0, 1.0, 1.0}};
	
		Number[][] actual = DataUtilities.createNumberArray2D(input);
		for(Double[] expectedValue : expected) {
			for(Number[] number:  actual) {
				assertArrayEquals("Array should have been transformed successfully", expectedValue, number);
				break;
			}
		}
	}
	
	
	@Test(expected = InvalidParameterException.class)
	public void testingWithNullArrays() {
		double[][] input = null ;
		try {
			DataUtilities.createNumberArray2D(input);
		}
		catch(Exception e){
			
		}
		
		
	}
	
	
	@After
	public void tearDown() throws Exception {
	}

	

}
