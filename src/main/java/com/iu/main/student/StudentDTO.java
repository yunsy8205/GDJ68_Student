package com.iu.main.student;

public class StudentDTO {
	//컬럼명과 변수명은 동일하게
	
	private long studNum;
	private String studName;
	private int studKor;
	private int studEng;
	private int studMath;
	private int studTotal;
	private double studAvg;
	
	public void setStudTotal() {
		this.studTotal = studKor+studEng+studMath;
	}
	public void setStudAvg() {
		this.studAvg = studTotal/3.0;
	}
	public void setStudTotal(int total) {
		this.studTotal = total;
	}
	public void setStudAvg(double avg) {
		this.studAvg = avg;
	}
	public long getStudNum() {
		return studNum;
	}
	public int getStudTotal() {
		return studTotal;
	}
	public double getStudAvg() {
		return studAvg;
	}
	public void setStudNum(long studNum) {
		this.studNum = studNum;
	}
	public String getStudName() {
		return studName;
	}
	public void setStudName(String studName) {
		this.studName = studName;
	}
	public int getStudKor() {
		return studKor;
	}
	public void setStudKor(int studKor) {
		this.studKor = studKor;
	}
	public int getStudEng() {
		return studEng;
	}
	public void setStudEng(int studEng) {
		this.studEng = studEng;
	}
	public int getStudMath() {
		return studMath;
	}
	public void setStudMath(int studMath) {
		this.studMath = studMath;
	}

}