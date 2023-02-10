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
		mockingContext = new Mockery();
		values = mockingContext.mock(KeyedValues.class);
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
	            will(returnValue(3));
	            allowing(values).getValue(0);
	            will(returnValue(5));
	            allowing(values).getKey(0);
				will(returnValue(0));
				allowing(values).getValue(1);
	            will(returnValue(9));
	            allowing(values).getKey(1);
				will(returnValue(1));
				allowing(values).getValue(2);
	            will(returnValue(2));
	            allowing(values).getKey(2);
				will(returnValue(2));
	            
	        }
	    });
		
		KeyedValues result =  DataUtilities.getCumulativePercentages(values);
		assertEquals("Wrong cummulative percentage", 0.3125, result.getValue(0));
		assertEquals("Wrong cummulative percentage", 0.875, result.getValue(1));
		assertEquals("Wrong cummulative percentage", 1.0, result.getValue(2));
		
		
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
	            will(returnValue(3));
	            allowing(values).getValue(0);
	            will(returnValue(-5));
	            allowing(values).getKey(0);
				will(returnValue(0));
				allowing(values).getValue(1);
	            will(returnValue(-9));
	            allowing(values).getKey(1);
				will(returnValue(1));
				allowing(values).getValue(2);
	            will(returnValue(-2));
	            allowing(values).getKey(2);
				will(returnValue(2));
	            
	        }
	    });
		
		KeyedValues result =  DataUtilities.getCumulativePercentages(values);
		assertEquals("Wrong cummulative percentage", 0.3125, result.getValue(0));
		assertEquals("Wrong cummulative percentage", 0.875, result.getValue(1));
		assertEquals("Wrong cummulative percentage", 1.0, result.getValue(2));
		
		
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
	            will(returnValue(3));
	            allowing(values).getValue(0);
	            will(returnValue(1));
	            allowing(values).getKey(0);
				will(returnValue(0));
				allowing(values).getValue(1);
	            will(returnValue(-1));
	            allowing(values).getKey(1);
				will(returnValue(1));
				allowing(values).getValue(2);
	            will(returnValue(1));
	            allowing(values).getKey(2);
				will(returnValue(2));
	            
	        }
	    });
		
		KeyedValues result =  DataUtilities.getCumulativePercentages(values);
		assertEquals("Wrong cummulative percentage", 1.0, result.getValue(0));
		assertEquals("Wrong cummulative percentage", -1.0, result.getValue(1));
		assertEquals("Wrong cummulative percentage", 1.0, result.getValue(2));
		
		
	}
	
	
	
	
//	|key value|                 			 			 |key    value| 
//	|0 		 5|  		should return	                 |0 	   1.0| 
	@Test
	public void getCumulativePercentagesTestForOneKey() {
		
		mockingContext.checking(new Expectations() {
	        {
	        	
	        	allowing(values).getItemCount();
	            will(returnValue(1));
	            allowing(values).getValue(0);
	            will(returnValue(5));
	            allowing(values).getKey(0);
				will(returnValue(0));
	            
	        }
	    });
		
		KeyedValues result =  DataUtilities.getCumulativePercentages(values);
		assertEquals("Wrong cummulative percentage",1.0, result.getValue(0));
	
		
		
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
	            will(returnValue(5));
	            allowing(values).getValue(0);
	            will(returnValue(1));
	            allowing(values).getKey(0);
				will(returnValue(0));
				allowing(values).getValue(1);
	            will(returnValue(1));
	            allowing(values).getKey(1);
				will(returnValue(1));
				allowing(values).getValue(2);
	            will(returnValue(1));
	            allowing(values).getKey(2);
				will(returnValue(2));
				allowing(values).getValue(3);
	            will(returnValue(1));
	            allowing(values).getKey(3);
				will(returnValue(3));
				allowing(values).getValue(4);
	            will(returnValue(1));
	            allowing(values).getKey(4);
				will(returnValue(4));
				
	            
	        }
	    });
		
		KeyedValues result =  DataUtilities.getCumulativePercentages(values);
		assertEquals("Wrong cummulative percentage",0.2, result.getValue(0));
		assertEquals("Wrong cummulative percentage",0.4, result.getValue(1));
		assertEquals("Wrong cummulative percentage",0.6, result.getValue(2));
		assertEquals("Wrong cummulative percentage",0.8, result.getValue(3));
		assertEquals("Wrong cummulative percentage",1.0, result.getValue(4));
	
		
	}	
	
	@Test
	public void getCumulativePercentagesTestForNoKey() {
		mockingContext.checking(new Expectations() {
	        {
	        	
	        	allowing(values).getItemCount();
	            will(returnValue(0));
	        }
	    });
		 DataUtilities.getCumulativePercentages(values);
		
	}
	
	
	//passing null keyValued
	//should call InvalidParameterException.class
	@Test(expected = InvalidParameterException.class)
	public void getCumulativePercentagesTestForNoKeyValued() {
		values = null;
		 try {
			 DataUtilities.getCumulativePercentages(values);
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
	            will(returnValue(1));
	            allowing(values).getValue(0);
	            will(returnValue(null));
	            allowing(values).getKey(0);
				will(returnValue(0));
	            
	        }
	    });
		
		DataUtilities.getCumulativePercentages(values);
		
	
		
		
	}
	
//	|key value|                 			 			  
//	|0 		 0|  		should be invalid	                 
//	|1	     0|                 			 			  
 
	@Test(expected = InvalidParameterException.class)
	public void getCumulativePercentagesTestForAllValuesEqualToZero() {
		
		mockingContext.checking(new Expectations() {
	        {
	        	
	        	allowing(values).getItemCount();
	            will(returnValue(2));
	            allowing(values).getValue(0);
	            will(returnValue(0));
	            allowing(values).getKey(0);
				will(returnValue(0));
				allowing(values).getValue(1);
	            will(returnValue(0));
	            allowing(values).getKey(1);
				will(returnValue(1));
				
	            
	        }
	    });
		
	    DataUtilities.getCumulativePercentages(values);
		
		
	}
	

}
