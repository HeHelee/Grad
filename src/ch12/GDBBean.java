package ch12;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GDBBean {
	private static GDBBean instance = new GDBBean(); // �ڱ� �ڽ����� ��ü ���� static ��� ������ ���������� ������ ��ħ.
	public static GDBBean getInstance(){ //�޼ҵ� �տ� static�� �پ��ٴ� ���� �� �θ� �� �ִٴ� ��.
		return instance; //LogonDBBean ��ҵ鿡 �� ���ٰ���.
	} //jsp �� java�������ֱ� (�� å ���ڸ��� �����)
	public GDBBean(){
		//�ڹ� ������ : �ʱ�ȭ
	}
	
	//Ŀ�ؼ�
		public Connection getConnection() throws ClassNotFoundException, SQLException{ //type�� Connection���� �ٲ�
			Connection conn =null;
			String jdbcUrl="jdbc:mysql://localhost:3306/jsp_01?useUnicode=true&characterEncoding=utf8";
			String dbId="root";
			String dbPass ="1234";
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection(jdbcUrl,dbId,dbPass);
			//system.out.println(conn);
			System.out.println("���Ἲ��");
			
			return conn; //�� �޼ҵ���� conn�� �ǹ�
		}
		
		
	    //�۾��� ���
		public void insertGame (GDataBean gb){ 
			//�� connection(�޼ҵ�)ȣ��
		
			Connection conn = null; //getConnection�� ȣ���ؼ� Connection Ÿ���� conn�� ����
			PreparedStatement pstmt=null;
			try{
				conn = getConnection();
				String sql ="insert into game(title,name,passwd,content,date) values (?,?,?,?,?)";
				pstmt = conn.prepareStatement(sql); 
				pstmt.setString(1,gb.getTitle());
				pstmt.setString(2,gb.getName());
				pstmt.setInt(3,gb.getPasswd());
			    pstmt.setString(4,gb.getContent());
			    pstmt.setTimestamp(5,gb.getDate());
			    pstmt.executeUpdate();
			    System.out.println("�Խ��� ���� �ϼ�");
			    
			}catch(Exception e) {
				   e.printStackTrace();
			}
			
			

			
		   }
		public List<GDataBean> getGame()
		{
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet gs = null;
			
			List<GDataBean> list = new ArrayList<GDataBean>();
			
			try{
				conn = getConnection();
				
				//sql ��üȸ�� ��������
				String sql = "select number,title,name,date,hit from game order by number desc";
				pstmt = conn.prepareStatement(sql);
			    gs = pstmt.executeQuery();
			    
			    //gs ������ ������ �ڹٺ� ��ü����
			    //gs => �ڹٺ� ������� ����
			    //�ڹٺ� => ����Ʈ ��ĭ �߰�
			    
			    while(gs.next()){
			    	GDataBean gb = new GDataBean();
			    	gb.setNumber(gs.getInt("number"));
			    	gb.setTitle(gs.getString("title"));
			    	gb.setName(gs.getString("name"));
			    	gb.setDate(gs.getTimestamp("date"));
			        gb.setHit(gs.getInt("hit"));
			        list.add(gb);
			    	
			    }
				
			}catch(Exception e){
				e.printStackTrace();
			}
			return list;
		}
		
		//�ϳ��� �Խñ��� ���� �޼ҵ�
				public GDataBean getGbs(int number) {
					GDataBean gb = null;
					Connection conn = null;
					PreparedStatement pstmt = null;
					ResultSet gs = null;
					
					try {
						conn = getConnection();
						//sql���� �۳��� ��������
						String sql = "select number,title,name,content,date,hit from game where number =?";
						pstmt = conn.prepareStatement(sql);
						pstmt.setInt(1, number);
						gs = pstmt.executeQuery();
						
						if(gs.next()) {
							
							gb = new GDataBean();
							gb.setNumber(gs.getInt("number"));
							gb.setTitle(gs.getString("title"));
							gb.setName(gs.getString("name"));
						    gb.setContent(gs.getString("content"));
						    gb.setDate(gs.getTimestamp("date"));
						    gb.setHit(gs.getInt("hit"));
							System.out.println("�� �������� �ϼ�");
					}
							
						}
						 catch(Exception e){
						e.printStackTrace();
					}
					return gb;
							
					
				}
					
}
