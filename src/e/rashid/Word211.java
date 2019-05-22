package e.rashid;

import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.Collections;

public class Word211 {

	//words for the game are saved into this arrayList
	public static ArrayList<String> Words = new ArrayList<String>();
	
	//This method reads the txt file and adds the words into an array list
	public void readFile(String fileName) throws FileNotFoundException{
		
		Scanner inputFile = new Scanner(new File(fileName));
		
		while (inputFile.hasNextLine()){
			String n = inputFile.next();
			Words.add(n);
		}
	}
	
	// this method selects a word randomly from the array list
	// and temporarily adds them to a temp array that is then
	// shuffled and saved as a question variable.
	// a hash map is creating using the question variable as the keyset
	// and answer variable as the object its getting.
	public static HashMap<String, String> getNextWord(){
		Random rnd = new Random();
		int index = rnd.nextInt(Words.size());
		String answer = Words.get(index);
	
	
	List<String> qTemp = Arrays.asList(answer.split(""));
	Collections.shuffle(qTemp);
	String question = "";
	
	for (int i = 0 ; i < qTemp.size(); i++) {
		question += qTemp.get(i);
	}
	
	HashMap<String, String> hm = new HashMap<>();
	hm.put(question, answer);
	return hm;
  }
}
