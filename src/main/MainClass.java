package main;

import java.util.Scanner;
import jieun.Mem_jieun;
import Kimhs.KHS_method;


public class MainClass {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input = 0;
		
		while(true) {
			System.out.println("1.박상진");
			System.out.println("2.김여진");
			System.out.println("3.이동호");
			System.out.println("4.김형석");
			System.out.println("5.문지은");
			System.out.println("6.박선영");
			
			input = sc.nextInt(); sc.nextLine();
			
			switch (input) {
			case 1: break;
			case 2: break;
			case 3: break;
			case 4:
				KHS_method hs = new KHS_method();
				hs.display();
				break;
			case 5:
				Mem_jieun mem = new Mem_jieun();
				mem.display();
				break;
			case 6: break;
			case 7: System.exit(0); break;
			default:
				System.out.println("only 1~7.");
				break;
			}
		}
	}
}
