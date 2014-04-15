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
		Hinter h = new Hinter("b@a.com","a","a");
		//h.save();
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
        String email = loginForm.get().email;
        Hinter temp = Hinter.find.byId(email);
        //Words word = Words.find.byId(1);
        Integer score = temp.score;
        //return redirect(
        //    routes.Application.hinter()
       // );
        return ok(hinter.render(email,score,""));
    }
}

    public static Result hinter(String email, Integer score, String image) {//int id
    	//Hinter hinter = Hinter.findById(id);

    	return ok(hinter.render(email,score,image));
  	}
  	
  	public static Result solver(String email, Integer score, String image){
  		return ok(solver.render(email,socre,image));
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

