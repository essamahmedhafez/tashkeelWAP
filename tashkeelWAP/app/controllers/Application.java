package controllers;

import play.*;
import play.mvc.*;
import play.data.*;
import static play.data.Form.*;

import models.*;
import views.html.*;

public class Application extends Controller {

	public static Result index() {
	      return redirect(
            routes.Application.login()
        );
	}

  public static Result login() {
        return ok(
            login.render(Form.form(Login.class))
        );
    }

public static Result authenticate() {
    Form<Login> loginForm = Form.form(Login.class).bindFromRequest();
    if (loginForm.hasErrors()) {
        return badRequest(login.render(loginForm));
    } else {
        session().clear();
        session("email", loginForm.get().email);
        return redirect(
            routes.Application.index()
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

    public String email;
    public String password;

public String validate() {
    if (Hinter.authenticate(email, password) == null) {
      return "Invalid user or password";
    }
    return null;
}
}

}

