package com.iu.main.student;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentController {
	StudentDAO studentDAO = new StudentDAO();
	StudentDTO studentDTO = new StudentDTO();
	StudentInput studentInput = new StudentInput();
	StudentOutput studentOutput = new StudentOutput();
	ArrayList<StudentDTO> ar = new ArrayList<StudentDTO>();
	
	public void Controller() throws Exception{
		Scanner sc = new Scanner(System.in);
		System.out.println("1. 학생정보 등록");
		System.out.println("2. 학생정보 조회");
		System.out.println("3. 학생정보 삭제");
		System.out.println("4. 학생전체 조회");
		System.out.println("5. 학생검색 조회");
		System.out.println("6. 프로그램 종료");
		int select = sc.nextInt();
		
		switch(select) {
		case 1:
			studentDTO = studentInput.studentAdd(); 
			select = studentDAO.studentAdd(studentDTO);
			
			if(select > 0) {
				studentOutput.view("등록성공");
			}else {
				studentOutput.view("등록실패");
			}
			break;
		case 2:
			studentDTO = studentInput.studentDetail();
			studentDTO = studentDAO.studentDetail(studentDTO);
			studentOutput.view(studentDTO);
			
			break;
		case 3:                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        
			studentDTO = studentInput.studentDelete(); 
			select = studentDAO.studentAdd(studentDTO);
			
			if(select > 0) {
				studentOutput.view("삭제성공");
			}else {
				studentOutput.view("삭제실패");
			}
			break;
		case 4:
			ar = studentDAO.studentList();
			
			break;
		case 5:
			break;
		default:
			System.out.println("프로그램 종료");
			break;
		}
	}

}
