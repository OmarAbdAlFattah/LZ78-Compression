
public class Main {
	public static void main(String[] args) 
	{
		String input = "ABBCBCABABCAABCAAB";
		System.out.println("the input is: " + input);
		System.out.println();
		Compression compression = new Compression();
		Dictionary dic = new Dictionary();
		
		//System.out.println(dic.dic.size());
		//for(int i = 0; i < dic.dic.size() - 1; i++)
			//System.out.println("the dictionary contains: " + dic.dic.get(0));
		compression.compress(input,  Character.toString(input.charAt(0)) ,dic, 0);
		System.out.println(compression.encryption);
	}
}
