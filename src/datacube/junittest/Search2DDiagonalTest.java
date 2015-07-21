package datacube.junittest;

import org.junit.Test;
import org.junit.runners.JUnit4;

import datacube.search.share.abstracts.AbstractSearch2D;
import datacube.search.share.impl.InvariantBroken;
import datacube.search.share.impl.Search2DDiagonal;

/**
 * 
 * This class is an implementation of {@link AbstractSearch2DTest} </br>
 * 
 * Create {@link JUnit4} test cases for {@link Search2DDiagonal} </br> 
 * 
 * @author btdiem </br>
 *
 */
public class Search2DDiagonalTest extends AbstractSearch2DTest {

	/*
	 * (non-Javadoc)
	 * @see datacube.junittest.AbstractSearch2DTest#getInstance_DiagonalSearch()
	 */
	@Override
	public AbstractSearch2D getInstance_DiagonalSearch() throws InvariantBroken {
		return new Search2DDiagonal(twoD, word_Diagonal);
	}

	/*
	 * (non-Javadoc)
	 * @see datacube.junittest.AbstractSearch2DTest#getInstance_SearchNotFound()
	 */
	@Override
	public AbstractSearch2D getInstance_SearchNotFound() throws InvariantBroken {
		return new Search2DDiagonal(twoD, word__NOK);
	}

	/*
	 * (non-Javadoc)
	 * @see datacube.junittest.AbstractSearch2DTest#testConstructor_ArrayNULL()
	 */
	@Override
	@Test(expected = InvariantBroken.class)
	public void testConstructor_ArrayNULL() throws InvariantBroken {
		
		new Search2DDiagonal(null, word__NOK);
	}

	/*
	 * (non-Javadoc)
	 * @see datacube.junittest.AbstractSearch2DTest#testConstructor_WordNULL()
	 */
	@Override
	@Test(expected = InvariantBroken.class)
	public void testConstructor_WordNULL() throws InvariantBroken {
		new Search2DDiagonal(twoD, null);

	}

	/*
	 * (non-Javadoc)
	 * @see datacube.junittest.AbstractSearch2DTest#testConstructor_NOK()
	 */
	@Override
	@Test(expected = InvariantBroken.class)
	public void testConstructor_NOK() throws InvariantBroken {
		new Search2DDiagonal(null, null);

	}
	
	/*
	 * (non-Javadoc)
	 * @see datacube.junittest.AbstractSearch2DTest#testConstructor_TwoDNotSameLength()
	 */
	@Override
	@Test(expected = InvariantBroken.class)
	public void testConstructor_TwoDNotSameLength() throws InvariantBroken {
		new Search2DDiagonal(twoD_NOK, word_Diagonal);
	}
	
	

}
