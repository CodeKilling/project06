package Kimhs;

import java.util.ArrayList;
import java.util.Scanner;

import main.MemberDTO;

public class KHS_method{
	Scanner input = new Scanner(System.in);
	String id, name;
	int age, result;
	ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
	DBClass db = new DBClass();
	
	public void display() {
		boolean bool = true;
		int sel;
		while(bool) {
			System.out.println("=====  회원 관리 페이지  =====");
			System.out.println("1.회원 목록\n2.회원 추가\n3.회원 수정\n4.회원 삭제\n5.나가기");
			sel = input.nextInt();
			switch(sel) {
			case 1:
				list = db.getList();
				for(int i = 0; i < list.size(); i++) {
					System.out.println("id : " + list.get(i).getId());
					System.out.println("name : " + list.get(i).getName());
					System.out.println("age : " + list.get(i).getAge());
					System.out.println("--------------------------------");
				}
				break;
			case 2:
				System.out.println("아이디 입력");
				id = input.next();
				System.out.println("이름 입력");
				name = input.next();
				System.out.println("나이 입력");
				age = input.nextInt();
				result = db.getAdd(id, name, age);
				if(result == 1) {
					System.out.println("저장 성공");
				}else {
					System.out.println("동일한 id가 존재합니다.");
				}
				break;
			case 3:
				System.out.println("수정할 아이디 입력");
				id = input.next();
				System.out.println("수정할 이름 입력");
				name = input.next();
				System.out.println("수정할 나이 입력");
				age = input.nextInt();
				result = db.getModify(id, name, age);
				if(result == 1) {
					System.out.println("성공적으로 수정되었습니다!!");
				}else {
					System.out.println("수정할 id가 존재하지 않습니다.");
				}
				break;
			case 4:
				System.out.println("삭제할 아이디 입력");
				id = input.next();
				result = db.getDelete(id);
				if(result == 1) {
					System.out.println("성공적으로 삭제되었습니다.");
				}else {
					System.out.println("삭제하려는 id가 존재하지 않습니다.");
				}
				break;
			case 5:
				System.out.println("프로그램을 종료합니다.");
				bool = false;
				break;
			default : System.out.println("1~5 사이에 숫자만 입력하세요.");break;
			}
			
		}
	}
}
