package datacube.search.share.impl;

import datacube.search.share.abstracts.AbstractSearch2D;

/**
* 
* This is an implementation of {@link AbstractSearch2D} class </br>
* This class will search the given 2D array and the given string in diagonal dimension from any directions </br>
* 
* @author btdiem </br> 
*/

public class Search2DDiagonal extends AbstractSearch2D {

	private static final long serialVersionUID = 8160343786484116211L;

	public Search2DDiagonal(byte[][] twoD, String word) throws InvariantBroken {
		super(twoD, word);
	}

	/*
	 * @see SearchArray#contains(byte[][], String, byte[], byte[]) </br>
	 * (non-Javadoc)
	 * @see datacube.search.share.abstracts.AbstractSearch2D#search2DArray()
	 */
	@Override
	public boolean search2DArray() {
		return SearchArray.contains(twoD, word, new byte[]{-1, 1}, new byte[]{-1, 1});
	}

}
