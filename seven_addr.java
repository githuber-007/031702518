package a;
import com.alibaba.fastjson.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.*;
public class seven_addr extends addr{

	protected String sixth_addr;
	protected String seventh_addr;
	public seven_addr() {}
	public seven_addr(String s,String output)throws Exception
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
	    }
	    else
	    	System.out.println("Error in finding telephone number!");
		
	}
protected void writeinto(String output)
	{try {
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
		out.write(c1+this.sixth_addr+c2+",");
		out.write(c1+this.seventh_addr+c2);
		out.write("]}"+"\r\n");
		out.close();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	}
protected void depart(String s)throws Exception
{
	s=fisrt(s);
	s=second(s);
	s=third(s);
	s=fourth(s);
	s=fifth(s);
	s=sixth(s);
	this.seventh_addr=s;
}
protected String fifth(String s)throws Exception
{

		String encoding="UTF-8";
		File file=new File("D:\\ChineseAddressDict-master\\ChineseAddressDict-master\\road.txt");
		if(file.isFile() && file.exists())
		{
			 
		        InputStreamReader read=new InputStreamReader(new FileInputStream(file),encoding);
		        BufferedReader reader=new BufferedReader(read);
		        String message=null;
		        int max_len=0; //��¼�ļ��е��ƥ�?
		        int flag1=0;  //�ļ���ѯ�Ƿ�ɹ���?0��ʾû�ҵ�����ʱ��Ӧ��ַӦ��ΪNULL��1��ʾ��ѯ�ɹ�����ʱ��Ӧ��ַΪmessage
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
		        	this.fifth_addr="";
		        }
		        else 
		        {
		        	s=s.substring(max_len);
		        }
		        reader.close();
		        return s;
			}
		else
			System.out.println("Fail to open file!");
	
	return s;
}
protected String sixth(String s)throws Exception
{
    int i=0;char c;
    for(;i<s.length();i++)
    {
    	c=s.charAt(i);
    	if(c<'0'||c>'9')
    		break;
    }
    if(i==0)
    	this.sixth_addr="";
    else
    {
    	this.sixth_addr=s.substring(0,i+1);
        s=s.substring(i+1);
    }
	return s;
}

}
