package datacube.junittest;


import static org.junit.Assert.*;

import java.util.concurrent.ForkJoinPool;

import org.junit.Test;
import org.junit.runners.JUnit4;



import datacube.search.share.abstracts.AbstractBase;
import datacube.search.share.impl.InvariantBroken;
/**
 * 
 * Create {@link JUnit4} test cases for {@link AbstractBase} class </br>
 * 
 * @author btdiem </br>
 *
 */
public abstract class AbstractBaseTest {

	protected ForkJoinPool pool = new ForkJoinPool();
	public abstract AbstractBase getDefaultConstructor() throws InvariantBroken;
	
	/**
	 * Verify that when a new search task created, the default is "found' variable is false </br>
	 * by testing {@link AbstractTask#getResult()} returns false and calling {@link AbstractTask#reset()} to reset the value whenever running the other test cases </br>
	 * @throws {@link InvariantBroken} if the input parameter is invalid </br>
	 * Returns false as default value when creating the constructor </br>
	 * @see {@link AbstractBase#getResult()} </br>
	 */
	@Test
	public void testGetResult() throws InvariantBroken{

		AbstractBase task = getDefaultConstructor();
		task.reset();
		assertFalse(task.getResult());
	}
	
	/**
	 * Returns true when calling {@link AbstractBase#updateResult(boolean)} with true parameter value</br>
	 * @throws {@link InvariantBroken} if the input parameter is invalid </br>
	 * @see {@link AbstractBase#getResult()} </br>
	 * @see {@link AbstractBase#updateResult(boolean)} </br>
	 */
	@Test
	public void testUpdateResult1() throws InvariantBroken{
		
		AbstractBase task = getDefaultConstructor();
		task.reset();
		assertFalse(task.getResult());
		task.updateResult(true);
		assertTrue(task.getResult());
		
	}
	
	/**
	 * Return false when calling {@link AbstractBase#updateResult(boolean) with false parameter } </br>
	 * @throws {@link InvariantBroken} if the input parameter is invalid </br>
	 * @see {@link AbstractBase#getResult()} </br>
	 * @see {@link AbstractBase#updateResult(boolean)} </br>
	 */
	@Test
	public void testUpdateResult2() throws InvariantBroken{
		
		AbstractBase task = getDefaultConstructor();
		task.reset();
		assertFalse(task.getResult());
		task.updateResult(false);
		assertFalse(task.getResult());
		
	}

	/**
	 * {@link AbstractBase#getResult()} will return false after calling {@link AbstractBase#reset()} </br>
	 * @throws {@link InvariantBroken} if the input parameter is invalid </br>
	 * @see {@link AbstractBase#reset()} </br>
	 * @see {@link AbstractBase#getResult()} </br>
	 */
	@Test
	public void testReset() throws InvariantBroken{
		getDefaultConstructor().reset();
		assertFalse(getDefaultConstructor().getResult());
	}
}
