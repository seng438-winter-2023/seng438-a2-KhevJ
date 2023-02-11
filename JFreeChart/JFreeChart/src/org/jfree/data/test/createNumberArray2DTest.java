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

	//testing with empty array 
	@Test
	public void testingWithEmptyArrays() {
		double[][] input = {{}}; // Creating empty test double array
		Double[][] expected = {{}}; // Creating expected empty double array
		Number[][] actual = DataUtilities.createNumberArray2D(input); // Creating array with empty test double array with createnumberarray2d method
		for(Double[] expectedValue : expected) {
			for(Number[] number:  actual) {
				assertArrayEquals("Empty should have been transformed successfully", expectedValue, number); // Assert that the empty 2d arrays are identical
				break;
			}
		}
	}
	
	//testing with three by three array 
	@Test
	public void testingWithThreebyThreeArrays() {
		double[][] input =  {{1.0, 2.0, 3.0}, {1.0, 2.0, 3.0}, {1.0, 2.0, 3.0 }}; // Creating 3 by 3 test array
		Double[][] expected = {{1.0, 2.0, 3.0}, {1.0, 2.0, 3.0}, {1.0, 2.0, 3.0}}; // Creating 3 by 3 expected array
		
		Number[][] actual = DataUtilities.createNumberArray2D(input); // Creating 3 by 3 array with test array and createnumerarray2d
		for(Double[] expectedValue : expected) {
			for(Number[] number:  actual) {
				assertArrayEquals("Array should have been transformed successfully", expectedValue, number); // Assert the two arrays are identical
				break;
			}
		}
	}
	
	//testing with one by one array 
	@Test
	public void testingWithOnebyOneArrays() {
		double[][] input =  {{1.0} }; // Create one by one test array
		Double[][] expected = {{1.0}}; // Create one by one expected array
	
		Number[][] actual = DataUtilities.createNumberArray2D(input); // Creating one by one array with createnumberarray2d
		for(Double[] expectedValue : expected) {
			for(Number[] number:  actual) {
				assertArrayEquals("Array should have been transformed successfully", expectedValue, number); // Assert the two arrays are identical
				break;
			}
		}
	}
	
	
	//testing with five by one array 
	@Test
	public void testingFiveByOneArray() {
		double[][] input =  {{1.0},{1.0},{1.0},{1.0},{1.0} }; // Creating 5 by 5 test array
		Double[][] expected = {{1.0},{1.0},{1.0},{1.0},{1.0}}; // Creating 5 by 5 expected array
	
		Number[][] actual = DataUtilities.createNumberArray2D(input); // Creating 5 by 5 array with createnumberarray2d
		for(Double[] expectedValue : expected) {
			for(Number[] number:  actual) {
				assertArrayEquals("Array should have been transformed successfully", expectedValue, number); // Assert the arrays are identical
				break;
			}
		}
	}
	
	
	
	//testing with one by five array 
	@Test
	public void testingOneByFiveArray() {
		double[][] input = {{1.0, 1.0, 1.0, 1.0, 1.0}}; // Creating 5 by 5 test array
		Double[][] expected = {{1.0, 1.0, 1.0, 1.0, 1.0}}; // Creating 5 by 5 expected array
	
		Number[][] actual = DataUtilities.createNumberArray2D(input); // Creating 5 by 5 array with createnumberarray2d
		for(Double[] expectedValue : expected) {
			for(Number[] number:  actual) {
				assertArrayEquals("Array should have been transformed successfully", expectedValue, number); // Assert the arrays are identical
				break;
			}
		}
	}
	
	
	//testing method with null object
	@Test(expected = InvalidParameterException.class)
	public void testingWithNullArrays() {
		double[][] input = null ; // Creating double array that is null
		try {
			DataUtilities.createNumberArray2D(input); // Should throw an exception with invalid input
		}
		catch(Exception e){
			
		}
		
		
	}
	
	
	@After
	public void tearDown() throws Exception {
	}

	

}
