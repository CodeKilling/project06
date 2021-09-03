package jieun;

import java.util.*;

import main.MemberDTO;

public class Mem_jieun {
	Scanner sc = new Scanner(System.in);
	DB_jieun db = new DB_jieun();
	ArrayList<MemberDTO> list = null;
	private int result = 0, age = 0;
	private String id = null, name = null;
	public void display() {
		boolean bool = true;
		int num = 0;
		while(bool) {
			System.out.println("1.회원목록 2.회원추가 3.회원수정 4.회원삭제 5.종료");
			num = sc.nextInt();
			switch(num) {
			case 1 : view(); break;
			case 2 : add(); break;
			case 3 : modify(); break;
			case 4 : delete(); break;
			case 5 : bool = false; break;
			default : System.out.println("1~5 중 입력하세요."); break;
			}
		}
	}
	public void view() {
		list = db.getList();
		for(int i=0; i<list.size(); i++) {
			System.out.println("--- " + (i+1) + " ---");
			System.out.println("id : " + list.get(i).getId());
			System.out.println("name : " + list.get(i).getName());
			System.out.println("age : " + list.get(i).getAge());
		}
	}
	public void add() {
		System.out.print("저장할 id 입력 : "); id = sc.next();
		System.out.print("저장할 이름 입력 : "); name = sc.next();
		System.out.print("저장할 나이 입력 : "); age = sc.nextInt();
		result = db.getAdd(id, name, age);
		if(result == 1) {
			System.out.println("저장 성공!");
		}else {
			System.out.println("저장 실패!");
		}
	}
	public void modify() {
		System.out.print("수정할 id 입력 : "); id = sc.next();
		System.out.print("수정할 이름 입력 : "); name = sc.next();
		System.out.print("수정할 나이 입력 : "); age = sc.nextInt();
		result = db.getModify(id, name, age);
		if(result == 1) {
			System.out.println("수정 성공!");
		}else {
			System.out.println("수정 실패! 존재하지 않는 id");
		}
	}
	public void delete() {
		System.out.print("삭제할 id 입력 : "); id = sc.next();
		result = db.getDelete(id);
		if(result == 1) {
			System.out.println("삭제 성공!");
		}else {
			System.out.println("삭제 실패! 존재하지 않는 id");
		}
	}
}
