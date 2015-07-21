package datacube.search.parallel;

import java.util.ArrayList;
import java.util.List;

import datacube.search.share.abstracts.AbstractBase;
import datacube.search.share.abstracts.AbstractSearch3D;
import datacube.search.share.impl.InvariantBroken;
import datacube.search.share.interfaces.IDataCube;
import datacube.search.share.interfaces.IDictionary;

/**
 * 
 * This class is an implementation of {@link AbstractSearch3D} class </br>
 * Executes each search unit task in parallel to find the association between {@link IDictionary} and {@link IDataCube} </br>
 * 
 * @author btdiem </br>
 *
 */
public class Search3DParallel extends AbstractSearch3D{

	public Search3DParallel(byte[][][] threeD, String word)
			throws InvariantBroken {
		
		super(threeD, word);
		
	}

	private static final long serialVersionUID = -5797194514708296619L;
	/**
	 * Invoke all search unit tasks in the parallel </br>
	 * The number of tasks in an execution node is calculated by the total number of tasks 
	 * and the number of available cores </br>
	 */
	@Override
	protected void compute() {

		List<AbstractBase> list = new ArrayList<AbstractBase>();
		list.addAll(searchXY());
		list.addAll(searchXZ());
		list.addAll(searchYZ());
		list.addAll(searchParallelPlane());
		
		int size = list.size();
		int cores = Runtime.getRuntime().availableProcessors();
		int d = size / cores;
		int m = size % cores;
		
		for (int i=1; i <= cores; i++){
			int from = (i-1)*d;
			int to = i*d -1;
			if (i==cores) to += m;
			invokeAll(list.subList(from, to));
		}//for
		
	}
	    	    
}
