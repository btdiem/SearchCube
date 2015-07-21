package datacube.search.share.impl;

import datacube.search.share.abstracts.AbstractDictionary;
import datacube.search.share.interfaces.IDictionary;

/**
 * 
 * This class is an extension of {@link AbstractDictionary} and is an implementation of {@link IDictionary} </br>
 * 
 * @author btdiem </br>
 *
 */
public class Dictionary extends AbstractDictionary 
								  implements IDictionary {

	public Dictionary(int size, int len) throws InvariantBroken {
		super(size, len);
	}

	@Override
	public void generateData() {
		
		for(int i=0; i<this.size; i++){
			String word = generateOneWord();
			wordList.add(word);
			
		}
	}
	

}
