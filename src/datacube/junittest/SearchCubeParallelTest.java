package datacube.junittest;


import org.junit.runners.JUnit4;

import datacube.search.parallel.SearchCubeParallel;
import datacube.search.share.abstracts.AbstractSearchCube;
import datacube.search.share.impl.InvariantBroken;

/**
 * 
 * This class is an implementation of {@link AbstractSearchCube} class </br>
 * Create {@link JUnit4} test cases for {@link SearchCubeParallel} class </br>
 * 
 * @author btdiem </br>
 *
 */
public class SearchCubeParallelTest extends AbstractSearchCubeTest{

	/*
	 * (non-Javadoc)
	 * @see datacube.junittest.AbstractSearchTaskTest#getDefaultConstructor()
	 */
	@Override
	public AbstractSearchCube getDefaultConstructor() throws InvariantBroken {
		return new SearchCubeParallel(cube, dictionary);
	}

	/*
	 * (non-Javadoc)
	 * @see datacube.junittest.AbstractSearchTaskTest#getDefaultConstructor_DictionaryNull()
	 */
	@Override
	public AbstractSearchCube getDefaultConstructor_DictionaryNull() throws InvariantBroken {
		return new SearchCubeParallel(cube, null);
	}

	/*
	 * (non-Javadoc)
	 * @see datacube.junittest.AbstractSearchTaskTest#getDefaultConstructor_CubeNull()
	 */
	@Override
	public AbstractSearchCube getDefaultConstructor_CubeNull() throws InvariantBroken {
		return new SearchCubeParallel(null, dictionary);
	}

	/*
	 * (non-Javadoc)
	 * @see datacube.junittest.AbstractSearchTaskTest#getDefaultConstructor_NOK()
	 */
	@Override
	public AbstractSearchCube getDefaultConstructor_NOK()
			throws InvariantBroken {
		return new SearchCubeParallel(null, null);
	}

}
