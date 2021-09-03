package nmrnkd;

import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.Scanner;

import main.MemberDTO;

public class Main_KYJ {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		DB_Class_KYJ db = new DB_Class_KYJ();
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
		String id = null, name = null; int age = 0;
		int num, result = 0; boolean bool = true;

		while(bool)
		{
			System.out.println("-------회원 관리 페이지-------");
			System.out.println("1.회원 목록");
			System.out.println("2.회원 추가");
			System.out.println("3.회원 수정");
			System.out.println("4.회원 삭제");
			System.out.println("5.종료");
			System.out.println("-------------------------");
			
			num = input.nextInt();
			
			switch(num) {
			case 1:
				db.getList();
				System.out.println("    View Member List	");

				for(int i=0;i<list.size();i++)
				{
					System.out.println("-------------------------");
					System.out.println("User Id : "+list.get(i).getId());
					System.out.println("User Name : "+list.get(i).getName());
					System.out.println("User Age : "+list.get(i).getAge());
					System.out.println("-------------------------");
				}
				break;
			case 2:
				System.out.println("	Add Member List 	");
				System.out.println("-------------------------");
				System.out.println("Input New Id : ");
				id = input.next();
				System.out.println("Input New Name : ");
				name = input.next();
				System.out.println("Input New Age  : ");
				age = input.nextInt();
				System.out.println("-------------------------");

				result = db.getAdd(id, name, age);
				if(result == 1) {
					System.out.println("Save Complete!");
				}else {
					System.out.println("Failed to Save");
					System.out.println(": '"+id+"' is already registered.");
				}
				break;
			case 3:
				System.out.println("    Edit Member List	 ");
				System.out.println("-------------------------");
				System.out.println("Input User Id : ");
				id = input.next();
				for(int i=0; i<list.size();i++)
				{
					if(id.equals(list.get(i).getId()))
					{
						System.out.println("Input New Name : ");
						name = input.next();
						System.out.println("Input New Age  : ");
						age = input.nextInt();
						System.out.println("-------------------------");	
						result = db.getModify(id, name, age);
						if(result == 1)
						{
							System.out.println("Modification complete!");
						}else {
							System.out.println("Failed to Modify");
						}
						break;
					}else if(i==list.size()-1)
					{
						System.out.println("There is no registered Information.");
					}
				}				
				break;
			case 4:
				System.out.println("    Delete Member List	 ");
				System.out.println("Input User Id : ");
				id = input.next();
				result = db.getAdd(id, name, age);
				if(result == 1) {
					System.out.println("Delete Complete!");
				}else {
					System.out.println("Failed to Delete");
					System.out.println(": There is no registered Information.");
				}				
				break;
			case 5: bool = false; break;
				default : System.out.println("Only 1~6");
			}
		
		}
	}
	
}
