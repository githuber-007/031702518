package a;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//没事
//import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
//import java.io.Reader;
import java.io.*;
public class addr {

	protected String name;
	protected String tel_number;
	protected String first_addr;
	protected String sec_addr;
	protected String third_addr;
	protected String fourth_addr;
	protected String fifth_addr;
	protected String output;
	public addr() {}
	public addr(String s,String o)throws Exception
	{
		this.output=o;
		String[] arr=s.split(",");
		this.name=arr[0];
		String num="\\d{11}";
		Pattern p=Pattern.compile(num);
	    Matcher m=p.matcher(arr[1]);
	    if(m.find())
	    { 
	    	String str=new String(m.group(0));
	    	this.tel_number=str;
			String[] arr1=arr[1].split(str);
			str=arr1[0]+arr1[1];
		        int l=str.length()-1;
			str=str.substring(0,l);
			depart(str);
			writeinto(o);
	    }
	    else
	    	System.out.println("Error in finding telephone number!");
		
			}
	protected void writeinto(String output)throws Exception
	{
		BufferedWriter out=new BufferedWriter(
		new OutputStreamWriter(new FileOutputStream(output,true)));
		char c1='"';
		char c2='"';
		out.write("{"+c1+"姓名"+c2+":"+c1+this.name+c2+",");
		out.write(c1+"手机"+c2+":"+c1+this.tel_number+c2+",");
		out.write(c1+"地址"+c2+":[");
		out.write(c1+this.first_addr+c2+",");
		out.write(c1+this.sec_addr+'"'+c2+",");
		out.write(c1+this.third_addr+c2+",");
		out.write(c1+this.fourth_addr+c2+",");
		out.write(c1+this.fifth_addr+c2);
		out.write("]},");
		out.close();
	
	}
	protected void depart(String s)throws Exception
	{
		s=fisrt(s);
		s=second(s);
		s=third(s);
		s=fourth(s);
		this.fifth_addr=s;
	}
	protected String fisrt(String s)throws Exception
	{
		
			String encoding="UTF-8";
			File file=new File("D:\\ChineseAddressDict-master\\ChineseAddressDict-master\\prov.txt");
			if(file.isFile() && file.exists())
			{
			        InputStreamReader read=new InputStreamReader(new FileInputStream(file),encoding);
			        BufferedReader reader=new BufferedReader(read);
			        String message=null;
			        int flag1=0;  //�ļ���ѯ�Ƿ�ɹ��市0��ʾû�ҵ�����ʱ��Ӧ��ַӦ��ΪNULL��1��ʾ��ѯ�ɹ�����ʱ��Ӧ��ַΪmessage
			        message=reader.readLine();
			        while((message=reader.readLine())!=null)
			         {
			        	
			        	int i=0;
			        	char c1,c2;
			        	int len=message.length()-1;
			        	int flag =0;
			        	for(;i<len;i++)
			        		{
			        			c1=s.charAt(i);
			        			c2=message.charAt(i);
			        			if(c1!=c2)
			        			{
			        				flag=1;break;
			        			}
			        		}
			        	
			        	if(flag==0)
			        	{
			        	
			        		flag1=1;
			        		
			                if(s.charAt(i)==message.charAt(i)&&s.charAt(i)!='市')
			                {
			                	s=s.substring(message.length());
			                	this.first_addr=message;
			                }
			                else
			                {
			                	if(s.charAt(i)=='市')
			                	{
			                	   this.first_addr=s.substring(0,i);
			                	   reader.close();
			                	   return s;
			                	}
			                	else
			                	{
			                		this.first_addr=message;
			                		s=s.substring(i);
			                	}
			                	
			                }
			        		break;
			        	}
			        		
			         } 
			        if(flag1==0)
			        {
			        	this.first_addr="";
			        }
			      reader.close();
			        return s;
				}
			else
				System.out.println("Fail to open file!");
		return s;
	}
	protected String second(String s)throws Exception
	{
		
			String encoding="UTF-8";
			File file=new File("D:\\ChineseAddressDict-master\\ChineseAddressDict-master\\city.txt");
			if(file.isFile() && file.exists())
			{
			        InputStreamReader read=new InputStreamReader(new FileInputStream(file),encoding);
			        BufferedReader reader=new BufferedReader(read);
			        String message=null;
			        int flag1=0;  //�ļ���ѯ�Ƿ�ɹ��市0��ʾû�ҵ�����ʱ��Ӧ��ַӦ��ΪNULL��1��ʾ��ѯ�ɹ�����ʱ��Ӧ��ַΪmessage
			        while((message=reader.readLine())!=null)
			         {
			        	int i=0;
			        	char c1,c2;
			        	int len=message.length()-1;
			        	int flag =0;
			        	for(;i<len;i++)
			        		{
			        			c1=s.charAt(i);
			        			c2=message.charAt(i);
			        			if(c1!=c2)
			        			{
			        				flag=1;break;
			        			}
			        		}
			        	
			        	if(flag==0)
			        	{
			        		this.sec_addr=message;
			        		flag1=1;
			        	if(s.charAt(i)==message.charAt(i))
			        	{
			                s=s.substring(message.length());}
			        	else
			        	{
			        		s=s.substring(i);
			        	}
			        		break;
			        	}
			        		
			         } 
			        if(flag1==0)
			        {
			        	this.sec_addr="";
			        }
			        reader.close();
			        return s;
				}
			else
				System.out.println("Fail to open file!");
			
		
		return s;
	}
	protected String third(String s)throws Exception
	{
			String encoding="UTF-8";
			File file=new File("D:\\ChineseAddressDict-master\\ChineseAddressDict-master\\town.txt");
			if(file.isFile() && file.exists())
			{
				 
			        InputStreamReader read=new InputStreamReader(new FileInputStream(file),encoding);
			        BufferedReader reader=new BufferedReader(read);
			        String message=null;
			        int flag1=0;  //�ļ���ѯ�Ƿ�ɹ��市0��ʾû�ҵ�����ʱ��Ӧ��ַӦ��ΪNULL��1��ʾ��ѯ�ɹ�����ʱ��Ӧ��ַΪmessage
			        while((message=reader.readLine())!=null)
			         {
			        	int i=0;
			        	char c1,c2;
			        	int len=message.length();
			        	int flag =0;
			        	for(;i<len;i++)
			        		{
			        		    
			        			c1=s.charAt(i);
			        			c2=message.charAt(i);
			        			if(c1!=c2)
			        			{
			        				flag=1;break;
			        			}
			        		}
			        	if(flag==0)
			        	{
			        		this.third_addr=message;
			        		
			        		flag1=1;
			                s=s.substring(message.length());
			        		break;
			        	}
			        		
			         } 
			        if(flag1==0)
			        {
			        	this.third_addr="";
			        }
			        reader.close();
			        return s;
				}
			else
				System.out.println("Fail to open file!");
		
		return s;
	}
	protected String fourth(String s)throws Exception
	{

		
			String encoding="UTF-8";
			File file=new File("D:\\ChineseAddressDict-master\\ChineseAddressDict-master\\town.txt");
			if(file.isFile() && file.exists())
			{
				 
			        InputStreamReader read=new InputStreamReader(new FileInputStream(file),encoding);
			        BufferedReader reader=new BufferedReader(read);
			        String message=null;
			        int flag1=0;  //�ļ���ѯ�Ƿ�ɹ��市0��ʾû�ҵ�����ʱ��Ӧ��ַӦ��ΪNULL��1��ʾ��ѯ�ɹ�����ʱ��Ӧ��ַΪmessage
			        while((message=reader.readLine())!=null)
			         {
			        	int i=0;
			        	char c1,c2;
			        	int len=message.length();
			        	
			        	int flag =0;
			        	for(;i<len;i++)
			        		{
			        		    
			        			c1=s.charAt(i);
			        			c2=message.charAt(i);
			        			if(c1!=c2)
			        			{
			        				flag=1;break;
			        			}
			        		}
			        	if(flag==0)
			        	{
			        		this.fourth_addr=message;
			        		
			        		flag1=1;
			                s=s.substring(message.length());
			        		break;
			        	}
			        		
			         } 
			        if(flag1==0)
			        {
			        	this.fourth_addr="";
			        }
			        reader.close();
			        return s;
				}
			else
				System.out.println("Fail to open file!");
			
		
		
		return s;
	}
}
