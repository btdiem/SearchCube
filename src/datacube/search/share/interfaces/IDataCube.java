package datacube.search.share.interfaces;

import datacube.search.parallel.DataCubeParallel;
import datacube.search.sequence.DataCubeSequence;

/**
 * This is an interface of {@link DataCubeSequence} and {@link DataCubeParallel} </br>
 * 
 * @author btdiem </br>
 *
 */
public interface IDataCube extends HasInvariant{

	/**
	 * Fill 3D array of {@link IDataCube} by getting randomly letters from {@link Parameters#LETTERS} </br>
	 * @see {@link Parameters#LETTERS} </br>
	 */
	public void generateData();
	/**
	 * 
	 * @return value of {@link IDataCube} is a 3D array </br>
	 */
	public byte[][][] getValue();
	/**
	 * 
	 * @param x X coordinator </br>
	 * @param y Y coordinator </br>
	 * @param z Z coordinator </br>
	 * @return a value of a letter at the position (x,y,z) </br>
	 * @throws IllegalArgumentException if x,y,z are invalid (less than 0 or greater than {@link IDataCube#getSize()} </br>
	 * @throws IllegalArgumentException </br>
	 */
	public byte getValue(int x, int y, int z) throws IllegalArgumentException;
	/**
	 * Sets for {@link IDataCube} value of  a letter </br>  
	 * @param x X coordinator </br>
	 * @param y Y coordinator </br>
	 * @param z Z coordinator </br>
	 * @param value a letter </br>
	 * @throws IllegalArgumentException if x,y,z are invalid (less than 0 or greater than {@link IDataCube#getSize()} </br>
	 * @throws IllegalArgumentException </br>
	 */
	public void setValue (int x, int y, int z, byte value) throws IllegalArgumentException;
	/**
	 * 
	 * @return the size of {@link IDataCube}. In other words, it returns the value of dimension of 3D array </br>
	 */
	public int getSize();
	

}
