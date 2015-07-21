package datacube.search.parallel;

import datacube.search.share.abstracts.AbstractSearchCube;
import datacube.search.share.abstracts.AbstractBase;
import datacube.search.share.impl.InvariantBroken;
import datacube.search.share.interfaces.IDataCube;
import datacube.search.share.interfaces.IDictionary;

/**
 * 
 * This class is a implementation of {@link AbstractSearchCube} </br>
 * This class will create a parallel search process </br>
 * 
 * @author btdiem </br>
 *
 */
public class SearchCubeParallel extends AbstractSearchCube  {

	public SearchCubeParallel(){};
	
	public SearchCubeParallel(IDataCube cube, IDictionary dictionary)
			throws InvariantBroken {
		super(cube, dictionary);
	}

	/*
	 * @see {@link SearchThreeDTask} </br>
	 * (non-Javadoc)
	 * @see datacube.search.share.abstracts.AbstractSearchTask#getTask(byte[][][], java.lang.String)
	 */
	@Override
	public AbstractBase getExecutionTask(byte[][][] threeD, String word)
			throws InvariantBroken {
		return new Search3DParallel(threeD, word);
	}



	

	
	
}
