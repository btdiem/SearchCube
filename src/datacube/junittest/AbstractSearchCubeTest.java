package datacube.junittest;

import static org.junit.Assert.*;

import java.util.concurrent.ForkJoinPool;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runners.JUnit4;

import datacube.search.share.abstracts.AbstractSearchCube;
import datacube.search.share.abstracts.AbstractBase;
import datacube.search.share.impl.DataFactory;
import datacube.search.share.impl.InvariantBroken;
import datacube.search.share.interfaces.IDataCube;
import datacube.search.share.interfaces.IDictionary;

/**
 * 
 * Create {@link JUnit4} test cases for {@link AbstractSearchCube} class</br>
 * 
 * @author btdiem </br>
 *
 */
public abstract class AbstractSearchCubeTest {

	protected IDictionary dictionary = null;
	protected IDataCube cube = null;
	protected ForkJoinPool pool = null;
	protected AbstractSearchCube constructor = null;
	
	@Before
	public void setUp() throws InvariantBroken{
		
		dictionary = DataFactory.createDictionary(20, 5);
		cube = DataFactory.createCubeParallel(200);
		pool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
		constructor = getDefaultConstructor();
		
	}
	
	@After
	public void tearDown(){
		
		dictionary = null;
		cube = null;
		pool = null;
		constructor = null;
	}
	
	/**
	 * Verify that returning a true value with the valid input parameters </br>
	 * @throws {@link InvariantBroken} if the input parameter is invalid </br>
	 * @see {@link AbstractSearchCube#invariant() } </br>
	 */
	@Test
	public void testConstructor() throws InvariantBroken{
		
		assertTrue(constructor.invariant());
	}
	/**
	 * Verify that an {@link AbstractBase} created will return a false if calling {@link AbstractBase#getResult()}
	 * after calling {@link AbstractBase#reset()} </br>
	 * @throws {@link InvariantBroken} if the input parameter is invalid </br>
	 * @see {@link AbstractSearchCube#invariant() } </br>
	 */
	@Test
	public void testGetTask() throws InvariantBroken{
	
		AbstractBase task = getDefaultConstructor().getExecutionTask(cube.getValue(), dictionary.generateOneWord());
		task.reset();
		assertFalse(task.getResult());

	}

	/**
	 * Expect throwing {@link InvariantBroken} exception when calling {@link AbstractSearchCube#isAssociation()} with invalid input parameter </br>
	 * @see {@link AbstractSearchCube#invariant() } </br>
	 */
	@Test (expected=InvariantBroken.class)
	public void testIsAssociation_NOK1() throws InvariantBroken{
		
		assertTrue(getDefaultConstructor_CubeNull().isAssociation());
	}

	/**
	 * Expect throwing {@link InvariantBroken} exception 
	 * when calling {@link AbstractSearchCube#isAssociation()} with invalid input parameter </br>
	 * @see {@link AbstractSearchCube#invariant() } </br>
	 */
	@Test (expected=InvariantBroken.class)
	public void testIsAssociation_NOK2() throws InvariantBroken{
		
		assertTrue(getDefaultConstructor_DictionaryNull().isAssociation());
	}
	
	/**
	 * Expect throwing an {@link InvariantBroken} exception when calling {@link AbstractSearchCube#isAssociation()} 
	 * with invalid input parameter </br>
	 * @see {@link AbstractSearchCube#invariant() } </br>
	 */
	@Test (expected=InvariantBroken.class)
	public void testIsAssociation_NOK3() throws InvariantBroken{
		
		assertTrue(getDefaultConstructor_NOK().isAssociation());
	}


	/**
	 * Return true to show all words in {@link IDictionary} found {@link IDataCube} </br>
	 * In other word, they have a association </br>
	 * @throws {@link  InvariantBroken} if the input parameter is invalid </br>
	 * @see {@link AbstractSearchCube#invariant() } </br>
	 */
	@Test
	public void testIsAssociation() throws InvariantBroken{
		assertTrue(constructor.isAssociation());
	}

	/**
	 * Create a constructor with two valid input parameters </br>
	 * @return {@link AbstractSearchCube} </br>
	 * @throws {@link  InvariantBroken} if the input parameter is invalid </br>
	 * @see {@link AbstractSearchCube#invariant() } </br>
	 */
	public abstract AbstractSearchCube getDefaultConstructor() throws InvariantBroken;
	
	/**
	 * Create a constructor with one null input parameter </br>
	 * @return {@link AbstractSearchCube} </br>
	 * @throws {@link  InvariantBroken} if the input parameter is invalid </br>
	 * @see {@link AbstractSearchCube#invariant() } </br>
	 */
	public abstract AbstractSearchCube getDefaultConstructor_DictionaryNull() throws InvariantBroken;
	
	/**
	 * Create a constructor with one null input parameter </br>
	 * @return {@link AbstractSearchCube} </br>
	 * @throws {@link  InvariantBroken} if the input parameter is invalid </br>
	 * @see {@link AbstractSearchCube#invariant() } </br>
	 */
	public abstract AbstractSearchCube getDefaultConstructor_CubeNull() throws InvariantBroken;
	
	/**
	 * Create a constructor with both invalid input parameters </br>
	 * @return {@link AbstractSearchCube} </br>
	 * @throws {@link  InvariantBroken} if the input parameter is invalid </br>
	 * @see {@link AbstractSearchCube#invariant() } </br>
	 */
	public abstract AbstractSearchCube getDefaultConstructor_NOK() throws InvariantBroken;
	
	
}
