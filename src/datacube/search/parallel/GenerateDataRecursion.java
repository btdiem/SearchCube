package datacube.search.parallel;

import java.util.concurrent.RecursiveAction;
import java.util.concurrent.ThreadLocalRandom;

import datacube.search.sequence.DataCubeSequence;
import datacube.search.share.interfaces.IDataCube;
import datacube.search.share.interfaces.Parameters;
/**
 * 
 * This class is used to generate data for {@link IDataCube} in parallel way </br>
 * Parallel mechanism is activated depending on the input size parameter  </br>
 * If the input size parameter is greater than {@link Parameters#THRESHOLD_CUBE}, parallel is activated </br>
 * Otherwise, the same way as {@link DataCubeSequence} </br>
 * 
 * @author btdiem </br>
 *
 */
class GenerateDataRecursion extends RecursiveAction{

	private int start;//the start point of 3D array
	private int len;// the size of 3D array
	private int size;//the size of 2D array
	private byte[][][] dest;//the 3D array output
	
	public GenerateDataRecursion(int start, int len, int size, byte[][][] dest){
		this.start = start;
		this.len = len;
		this.dest = dest;
		this.size = size;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 6756007018592180057L;

	private void computeDirectly(){
		
		for (int i=0; i<size; i++){
			//char[][] a = new char[len][len];
			for (int j=0; j<len; j++){
				for(int k=0; k<len; k++){
					int index = ThreadLocalRandom.current().nextInt(Parameters.LETTERS.length);
					dest[start+i][j][k] = Parameters.LETTERS[index];
				}//for k
			}//for j
		}//for i
		
	}
	
	@Override
	protected void compute() {
		
		int threshold = Parameters.THRESHOLD_CUBE;
		if (size <= threshold){
			computeDirectly();
			
		}else{

			int divide = size - threshold;
			invokeAll(new GenerateDataRecursion(start, len, threshold, dest),
					  new GenerateDataRecursion(start + threshold, len, divide, dest ));
		
		}
		
	}
	
}