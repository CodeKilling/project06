package jieun;

import java.sql.*;
import java.util.ArrayList;
import main.*;

public class DB_jieun implements Interface_Member{
	private String url = "jdbc:oracle:thin:@210.221.253.215:1521:xe";
	private String id = "g2";
	private String pwd = "oracle";
	private Connection con = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	private String sql = null;
	private int result = 0;
	public DB_jieun() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, id, pwd);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public ArrayList<MemberDTO> getList() {
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
		MemberDTO dto = null;
		try {
			//con = DriverManager.getConnection(url, id, pwd);
			sql = "select * from newst";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				dto = new MemberDTO();
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
		try {
			//con = DriverManager.getConnection(url, id, pwd);
			//insert into newst values('아이디', '이름', 33);
			sql = "insert into newst values(?, ?, ?)";
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
	public int getModify(String userId, String userName, int userAge) {
		try {
			//con = DriverManager.getConnection(url, id, pwd);
			//update newst set name = '이름', age =35 where id = '333';
			sql = "update newst set name = ?, age = ? where id = ?";
			ps= con.prepareStatement(sql);
			ps.setString(1, userName);
			ps.setInt(2, userAge);
			ps.setString(3, userId);
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public int getDelete(String userId) {
		try {
			//con = DriverManager.getConnection(url, id, pwd);
			//delete from newst where id = '111';
			sql = "delete from newst where id = '"+userId+"'";
			ps = con.prepareStatement(sql);
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
}
