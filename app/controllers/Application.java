package controllers;

import play.*;
import play.data.validation.Required;
import play.mvc.*;
import play.mvc.results.Result;

import java.util.*;

import models.*;

public class Application extends Controller {
	
    public static void index() {
        render();
    }
	
    public static void bye(){
    	render();
    }
    //不添加的验证
    public static void sayHello(String myName){
    	render(myName);
    }
  //验证名称不能为空
   /* public static void sayHello(@Required String myName){
    	if(validation.hasErrors()){
    		flash.error("Oops,please enter your name!");
    		index();
    	}
    	render(myName);
    }*/
	
    
}