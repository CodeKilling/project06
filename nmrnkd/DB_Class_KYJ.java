package nmrnkd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import main.Interface_Member;
import main.MemberDTO;



public class DB_Class_KYJ implements Interface_Member{

	private String url = "jdbc:oracle:thin:@210.221.253.215:1521:xe";
	private String id = "nmrnkd";
	private String pwd = "nmrnkd";
	private Connection con = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	public DB_Class_KYJ() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, id, pwd);
			System.out.println("\nConnection Successful!\n");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public ArrayList<MemberDTO> getList() {
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
		try {
			String sql = "select * from newst";
			con = DriverManager.getConnection(url, id, pwd);
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				MemberDTO dto = new MemberDTO();
				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));
				dto.setAge(rs.getInt("age"));
				
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public int getAdd(String userId, String userName, int userAge) {
		String sql = "insert into newst values(? , ? , ?)";
		int result = 0;
		try {
			con = DriverManager.getConnection(url, id, pwd);
			ps = con.prepareStatement(sql);

			ps.setString(1, userId);
			ps.setString(2, userName);
			ps.setInt(3, userAge);
			
			result = ps.executeUpdate();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int getDelete(String userId) {
		int result = 0;
		String sql = "delete from newst where id=?";
		try {
			con = DriverManager.getConnection(url, id, pwd);
			ps = con.prepareStatement(sql);	
			ps.setString(1, userId);
			result = ps.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int getModify(String userId, String userName, int userAge) {
		int result = 0;
		String sql = "update newst set name=? ,age=? where id=?";
		try {
			con = DriverManager.getConnection(url, id, pwd);
			ps = con.prepareStatement(sql);
			
			ps.setString(1, userName);//쿼리문 순서와 맞춰줌
			ps.setInt(2, userAge);
			ps.setString(3, userId);
			
			result = ps.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
			}
		return result;
	}
}
