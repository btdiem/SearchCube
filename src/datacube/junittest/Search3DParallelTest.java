package datacube.junittest;

import org.junit.Test;
import org.junit.runners.JUnit4;

import datacube.search.parallel.Search3DParallel;
import datacube.search.share.abstracts.AbstractSearch3D;
import datacube.search.share.impl.InvariantBroken;

/**
 * 
 * This class is an extension of {@link AbstractSearch3DTest} </br>
 * Create {@link JUnit4} test cases for {@link Search3DParallel} </br>
 * 
 * @author btdiem </br>
 *
 */
public class Search3DParallelTest extends AbstractSearch3DTest {


	/*
	 * (non-Javadoc)
	 * @see datacube.test.AbstractSearch3DTest#getDefaultConstructor()
	 */
	@Override
	public AbstractSearch3D getDefaultConstructor() throws InvariantBroken {
		return new Search3DParallel(threeD, word_XYDimension);
	}

	/*
	 * (non-Javadoc)
	 * @see datacube.test.AbstractSearch3DTest#getContructor_SearchNotFound()
	 */
	@Override
	public AbstractSearch3D getContructor_SearchNotFound()
			throws InvariantBroken {
		return new Search3DParallel(threeD, word_search_NotFound);
	}

	/*
	 * (non-Javadoc)
	 * @see datacube.test.AbstractSearch3DTest#testConstructor_ArrayNULL()
	 */
	@Override
	@Test(expected = InvariantBroken.class)
	public void testConstructor_ArrayNULL() throws InvariantBroken {
		new Search3DParallel(null, word_XYDimension);
		
	}

	/*
	 * (non-Javadoc)
	 * @see datacube.test.AbstractSearch3DTest#testConstructor_WordNULL()
	 */
	@Override
	@Test(expected = InvariantBroken.class)
	public void testConstructor_WordNULL() throws InvariantBroken {
		new Search3DParallel(threeD, null);
		
	}

	/*
	 * (non-Javadoc)
	 * @see datacube.test.AbstractSearch3DTest#testConstructor_NOK()
	 */
	@Override
	@Test(expected = InvariantBroken.class)
	public void testConstructor_NOK() throws InvariantBroken {
		new Search3DParallel(null, null);
		
	}

	/*
	 * (non-Javadoc)
	 * @see datacube.junittest.AbstractSearch3DTest#getContructor_SearchNotOK()
	 */
	@Override
	public AbstractSearch3D getContructor_SearchNotOK() throws InvariantBroken {
		
		return new Search3DParallel(threeD, word_search_overlen);
	}
}
