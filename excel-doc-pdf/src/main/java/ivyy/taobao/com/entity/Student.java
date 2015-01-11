package ivyy.taobao.com.entity;

import java.io.Serializable;

/**
 *@DEMO:excel-doc-pdf
 *@Java：Student.java
 *@Date:2015-1-10下午10:37:54
 *@Author:liangjilong
 *@Email:jilongliang@sina.com
 *@Weibo:http://weibo.com/jilongliang
 *@Version:1.0
 *@Description：
 */
@SuppressWarnings("all")
public class Student implements Serializable{
	private String name;//用户名
	private String gender;//性别
	private int age;//年龄
	private String classz;//班级
	private int score;//得分
	public Student() {
		super();
	}
	public Student(String name, String gender, int age, String sclass, int score) {
		super();
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.classz = sclass;
		this.score = score;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getClassz() {
		return classz;
	}
	public void setClassz(String classz) {
		this.classz = classz;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	
	@Override
	public String toString() {
		return "Student [age=" + age + ", gender=" + gender + ", name=" + name
				+ ", sclass=" + classz + ", score=" + score + "]";
	}
}