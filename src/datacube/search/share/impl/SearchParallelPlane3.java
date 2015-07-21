package datacube.search.share.impl;

import datacube.search.share.abstracts.AbstractBase;
import datacube.search.share.abstracts.AbstractSearch3D;

/**
 * 
 * This class is an extension of {@link AbstractSearch3D} </br>
 * Invoke all scheduled unit tasks that the given word will be searched 
 * in the planes of x = x0 + 1, y = y0 - 1, z = z0 - 1 in execution process </br>
 * 
 * @author btdiem </br>
 *
 */
public class SearchParallelPlane3 extends AbstractSearch3D {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5029135943044908428L;

	public SearchParallelPlane3(byte[][][] threeD, String word)
			throws InvariantBroken {
		super(threeD, word);
	}

	/**
	 * Update the searched result after finishing </br>
	 * @see {@link AbstractBase#updateResult(boolean)} </br>
	 * @see {@link SearchArray#compute3D_ParallelPlane3(byte[][][], String)} </br>
	 */
	@Override
	protected void compute() {
		updateResult(SearchArray.compute3D_ParallelPlane3(threeD, word));
	}

}
