package psy;

import java.sql.*;
import java.util.*;
import main.*;

public class DBClass_psy implements Interface_Member{
	
	private String url = "jdbc:oracle:thin:@210.221.253.215:1521:xe";
	private String id = "g2";
	private String pwd = "oracle";
	private String sql = null;
	
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public DBClass_psy() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public ArrayList<MemberDTO> getList() {
		// TODO Auto-generated method stub
		ArrayList<MemberDTO> arr = new ArrayList<MemberDTO>();
		
		try {
			con = DriverManager.getConnection(url, id, pwd);
			sql = "select * from newst";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				MemberDTO dto = new MemberDTO();
				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));
				dto.setAge(rs.getInt("age"));
				arr.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return arr;
	}

	@Override
	public int getAdd(String id, String name, int age) {
		String sql = "insert into newst values(?,?,?)";
		int result = 0;
		try {
			con = DriverManager.getConnection(url,this.id,pwd);
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, name);
			ps.setInt(3, age);
			result= ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int getDelete(String id) {
		String sql = "delete from newst where id=?";
		int result = 0;
		try {
			con = DriverManager.getConnection(url,this.id,pwd);
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int getModify(String id,String name, int age) {
		String sql = "update newst set name=?, age=? where id=?";
		int result = 0;
		try {
			con = DriverManager.getConnection(url,this.id,pwd);
			ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setInt(2, age);
			ps.setString(3, id);
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
