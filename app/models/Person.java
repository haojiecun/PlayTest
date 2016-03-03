package models;

import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity
public class Person extends Model{
	public String name;
	public String sex;
	public String age;
	public String password;
}
