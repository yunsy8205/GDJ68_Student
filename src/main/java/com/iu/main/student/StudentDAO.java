package com.iu.main.student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.iu.main.util.DBConnector;

public class StudentDAO {
	
	//상품 N개 조회
		//bankBookSearch
		public ArrayList<StudentDTO> studentSearch(StudentDTO studentDTO) throws Exception{
			ArrayList<StudentDTO> ar = new ArrayList<StudentDTO>();
			//1. DB 연결
			Connection con = DBConnector.getConnection();
			//2. query123
			String sql = "SELECT * FROM STUDENTS WHERE NAME LIKE ? ORDER BY NUM DESC";//내림차순
			//3. 미리보내기
			PreparedStatement st = con.prepareStatement(sql);
			//4. ?값 세팅
			st.setString(1, "%"+studentDTO.getStudName()+"%");
			
			//5. 최종 전송 및 결과 처리

			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				studentDTO = new StudentDTO();
				studentDTO.setStudNum(rs.getLong("NUM"));
				studentDTO.setStudName(rs.getNString("NAME"));
				studentDTO.setStudKor(rs.getInt("KOR"));
				studentDTO.setStudEng(rs.getInt("ENG"));
				studentDTO.setStudMath(rs.getInt("MATH"));
				studentDTO.setStudTotal(rs.getInt("TOTAL"));
				studentDTO.setStudAvg(rs.getDouble("AVG"));
				ar.add(studentDTO);	
			}
			DBConnector.disConnect(rs, st, con);
			
			return ar;
			
		}
		
		//상품 N개 조회
		public ArrayList<StudentDTO> studentList() throws Exception{
			ArrayList<StudentDTO> ar = new ArrayList<StudentDTO>();
			//1. DB 연결
			Connection con = DBConnector.getConnection();
			//2. query
			String sql = "SELECT * FROM STUDENTS ORDER BY NUM DESC";//내림차순
			//3. 미리보내기
			PreparedStatement st = con.prepareStatement(sql);
			//4. ?세팅
			//5. 최종 전송 및 결과 처리

			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				StudentDTO studentDTO = new StudentDTO();
				
				studentDTO.setStudNum(rs.getLong("NUM"));
				studentDTO.setStudName(rs.getNString("NAME"));
				studentDTO.setStudKor(rs.getInt("KOR"));
				studentDTO.setStudEng(rs.getInt("ENG"));
				studentDTO.setStudMath(rs.getInt("MATH"));
				studentDTO.setStudTotal(rs.getInt("TOTAL"));
				studentDTO.setStudAvg(rs.getDouble("AVG"));
				ar.add(studentDTO);	
				
			}
			
			DBConnector.disConnect(rs, st, con);
			
			return ar;
			
		}
	
	//학생 1명 조회
	public StudentDTO studentDetail(StudentDTO studentDTO) throws Exception{
		//1. DB 연결
		Connection con = DBConnector.getConnection();
		
		//2.query
		String sql ="SELECT * FROM STUDENTS WHERE NUM=?";
		
		//3. 미리 전송
		PreparedStatement st = con.prepareStatement(sql);
		
		//4. ?값 세팅
		st.setLong(1, studentDTO.getStudNum());
		
		//5. 최종 전송 및 결과 처리
		ResultSet rs = st.executeQuery();
		
		// next() : cursor 한줄읽기(커서) (무조건 한줄씩 읽어서 처리), 한줄 읽고 오라는 의미 -> true 또는 false
		// 그 결과물을 rs에 담음
		if(rs.next()) {
			//매개변수로 받은 DTO 재활용
			studentDTO.setStudNum(rs.getLong("NUM"));
			studentDTO.setStudName(rs.getNString("NAME"));
			studentDTO.setStudKor(rs.getInt("KOR"));
			studentDTO.setStudEng(rs.getInt("ENG"));
			studentDTO.setStudMath(rs.getInt("MATH"));
			studentDTO.setStudTotal(rs.getInt("TOTAL"));
			studentDTO.setStudAvg(rs.getDouble("AVG"));
			
		}else {
			studentDTO=null;
			
		}
		
		DBConnector.disConnect(rs, st, con);
		return studentDTO; 
		
	}
	
	//delete
		public int studentDelete(StudentDTO studentDTO) throws Exception {
			//1. DB 연결
			Connection con = DBConnector.getConnection();
			//2. query문 작성
			String sql="DELETE STUDENTS WHERE NUM=?";
			//3. 미리 전송
			PreparedStatement st = con.prepareStatement(sql);
			//4. ?값 세팅
			st.setLong(1, studentDTO.getStudNum());
			//5. 최종전송 및 결과 처리
			int result = st.executeUpdate(); //result가 1이상이면 성공 아니면 실패
			
			System.out.println("DB Delete");
			
			DBConnector.disConnect(st, con);
			
			return result;
		}
		
	public int studentAdd(StudentDTO studentDTO) throws Exception {
		//1. DB 연결
		Connection con = DBConnector.getConnection();
		//2. 쿼리문 작성
		String sql="INSERT INTO STUDENTS VALUES (STUDENT_SEQ.NEXTVAL,?,?,?,?,?,?)";
		
		//3. 쿼리문 미리 전송
		PreparedStatement st = con.prepareStatement(sql);
		
		//4.?값 세팅
		st.setString(1, studentDTO.getStudName());
		st.setInt(2, studentDTO.getStudKor());
		st.setInt(3, studentDTO.getStudEng());
		st.setInt(4, studentDTO.getStudMath());
		st.setInt(5, studentDTO.getStudTotal());
		st.setDouble(6, studentDTO.getStudAvg());
		
		//5. 최종 전송 및 결과 처리
		int result = st.executeUpdate(); //result가 1이상이면 성공 아니면 실패
		
		System.out.println("DB에 insert");
		
		DBConnector.disConnect(st, con);
		
		return result;
		
	}

}