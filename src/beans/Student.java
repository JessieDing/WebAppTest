package beans;

import java.util.ArrayList;
import java.util.List;

/**
 * @classname:Student
 * @Description:TODO
 * @author admin
 * @Date:2017年5月18日下午5:10:43
 */

public class Student {
	String name;
	int age;
	List<String> fav;

	public Student() {
		super();
		System.out.println("Student()");
		fav = new ArrayList<>();
		fav.add("music");
		fav.add("fishing");
		fav.add("football");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<String> getFav() {
		return fav;
	}

	public void setFav(List<String> fav) {
		this.fav = fav;
	}

	public boolean getValid() {
		if (age >= 18) {
			return true;
		} else {
			return false;
		}
	}
}
