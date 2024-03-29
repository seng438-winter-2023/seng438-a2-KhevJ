package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.DataUtilities;
import org.jfree.data.Values2D;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import java.security.InvalidParameterException;


public class calculateRowTotalTest {

	private Mockery mockingContext;
	private Values2D values;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		mockingContext = new Mockery();
	    values = mockingContext.mock(Values2D.class);
	}

	

	@After
	public void tearDown() throws Exception {
		values = null;
		mockingContext = null;
	}

	
	
	
	
	/*** Here starts calculateRowTotal for 2 values***/
	//valid inputs |7.5 2.5|
	@Test
	public void calculateRowTotalForTwoValues() {
		mockingContext.checking(new Expectations() {
	        {    //setting up return of those functions to the value
	            one(values).getColumnCount();
	            will(returnValue(2));
	            one(values).getValue(0, 0);
	            will(returnValue(7.5));
	            one(values).getValue(0, 1);
	            will(returnValue(2.5));
	            
	        }
	    });
	    double result = DataUtilities.calculateRowTotal(values, 0);
	    assertEquals("Should return ten",10, result, .000000001d);
		
	}
	
	
	/*** Here starts calculateRowTotal for 2 negative values ***/
	//valid inputs |-7.5 -2.5|
	@Test
	public void calculateRowTotalForNegativeTwoValues() {
		mockingContext.checking(new Expectations() {
	        {    //setting up return of those functions to the value
	            one(values).getColumnCount();
	            will(returnValue(2));
	            one(values).getValue(0, 0);
	            will(returnValue(-7.5));
	            one(values).getValue(0, 1);
	            will(returnValue(-2.5));
	            
	        }
	    });
	    double result = DataUtilities.calculateRowTotal(values, 0);
	    assertEquals("Should return negative ten",-10, result, .000000001d);
		
	}
	
	/*** Here starts calculateRowTotal for 5 values ***/
	//valid inputs |7.5 -2.5 2.5 7.5 1.0|
	@Test
	public void calculateRowTotalFiveValues() {
		mockingContext.checking(new Expectations() {
	        {    //setting up return of those functions to the value
	            one(values).getColumnCount();
	            will(returnValue(5));
	            one(values).getValue(0, 0);
	            will(returnValue(7.5));
	            one(values).getValue(0, 1);
	            will(returnValue(-2.5));
	            one(values).getValue(0, 2);
	            will(returnValue(2.5));
	            one(values).getValue(0, 3);
	            will(returnValue(-7.5));
	            one(values).getValue(0, 4);
	            will(returnValue(1.0));
	            
	            
	        }
	    });
	    double result = DataUtilities.calculateRowTotal(values, 0);
	    assertEquals("Should return 1.0",1.0, result, .000000001d);
		
	}
	
	/*** Here starts calculateRowTotal for 1 values ***/
	//valid inputs |7.5 -2.5 2.5 7.5 1.0|
	@Test
	public void calculateRowTotalOneValue() {
		mockingContext.checking(new Expectations() {
	        {   //setting up return of those functions to the value
	            one(values).getColumnCount();
	            will(returnValue(1));
	            one(values).getValue(0, 0);
	            will(returnValue(7.5));
	            
	            
	            
	        }
	    });
	    double result = DataUtilities.calculateRowTotal(values, 0);
	    assertEquals("Should return 7.5",7.5, result, .000000001d);
		
	}
	
	
	//invalid input with no column
	//should print zero
	@Test
	public void calculateRowTotalForNoColumns() {
		mockingContext.checking(new Expectations() {
	        {    //setting up return of those functions to the value
	            one(values).getColumnCount();
	            will(returnValue(0));
	            
	        }
	    });
	    double result = DataUtilities.calculateRowTotal(values, 0);
	    assertEquals("Should return 0",0.0, result, .000000001d);
		
	}
	
	
	
	
	
	//invalid inputs |null null|
	//should print zero
	@Test
	public void testingForTotalToBeZeroForInvalidInput() {
		mockingContext.checking(new Expectations() {
	        {    //setting up return of those functions to the value
	            one(values).getColumnCount();
	            will(returnValue(2));
	            one(values).getValue(0, 0);
	            will(returnValue(1.0));
	            one(values).getValue(0, 1);
	            will(returnValue(null));
	            
	        }
	    });
	    double result = DataUtilities.calculateRowTotal(values, 0);
	    assertEquals("Should return zero",0, result, .000000001d);
		
	}
	
	
	//valid input with 2 rows    |7.5| 
	//							 |7.5|
	@Test
	public void calculateRowTotalForTwoRows() {
		mockingContext.checking(new Expectations() {
	        {    //setting up return of those functions to the value
	            one(values).getColumnCount();
	            will(returnValue(1));
	            one(values).getValue(0, 0);
	            will(returnValue(7.5));
	            one(values).getValue(1, 0);
	            will(returnValue(7.5));
	            
	            
	        }
	    });
	    double result = DataUtilities.calculateRowTotal(values, 1);
	    assertEquals("Should return 7.5",7.5, result, .000000001d);
		
	}	
		
	
	
	//invalid inputs |null null|
	//should trigger InvalidParameterException
	@Test(expected = InvalidParameterException.class)
	public void testingForInvalidParameterExceptionForInvalidValue() {
		mockingContext.checking(new Expectations() {
	        {    //setting up return of those functions to the value
	            one(values).getColumnCount();
	            will(returnValue(2));
	            one(values).getValue(0, 0);
	            will(returnValue(null));
	            one(values).getValue(0, 1);
	            will(returnValue(null));
	            
	        }
	    });
	    DataUtilities.calculateRowTotal(values, 0);
	    
		
	}
	

	
	
	
	//invalid  row index less than zero for table |1|
	//should trigger InvalidParameterException
	@Test(expected = InvalidParameterException.class)
	public void testingForInvalidParameterExceptionForInvalidRowIndexForLessThanZero() {
		mockingContext.checking(new Expectations() {
	        {  //setting up return of those functions to the value
	            one(values).getColumnCount();
	            will(returnValue(1));
	            one(values).getValue(-1, 0);
	            will(returnValue(1));
	            
	        }
	    });
	    DataUtilities.calculateRowTotal(values, -1);
	    
		
	}
	
	//invalid  row index higher than row length for table |1|
	//should trigger InvalidParameterException
	@Test(expected = InvalidParameterException.class)
	public void testingForInvalidParameterExceptionForInvalidRowIndexHigherThanRowSize() {
		mockingContext.checking(new Expectations() {
	        {    //setting up return of those functions to the value
	            one(values).getColumnCount();
	            will(returnValue(1));
	            one(values).getValue(2, 0);
	            will(returnValue(1));
	            
	        }
	    });
	    DataUtilities.calculateRowTotal(values, 2);
	    
		
	}
	

	//invalid inputs |null null|
	//should trigger InvalidParameterException
	@Test(expected = InvalidParameterException.class)
	public void testingForInvalidParameterExceptionForInvalidValues2D() {
		try {
	    DataUtilities.calculateRowTotal(null, 0);
		}
		catch(Exception e) {
			
		}
	}
	
	
	
	
}
