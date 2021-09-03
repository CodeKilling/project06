package psj;

import java.util.ArrayList;
import java.util.Scanner;

import main.MemberDTO;

public class Sj_Main1 {
	
	Scanner sc = new Scanner(System.in);
	int num, age, result = 0;
	String id, name;
	ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
	Sj_DB db = new Sj_DB();
	

	public void display() {
		boolean bool = true;
		while (bool) {
			System.out.println("1.목록보기 2.추가 3.수정 4.삭제 5.종료");
			num = sc.nextInt();
			switch (num) {
			case 1:
				list = db.getList();
				for (int i = 0; i < list.size(); i++) {
					System.out.println("ID : " + list.get(i).getId());
					System.out.println("이름 : " + list.get(i).getName());
					System.out.println("나이 : " + list.get(i).getAge());
					System.out.println("=============");
				}
				break;
			case 2:
				System.out.println("추가할 ID 입력 : ");
				id = sc.next();
				System.out.println("이름 : ");
				name = sc.next();
				System.out.println("나이 : ");
				age = sc.nextInt();
				result = db.getAdd(id, name, age);
				if (result == 1) {
					System.out.println("추가 성공");
				} else {
					System.out.println("동일한 ID가 존재합니다");
				}

				break;
			case 3:
				System.out.println("수정할 ID 입력 : ");
				id = sc.next();
				System.out.println("변경할 이름 입력 : ");
				name = sc.next();
				System.out.println("변경할 나이 입력 : ");
				age = sc.nextInt();
				result = db.getModify(id, name, age);
				if (result == 1) {
					System.out.println("수정되었습니다");
				} else {
					System.out.println("해당 ID는 존재하지 않습니다");
				}
				break;
			case 4:
				System.out.println("삭제할 ID 입력 : ");
				id = sc.next();
				result = db.getDelete(id);
				if (result == 1) {
					System.out.println("삭제되었습니다");
				} else {
					System.out.println("존재하지 않는 아이디 입니다");
				}
				break;
			case 5:
				System.out.println("프로그램을 종료합니다");
				bool = false;
				break;
			}
		}
	}
}
