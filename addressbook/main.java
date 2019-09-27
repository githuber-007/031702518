package addressbook;
import java.util.Scanner;
import java.io.*;
public class main {

	public  static void main(String[] agrs)
	{
	      /*  Scanner m=new Scanner(System.in);	
	        System.out.println("please input the input file's path ");
	        String input=m.nextLine();
	        System.out.println("please input the output file's path ");
	        String output=m.nextLine();*/
		    String input="D:\\1.txt";
		    String output="D:\\2.txt";
			String encoding="GBK";
			File file=new File(input);
			if(file.isFile() && file.exists())
			{
				try {
			    InputStreamReader read=new InputStreamReader(new FileInputStream(file),encoding);
			    BufferedReader reader=new BufferedReader(read);
			    String message=null;
		while((message=reader.readLine())!=null)
		{
			String str=message;
			System.out.println(message);
			int l=str.length()-1;
			str=str.substring(0,l);
			String[] arr=str.split("!");
			switch(arr[0])
			{
			case "1":
			addr A=new addr(arr[1],output);
				break;
				
			case "2":
			seven_addr B=new seven_addr(arr[1],output);
				break;
			default:
				break;
			}
		}
			}
			catch(Exception e)
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
}
