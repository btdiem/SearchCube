package datacube.junittest;


import org.junit.runners.JUnit4;

import datacube.search.sequence.SearchCubeSequence;
import datacube.search.share.abstracts.AbstractSearchCube;
import datacube.search.share.impl.InvariantBroken;

/**
 * 
 * This class is an implementation of {@link AbstractSearchCubeTest} class </br>
 * Creates {@link JUnit4} test cases for {@link SearchCubeSequence} class </br>
 * 
 * @author btdiem </br>
 *
 */
public class SearchCubeSequenceTest extends AbstractSearchCubeTest{
	/*
	 * (non-Javadoc)
	 * @see datacube.junittest.AbstractSearchCubeTest#getDefaultConstructor()
	 */
	@Override
	public AbstractSearchCube getDefaultConstructor() throws InvariantBroken {
		return new SearchCubeSequence(cube, dictionary);
	}

	/*
	 * (non-Javadoc)
	 * @see datacube.junittest.AbstractSearchCubeTest#getDefaultConstructor_DictionaryNull()
	 */
	@Override
	public AbstractSearchCube getDefaultConstructor_DictionaryNull() throws InvariantBroken {
		return new SearchCubeSequence(cube, null);
	}

	/*
	 * (non-Javadoc)
	 * @see datacube.junittest.AbstractSearchCubeTest#getDefaultConstructor_CubeNull()
	 */
	@Override
	public AbstractSearchCube getDefaultConstructor_CubeNull() throws InvariantBroken {
		return new SearchCubeSequence(null, dictionary);
	}

	/*
	 * (non-Javadoc)
	 * @see datacube.junittest.AbstractSearchCubeTest#getDefaultConstructor_NOK()
	 */
	@Override
	public AbstractSearchCube getDefaultConstructor_NOK()
			throws InvariantBroken {
		return new SearchCubeSequence(null, null);
	}

}
