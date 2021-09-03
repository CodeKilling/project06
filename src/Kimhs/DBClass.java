package Kimhs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import main.Interface_Member;
import main.MemberDTO;

public class DBClass implements Interface_Member{
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String id = "faker";
	private String pwd = "1234";
	
	public DBClass() {
		try { // DBClass 객체 생성시 오라클 기능을 등록하도록 초기화
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public ArrayList<MemberDTO> getList() {
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
		try {
			Connection con = DriverManager.getConnection(url, id, pwd);
			String sql = "select * from newst";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				MemberDTO dto = new MemberDTO();
				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));
				dto.setAge(rs.getInt("age"));
				
				list.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int getAdd(String userId, String userName, int userAge) {
		String sql = "insert into newst values(?,?,?)";
		int result = 0;
		try {
			Connection con = DriverManager.getConnection(url,id,pwd);
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ps.setString(2,userName);
			ps.setInt(3,userAge);
			result = ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	@Override
	public int getDelete(String userId) {
		String sql = "delete from newst where id = ?";
		int result = 0;
		try {
			Connection con = DriverManager.getConnection(url,id,pwd);
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			result = ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int getModify(String userId, String userName, int userAge) {
		String sql = "update newst set name = ?, age = ? where id = ?";
		int result = 0;
		try {
			Connection con = DriverManager.getConnection(url, id, pwd);
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userName);
			ps.setString(3, userId);
			ps.setInt(2, userAge);
			
			result = ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
}
