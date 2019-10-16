import java.util.ArrayList;

public class Dictionary {
	ArrayList<String> dic = new ArrayList<String>();
	
	int inDic(String value, ArrayList<String> dic)
	{	
		if(dic.contains(value))
			return dic.indexOf(value);
		else
			return 0;	//not found
	}
}
