package datacube.search.share.impl;

import datacube.search.share.abstracts.AbstractBase;
import datacube.search.share.abstracts.AbstractSearch3D;

/**
 * 
 * This class is an extension of {@link AbstractSearch3D} </br>
 * Invoke all scheduled unit tasks that the given word will be searched 
 * in the planes of x = x0 + 1, y = y0 + 1, z = z0 + 1 </br>
 * 
 * @author btdiem </br>
 *
 */
public class SearchParallelPlane2 extends AbstractSearch3D {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1854649404973415057L;

	public SearchParallelPlane2(byte[][][] threeD, String word)
			throws InvariantBroken {
		super(threeD, word);
	}

	/**
	 * Update the searched result after finishing </br>
	 * @see {@link AbstractBase#updateResult(boolean)} </br>
	 * @see {@link SearchArray#compute3D_ParallelPlane2(byte[][][], String)} </br>
	 */
	@Override
	protected void compute() {

		updateResult(SearchArray.compute3D_ParallelPlane2(threeD, word));
	}

}
