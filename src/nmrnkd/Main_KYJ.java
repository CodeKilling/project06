package nmrnkd;

import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.Scanner;

import main.MemberDTO;

public class Main_KYJ {

	public void display() {
		
		Scanner input = new Scanner(System.in);
		DB_Class_KYJ db = new DB_Class_KYJ();
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
		String id = null, name = null; int age = 0;
		int num, result = 0; boolean bool = true;

		while(bool)
		{
			System.out.println("-------Member Management Page-------");
			System.out.println("1.View Member List");
			System.out.println("2.Add Member List");
			System.out.println("3.Edit Member List");
			System.out.println("4.Delete Member List");
			System.out.println("5.Exit");
			System.out.println("-------------------------------------");
			
			num = input.nextInt();
			
			switch(num) {
			case 1:
				list = db.getList();
				System.out.println("-------View Member List-------");

				for(int i=0;i<list.size();i++)
				{
					System.out.println("------------------------------");
					System.out.println("User Id : "+list.get(i).getId());
					System.out.println("User Name : "+list.get(i).getName());
					System.out.println("User Age : "+list.get(i).getAge());
					System.out.println("------------------------------");

				}
				break;
			case 2:
				System.out.println("-------Add Member List-------");
				System.out.println("Input New Id : ");
				id = input.next();
				System.out.println("Input Name : ");
				name = input.next();
				System.out.println("Input Age  : ");
				age = input.nextInt();
				System.out.println("------------------------------");

				result = db.getAdd(id, name, age);
				if(result == 1) {
					System.out.println("\nSave Complete!\n");
				}else {
					System.out.println("\nFailed to Save");
					System.out.println(": '"+id+"' is already registered./n");
				}
				break;
			case 3:
				System.out.println("--------Edit Member List-------");
				System.out.println("Input User Id : ");
				id = input.next();				
							
				System.out.println("Input New Id : ");
				id = input.next();
				System.out.println("Input New Name : ");
				name = input.next();
				System.out.println("Input New Age  : ");
				age = input.nextInt();
				System.out.println("------------------------------");
				
				result = db.getModify(id, name, age);
				if(result == 1)
				{
				System.out.println("\nEdit Complete!\n");
				}else {
					System.out.println("\nFailed to Modify\n");
					System.out.println("\nThere is no registered Information.\n");
				}
	
							
				break;
			case 4:
				System.out.println("-------Delete Member List-------");
				System.out.println("Input User Id : ");
				id = input.next();
				result = db.getDelete(id);
				if(result == 1) {
					System.out.println("\nDelete Complete!\n");
				}else {
					System.out.println("\nFailed to Delete");
					System.out.println(": There is no registered Information.\n");
				}				
				break;
			case 5: bool = false; break;
				default : System.out.println("Only 1~6");
			}
		
		}
	}
	
}
