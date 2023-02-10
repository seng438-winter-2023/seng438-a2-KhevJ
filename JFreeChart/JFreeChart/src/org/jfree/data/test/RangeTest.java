package org.jfree.data.test;

import static org.junit.Assert.*; import org.jfree.data.Range; import org.junit.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;





@RunWith(Enclosed.class)
public class RangeTest {
    private static Range exampleRange;
    @BeforeClass public static void setUpBeforeClass() throws Exception {
    	exampleRange = new Range(-1, 1);
    }


    @Before
    public void setUp() throws Exception { exampleRange = new Range(-1, 1);
    }
    
   
   

   public static class lengthTesting {
	   @Test
	    public void lengthShouldBeTwo() {
	    	assertEquals("The length of -1 and 1 should be 2",
	    	        2.0, exampleRange.getLength(), .000000001d);
	    }
	   
   }

    
    
    
    public static class centralValueTesting{
    	 @Test
    	    public void centralValueShouldBeZero() {
    	        assertEquals("The central value of -1 and 1 should be 0",
    	        0, exampleRange.getCentralValue(), .000000001d);
    	    }
    	 
    	 
    }
   
    
    public static class containsTesting {
    	 	@Test
    	    public void containsZero() {
    	    	assertTrue("Zero should be in range -1 and 1",exampleRange.contains(0.0));
    	    }
    	    
    	    
    	    @Test
    	    public void containsLessThanLowerBound() {
    	    	assertFalse("-3 should be in range -1 and 1",exampleRange.contains(-3.0));
    	    }
    	    
    	    @Test
    	    public void containsMoreThanUpperBound() {
    	    	assertFalse("3 should be in range -1 and 1",exampleRange.contains(3.0));
    	    }
    }

    
    public static class boundaryTesting{
    	@Test
        public void lowerBoundShouldBeNegativeOne() {
        	assertEquals("The lower bound of -1 and 1 should be -1",
        	        -1.0, exampleRange.getLowerBound(), .000000001d);
        }
        
        @Test
        public void upperBoundShouldBeOne() {
        	assertEquals("The upper bound of -1 and 1 should be 1",
        	        1.0, exampleRange.getUpperBound(), .000000001d);
        }
    }
    
   
    
    public static class intersectingTest {
    	
    	
    	
    	
    	 @Test
    	    public void intersectWithValuesWithinBoundary() {
    	    	assertTrue("-0.5 and 0 should intersect -1 and 1",
    	    	        exampleRange.intersects(-0.5, 0));
    	    }
    	 
    	 @Test
    	 public void intersectWithRangeBoundaries() {
    		 assertTrue("-1 and 1 should intersect -1 and 1",
 	    	        exampleRange.intersects(-1, 1));
 	    
    	 }
    	 
    	 @Test
    	 public void intersectWithOnlyLowerValueInRange() {
 	    	assertFalse("0 and 5 should not intersect -1 and 1",
 	    	        exampleRange.intersects(0, 5));
 	    }
    	 
    	 @Test
    	 public void intersectWithOnlyUpperValueInRange() {
 	    	assertFalse("-5 and 0 should not intersect -1 and 1",
 	    	        exampleRange.intersects(-5, 0));
    	 }
 	    
    	 
    	 @Test
    	 public void intersectWithBothValuesMoreThanUpperBoundary() {
 	    	assertFalse("3 and 10 should not intersect -1 and 1",
 	    	        exampleRange.intersects(3, 10));
 	    }
    	 
    	 @Test
    	 public void intersectWithBothValuesLessThanLowerBoundary() {
 	    	assertFalse("-5 and -3 should not intersect -1 and 1",
 	    	        exampleRange.intersects(-5, -3));
 	    	
 	    }
    	 
    	 
    	 
    }
    
    
    
    
    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
    
    
   
    
    
    
}
