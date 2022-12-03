package ch12;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class FDBBean {
	private static FDBBean instance = new FDBBean(); // 
	public static FDBBean getInstance(){ 
		return instance; 
	} 
	public FDBBean(){
		
	}
	
	
		public Connection getConnection() throws ClassNotFoundException, SQLException{ //type�� Connection���� �ٲ�
			Connection conn =null;
			String jdbcUrl="jdbc:mysql://localhost:3308/jsp_01?useUnicode=true&characterEncoding=utf8";
			String dbId="root";
			String dbPass ="1234";
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection(jdbcUrl,dbId,dbPass);
			//system.out.println(conn);
			System.out.println("연결완료");
			
			return conn;
		}
		
		
	   
		public void insertNotice (FDataBean fb){ 
			
		
			Connection conn = null; 
			PreparedStatement pstmt=null;
			try{
				conn = getConnection();
				String sql ="insert into quest(title,name,passwd,content,date) values (?,?,?,?,?)";
				pstmt = conn.prepareStatement(sql); 
				pstmt.setString(1,fb.getTitle());
				pstmt.setString(2,fb.getName());
				pstmt.setInt(3,fb.getPasswd());
			    pstmt.setString(4,fb.getContent());
			    pstmt.setTimestamp(5,fb.getDate());
			    pstmt.executeUpdate();
			    System.out.println("게시글 등록 완료");
			    
			}catch(Exception e) {
				   e.printStackTrace();
			}
			
			

			
		   }
		public List<FDataBean> getNotice()
		{
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet ns = null;
			
			List<FDataBean> list = new ArrayList<FDataBean>();
			
			try{
				conn = getConnection();
				
			
				String sql = "select number,title,name,date,hit from quest order by number desc";
				pstmt = conn.prepareStatement(sql);
			    ns = pstmt.executeQuery();
			    
			  
			    
			    while(ns.next()){
			    	FDataBean fb = new FDataBean();
			    	fb.setNumber(ns.getInt("number"));
			    	fb.setTitle(ns.getString("title"));
			    	fb.setName(ns.getString("name"));
			    	fb.setDate(ns.getTimestamp("date"));
			        fb.setHit(ns.getInt("hit"));
			        list.add(fb);
			    	
			    }
				
			}catch(Exception e){
				e.printStackTrace();
			}
			return list;
		}
		
		
				public FDataBean getNbs(int number) {
					FDataBean fb = null;
					Connection conn = null;
					PreparedStatement pstmt = null;
					ResultSet ns = null;
					
					try {
						conn = getConnection();
						
						String sql = "select number,title,name,content,date,hit from quest where number =?";
						pstmt = conn.prepareStatement(sql);
						pstmt.setInt(1, number);
						ns = pstmt.executeQuery();
						
						if(ns.next()) {
							
							fb = new FDataBean();
							fb.setNumber(ns.getInt("number"));
							fb.setTitle(ns.getString("title"));
							fb.setName(ns.getString("name"));
						    fb.setContent(ns.getString("content"));
						    fb.setDate(ns.getTimestamp("date"));
						    fb.setHit(ns.getInt("hit"));
							System.out.println("완성");
					}
							
						}
						 catch(Exception e){
						e.printStackTrace();
					}
					return fb;
						
					
				}

}