package psj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import main.Interface_Member;
import main.MemberDTO;

public class Sj_DB implements Interface_Member {
	private String url = "jdbc:oracle:thin:@210.221.253.215:1521:xe";
	private String id = "g2";
	private String pwd = "oracle";

	public Sj_DB() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<MemberDTO> getList() {
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
		try {
			Connection con = DriverManager.getConnection(url, id, pwd);
			String sql = "select * from newst";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
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
		String sql = "insert into newst values(?,?,?)";
		int result = 0;
		try {
			Connection con = DriverManager.getConnection(url, id, pwd);
			PreparedStatement ps = con.prepareStatement(sql);

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
		String sql = "delete from newst where id = ?";
		try {
			Connection con = DriverManager.getConnection(url, id, pwd);
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public int getModify(String userId, String userName, int userAge){
		int result = 0;
		String sql = "update newst set name =?,age=? where id = ?";
		try {
			Connection con = DriverManager.getConnection(url,id,pwd);
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ps.setString(2, userName);
			ps.setInt(3, userAge);
			
			result = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
