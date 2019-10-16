import java.util.HashMap; 
import java.util.Map;

public class Compression {
	HashMap	<Integer, Character> encryption = new HashMap<Integer, Character>();
	
	void compress(String input, String reading, Dictionary dicClass, int index)
	{
		for(int i = index; i < input.length()-1; i++)
		{
			reading = Character.toString(input.charAt(i));

			if(dicClass.inDic(reading, dicClass.dic) == 0)		//if not found
			{
				dicClass.dic.add(reading);	//add in dictionary
				//System.out.println(dicClass.dic.get(i));
				System.out.println("the dictionary contains: " + dicClass.dic);
				encryption.put(index, input.charAt(i));    //add in final compressed result
				index = i;
			}
			
			else
			{
				String theTemp = formulate(input, reading, i, dicClass);
				
				dicClass.dic.add(theTemp);
				encryption.put(index, input.charAt(i));
			}
			//i = index;
		}
		
		
	}
	
	String formulate(String input, String reading, int index, Dictionary dictionary)	              
	{
		String[] temp;		//to save the updated value of temp to use out side the loop
		temp = new String[1];
		
		int j = index;
		while(j < input.length() - 1)
		{
			temp[0] =  merge(reading, Character.toString(input.charAt(index + j)));
			System.out.println("STUCK IN WHILE LOOP NOT RECURSION");
			if(dictionary.inDic( temp[0], dictionary.dic) == 0){	//found
				formulate(input, temp[0], index, dictionary);
			}
			else
				break;
		}
		return temp[0];
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
