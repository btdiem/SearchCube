package datacube.junittest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.List;
import java.util.concurrent.CancellationException;

import org.junit.Test;
import org.junit.runners.JUnit4;


import datacube.search.share.abstracts.AbstractSearch3D;
import datacube.search.share.abstracts.AbstractBase;
import datacube.search.share.impl.InvariantBroken;

/**
 * This class is an extension of {@link AbstractBaseTest} class </br>
 * Creates {@link JUnit4} test cases for {@link AbstractSearch3D} class </br>
 * 
 * @author btdiem </br>
 *
 */
public abstract class AbstractSearch3DTest extends AbstractBaseTest{



byte[][][] threeD = {{ {'A', 'B', 'C', 'D'}, {'e', 'f', 'g', 'h'}, {'a', 'b', 'c', 'd'}, {'E', 'F', 'G', 'H'} }, 
					{ {'K', 'L', 'M', 'N'}, {'k', 'l', 'm', 'n'}, {'O', 'P', 'Q', 'R'}, {'o', 'p', 'q', 'r'} }, 
					{ {'R', 'S', 'T', 'U'}, {'r', 's', 't', 'u'}, {'V', 'S', 'W', 'T'}, {'v', 's', 'w', 't'} },
					{ {'X', 'Y', 'Z', 'a'}, {'A', 'L', 'T', 'U'}, {'e', 'l', 'P', 'S'}, {'F', 'k', 'T', 'R'} }};


	protected String word_XYDimension = "DCBA";
	protected String word_YZDimension = "XrOE";
	protected String word_XZDimension = "ALTa";
	protected String word_ParallelPlane1 = "DmSF";
	protected String word_ParallelPlane2 = "AlWR";
	protected String word_ParallelPlane3 = "atPE";
	protected String word_ParallelPlane4 = "XsQH";
	protected String word_search_overlen = "something else";
	protected String word_search_NotFound = "oooo";
	
	/**
	 * Create a default constructor of {@link AbstractSearch3D} </br>
	 * @return The specific implementation of class {@link AbstractSearch3D} </br> 
	 * @throws   {@link InvariantBroken} if the input parameters are invalid  </br>
	 * @see {@link AbstractSearch3D#invariant()} </b>
	 */
	public abstract AbstractSearch3D getDefaultConstructor() throws InvariantBroken;
	
	/**
	 * Create a constructor of {@link AbstractSearch3D} that string input parameter is not found in array </br>
	 * @return The specific implementation of class {@link AbstractSearch3D} </br> 
	 * @throws   {@link InvariantBroken} if the input parameters are invalid  </br>
	 * @see {@link AbstractSearch3D#invariant()} </b>
	 */
	public abstract AbstractSearch3D getContructor_SearchNotFound() throws InvariantBroken;

	/**
	 * Create a constructor of {@link AbstractSearch3D} that the length of string input parameter is greater than array's </br>
	 * @return The specific implementation of class {@link AbstractSearch3D} </br> 
	 * @throws   {@link InvariantBroken} if the input parameters are invalid  </br>
	 * @see {@link AbstractSearch3D#invariant()} </b>
	 */
	public abstract AbstractSearch3D getContructor_SearchNotOK() throws InvariantBroken;

	/**
	 * Throw {@link InvariantBroken} exception when creating an instance Of {@link AbstractSearch3D} </br>
	 * Because the first input parameter is NULL </br>
	 * @see {@link AbstractSearch3D#invariant()} </br>
	 * 
	 */
	@Test (expected=InvariantBroken.class)
	public abstract void testConstructor_ArrayNULL() throws InvariantBroken;
	/**
	 * Throw {@link InvariantBroken} exception when creating an instance Of {@link AbstractSearch3D} </br>
	 * Because the second input parameter is NULL </br>
	 * @see {@link AbstractSearch3D#invariant()} </br>
	 * 
	 */
	@Test (expected=InvariantBroken.class)
	public abstract void testConstructor_WordNULL() throws InvariantBroken;
	
	/**
	 * Throw {@link InvariantBroken} exception when creating an instance Of {@link AbstractSearch3D} </br>
	 * Because the two input parameters are NULL </br>
	 * @see {@link AbstractSearch3D#invariant()} </br>
	 * 
	 */
	@Test (expected=InvariantBroken.class)
	public abstract void testConstructor_NOK() throws InvariantBroken;
	/**
	 * Verify the number of task scheduled for execution </br>
	 * @see {@link AbstractSearch3D#searchXY(byte[][][], String)} </br>
	 * @throws {@link InvariantBroken} if the input parameters are invalid </br>
	 * @see {@link AbstractSearch3D#invariant()} </br>
	 */
	@Test
	public void testSearchXY() throws InvariantBroken{
		List<AbstractBase> taskList = getDefaultConstructor().searchXY();
		assertEquals(taskList.size(), 4);
	}
	
	/**
	 * Verify the number of task scheduled for the execution </br>
	 * @see {@link AbstractSearch3D#searchXZ(byte[][][], String)} </br>
	 * @throws {@link InvariantBroken} if the input parameters are invalid </br>
	 * @see {@link AbstractSearch3D#invariant()} </br>
	 */
	@Test
	public void testSearchXZ() throws InvariantBroken{
		List<AbstractBase> taskList = getDefaultConstructor().searchXZ();
		assertEquals(taskList.size(), 4);
	}
	
	/**
	 * Verify the number of tasks scheduled for the execution </br>
	 * @see {@link AbstractSearch3D#searchYZ(byte[][][], String)} </br>
	 * @throws {@link InvariantBroken} if the input parameters are invalid </br>
	 * @see {@link AbstractSearch3D#invariant()} </br>
	 */
	@Test
	public void testSearchYZ() throws InvariantBroken{
		List<AbstractBase> taskList = getDefaultConstructor().searchYZ();
		assertEquals(taskList.size(), 4);
	}

	/**
	 * Verify the number of tasks scheduled for the execution </br>
	 * @see {@link AbstractSearch3D#searchParallelPlane(byte[][][], String)} </br>
	 * @throws {@link InvariantBroken} if the input parameters are invalid </br>
	 * @see {@link AbstractSearch3D#invariant()} </br>
	 */
	@Test
	public void testSearchParallelPlane() throws InvariantBroken{
		List<AbstractBase> taskList = getDefaultConstructor().searchParallelPlane();
		assertEquals(taskList.size(), 4);
	}

	/**
	 * Verify the {@link AbstractSearch3D#getResult()} </br>
	 * @throws {@link InvariantBroken} if the input parameters are invalid </br>
	 * @see {@link AbstractSearch3D#invariant()} </br>
	 */
	@Test (expected=CancellationException.class)
	public void testSearch_OK() throws InvariantBroken{
		
		AbstractSearch3D search3D = getDefaultConstructor();
		search3D.reset();
		pool.invoke(search3D);
		search3D.getResult();
		
	}
	
	/**
	 * Throws exception because the length of searched word is greater than array </br>
	 * @see {@link AbstractSearch3D#getResult()} </br>
	 * @throws {@link InvariantBroken} if the input parameters are invalid </br>
	 * @see {@link AbstractSearch3D#invariant()} </br>
	 */
	@Test (expected=InvariantBroken.class)
	public void testSearch_NOK() throws InvariantBroken{
		
		AbstractSearch3D search3D = getContructor_SearchNotOK();
		search3D.reset();
		pool.invoke(search3D);
		assertFalse(search3D.getResult());
	}
	
	/**
	 * Returns a false result after finishing the search </br>
	 * @see {@link AbstractSearch3D#getResult()} </br>
	 * @throws {@link InvariantBroken} if the input parameters are invalid </br>
	 * @see {@link AbstractSearch3D#invariant()} </br>
	 */
	@Test
	public void testSearch_NotFound() throws InvariantBroken{
		
		AbstractSearch3D search3D = getContructor_SearchNotFound();
		search3D.reset();
		pool.invoke(search3D);
		assertFalse(search3D.getResult());
	}

}
