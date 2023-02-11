package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.DataUtilities;
import org.jfree.data.KeyedValues;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import java.security.InvalidParameterException;

public class getCumulativePercentagesTest {
	private Mockery mockingContext;
	private KeyedValues values;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		mockingContext = new Mockery(); // Making new mocking object
		values = mockingContext.mock(KeyedValues.class); // Creating mocking object of keyed values
	}

	@After
	public void tearDown() throws Exception {
		
	}

	
//  for positive values
//	|key value|                 			 |key    value| 
//	|0 		 5|  			                 |0 	0.3125| 
//	|1       9|   should return              |1 	 0.875| 
//	|2	     2|                 			 |2 	   1.0| 
	@Test
	public void getCumulativePercentagesTestForThreePositiveKeys() {
		
		mockingContext.checking(new Expectations() {
	        {
	        	
	        	allowing(values).getItemCount();
	            will(returnValue(3)); // Amount of keyed values should be 3
	            allowing(values).getValue(0);
	            will(returnValue(5)); // Value returned should be 5
	            allowing(values).getKey(0);
				will(returnValue(0)); // Key returned should be 0
				allowing(values).getValue(1);
	            will(returnValue(9)); // Value returned should be 9
	            allowing(values).getKey(1);
				will(returnValue(1)); // Key returned should be 1
				allowing(values).getValue(2);
	            will(returnValue(2)); // Value returned should be 2
	            allowing(values).getKey(2);
				will(returnValue(2)); // Key returned should be 2
	            
	        }
	    });
		
		KeyedValues result =  DataUtilities.getCumulativePercentages(values);
		assertEquals("Wrong cummulative percentage", 0.3125, result.getValue(0)); // Should return 0.3125
		assertEquals("Wrong cummulative percentage", 0.875, result.getValue(1)); // Should return 0.875
		assertEquals("Wrong cummulative percentage", 1.0, result.getValue(2)); // Should return 1.0
		
		
	}
	
	
	
	
//	 for negative values
//	|key  value|                 			 |key    value| 
//	|0 		 -5|  			                 |0 	0.3125| 
//	|1       -9|   should return              |1 	 0.875| 
//	|2	     -2|                 			 |2 	   1.0| 
	@Test
	public void getCumulativePercentagesTestForThreeNegativeKeys() {
		
		mockingContext.checking(new Expectations() {
	        {
	        	
	        	allowing(values).getItemCount();
	            will(returnValue(3)); // Amount of keyed values should be 3
	            allowing(values).getValue(0);
	            will(returnValue(-5)); // Value returned should be -5
	            allowing(values).getKey(0);
				will(returnValue(0)); // Key returned should be 0
				allowing(values).getValue(1);
	            will(returnValue(-9)); // Value returned should be -9
	            allowing(values).getKey(1);
				will(returnValue(1)); // Key returned should be 1
				allowing(values).getValue(2);
	            will(returnValue(-2)); // Value returned should be -2
	            allowing(values).getKey(2);
				will(returnValue(2)); // Key returned should be 2
	            
	        }
	    });
		
		KeyedValues result =  DataUtilities.getCumulativePercentages(values);
		assertEquals("Wrong cummulative percentage", 0.3125, result.getValue(0)); // Should return 0.3125
		assertEquals("Wrong cummulative percentage", 0.875, result.getValue(1)); // Should return 0.875
		assertEquals("Wrong cummulative percentage", 1.0, result.getValue(2)); // Should return 1.0
		
		
	}
	
// for both negative and positive values
//	|key value|                 			 |key    value| 
//	|0 		 1|  			                 |0 	   1.0| 
//	|1      -1|   should return              |1 	  -1.0| 
//	|2	     1|                 			 |2 	   1.0| 
	@Test
	public void getCumulativePercentagesTestForBothNegativeAndPositiveKeys() {
		
		mockingContext.checking(new Expectations() {
	        {
	        	
	        	allowing(values).getItemCount();
	            will(returnValue(3)); // Amount of keyed values should be 3
	            allowing(values).getValue(0);
	            will(returnValue(1)); // Value returned should be 1
	            allowing(values).getKey(0);
				will(returnValue(0)); // Key returned should be 0
				allowing(values).getValue(1);
	            will(returnValue(-1)); // Value returned should be -1
	            allowing(values).getKey(1);
				will(returnValue(1)); // Key returned should be 1
				allowing(values).getValue(2);
	            will(returnValue(1)); // Value returned should be 1
	            allowing(values).getKey(2);
				will(returnValue(2)); // Key returned should be 2
	            
	        }
	    });
		
		KeyedValues result =  DataUtilities.getCumulativePercentages(values);
		assertEquals("Wrong cummulative percentage", 1.0, result.getValue(0)); // Should return 1.0
		assertEquals("Wrong cummulative percentage", -1.0, result.getValue(1)); // Should return -1.0
		assertEquals("Wrong cummulative percentage", 1.0, result.getValue(2)); // Should return 1.0
		
		
	}
	
	
	
	
//	|key value|                 			 			 |key    value| 
//	|0 		 5|  		should return	                 |0 	   1.0| 
	@Test
	public void getCumulativePercentagesTestForOneKey() {
		
		mockingContext.checking(new Expectations() {
	        {
	        	
	        	allowing(values).getItemCount();
	            will(returnValue(1)); // Amount of keyed values should be 1
	            allowing(values).getValue(0);
	            will(returnValue(5)); // Value returned should be 5
	            allowing(values).getKey(0);
				will(returnValue(0)); // Key returned should be 0
	            
	        }
	    });
		
		KeyedValues result =  DataUtilities.getCumulativePercentages(values);
		assertEquals("Wrong cummulative percentage",1.0, result.getValue(0)); // Should return 1.0
	
		
		
	}
	
//	|key value|                 			 			 |key    value| 
//	|0 		 1|  		should return	                 |0 	   0.2| 
//	|1	     1|                 			 			 |1 	   0.4| 
//	|2	     1|                 			 			 |2 	   0.6| 
//	|3	     1|                 						 |3 	   0.8| 
//	|4	     1|                 						 |4 	   1.0| 
	@Test
	public void getCumulativePercentagesTestForFiveKeys() {
		
		mockingContext.checking(new Expectations() {
	        {
	        	
	        	allowing(values).getItemCount();
	            will(returnValue(5)); // Amount of keyed values should be 5
	            allowing(values).getValue(0);
	            will(returnValue(1)); // Value returned should be 1
	            allowing(values).getKey(0);
				will(returnValue(0)); // Key returned should be 0
				allowing(values).getValue(1);
	            will(returnValue(1)); // Value returned should be 1
	            allowing(values).getKey(1);
				will(returnValue(1)); // Key returned should be 0
				allowing(values).getValue(2);
	            will(returnValue(1)); // Value returned should be 1
	            allowing(values).getKey(2);
				will(returnValue(2)); // Key returned should be 0
				allowing(values).getValue(3);
	            will(returnValue(1)); // Value returned should be 1
	            allowing(values).getKey(3);
				will(returnValue(3)); // Key returned should be 0
				allowing(values).getValue(4);
	            will(returnValue(1)); // Value returned should be 1
	            allowing(values).getKey(4);
				will(returnValue(4)); // Key returned should be 0
				
	            
	        }
	    });
		
		KeyedValues result =  DataUtilities.getCumulativePercentages(values);
		assertEquals("Wrong cummulative percentage",0.2, result.getValue(0)); // Should return 0.2
		assertEquals("Wrong cummulative percentage",0.4, result.getValue(1)); // Should return 0.4
		assertEquals("Wrong cummulative percentage",0.6, result.getValue(2)); // Should return 0.6
		assertEquals("Wrong cummulative percentage",0.8, result.getValue(3)); // Should return 0.8
		assertEquals("Wrong cummulative percentage",1.0, result.getValue(4)); // Should return 1.0
	
		
	}	
	
	
	//passing null keyValued
	//should call InvalidParameterException.class
	@Test(expected = InvalidParameterException.class)
	public void getCumulativePercentagesTestForNoKeyValued() {
		values = null;
		 try {
			 DataUtilities.getCumulativePercentages(values); // Should throw an exception for the invalid input
		 }
		 catch(Exception e){
			 
		 }
		
	}
	

//	|key value|                 			 			  
//	|0 	  null|  		is invalid
//should call InvalidParameterException.class
	@Test(expected = InvalidParameterException.class)
	public void getCumulativePercentagesTestForNullValue() {
		
		mockingContext.checking(new Expectations() {
	        {
	        	
	        	allowing(values).getItemCount();
	            will(returnValue(1)); // creates 1 keyed value
	            allowing(values).getValue(0);
	            will(returnValue(null)); // value is null
	            allowing(values).getKey(0);
				will(returnValue(0)); // key is 0
	            
	        }
	    });
		
		DataUtilities.getCumulativePercentages(values); // Should throw an exception for the invalid input
		
	
		
		
	}
	
//	|key value|                 			 			  
//	|0 		 0|  		should be invalid	                 
//	|1	     0|                 			 			  
 
	@Test(expected = InvalidParameterException.class)
	public void getCumulativePercentagesTestForAllValuesEqualToZero() {
		
		mockingContext.checking(new Expectations() {
	        {
	        	
	        	allowing(values).getItemCount();
	            will(returnValue(2)); // creates 2 keyed values
	            allowing(values).getValue(0);
	            will(returnValue(0)); // value is 0
	            allowing(values).getKey(0);
				will(returnValue(0)); // key is 0
				allowing(values).getValue(1);
	            will(returnValue(0)); // value is 0
	            allowing(values).getKey(1);
				will(returnValue(1)); // key is 0
				
	            
	        }
	    });
		
	    DataUtilities.getCumulativePercentages(values); // Should throw an exception for the invalid input
		
		
	}
	

}
