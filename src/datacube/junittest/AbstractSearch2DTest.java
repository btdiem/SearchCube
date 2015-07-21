package datacube.junittest;

import static org.junit.Assert.*;

import java.util.concurrent.CancellationException;

import org.junit.Test;
import org.junit.runners.JUnit4;

import datacube.search.share.abstracts.AbstractSearch2D;
import datacube.search.share.abstracts.AbstractBase;
import datacube.search.share.impl.InvariantBroken;

/**
 * This class is an extension of {@link AbstractBaseTest} </br>
 * Creates {@link JUnit4} test cases for {@link AbstractSearch2D} </br>
 * 
 * @author btdiem </br>
 *
 */
public abstract class AbstractSearch2DTest extends AbstractBaseTest{

	
	protected byte[][] twoD = new byte[][]{{'A', 'B', 'C', 'D'},  
											{'e', 'f', 'g', 'h'},
											{'a', 'b', 'c', 'd'},
											{'E', 'F', 'G', 'H'}};
	
	protected byte[][] twoD_NOK = new byte[][]{{'A', 'B', 'C', 'D'},  
												{'e', 'f', 'g', 'h'},
												{'a', 'b', 'c', 'd'}};
	
	protected String word_Horizonal = "ABCD";
	protected String word_Vertical = "DhdH";
	protected String word_Diagonal = "AfcH";
	protected String word__NOK = "KLmN";
	
	
	/*
	 * (non-Javadoc)
	 * @see datacube.junittest.AbstractTaskTest#getDefaultConstructor()
	 */
	@Override
	public AbstractBase getDefaultConstructor() throws InvariantBroken {
		return getInstance_DiagonalSearch();
	}

	/**
	 * Creates an instance of {@link AbstractSearch2D} that returns false when searching a given word 
	 * in 2D array in diagonal dimension </br>
	 * @return {@link AbstractSearch2D} </br>
	 * @throws {@link InvariantBroken} exception if the input parameters are invalid </br>
	 * @see {@link AbstractSearch2D#invariant()} </br>
	 */
	public abstract AbstractSearch2D getInstance_DiagonalSearch() throws InvariantBroken;
	
	/**
	 * 
	 * Creates an instance of {@link AbstractSearch2D} that returns false when searching a given word 
	 * in 2D array in diagonal dimension </br>
	 * @return {@link AbstractSearch2D} </br>
	 * @throws InvariantBroken if the input parameters are invalid </br>
	 * @see {@link AbstractSearch2D#invariant() </br>
	 */
	public abstract AbstractSearch2D getInstance_SearchNotFound() throws InvariantBroken;
	
	/**
	 * Create a constructor to verify that there is an {@link InvariantBroken} thrown 
	 * if input parameters are invalid </br>
	 * @throws {@link InvariantBroken}</br>
	 * @see {@link AbstractSearch2D#invariant()} </br>
	 */
	@Test (expected=InvariantBroken.class)
	public abstract void testConstructor_ArrayNULL() throws InvariantBroken;
	/**
	 * Create a constructor to verify that there is an {@link InvariantBroken} thrown 
	 * if input parameters are invalid </br>
	 * @throws InvariantBroken </br>
	 * @see {@link AbstractSearch2D#invariant()} </br>
	 */
	@Test (expected=InvariantBroken.class)
	public abstract void testConstructor_WordNULL() throws InvariantBroken;
	/**
	 * Create a constructor to verify that there is an {@link InvariantBroken} thrown 
	 * if input parameters are invalid </br>
	 * @throws InvariantBroken </br>
	 * @see {@link AbstractSearch2D#invariant()} </br>
	 */
	@Test (expected=InvariantBroken.class)
	public abstract void testConstructor_NOK() throws InvariantBroken;
	/**
	 * Throws {@link InvariantBroken} exception because the width 
	 * and height of 2D array are not the same </br>
	 * @see {@link AbstractSearch2D#invariant()} </br>
	 * @throws InvariantBroken </br>
	 */
	@Test (expected=InvariantBroken.class)
	public abstract void testConstructor_TwoDNotSameLength() throws InvariantBroken;
	
	
	/**
	 * Starts searching a given word in 2D array in diagonal dimension </br>
	 * Expects a true value returned </br>
	 * @throws {@link InvariantBroken} if the input parameters are invalid </br>
	 * @see {@link AbstractSearch2D#invariant()} </br>
	 */
	@Test (expected=CancellationException.class)
	public void testSearchDiagonal() throws InvariantBroken{
		
		AbstractSearch2D search2D = getInstance_DiagonalSearch();
		search2D.reset();
		pool.invoke(search2D);
		assertTrue(search2D.getResult());
	}

	/**
	 * Start searching a given word in 2D array in diagonal dimension </br>
	 * Expects a false value returned </br>
	 * @throws {@link  InvariantBroken} if the input parameters are invalid </br>
	 * @see {@link AbstractSearch2D#invariant()} </br>
	 */
	@Test
	public void testSearchNotFound() throws InvariantBroken{
		
		AbstractSearch2D search2D = getInstance_SearchNotFound();
		search2D.reset();
		pool.invoke(search2D);
		assertFalse(search2D.getResult());
	}
	


}
