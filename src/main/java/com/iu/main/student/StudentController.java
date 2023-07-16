package com.iu.main.student;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentController {
	
	public void Controller() throws Exception{
		StudentDAO studentDAO = new StudentDAO();
		StudentDTO studentDTO = new StudentDTO();
		StudentInput studentInput = new StudentInput();
		StudentOutput studentOutput = new StudentOutput();
		ArrayList<StudentDTO> ar = new ArrayList<StudentDTO>();
		
		boolean flag = true;
		
		while(flag) {
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
				
				if(studentDTO != null) {
					studentOutput.view(studentDTO);	
				}else {
					studentOutput.view("조회되지 않습니다.");
				}
				break;
			case 3:                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        
				studentDTO = studentInput.studentDelete(); 
				select = studentDAO.studentDelete(studentDTO);
				
				if(select > 0) {
					studentOutput.view("삭제성공");
				}else {
					studentOutput.view("삭제실패");
				}
				break;
			case 4:
				ar = studentDAO.studentList();
				studentOutput.view(ar);
				break;
			case 5:
				studentDTO =  studentInput.studentSearch();
				ar = studentDAO.studentSearch(studentDTO);
				if(ar.size() != 0) {
					studentOutput.view(ar);
				}else {
					studentOutput.view("조회되지 않습니다.");
				}
				break;
			default:
				System.out.println("프로그램 종료");
				flag = false;
				break;
			}
		}
	}

}
