package controllers;

import play.*;
import play.mvc.*;
import play.data.*;
import static play.data.Form.*;
import models.*;
import views.html.*;
import play.db.*;
import play.api.*;
import java.util.*;
import javax.persistence.*;

public class Application extends Controller {

//static Digitization d = new Digitization(1,2,"menna");	
//	static User h = new User("a@a.com","a","a");
  //static Words w = new Words("مدرسه","images/ImageSample.png");
  static boolean init = false;
  static String email = "";
  static Words wordStatic = null;
  static Integer score = 0;
  static boolean solverOrHinter = false;//Solver = true, Hinter = false;


  public static Result index() {
      //return redirect(routes.Application.login());

      return ok(login.render(Form.form(Login.class)));
	}

  public static Result login() {
       //d.save();
  	   // h.save();
      //w.save();
      //initializeDB();

List<Words> words = Words.find.all();
        

      return ok(login.render(Form.form(Login.class)));
    }


    public static void initializeDB(){
      if(!init){
        for(int i=1;i<=55;i++){
          Words w = new Words (i,"","images/"+i+".jpg");
          w.save();
          Digitization d = new Digitization(i,w.id,w.word);
          d.save();
          User h = new User(i,i+"@a.com",i+"",i+"");
          h.save();
        }
        init = true;
       }
    }


public static Result addTashkeel(String email, Integer score, String wordHTML, Integer wordID, Integer sessionNum){

  DynamicForm requestData = Form.form().bindFromRequest();
  if(requestData.hasErrors()){
    return badRequest();
   } else{
      session().clear();
      String digitalWord = requestData.get("digitization");
      Words word = Words.find.byId(wordID);
      Digitization digitizedWord = Digitization.find.byId(sessionNum);
      digitizedWord.digitization = digitalWord;
      digitizedWord.save();
      return ok(solver.render(email,score,wordHTML,Form.form(Digitization.class),wordID,sessionNum));

    }

}



public static Result authenticate() {
  DynamicForm requestData = Form.form().bindFromRequest();
  //Form<Login> loginForm = form(Login.class).bindFromRequest();
   if (requestData.hasErrors()) {
        return badRequest();//login.render(loginForm)
    } else {
        session().clear();
        session("email", requestData.get("email"));
        String email = requestData.get("email");     
        String password = requestData.get("password");
        //get user
        User temp = User.find.byId(email);
        Integer score = temp.score;
        //get word
        List<Words> words = Words.find.all();
        int randomImage = (int) ((((Math.random()*100))%(words.size())) + 1);
        Words word = Words.find.byId(randomImage);
        Integer wordID = word.id;
        if(temp.solver == false){
          temp.solver = true;
        return ok(user.render(email,score,wordID,Form.form(Words.class)));
      }else{
        temp.solver = false;
        return ok(solver.render(email,score,word.word,wordID));
      }

    }
}
   
    public static Result user(String email, Integer score, Integer wordID) {//int id
    	//User user = User.findById(id);
    	return ok(user.render(email,score,wordID,Form.form(Words.class)));
  	}
  	

    public static Result sendFirstHelp(String email, int score, Integer wordID) {
      DynamicForm requestData = Form.form().bindFromRequest();
      String checked1 = requestData.get("Checkbox1");
      String checked2 = requestData.get("Checkbox2");
      String checked3 = requestData.get("Checkbox3");
      String checked4 = requestData.get("Checkbox4");
      String checked5 = requestData.get("Checkbox5");
      String checked6 = requestData.get("Checkbox6");
      String checked7 = requestData.get("Checkbox7");
      String checked8 = requestData.get("Checkbox8");
      // if null, not checked, else checked.
      return ok(user.render(email,score,wordID,Form.form(Words.class)));
    }

	public static Result sendSecondHelp(String email, int score, Integer wordID) {
      DynamicForm requestData = Form.form().bindFromRequest();
      String nSigns = requestData.get("noOfSigns");
      Digitization digitization = Digitization.find.byId(wordID);
      digitization.noOfSigns = Integer.parseInt(nSigns);
      digitization.save();
      return ok(user.render(email,score,wordID,Form.form(Words.class)));
    }

  	public static Result sendThirdHelp(String email, int score, Integer wordID) {
      DynamicForm requestData = Form.form().bindFromRequest();
      String francoSent = requestData.get("franco");
      Digitization digitization = Digitization.find.byId(wordID);
      digitization.franco = francoSent;
      digitization.save();
      return ok(user.render(email,score,wordID,Form.form(Words.class)));
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

