package designpatterns;

import model.Person;
import model.Student;
import model.User;

/**
 * @author zhangyi
 *
 * TODO  工厂模式
 */
public class PeopleFactory {
	public static Person getStudent(){
		return new Student();
	}
	public static Person getUser(){
		return new User();
	}
}
