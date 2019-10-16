import java.util.HashMap; 
import java.util.Map;

public class Compression {
	HashMap	<Integer, Character> encryption = new HashMap<Integer, Character>();
	
	void compress(String input, String reading, Dictionary dicClass, int index)
	{
		for(int i = index; i < input.length()-1; i++)
		{
			reading = Character.toString(input.charAt(i));

			if(dicClass.inDic(reading, dicClass.dic) == -1)		//if not found
			{
				dicClass.dic.add(reading);	//add in dictionary
				System.out.println("the dictionary contains: " + dicClass.dic);
				encryption.put(i, input.charAt(i));    //add in final compressed result
				System.out.println("the encryption contains: " + encryption);
				System.out.println();
			}
			
			else		//found already
			{
				//System.out.println("i in compress is: " + i);
				String theTemp_value = formulate(input, reading, i, dicClass).get(i);
				//System.out.println("the temp value is " + theTemp_value);
				// i is the index where the first element isn't found in dictionary
				dicClass.dic.add(theTemp_value);
				encryption.put(index, input.charAt(i));
			}
			//i = index;
		}
		
		
	}
	
	String[] temp = new String [1];		//to save the updated value of temp to use out side the loop
					//INDEX: we need to know the index to add it to the compression
	Map<Integer, String> formulated = new HashMap<>(1);
	int counter = 0;
	Map<Integer, String> formulate(String input, String reading, int index, Dictionary dictionary)	              
	{
		//temp[0] = reading;
		if(dictionary.inDic( reading, dictionary.dic) != -1 && index < input.length() - 1){//found
			reading = merge(reading, Character.toString(input.charAt(index + 1)));
			//System.out.println("the current reading: " + reading);
			formulated.put(index + 1, reading);	// 3=bc
			//System.out.println("index is : " + index);
			index ++;
			//System.out.println("Print is -> " + reading);
			//System.out.println("modified -> " + reading);
			formulate(input, reading, index, dictionary);
		}
		
		return formulated;
	}
	
	
	
	String merge(String first, String second)
	{
		
		 String reading = first + second;
		 
		return reading;
	}
	
	
	
	/*String formatEntry(String fullInput, Dictionary dicClass){
	for(int i = 0; i < fullInput.length() - 1; i++)
	{
		temp = Character.toString(fullInput.charAt(i));
		if( dicClass.inDic(Character.toString(fullInput.charAt(i))) == 0 )	//not in the dictionary
		{
			compress(temp, dicClass, i);
		}
		
		else
		{
			
			//temp = Character.toString(input.charAt(i)) + Character.toString(input.charAt(i + 1));
			//if(dicClass.inDic(temp))
		}
		
	}
	return fullInput;
	}*/	
}
