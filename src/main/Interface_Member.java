package main;

import java.util.ArrayList;

public interface Interface_Member {
	public ArrayList<MemberDTO> getList();
	public int getAdd(String id, String name, int age);
	public int getDelete(String id);
	public int getModify(String id,String name, int age);
}
