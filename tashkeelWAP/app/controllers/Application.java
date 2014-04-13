package controllers;

import play.*;
import play.mvc.*;
import play.data.*;
import static play.data.Form.*;
import models.*;
import views.html.*;
import play.db.*;

public class Application extends Controller {
	static Form<Login> loginForm = Form.form(Login.class);
	public static Result index() {
	    return redirect(routes.Application.login());
	}

  public static Result login() {
        return ok(
            login.render(Form.form(Login.class))
        );
    }

public static Result authenticate() {

	Form<Login> loginForm2 = loginForm.bindFromRequest();
    if (loginForm2.hasErrors()) {
        return badRequest(login.render(loginForm));
    } else {
        session().clear();
        session("email", loginForm.get().email);
        String e = loginForm.get().email;
        //return redirect(
        //    routes.Application.hinter()
       // );
        return ok(hinter.render(e));
    }
}

    public static Result hinter(String email) {//int id
    	//Hinter hinter = Hinter.findById(id);
    	return ok();
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

