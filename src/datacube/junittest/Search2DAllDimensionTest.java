package datacube.junittest;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.CancellationException;

import org.junit.Test;
import org.junit.runners.JUnit4;

import datacube.search.share.abstracts.AbstractSearch2D;
import datacube.search.share.impl.InvariantBroken;
import datacube.search.share.impl.Search2DAllDimension;

/**
 * This class is a implementation of {@link AbstractSearch2DTest} </br>
 * Create {@link JUnit4} test cases for {@link Search2DAllDimension} </br>
 * 
 * @author btdiem </br>
 *
 */
public class Search2DAllDimensionTest extends AbstractSearch2DTest {


	/*
	 * (non-Javadoc)
	 * @see datacube.junittest.AbstractSearch2DTest#getInstance_DiagonalSearch() </br>
	 * @throws {@link InvariantBroken} if the input parameters are invalid </br>
	 * @see {@link AbstractSearch2D#invariant()} <br>
	 */
	@Override
	public AbstractSearch2D getInstance_DiagonalSearch() throws InvariantBroken {
		return new Search2DAllDimension(twoD, word_Diagonal);
	}

	/*
	 * (non-Javadoc)
	 * @see datacube.junittest.AbstractSearch2DTest#testConstructor_ArrayNULL() </br>
	 * @throws {@link InvariantBroken} if the input parameters are invalid </br>
	 * @see {@link AbstractSearch2D#invariant()} <br>
	 * 
	 */
	@Override
	public void testConstructor_ArrayNULL() throws InvariantBroken {
		new Search2DAllDimension(null, word__NOK);
	}

	/*
	 * (non-Javadoc)
	 * @see datacube.junittest.AbstractSearch2DTest#testConstructor_WordNULL() </br>
	 * @throws {@link InvariantBroken} if the input parameters are invalid </br>
	 * @see {@link AbstractSearch2D#invariant()} <br>
 
	 */
	@Override
	public void testConstructor_WordNULL() throws InvariantBroken {
		new Search2DAllDimension(twoD, null);
	}
	

	/*
	 * (non-Javadoc)
	 * @see datacube.junittest.AbstractSearch2DTest#testConstructor_NOK() </br>
	 * @throws {@link InvariantBroken} if the input parameters are invalid </br>
	 * @see {@link AbstractSearch2D#invariant()} <br>
	 */
	@Override
	public void testConstructor_NOK() throws InvariantBroken {
		new Search2DAllDimension(null, null);
		
	}

	/*
	 * (non-Javadoc)
	 * @see datacube.junittest.AbstractSearch2DTest#getInstance_SearchNotFound() </br>
	 * @throws {@link InvariantBroken} if the input parameters are invalid </br>
	 * @see {@link AbstractSearch2D#invariant()} <br>
	 */
	@Override
	public AbstractSearch2D getInstance_SearchNotFound() throws InvariantBroken {
		return new Search2DAllDimension(twoD, word__NOK);
	}

	/*
	 * (non-Javadoc)
	 * @see datacube.junittest.AbstractSearch2DTest#testConstructor_TwoDNotSameLength() </br>
	 * @throws {@link InvariantBroken} if the input parameters are invalid </br>
	 * @see {@link AbstractSearch2D#invariant()} <br>
 
	 */
	@Override
	@Test(expected = InvariantBroken.class)
	public void testConstructor_TwoDNotSameLength() throws InvariantBroken {
		new Search2DAllDimension(twoD_NOK, word_Diagonal);
		
	}

	/**
	 * Return a true value when searching the given word in horizontal dimension </br>
	 * {@link CancellationException} is thrown when the string is found because all other
	 * search tasks scheduled have to stop violently </br>
	 * @throws {@link InvariantBroken} if the input parameters are invalid </br>
	 * @see {@link AbstractSearch2D#invariant()} <br>
	 */
	@Test (expected=CancellationException.class)
	public void testSearchHorizonal() throws InvariantBroken{
		
		AbstractSearch2D search2D = new Search2DAllDimension(twoD, word_Horizonal);
		search2D.reset();
		pool.invoke(search2D);
		assertTrue(search2D.getResult());
	}
	/**
	 * Return a true value when searching the given word in vertical dimension </br>
	 * {@link CancellationException} is thrown when the string is found because all other
	 * search tasks scheduled have to stop violently </br>
	 * @throws {@link InvariantBroken} if the input parameters are invalid </br>
	 * @see {@link AbstractSearch2D#invariant()} <br>
	 */	
	@Test (expected=CancellationException.class)
	public void testSearchVertical() throws InvariantBroken{
		
		AbstractSearch2D search2D = new Search2DAllDimension(twoD, word_Vertical);
		search2D.reset();
		pool.invoke(search2D);
		assertTrue(search2D.getResult());
	}

}
