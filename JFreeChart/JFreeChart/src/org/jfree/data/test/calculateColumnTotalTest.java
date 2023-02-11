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


public class calculateColumnTotalTest {

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

	
	
	
	
	/*** Here starts calculateColumnTotal for 2 valid values ***/
	//			   |7.5| 
	//			   |2.5|
	@Test
	public void calculateColumnTotalForTwoValues() {
		mockingContext.checking(new Expectations() {
	        {
	            one(values).getRowCount();
	            will(returnValue(2));
	            one(values).getValue(0, 0);
	            will(returnValue(7.5));
	            one(values).getValue(1, 0);
	            will(returnValue(2.5));
	            
	        }
	    });
	    double result = DataUtilities.calculateColumnTotal(values, 0);
	    assertEquals("Should return ten",10, result, .000000001d);
		
	}
	
	
	/*** Here starts calculateColumnTotal for 2 negative valid values ***/
	//			   |-7.5|
	//             |-2.5|
	@Test
	public void calculateColumnTotalForNegativeTwoValues() {
		mockingContext.checking(new Expectations() {
	        {
	            one(values).getRowCount();
	            will(returnValue(2));
	            one(values).getValue(0, 0);
	            will(returnValue(-7.5));
	            one(values).getValue(1, 0);
	            will(returnValue(-2.5));
	            
	        }
	    });
	    double result = DataUtilities.calculateColumnTotal(values, 0);
	    assertEquals("Should return negative ten",-10, result, .000000001d);
		
	}
	
	/*** Here starts calculateColumnTotal for 5 valid values ***/
	//			   |7.5 |
//				   |-2.5| 
//				   |2.5 |
//				   |7.5 |
//				   |1.0 |
	@Test
	public void calculateColumnTotalFiveValues() {
		mockingContext.checking(new Expectations() {
	        {
	            one(values).getRowCount();
	            will(returnValue(5));
	            one(values).getValue(0, 0);
	            will(returnValue(7.5));
	            one(values).getValue(1, 0);
	            will(returnValue(-2.5));
	            one(values).getValue(2, 0);
	            will(returnValue(2.5));
	            one(values).getValue(3, 0);
	            will(returnValue(-7.5));
	            one(values).getValue(4, 0);
	            will(returnValue(1.0));
	            
	            
	        }
	    });
	    double result = DataUtilities.calculateColumnTotal(values, 0);
	    assertEquals("Should return 1.0",1.0, result, .000000001d);
		
	}
	
	/*** Here starts calculateColumnTotal for 1 valid value ***/
	//	 |7.5 |
	@Test
	public void calculateColumnTotalOneValue() {
		mockingContext.checking(new Expectations() {
	        {
	            one(values).getRowCount();
	            will(returnValue(1));
	            one(values).getValue(0, 0);
	            will(returnValue(7.5));
	            
	            
	            
	        }
	    });
	    double result = DataUtilities.calculateColumnTotal(values, 0);
	    assertEquals("Should return 7.5",7.5, result, .000000001d);
		
	}
	
	
	//valid input with 2 columns |7.5  7.5|
	@Test
	public void calculateColumnTotalForTwoColumns() {
		mockingContext.checking(new Expectations() {
	        {
	            one(values).getRowCount();
	            will(returnValue(1));
	            one(values).getValue(0, 0);
	            will(returnValue(7.5));
	            one(values).getValue(0, 1);
	            will(returnValue(7.5));
	            
	            
	        }
	    });
	    double result = DataUtilities.calculateColumnTotal(values, 1);
	    assertEquals("Should return 7.5",7.5, result, .000000001d);
		
	}
	
	
	//invalid input with no row
	//should print zero
	@Test
	public void calculateColumnTotalForNoRows() {
		mockingContext.checking(new Expectations() {
	        {
	            one(values).getRowCount();
	            will(returnValue(0));
	            
	        }
	    });
	    double result = DataUtilities.calculateColumnTotal(values, 0);
	    assertEquals("Should return 0",0.0, result, .000000001d);
		
	}
	
	
	//invalid  column index less than zero for table |1|
		//should trigger InvalidParameterException
		@Test(expected = InvalidParameterException.class)
		public void testingForInvalidParameterExceptionForInvalidRowIndexForLessThanZero() {
			mockingContext.checking(new Expectations() {
	            {
	                one(values).getRowCount();
	                will(returnValue(1));
	                one(values).getValue(0, -1);
	                will(returnValue(1));
	            }
	        });
	        // test
	        DataUtilities.calculateColumnTotal(values, -1);
		    
			
		}
		
		
		
		//invalid  column index higher than column length for table |1|
		//should trigger InvalidParameterException
		@Test(expected = InvalidParameterException.class)
		public void testingForInvalidParameterExceptionForInvalidRowIndexHigherThanRowSize() {
			mockingContext.checking(new Expectations() {
		        {
		            one(values).getRowCount();
		            will(returnValue(1));
		            one(values).getValue(0, 2);
		            will(returnValue(1));
		            
		        }
		    });
		    DataUtilities.calculateColumnTotal(values, 2);
		    
			
		}
	
	
	//invalid inputs |null| 
	//				 |null|
	//should print zero
	@Test
	public void testingForTotalToBeZeroForInvalidInput() {
		mockingContext.checking(new Expectations() {
	        {
	            one(values).getRowCount();
	            will(returnValue(2));
	            one(values).getValue(0, 0);
	            will(returnValue(1.0));
	            one(values).getValue(1, 0);
	            will(returnValue(null));
	            
	        }
	    });
	    double result = DataUtilities.calculateColumnTotal(values, 0);
	    assertEquals("Should return zero",0, result, .000000001d);
		
	}
	
	
	//invalid inputs |null|
	//				 |null|
	//should trigger InvalidParameterException
	@Test(expected = InvalidParameterException.class)
	public void testingForInvalidParameterExceptionForInvalidValue() {
		mockingContext.checking(new Expectations() {
	        {
	            one(values).getRowCount();
	            will(returnValue(2));
	            one(values).getValue(0, 0);
	            will(returnValue(null));
	            one(values).getValue(1, 0);
	            will(returnValue(null));
	            
	        }
	    });
	    DataUtilities.calculateColumnTotal(values, 0);
	    
		
	}
	

	
	
	

	//null is passed in arguments
	//should trigger InvalidParameterException
	@Test(expected = InvalidParameterException.class)
	public void testingForInvalidParameterExceptionForInvalidValues2D() {
		try {
	    DataUtilities.calculateColumnTotal(null, 0);
		}
		catch(Exception e) {
			
		}
	}
	
	
	
	
}