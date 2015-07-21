package datacube.search.share.abstracts;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import datacube.search.share.impl.InvariantBroken;
import datacube.search.share.interfaces.IDictionary;
import datacube.search.share.interfaces.Parameters;

/**
 * 
 * This class is an extension of {@link IDictionary} </br>
 * It implements some common methods can be possibly shared from specific implementation </br>
 * 
 * @author btdiem </br>
 *
 */
public abstract class AbstractDictionary implements IDictionary {

	//the size of dictionary that means the number of words
	protected int size;
	//the length of words in the dictionary
	protected int len;
	protected List<String> wordList = new LinkedList<String>();
	
	
	public AbstractDictionary(int size, int len) throws InvariantBroken{
		this.len = len;
		this.size = size;
		if (!invariant()) throw new InvariantBroken("Input parameters are invalid.");
	}
	
	@Override
	public boolean invariant() throws InvariantBroken {
		
		return (this.size >= Parameters.MIN_DICTIONARY_SIZE && this.size <= Parameters.MAX_DICTIONARY_SIZE)
				&& (this.len >= Parameters.MIN_WORD_LEN && this.len <= Parameters.MAX_WORD_LEN);
	}

	/*
	 * (non-Javadoc)
	 * @see datacube.search.interfaces.IDictionary#getWordList()
	 */
	@Override
	public List<String> getWordList() {
		
		return this.wordList;
	}

	/*
	 * (non-Javadoc)
	 * @see datacube.search.interfaces.IDictionary#getOneWord(int)
	 */
	@Override
	public String getOneWord(int pos) throws IllegalArgumentException {
		if (pos < 0 || pos >= size)
			throw new IllegalArgumentException("The input value is invalid.");
		
		return wordList.get(pos);
	}

	/*
	 * (non-Javadoc)
	 * @see datacube.search.share.interfaces.IDictionary#generateOneWord()
	 */
	@Override
	public String generateOneWord(){
		
		StringBuffer sb = new StringBuffer();
		for(int i=0; i<this.len; i++){

			int index = ThreadLocalRandom.current().nextInt(Parameters.LETTERS.length);
			sb.append((char)Parameters.LETTERS[index]);
		}
		return sb.toString();
		
	}

	/*
	 * (non-Javadoc)
	 * @see datacube.search.interfaces.IDictionary#setOneWord(int, java.lang.String)
	 */
	@Override
	public void setOneWord(int pos, String word)
			throws IllegalArgumentException {
		if (pos < 0 || pos >= size)
			throw new IllegalArgumentException("The input value is invalid.");
		wordList.add(pos, word);
	}

	@Override
	public void print() {
		System.out.print("Dictionary = ");
		for (int i=0; i<this.size; i++){
			System.out.print(getOneWord(i));
			if (i < this.size -1) System.out.print(", ");
		}
		System.out.println();
	}

	/*
	 * (non-Javadoc)
	 * @see datacube.search.interfaces.IDictionary#getSize()
	 */
	@Override
	public int getSize() {
		
		return this.size;
	}

	/*
	 * (non-Javadoc)
	 * @see datacube.search.interfaces.IDictionary#getWordLength()
	 */
	@Override
	public int getWordLength() {
		
		return this.len;
	}
	
	
	
	
	

}
