package datacube.junittest;

import org.junit.Test;
import org.junit.runners.JUnit4;

import datacube.search.share.abstracts.AbstractSearch3D;
import datacube.search.share.impl.InvariantBroken;
import datacube.search.share.impl.SearchParallelPlane4;

/**
 * 
 * This class is an implementation of {@link AbstractSearch3DTest} class </br>
 * Create {@link JUnit4} test case for {@link SearchParallelPlane4} class </br>
 * 
 * @author btdiem </br>
 *
 */

public class SearchParallelPlane4Test extends AbstractSearch3DTest {

	/*
	 * (non-Javadoc)
	 * @see datacube.test.AbstractSearch3DTest#getDefaultConstructor()
	 */
	@Override
	public AbstractSearch3D getDefaultConstructor() throws InvariantBroken {
		
		return new SearchParallelPlane4(threeD, word_ParallelPlane4);
	}

	/*
	 * (non-Javadoc)
	 * @see datacube.test.AbstractSearch3DTest#getContructor_SearchNotFound()
	 */
	@Override
	public AbstractSearch3D getContructor_SearchNotFound()
			throws InvariantBroken {
		return new SearchParallelPlane4(threeD, word_search_NotFound);
	}

	/*
	 * (non-Javadoc)
	 * @see datacube.test.AbstractSearch3DTest#testConstructor_ArrayNULL()
	 */
	@Override
	@Test(expected = InvariantBroken.class)
	public void testConstructor_ArrayNULL() throws InvariantBroken {
		new SearchParallelPlane4(null, word_ParallelPlane4);
	}

	/*
	 * (non-Javadoc)
	 * @see datacube.test.AbstractSearch3DTest#testConstructor_WordNULL()
	 */
	@Override
	@Test(expected = InvariantBroken.class)
	public void testConstructor_WordNULL() throws InvariantBroken {
		new SearchParallelPlane4(threeD, null);
	}

	/*
	 * (non-Javadoc)
	 * @see datacube.test.AbstractSearch3DTest#testConstructor_NOK()
	 */
	@Override
	@Test(expected = InvariantBroken.class)
	public void testConstructor_NOK() throws InvariantBroken {
		new SearchParallelPlane4(null, null);
	}

	/*
	 * (non-Javadoc)
	 * @see datacube.junittest.AbstractSearch3DTest#getContructor_SearchNotOK()
	 */
	@Override
	public AbstractSearch3D getContructor_SearchNotOK() throws InvariantBroken {
		return new SearchParallelPlane4(threeD, word_search_overlen);
	}


}
