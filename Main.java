package a;
//import java.util.Scanner;
import java.io.*;
public class Main {
	public  static void main(String[] agrs)throws Exception
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
			if(file.isFile() && file.exists())
			{
				
					
			    InputStreamReader red=new InputStreamReader(new FileInputStream(file),"UTF-8");
			    BufferedReader reade=new BufferedReader((red));
			    String message=null;
		while((message=reade.readLine())!=null)
		{
			String str=message;
			//System.out.println(message);
			int l=str.length()-1;
			str=str.substring(0,l);
			String[] arr=str.split("!");
			//System.out.println("arr"+arr[0]);
		
			if(arr[0].equalsIgnoreCase("1"))
			{
				//System.out.println("1"+str);
				 new addr(arr[1],output);
			}
			else if(arr[0].equalsIgnoreCase("2"))
			{
				//System.out.println("2"+str);
				new seven_addr(arr[1],output);
			
				}
			else
				;
		}
				reade.close();
				System.out.println("[");
		   show(output);
			System.out.print("]");
		//m.close();
	}
			else
			{
				System.out.println("Error in finding input files");
			}
	}
	
	public static void show(String file)throws Exception
	{
		
			File f=new File(file);
			InputStreamReader red=new InputStreamReader(new FileInputStream(f),"UTF-8");
		    BufferedReader reade=new BufferedReader((red));
		    String s=null;
		    String next=null; 
		    s=reade.readLine();
		    while(true)
{

  next=reade.readLine();
  if(next!=null)
	System.out.println(s+',');
  else
  {
	  System.out.println(s);
	  break;
  }
  s=next;
  
}
		    reade.close();
		
	}
}
