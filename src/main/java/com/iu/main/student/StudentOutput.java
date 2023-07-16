package com.iu.main.student;

import java.util.ArrayList;

public class StudentOutput {
	
	public void view(StudentDTO studentDTO) {
		System.out.println(studentDTO.getStudNum());
		System.out.println(studentDTO.getStudName());
		System.out.println(studentDTO.getStudKor());
		System.out.println(studentDTO.getStudEng());
		System.out.println(studentDTO.getStudTotal());
		System.out.println(studentDTO.getStudAvg());
	}
	
	public void vies(ArrayList<StudentDTO> ar) {
		
		for(int i=0; i<ar.size();i++) {
			this.view(ar.get(i));
		}
	}
	
	public void view(String str) {//성공, 실패
		System.out.println("Result : "+str);
	}

}