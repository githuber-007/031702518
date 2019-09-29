package addressbook;
//import java.util.Scanner;
import java.io.*;
public class Main {
	public  static void main(String[] agrs)
	{
	      /*  Scanner m=new Scanner(System.in);	
	        System.out.println("please input the input file's path ");
	        String input=m.nextLine();
	        System.out.println("please input the output file's path ");
	        String output=m.nextLine();*/
	
		    String input=agrs[0];
		    String output=agrs[1];
			//String encoding="GBK";
			File file=new File(input);
			
			insert("[\r\n",output);
			if(file.isFile() && file.exists())
			{
				try {
					
			    InputStreamReader red=new InputStreamReader(new FileInputStream(file),"UTF-8");
			    BufferedReader reade=new BufferedReader((red));
			    String message=null;
		while((message=reade.readLine())!=null)
		{
			String str=message;
			System.out.println(message);
			int l=str.length()-1;
			str=str.substring(0,l);
			String[] arr=str.split("!");
			switch(arr[0])
			{
			case "1":
		      new addr(arr[1],output);
				break;
			case "2":
			new seven_addr(arr[1],output);
				break;
			default:
				break;
			}
		}
		insert("]\r\n",output);
			
				reade.close();}
			catch(IOException e)
			{
				System.out.println("Error in open inputfile");
				e.printStackTrace();
			}
		//m.close();
	}
			else
			{
				System.out.println("Error in finding input files");
			}
}
	public static void  insert(String str,String output)
	{
		try {
			BufferedWriter out=new BufferedWriter(
		    		new OutputStreamWriter(new FileOutputStream(output,true)));
				out.write(str);
				out.close();
				
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
