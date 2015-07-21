package datacube.search.parallel;

import java.util.concurrent.ForkJoinPool;

import datacube.search.share.abstracts.AbstractDataCube;
import datacube.search.share.impl.InvariantBroken;
import datacube.search.share.interfaces.IDataCube;

/**
 * This class is an implementation of {@link IDataCube} and is an extension of {@link AbstractDataCube} </br>
 * Implement {@link IDataCube#generateData()} method to generate data for {@link IDataCube} in parallel </br>
 * 
 * @author btdiem </br>
 *
 */
public class DataCubeParallel extends AbstractDataCube implements IDataCube{

	ForkJoinPool pool = null;
	
	public DataCubeParallel(int n) throws InvariantBroken {
		super(n);
	}

	/*
	 * (non-Javadoc)
	 * @see datacube.search.share.interfaces.IDataCube#generateData()
	 */
	@Override
	public void generateData(){

		pool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
		pool.invoke(new GenerateDataRecursion(0, size, size, threeD));
		
	}
	
	
}
