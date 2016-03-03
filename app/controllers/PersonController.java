package controllers;

import java.util.ArrayList;
import java.util.List;

import models.Person;
import play.data.validation.Required;
import play.mvc.Controller;

public class PersonController extends Controller {
	
	
	public static void delu() {
	        render();
	}
	
	//登录
	public static  void denglu(@Required String name,@Required String password){
		//验证不为空
		if(validation.hasErrors()){
			flash.error("Oops,please enter your name!");
			delu();
		}
		List<Person> list =  Person.findAll();
		//验证是否正确
		for (int i = 0; i < list.size(); i++) {
			Person person = list.get(i);
			if(!name.equals(person.name) || !password.equals(person.password)){
				flash.error("name or password is wrong!");
				delu();
			}else{
				find();
			}
		}
	}
	
	//获取Person列表
	public static  void find(){
		List<Person> list =  Person.findAll();
			render(list);
	}
	//新增一个用户
	public static void add(){
		render();
	}
	public static void addPerson(String name,String sex,String age,String password){
		Person person =  new Person();
		person.name = name;
		person.sex = sex;
		person.age = age;
		person.password = password;
		person.save();
		find();
	}
	
	//删除一个用户
	public static void delete(Long id){
		Person person = Person.findById(id);
		person.delete();
		find();
	}
	
	//修改一个用户前的准备(查找到一个用户)
	public static void update(Long id){
		Person person = Person.findById(id);
		render(person);
	}
	public static void updatePerson(Long id,String name,String sex,String age,String password){
		Person person = Person.findById(id);
		person.name=name;
		person.sex =sex;
		person.age = age;
		person.password = password;
		person.save();
		find();
	}
	
	/*//模糊查询
	public static void query(String name){
		String sql = "select * from person where name like %"+name+"%";
		
		Person.find(sql, name);
		List<Person> list = (List)Person.find(sql);
		render(list);
	}*/
}
