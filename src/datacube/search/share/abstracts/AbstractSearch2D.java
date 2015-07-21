package datacube.search.share.abstracts;

import java.util.concurrent.ForkJoinPool;

import datacube.search.share.impl.InvariantBroken;
import datacube.search.share.interfaces.HasInvariant;
/**
 * 
 * This class is an extension of {@link AbstractBase} class </br>
 * @author btdiem </br>
 *
 */
public abstract class AbstractSearch2D extends AbstractBase implements HasInvariant{

	protected byte[][] twoD;
	protected String word;
	
	public AbstractSearch2D(byte [][] twoD, String word) throws InvariantBroken{

		this.twoD = twoD;
		this.word = word;

		if (!invariant()) throw new InvariantBroken("Input parameters are invalid");
	}
	
	/**
	 * This method is called when this class is executed by {@link ForkJoinPool#execute} </br>
	 */
	@Override
	protected void compute() {
		updateResult(search2DArray());
		
	}

	@Override
	public boolean invariant() throws InvariantBroken {
		
		return (twoD != null) 
				&& (twoD.length == twoD[0].length) 
				&& (word != null);
	}
	
	/**
	 * This method will be implemented particularly depends on requirement</br>
	 * Some cases will search the given string with 3 direction : horizontal, vertical and diagonal </br>
	 * Otherwise, some cases only search the given string in diagonal dimension </br>
	 * Returns true if searched word is found the the 2D-array </br>
	 * @return Boolean </br>
	 */
	public abstract boolean search2DArray();

	/**
	 * 
	 */
	private static final long serialVersionUID = -8273809497423779762L;

}
