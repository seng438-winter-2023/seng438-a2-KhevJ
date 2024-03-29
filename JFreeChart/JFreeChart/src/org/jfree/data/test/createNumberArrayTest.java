package org.jfree.data.test;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.jfree.data.DataUtilities;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class createNumberArrayTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	 /* 
	 * Tests for createNumberArray
	 * Test: creating an array of doubles from an array with nothing in it, creating an array of doubles from an array with random doubles in it,
	 * creating an array from an array that is null,
	 */
	
	// Test creating an empty array 
	@Test 
	public void testCreatingEmptyArray() {
		double[] input = {}; // Creating empty array to test
		Double[] expected = {}; // Creating empty expected array
		Number[] actual = DataUtilities.createNumberArray(input); // Creating array with createnumberarray
		assertArrayEquals("This should create and array that has nothing in it", expected, actual); // Assert the array is null
	}
	
	// Test creating a small array with valid input
	@Test
	public void testCreatingSmallArray() {
		double[] input = {3.7, 1.9, 10.0, 6.745, 562.159}; // Creating a small array with valid input
		Double[] expected = {3.7, 1.9, 10.0, 6.745, 562.159}; // Creating a small expected array with valid input
		Number[] actual = DataUtilities.createNumberArray(input); // Creating array with createnumberarray
		assertArrayEquals("This should create an array that is identical to the input for a small array", expected, actual); // Assert the array is the same
	}
	
	// Test creating a large array with valid input
	@Test
	public void testCreatingLargeArray() {
		double[] input = {3.7, 1.9, 10.0, 6.745, 562.159, -1235.143, -1.0, 979.0, 32.0, 5634.34, -3244.5, -234.532, 325.6, -35.512, 124.124, 145.532, 79345.754, 432.654, 43565.4562}; // Creating large test array with valid input
		Double[] expected = {3.7, 1.9, 10.0, 6.745, 562.159, -1235.143, -1.0, 979.0, 32.0, 5634.34, -3244.5, -234.532, 325.6, -35.512, 124.124, 145.532, 79345.754, 432.654, 43565.4562}; // Creating large expected array with valid input
		Number[] actual = DataUtilities.createNumberArray(input); // Creating array with test array using createnumberarray method
		assertArrayEquals("This should create an array that is identical to the input for a large array", expected, actual); // Assert the arrays are identical
	}
	
	// Test creating an array with invalid input (null)
	@Test(expected = InvalidParameterException.class)
	public void testThrowsInvalidParameterException() {
		try {
			double[] input = null; // Creating a null array
			DataUtilities.createNumberArray(input); // Creating array with createnumberarray method with null test array, exception should be thrown
		}
		catch (Exception e){ 
		}
	}
	
}

