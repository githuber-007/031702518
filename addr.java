package addressbook;
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
	public addr(String s,String o)
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
			depart(str);
			writeinto(o);
	    }
	    else
	    	System.out.println("Error in finding telephone number!");
		
			}
	protected void writeinto(String output)
	{try {
		BufferedWriter out=new BufferedWriter(
		new OutputStreamWriter(new FileOutputStream(output,true)));
		out.write("\r\n"+"     "+"{"+"\r\n");
		out.write("         "+"“姓名” ："+this.name+" \r\n");
		out.write("         "+"“手机” ："+this.tel_number+"  "+"\r\n");
		out.write("         "+"“地址” ：  "+"["+"\r\n");
		out.write("            "+'"'+this.first_addr+'"'+"\r\n");
		out.write("            "+'"'+this.sec_addr+'"'+"\r\n");
		out.write("            "+'"'+this.third_addr+'"'+"\r\n");
		out.write("            "+'"'+this.fourth_addr+'"'+"\r\n");
		out.write("            "+'"'+this.fifth_addr+'"'+"\r\n");
		out.write("         "+"]"+"\r\n");
		out.write("},"+"\r\n");
		out.close();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	}
	protected void depart(String s)
	{
		s=fisrt(s);
		s=second(s);
		s=third(s);
		s=fourth(s);
		this.fifth_addr=s;
	}
	protected String fisrt(String s)
	{
		try
		{
			String encoding="UTF-8";
			File file=new File("D:\\ChineseAddressDict-master\\ChineseAddressDict-master\\prov.txt");
			if(file.isFile() && file.exists())
			{
			        InputStreamReader read=new InputStreamReader(new FileInputStream(file),encoding);
			        BufferedReader reader=new BufferedReader(read);
			        String message=null;
			        int flag1=0;  //�ļ���ѯ�Ƿ�ɹ���0��ʾû�ҵ�����ʱ��Ӧ��ַӦ��ΪNULL��1��ʾ��ѯ�ɹ�����ʱ��Ӧ��ַΪmessage
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
			
		}
		catch (Exception e)
		{
			 System.out.println("��ȡ�ļ����ݳ���");
		      e.printStackTrace();
		}
		
		return s;
	}
	protected String second(String s)
	{
		try
		{
			String encoding="UTF-8";
			File file=new File("D:\\ChineseAddressDict-master\\ChineseAddressDict-master\\city.txt");
			if(file.isFile() && file.exists())
			{
			        InputStreamReader read=new InputStreamReader(new FileInputStream(file),encoding);
			        BufferedReader reader=new BufferedReader(read);
			        String message=null;
			        int flag1=0;  //�ļ���ѯ�Ƿ�ɹ���0��ʾû�ҵ�����ʱ��Ӧ��ַӦ��ΪNULL��1��ʾ��ѯ�ɹ�����ʱ��Ӧ��ַΪmessage
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
			
		}
		catch (Exception e)
		{
			 System.out.println("��ȡ�ļ����ݳ���");
		      e.printStackTrace();
		}
		
		return s;
	}
	protected String third(String s)
	{
		try
		{
			String encoding="UTF-8";
			File file=new File("D:\\ChineseAddressDict-master\\ChineseAddressDict-master\\town.txt");
			if(file.isFile() && file.exists())
			{
				 
			        InputStreamReader read=new InputStreamReader(new FileInputStream(file),encoding);
			        BufferedReader reader=new BufferedReader(read);
			        String message=null;
			        int flag1=0;  //�ļ���ѯ�Ƿ�ɹ���0��ʾû�ҵ�����ʱ��Ӧ��ַӦ��ΪNULL��1��ʾ��ѯ�ɹ�����ʱ��Ӧ��ַΪmessage
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
			
		}
		catch (Exception e)
		{
			 System.out.println("��ȡ�ļ����ݳ���");
		      e.printStackTrace();
		}
		
		return s;
	}
	protected String fourth(String s)
	{

		try
		{
			String encoding="UTF-8";
			File file=new File("D:\\ChineseAddressDict-master\\ChineseAddressDict-master\\town.txt");
			if(file.isFile() && file.exists())
			{
				 
			        InputStreamReader read=new InputStreamReader(new FileInputStream(file),encoding);
			        BufferedReader reader=new BufferedReader(read);
			        String message=null;
			        int flag1=0;  //�ļ���ѯ�Ƿ�ɹ���0��ʾû�ҵ�����ʱ��Ӧ��ַӦ��ΪNULL��1��ʾ��ѯ�ɹ�����ʱ��Ӧ��ַΪmessage
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
			
		}
		catch (Exception e)
		{
			 System.out.println("��ȡ�ļ����ݳ���");
		      e.printStackTrace();
		}
		
		return s;
	}
	public void show()
	{
		System.out.println(name);
		System.out.println(tel_number);
		System.out.println(first_addr);
		System.out.println(sec_addr);
		System.out.println(third_addr);
		System.out.println(fourth_addr);
		System.out.println(fifth_addr);
	}
}
