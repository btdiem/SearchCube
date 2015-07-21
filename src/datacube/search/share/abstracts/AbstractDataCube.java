package datacube.search.share.abstracts;

import datacube.search.parallel.DataCubeParallel;
import datacube.search.sequence.DataCubeSequence;
import datacube.search.share.impl.InvariantBroken;
import datacube.search.share.interfaces.IDataCube;
import datacube.search.share.interfaces.Parameters;

/**
 * This class is an extension of {@link IDataCube} interface </br>
 * It implements the shared methods between  {@link DataCubeParallel} and {@link DataCubeSequence} </>
 * 
 * @author btdiem </br>
 *
 */
public abstract class AbstractDataCube implements IDataCube  {

	protected int size = 0;
	protected byte [][][] threeD = null;
	
	public AbstractDataCube(int n) throws InvariantBroken{
		this.size = n;
		if (!invariant()){
			throw new InvariantBroken("Input parameter is invalid.");
		}
		this.threeD = new byte[size][size][size];
		
	}
	
	/**
	 * This method returns true if size property has value between {@link Parameters#MIN_CUBE_SIZE} and {@link Parameters#MAX_CUBE_SIZE} </br>
	 * @return {@link Boolean} </br>
	 */
	@Override
	public boolean invariant() throws InvariantBroken {
		return (size >= Parameters.MIN_CUBE_SIZE && size <= Parameters.MAX_CUBE_SIZE);
	}

	/*
	 * (non-Javadoc)
	 * @see datacube.search.share.interfaces.IDataCube#getValue()
	 */
	@Override
	public byte[][][] getValue() {
		return this.threeD;
	}

	/*
	 * (non-Javadoc)
	 * @see datacube.search.share.interfaces.IDataCube#getSize()
	 */
	@Override
	public int getSize(){
		return this.size;
	}
	
	/*
	 * (non-Javadoc)
	 * @see datacube.search.share.interfaces.IDataCube#getValue(int, int, int)
	 */
	@Override
	public byte getValue(int x, int y, int z) throws IllegalArgumentException{
		
		if ( (x<0) || (x>size) || (y<0) || (y>size) || (z<0) || (z>size) ) 
			throw new IllegalArgumentException("Input parameters are invalid");
		
		return threeD[x][y][z];
		
	}
	/*
	 * (non-Javadoc)
	 * @see datacube.search.share.interfaces.IDataCube#setValue(int, int, int, byte)
	 */
	@Override
	public void setValue(int x, int y, int z, byte value) throws IllegalArgumentException{
		
		if ( (x<0) || (x>size) || (y<0) || (y>size) || (z<0) || (z>size) ) 
			throw new IllegalArgumentException("Input parameters are invalid");
		
		 threeD[x][y][z] =  value;
		
	}

}
