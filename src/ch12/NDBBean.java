package ch12;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class NDBBean {
	private static NDBBean instance = new NDBBean(); // �ڱ� �ڽ����� ��ü ���� static ��� ������ ���������� ������ ��ħ.
	public static NDBBean getInstance(){ //�޼ҵ� �տ� static�� �پ��ٴ� ���� �� �θ� �� �ִٴ� ��.
		return instance; //LogonDBBean ��ҵ鿡 �� ���ٰ���.
	} //jsp �� java�������ֱ� (�� å ���ڸ��� �����)
	public NDBBean(){
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
		public void insertNotice (NDataBean nb){ 
			//�� connection(�޼ҵ�)ȣ��
		
			Connection conn = null; //getConnection�� ȣ���ؼ� Connection Ÿ���� conn�� ����
			PreparedStatement pstmt=null;
			try{
				conn = getConnection();
				String sql ="insert into notice(title,name,passwd,content,date) values (?,?,?,?,?)";
				pstmt = conn.prepareStatement(sql); 
				pstmt.setString(1,nb.getTitle());
				pstmt.setString(2,nb.getName());
				pstmt.setInt(3,nb.getPasswd());
			    pstmt.setString(4,nb.getContent());
			    pstmt.setTimestamp(5,nb.getDate());
			    pstmt.executeUpdate();
			    System.out.println("�Խ��� ���� �ϼ�");
			    
			}catch(Exception e) {
				   e.printStackTrace();
			}
			
			

			
		   }
		public List<NDataBean> getNotice()
		{
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet ns = null;
			
			List<NDataBean> list = new ArrayList<NDataBean>();
			
			try{
				conn = getConnection();
				
				//sql ��üȸ�� ��������
				String sql = "select number,title,name,date,hit from notice order by number desc";
				pstmt = conn.prepareStatement(sql);
			    ns = pstmt.executeQuery();
			    
			    //ns ������ ������ �ڹٺ� ��ü����
			    //ns => �ڹٺ� ������� ����
			    //�ڹٺ� => ����Ʈ ��ĭ �߰�
			    
			    while(ns.next()){
			    	NDataBean nb = new NDataBean();
			    	nb.setNumber(ns.getInt("number"));
			    	nb.setTitle(ns.getString("title"));
			    	nb.setName(ns.getString("name"));
			    	nb.setDate(ns.getTimestamp("date"));
			        nb.setHit(ns.getInt("hit"));
			        list.add(nb);
			    	
			    }
				
			}catch(Exception e){
				e.printStackTrace();
			}
			return list;
		}
		
		//�ϳ��� �Խñ��� ���� �޼ҵ�
				public NDataBean getNbs(int number) {
					NDataBean nb = null;
					Connection conn = null;
					PreparedStatement pstmt = null;
					ResultSet ns = null;
					
					try {
						conn = getConnection();
						//sql���� �۳��� ��������
						String sql = "select number,title,name,content,date,hit from notice where number =?";
						pstmt = conn.prepareStatement(sql);
						pstmt.setInt(1, number);
						ns = pstmt.executeQuery();
						
						if(ns.next()) {
							
							nb = new NDataBean();
							nb.setNumber(ns.getInt("number"));
							nb.setTitle(ns.getString("title"));
							nb.setName(ns.getString("name"));
						    nb.setContent(ns.getString("content"));
						    nb.setDate(ns.getTimestamp("date"));
						    nb.setHit(ns.getInt("hit"));
							System.out.println("�� �������� �ϼ�");
					}
							
						}
						 catch(Exception e){
						e.printStackTrace();
					}
					return nb;
							
					
				}

}
