package datacube.junittest;

import org.junit.Test;
import org.junit.runners.JUnit4;

import datacube.search.parallel.DataCubeParallel;
import datacube.search.share.impl.InvariantBroken;
import datacube.search.share.interfaces.IDataCube;

/**
 * This class is an implementation of {@link AbstractCubeTest} </br>
 * Create {@link JUnit4} test cases for {@link DataCubeParallel} </br>
 * 
 * @author btdiem </br>
 *
 */
public class DataCubeParallelTest extends AbstractCubeTest {

	/*
	 * (non-Javadoc)
	 * @see datacube.test.AbstractCubeTest#getDefaultConstructor()
	 */
	@Override
	public IDataCube getDefaultConstructor() throws InvariantBroken {
		
		return new DataCubeParallel(default_cube_size);
	}

	/*
	 * (non-Javadoc)
	 * @see datacube.test.AbstractCubeTest#testConstructor_NOK1()
	 */
	@Override
	@Test(expected = InvariantBroken.class)
	public void testConstructor_NOK1() throws InvariantBroken {
		new DataCubeParallel(2);
		
	}

	/*
	 * (non-Javadoc)
	 * @see datacube.test.AbstractCubeTest#testConstructor_NOK2()
	 */
	@Override
	@Test(expected = InvariantBroken.class)
	public void testConstructor_NOK2() throws InvariantBroken {
		new DataCubeParallel(1001);
		
	}


}
