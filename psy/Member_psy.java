package psy;

import java.util.ArrayList;
import java.util.Scanner;
import main.MemberDTO;

public class Member_psy {
	ArrayList<MemberDTO> arr = null;
	String id = null, name = null;
	Scanner sc = new Scanner(System.in);
	int input = 0, result = 0, age = 0;
	DBClass_psy db = new DBClass_psy();
	
	public void display() {

		while (true) {
			System.out.println("1. 회원 목록");
			System.out.println("2. 회원 추가");
			System.out.println("3. 회원 수정");
			System.out.println("4. 회원 삭제");
			System.out.println("5. 나가기");

			input = sc.nextInt();
			sc.nextLine();

			switch (input) {
			case 1://회원 목록
				arr = db.getList();
				if(arr.size()==0) {
					System.out.println("현재 회원 0 명.");
				}else if(arr.size() > 0) {
					for(MemberDTO it : arr) {
						System.out.println("id : " + it.getId());
						System.out.println("name : " + it.getName());
						System.out.println("age : " + it.getAge());
						System.out.println("====================");
					}
				}
				break;
				
			case 2://회원 추가
				System.out.println("회원 추가 :: id 입력 : ");
				id = sc.nextLine();
				System.out.println("회원 추가 :: name 입력 : ");
				name = sc.nextLine();
				System.out.println("회원 추가 :: age 입력 : ");
				age = sc.nextInt();
				result = db.getAdd(id,name,age);
				if(result==1) {
					System.out.println("저장 성공.");
				}else
					System.out.println("저장 실패.");
				break;
				
			case 3://회원 수정
				System.out.println("회원 수정 :: id 입력 : ");
				id = sc.nextLine();
				System.out.println("회원 수정 :: name 입력 : ");
				name = sc.nextLine();
				System.out.println("회원 수정 :: age 입력 : ");
				age = sc.nextInt();
				result = db.getModify(id,name,age);
				if(result == 1) {
					System.out.println("수정 성공.");
				}else
					System.out.println("수정 실패.");
				break;
				
			case 4://회원 삭제
				System.out.println("회원 삭제 :: id 입력 : ");
				id = sc.nextLine();
				result = db.getDelete(id);
				if(result == 1) {
					System.out.println("삭제 성공.");
				}else
					System.out.println("삭제 실패.");
				break;

			case 5://나가기
				System.out.println("Exit.");
				return;
			default:
				System.out.println("only 1~5.");
				break;
			}
		}
	}
}
