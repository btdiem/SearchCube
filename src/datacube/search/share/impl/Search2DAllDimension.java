package datacube.search.share.impl;

import datacube.search.share.abstracts.AbstractSearch2D;

/**
 * This is an implementation of {@link AbstractSearch2D} class </br>
 * This class will search the given 2D array and the giving string through 3 dimensions from any directions </br>
 * 
 * @author btdiem </br>
 *
 */
public class Search2DAllDimension extends AbstractSearch2D {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8307013353597907585L;

	public Search2DAllDimension(byte[][] twoD, String word)
			throws InvariantBroken {
		super(twoD, word);
	}

	/*
	 * @see {@link SearchArray#contains(byte[][], String)} </br>
	 * (non-Javadoc)
	 * @see datacube.search.share.abstracts.AbstractSearch2D#search2DArray()
	 */
	@Override
	public boolean search2DArray() {
		return SearchArray.contains(twoD, word);
	}

}
