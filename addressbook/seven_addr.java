package addressbook;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.*;
public class seven_addr extends addr{

	protected String sixth_addr;
	protected String seventh_addr;
	public seven_addr() {}
	public seven_addr(String s,String output)
	{
		this.output=output;
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
			writeinto(this.output);
			show();
	    }
	    else
	    	System.out.println("Error in finding telephone number!");
		
	}
protected void writeinto(String output)
	{try {
		BufferedWriter out=new BufferedWriter(
		new OutputStreamWriter(new FileOutputStream(output,true)));
		out.write("\r\n"+"     "+"{"+"\r\n");
		out.write("         "+"“姓名”：  “ "+this.name+" ”\r\n");
		out.write("         "+"“手机”： “ "+this.tel_number+" ”"+"\r\n");
		out.write("         "+"“地址”：  "+"["+"\r\n");
		out.write("            "+'"'+this.first_addr+'"'+"\r\n");
		out.write("            "+'"'+this.sec_addr+'"'+"\r\n");
		out.write("            "+'"'+this.third_addr+'"'+"\r\n");
		out.write("            "+'"'+this.fourth_addr+'"'+"\r\n");
		out.write("            "+'"'+this.fifth_addr+'"'+"\r\n");
		out.write("            "+'"'+this.sixth_addr+'"'+"\r\n");
		out.write("            "+'"'+this.seventh_addr+'"'+"\r\n");
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
	s=fifth(s);
	s=sixth(s);
	this.seventh_addr=s;
}
protected String fifth(String s)
{

	try
	{
		String encoding="UTF-8";
		File file=new File("D:\\ChineseAddressDict-master\\ChineseAddressDict-master\\road.txt");
		if(file.isFile() && file.exists())
		{
			 
		        InputStreamReader read=new InputStreamReader(new FileInputStream(file),encoding);
		        BufferedReader reader=new BufferedReader(read);
		        String message=null;
		        int max_len=0; //记录文件中的最长匹配
		        String max_str=null;
		        int flag1=0;  //文件查询是否成功，0表示没找到，此时相应地址应设为NULL；1表示查询成功，此时相应地址为message
		        while((message=reader.readLine())!=null)
		         {
		        	
		        	int i=0;
		            char c1,c2;
		        	int len=message.length();
		        	int len1=s.length();
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
		        		if(len > max_len )
		        		{
		        			max_len=len;
		        			this.fifth_addr=message;
		        			
		        		}
		        	}
		         } 
		        if(flag1==0)
		        {
		        	this.fifth_addr=null;
		        }
		        else 
		        {
		        	s=s.substring(max_len);
		        }
		        return s;
			}
		else
			System.out.println("Fail to open file!");
		
	}
	catch (Exception e)
	{
		 System.out.println("读取文件内容出错");
	      e.printStackTrace();
	}
	
	return s;
}
protected String sixth(String s)
{
    int i=0;char c;
    for(;i<s.length();i++)
    {
    	c=s.charAt(i);
    	if(c<'0'||c>'9')
    		break;
    }
    if(i==0)
    	this.sixth_addr=null;
    else
    {
    	this.sixth_addr=s.substring(0,i+1);
        s=s.substring(i+1);
    }
	return s;
}
public void show()
{

	System.out.println("姓名:"+name);
	System.out.println("电话:"+tel_number);
	System.out.println(first_addr);
	System.out.println(sec_addr);
	System.out.println(third_addr);
	System.out.println(fourth_addr);
	System.out.println(fifth_addr);
	System.out.println(sixth_addr);
	System.out.println(seventh_addr);
}
}
