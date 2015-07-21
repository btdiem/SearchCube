package datacube.junittest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({DataCubeParallelTest.class, 
				DataCubeSequenceTest.class,
				DictionaryTest.class,
				Search2DAllDimensionTest.class,
				Search2DDiagonalTest.class,
				Search3DSequenceTest.class,
				SearchArrayTest.class,
				SearchCubeParallelTest.class,
				SearchParallelPlane1Test.class,
				SearchParallelPlane2Test.class,
				SearchParallelPlane3Test.class,
				SearchParallelPlane4Test.class,
				SearchCubeSequenceTest.class,
				Search3DParallelTest.class,
				DataFactoryTest.class})

public class TestAll {

}
