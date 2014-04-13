package controllers;

import play.*;
import play.mvc.*;
import play.data.*;
import static play.data.Form.*;

import models.*;
import views.html.*;

public class Application extends Controller {

	public static Result index() {
	   return ok(index.render(form(Login.class)));
	}

public static Result authenticate() {
    Form<Login> loginForm = form(Login.class).bindFromRequest();
    if (loginForm.hasErrors()) {
        return badRequest(index.render(loginForm));
    } else {
        session().clear();
        session("name", loginForm.get().name);
        return redirect(
            routes.Application.hinter()
        );
    }
}


    public static Result hinter() {//int id
    	//Hinter hinter = Hinter.findById(id);
    	return ok("","");
  	}

  	
  	
  	public static void firstHelp() {
        
    }

public static class Login {

    public String name;
    //public String password;

    public String validate() {
    if (Hinter.authenticate(name) == null) {
      return "Invalid user or password";
    }
    return null;
}

}

}

