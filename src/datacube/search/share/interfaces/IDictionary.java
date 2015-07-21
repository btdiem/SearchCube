package datacube.search.share.interfaces;

import java.util.List;

public interface IDictionary extends HasInvariant{

	/**
	 * Get randomly letters from {@link Parameters#LETTERS} to fill for {@link IDictionary} </br>
	 */
	public void generateData();
	/**
	 * Returns a list of word in the dictionary </br>
	 * @return {@link List}
	 */
	public List<String> getWordList();
	/**
	 * 
	 * @param pos The position of word in dictionary </br>
	 * @return String </br>
	 * Throws an exception if the position value is invalid (negative or out of range of dictionary size) </br>
	 * @throws IllegalArgumentException </br>
	 */
	public String getOneWord(int pos) throws IllegalArgumentException;
	/**
	 * 
	 * @param pos The position of word in dictionary </br>
	 * @param word Value of word </br>
	 * Throws an exception if the position value is invalid (negative or out of range of dictionary size) </br>
	 * @throws IllegalArgumentException </br>
	 */
	public void setOneWord(int pos, String word) throws IllegalArgumentException;
	/**
	 * 
	 * @return the size of dictionary </br>
	 */
	public int getSize();
	/**
	 * 
	 * @return the length of word in the dictionary </br>
	 */
	public int getWordLength();
	
	
	public void print();
	
	/**
	 * Get randomly some letters of {@link Parameters#LETTERS} to fill {@link IDictionary} </br>
	 * @return {@link String} </br>
	 */
	public String generateOneWord();
	
	
}
