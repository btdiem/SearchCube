package datacube.search.share.abstracts;

import java.util.LinkedList;
import java.util.List;

import datacube.search.share.impl.InvariantBroken;
import datacube.search.share.impl.Search2DAllDimension;
import datacube.search.share.impl.Search2DDiagonal;
import datacube.search.share.impl.SearchArray;
import datacube.search.share.impl.SearchParallelPlane1;
import datacube.search.share.impl.SearchParallelPlane2;
import datacube.search.share.impl.SearchParallelPlane3;
import datacube.search.share.impl.SearchParallelPlane4;
import datacube.search.share.interfaces.HasInvariant;
import datacube.search.share.interfaces.IDataCube;

/**
 * 
 * This is an extension of abstract {@link AbstractBase} class </br>
 * It divides 3D arrays of {@link IDataCube} to small 2D units and 
 * schedule search task for each 2D-array unit to prepare for an execution </br>
 * 
 * @author btdiem </br>
 *
 */
public abstract class AbstractSearch3D extends AbstractBase implements HasInvariant {

	private static final long serialVersionUID = 1115960101567369798L;
	protected byte[][][] threeD;
	protected String word;

	public AbstractSearch3D(byte[][][] threeD, String word) throws InvariantBroken{
		
		this.threeD = threeD;
		this.word = word;
		if (!invariant()) throw new InvariantBroken("Input parameters are invalid");

	}
	
	
	/*
	 * To return true, 3D-array and search word should be not NULL </br>
	 * 3D array should the same size value  for all 3 dimensions </br>
	 * And the size of word should not greater than the dimension array </br>
	 * (non-Javadoc)
	 * @see datacube.search.share.interfaces.HasInvariant#invariant()
	 */
	@Override
	public boolean invariant() throws InvariantBroken {
		
		return (threeD != null) && (word != null) && (threeD.length >= word.length()) ;
		
	}
	
	/**
	 * Selects all planes that are perpendicular to Z dimensions and 
	 * and starts scheduling task search units for these 2D planes </br>
	 * For these planes, search task units will search the given word through 3 dimensions:
	 * horizontal, vertical and diagonal </br>
	 * 
	 * @see {@link SearchArray#compute3D_DimensionXY(byte[][][])} </br>
	 * @see {@link Search2DAllDimension} </br>
	 * 
	 * @param threeD 3D array of letters. This is value of {@link IDataCube} </br>
	 * @param word A given string contains an array of letters </br>
	 * @return List<{@link AbstractBase}> will be executed when search process is started </br>
	 */
	public List<AbstractBase> searchXY(){
		
		List<byte[][]> twoDList = SearchArray.compute3D_DimensionXY(threeD);
		List<AbstractBase> taskList = new LinkedList<AbstractBase>();
		
		if (twoDList != null && !twoDList.isEmpty()){
			for (byte[][] twoD : twoDList){
				
				try {
					taskList.add(new Search2DAllDimension(twoD, word));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		}
		return taskList;
	}

	/**
	 * Selects all planes that are perpendicular to Y dimensions and 
	 * and starts scheduling task search units for these 2D planes </br>
	 * For these planes, search task units will search the given word only diagonal dimensions
	 * to avoid a duplicated search with {@link AbstractSearch3D#searchXY()} </br>
	 * 
	 * @see {@link SearchArray#compute3D_DimensionXZ(byte[][][])} </br>
	 * @see {@link Search2DDiagonal} </br>
	 * 
	 * @param threeD 3D array of letters. This is value of {@link IDataCube} </br>
	 * @param word A given string contains an array of letters </br>
	 * @return List<{@link AbstractBase}> will be executed when search process is started </br>
	 */
	public List<AbstractBase> searchXZ()  {

		List<byte[][]> twoDList = SearchArray.compute3D_DimensionXZ(threeD);
		List<AbstractBase> taskList = new LinkedList<AbstractBase>();
		
		if (twoDList != null && !twoDList.isEmpty()){
			for (byte[][] twoD : twoDList){
				
				try {
					taskList.add(new Search2DDiagonal(twoD, word));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		}
		return taskList;
				
	}

	/**
	 * Selects all planes that are perpendicular to X dimensions and 
	 * and starts scheduling task search units for these 2D planes </br>
	 * For these planes, search task units will search the given word only diagonal dimensions
	 * to avoid a duplicated search with {@link AbstractSearch3D#searchXY()} </br>
	 * 
	 * @see {@link SearchArray#compute3D_DimensionYZ(byte[][][])} </br>
	 * @see {@link Search2DDiagonal} </br>
	 * 
	 * @param threeD 3D array of letters. This is value of {@link IDataCube} </br>
	 * @param word A given string contains an array of letters </br>
	 * @return List<{@link AbstractBase}> will be executed when search process is started </br>
	 */
	
	public List<AbstractBase> searchYZ() {

		List<byte[][]> twoDList = SearchArray.compute3D_DimensionYZ(threeD);
		List<AbstractBase> taskList = new LinkedList<AbstractBase>();
		
		if (twoDList != null && !twoDList.isEmpty()){
			for (byte[][] twoD : twoDList){
				
				try {
					taskList.add(new Search2DDiagonal(twoD, word));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		}
		return taskList;

	}

	/**
	 * Selects all planes that have points:  
	 * x = x0 + 1, y = y0 - 1, z = z0 + 1 </br>
	 * x = x0 + 1, y = y0 + 1, z = z0 + 1 </br>
	 * x = x0 + 1, y = y0 - 1, z = z0 - 1 </br>
	 * x = x0 + 1, y = y0 + 1, z = z0 - 1 </br>
	 *  and starts scheduling task search units for these 2D planes </br>
	 * For these planes, search task units will search the given word only diagonal dimensions
	 * to avoid a duplicated search with {@link AbstractSearch3D#searchXY()}, {@link AbstractSearch3D#searchXZ()} and {@link AbstractSearch3D#searchYZ()} </br>
	 * 
	 * @see {@link SearchParallelPlane1} </br>
	 * @see {@link SearchParallelPlane2} </br>
	 * @see {@link SearchParallelPlane3} </br>
	 * @see {@link SearchParallelPlane4} </br>
	 * 
	 * @param threeD 3D array of letters. This is value of {@link IDataCube} </br>
	 * @param word A given string contains an array of letters </br>
	 * @return List<{@link AbstractBase}> will be executed when search process is started </br>
	 */	
	public List<AbstractBase> searchParallelPlane(){
		
		List<AbstractBase> taskList = new LinkedList<AbstractBase>();
		try {
			
			taskList.add(new SearchParallelPlane1(threeD, word));
			taskList.add(new SearchParallelPlane2(threeD, word));
			taskList.add(new SearchParallelPlane3(threeD, word));
			taskList.add(new SearchParallelPlane4(threeD, word));
			
		} catch (Exception e) {
			//e.printStackTrace();
		}
		return taskList;
		
	}

}
