import java.util.ArrayList;

public class Dictionary {
	ArrayList<String> dic = new ArrayList<String>();
	
	int inDic(String value, ArrayList<String> dic)
	{	
		if(dic.contains(value)){
			System.out.println("found at :" +dic.indexOf(value));
			return dic.indexOf(value);
		}
		else
			return -1;	//not found
	}
}
