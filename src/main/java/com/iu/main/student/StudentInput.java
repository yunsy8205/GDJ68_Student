package com.iu.main.student;
import java.util.Scanner;

public class StudentInput {
	
	private Scanner sc;
	StudentDTO studentDTO = new StudentDTO();
	
	public StudentInput() {
		this.sc = new Scanner(System.in);
	}
	
	public StudentDTO studentAdd() {
		System.out.println("이름을 입력하세요.");
		studentDTO.setStudName(sc.next());
		System.out.println("국어점수를 입력하세요.");
		studentDTO.setStudKor(sc.nextInt());
		System.out.println("영어점수를 입력하세요.");
		studentDTO.setStudEng(sc.nextInt());
		System.out.println("수학점수를 입력하세요.");
		studentDTO.setStudMath(sc.nextInt());
		studentDTO.setStudTotal();
		studentDTO.setStudAvg();
		
		return studentDTO;
	}
	
	public StudentDTO studentDelete() {
		System.out.println("삭제할 번호를 입력하세요.");
		studentDTO.setStudNum(sc.nextLong());
		
		return studentDTO;
	}
	
	public StudentDTO studentDetail() {
		System.out.println("조회할 번호를 입력하세요.");
		studentDTO.setStudNum(sc.nextLong());
		
		return studentDTO;
	}
	
	public StudentDTO studentSearch() {
		System.out.println("조회할 이름를 입력하세요.");
		studentDTO.setStudName(sc.next());
		
		return studentDTO;
	}

}