package src.main;

import java.util.ArrayList;
import main.MemberDTO;

public interface Interface_Member {
	public ArrayList<MemberDTO> getList();
	public int getAdd(String userId, String userName, int userAge);
	public int getDelete(String userId);
	public int getModify(String userId, String userName, int userAge);
}
