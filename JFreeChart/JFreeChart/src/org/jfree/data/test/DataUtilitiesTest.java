/**
 * 
 */
package org.jfree.data.test;




import org.jfree.data.DataUtilities;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;



@RunWith(Suite.class)
//allows us to run all data utilities simultaneously
@Suite.SuiteClasses({
   calculateColumnTotalTest.class,
   calculateRowTotalTest.class,
   createNumberArrayTest.class,
   createNumberArray2DTest.class,
   getCumulativePercentagesTest.class
   
})

public class DataUtilitiesTest extends DataUtilities {
	
	
	

}
