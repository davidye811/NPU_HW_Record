package ajax;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;  




import java.sql.*;//这个包必须有！！



public class ajaxServlet extends HttpServlet
{
 //private static final String CONTENT_TYPE = "text/xml; charset=UTF-8";//这里最好统一用UTF-8进行编码
 public void init() throws ServletException{}
 public static void main (String []argv) throws Exception
 {
	 

	 String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	   String URL = "jdbc:sqlserver://localhost:56565;databaseName=DAVID";
	   String USER = "godman";
	   String PWD = "godman";
	File file;
	   Connection conn;
	
		file =new File("D:/testj/WebContent/js_folder/7.js");
		
	
		conn = DriverManager.getConnection(URL, USER,PWD);
	
	   if(conn != null)
		   System.out.println('1');
	   else 
		   System.out.println('0');
	   java.sql.Statement sta;
	
		sta = conn.createStatement();
	
	 //{"lnglat":["113.56925","22.136546"],"name":"路氹城"} var citys = [{ 
		ResultSet rs=sta.executeQuery("select * from yek");
		StringBuffer sb = new StringBuffer();
		String S=new String();
	  S+=("var data = [");
	 /* S+=('"');
	  S+=("data");
	  S+=('"');
	  S+=(':');
	  S+=('[');*/
	  int i=0;
	       while(rs.next())
	       {
	    	   if(i!=0)
	    		   S+=(',');
	    	   i=1;
	    	   float id  = rs.getFloat("id");
	    	   float px  = rs.getFloat("longi");
	           float py  = rs.getFloat("lati");
	           float clus= rs.getFloat("cluster");
	           S+=('{');
	           S+=('"');
	           S+=("lnglat");
	           S+=('"');
	           S+=(":[");
	           S+=('"');
	           S+=(px);
	           S+=('"');
	           S+=(',');
	           S+=('"');
	           S+=(py);
	           S+=('"');
	           S+=("],");
	           S+=('"');
	           S+=("name");
	           S+=('"');
	           S+=(':');
	           S+=('"');
	           S+=(clus);
	           S+=('"');
	           S+=("}");
	         
	          
	       } S+=(']'); S+=('}');
	       FileWriter fw=new FileWriter(file); 
	       fw.write(S);
	       fw.close();
	         //sb.append("<type_name>"+action+"</type_name>");
	         
	        // out.write(sb.toString());//注意这里向jsp输出的流，在script中的截获方法
	        // out.close();
	         sta.close();
	         conn.close();	
	
 }
 
 public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
 {
  response.setContentType("text/xml; charset=UTF-8");
  //以下两句为取消在本地的缓存
  response.setHeader("Cache-Control", "no-cache");
   response.setHeader("Pragma", "no-cache");
  PrintWriter out = response.getWriter();
  String action = request.getParameter("action");
  String bm = request.getParameter("bm");
  
  try
    {
	   String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	   String URL = "jdbc:sqlserver://localhost:56565;databaseName=DAVID";
	   String USER = "godman";
	   String PWD = "godman";
	//   Class.forName(DRIVER).newInstance();  
	   Connection conn = DriverManager.getConnection(URL, USER,PWD); 
	   java.sql.Statement sta=conn.createStatement();
	     ResultSet rs=sta.executeQuery("select * from yek");
      StringBuffer sb = new StringBuffer();
       sb.append("<type>");
     while(rs.next())
      {
           System.out.println();
      sb.append("<type_name>"+rs.getString(1)+"</type_name>");
         
      }
        //sb.append("<type_name>"+action+"</type_name>");
        sb.append("</type>"); 
        out.write(sb.toString());//注意这里向jsp输出的流，在script中的截获方法
        out.close();
        sta.close();
        conn.close();
    }
    catch(Exception ex)
    {
         
    }
  
 }
}