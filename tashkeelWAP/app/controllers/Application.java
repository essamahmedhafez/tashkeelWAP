package controllers;

import play.*;
import play.mvc.*;
import play.data.*;
import static play.data.Form.*;
import models.*;
import views.html.*;
import play.db.*;
import play.api.*;

public class Application extends Controller {

	
	static User h = new User("b@a.com","a","a");
  static Words w = new Words("مدرسه","images/ImageSample.png");

  public static Result index() {
      //return redirect(routes.Application.login());
      //h.save();
      //w.save();
       return ok(login.render(Form.form(Login.class)));
	}

  public static Result login() {
        return ok(login.render(Form.form(Login.class)));
    }


public static Result authenticate() {
  DynamicForm requestData = Form.form().bindFromRequest();
   if (requestData.hasErrors()) {
        return badRequest();//login.render(loginForm)
    } else {
        session().clear();
        session("email", requestData.get("email"));


        String email = requestData.get("email");
        
        String password = requestData.get("password");
        User temp = User.find.byId(email);
        Words word = Words.find.byId(1);
        Integer score = temp.score;
        Integer wordID = word.id;
        return ok(user.render(email,score,wordID));
    }
}

    public static Result user(String email, Integer score, Integer wordID) {//int id
    	//User user = User.findById(id);
    	return ok(user.render(email,score,wordID));
  	}
  	

    public static Result firstHelp() {
      return ok();
    }


  	public static Result sendThirdHelp() {
      //request().email();
      DynamicForm requestData = Form.form().bindFromRequest();
      //Form<Task> taskForm = form(Task.class).bindFromRequest();
      
      return ok(login.render(Form.form(Login.class)));
    }

public static class Login {

    public String email;
    public String password;

  public String validate() {
      if (User.authenticate(email, password) == null) {
        return "Invalid user or password";
      }
      return null;
  }
}

}

