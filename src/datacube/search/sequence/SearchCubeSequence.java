package datacube.search.sequence;

import datacube.search.share.abstracts.AbstractSearchCube;
import datacube.search.share.abstracts.AbstractBase;
import datacube.search.share.impl.InvariantBroken;
import datacube.search.share.interfaces.IDataCube;
import datacube.search.share.interfaces.IDictionary;

/**
 * 
 * This class is a implementation of {@link AbstractSearchCube} class  </br>
 * This class will create a sequence search process </br>
 *  
 * @author btdiem </br>
 *
 */
public class SearchCubeSequence extends AbstractSearchCube{

	public SearchCubeSequence(){};
	
	public SearchCubeSequence(IDataCube cube, IDictionary dictionary)
			throws InvariantBroken {
		super(cube, dictionary);
		
	}
	
	/*
	 * @see {@link Search3DSequence} </br>
	 * (non-Javadoc)
	 * @see datacube.search.share.abstracts.AbstractSearchTask#getTask(byte[][][], java.lang.String)
	 */
	@Override
	public AbstractBase getExecutionTask(byte[][][] threeD, String word) throws InvariantBroken {
		return new Search3DSequence(threeD, word);
	}


	
}
