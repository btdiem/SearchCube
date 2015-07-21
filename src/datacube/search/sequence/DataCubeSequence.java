package datacube.search.sequence;

import java.util.concurrent.ThreadLocalRandom;

import datacube.search.share.abstracts.AbstractDataCube;
import datacube.search.share.impl.InvariantBroken;
import datacube.search.share.interfaces.IDataCube;
import datacube.search.share.interfaces.Parameters;

/**
 * This class is an implementation of {@link IDataCube} and is an extension of {@link AbstractDataCube} </br>
 * Implement {@link IDataCube#generateData()} to generate data for {@link IDataCube} in sequence </br>
 * 
 * @author btdiem </br>
 *
 */
public class DataCubeSequence extends AbstractDataCube implements IDataCube {

	public DataCubeSequence(int n) throws InvariantBroken {
		super(n);
	}

	/*
	 * (non-Javadoc)
	 * @see datacube.search.share.interfaces.IDataCube#generateData()
	 */
	@Override
	public void generateData() {

		for (int i=0; i<size; i++){
			//char[][] a = new char[len][len];
			for (int j=0; j<size; j++){
				for(int k=0; k<size; k++){
					int index = ThreadLocalRandom.current().nextInt(Parameters.LETTERS.length);
					threeD[i][j][k] = Parameters.LETTERS[index];
					//a[j][k] = letters[index];
				}//for k
			}//for j
		}//for i
	}
	
}
