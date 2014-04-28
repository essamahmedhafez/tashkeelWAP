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
      return ok(login.render(Form.form(Login.class)));
	}

  public static Result login() {
      List<Words> words = Words.find.all();
      return ok(login.render(Form.form(Login.class)));
    }

<<<<<<< HEAD

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
        System.out.println(temp);
        Integer score = temp.score;
        
        //get word
        List<Words> words = Words.find.all();
        int randomImage = (int) ((((Math.random()*100))%(words.size())) + 1);
        Words word = Words.find.byId(randomImage);
        //for testing reasons
        //this.wordStatic = word;
        Integer wordID = word.id;
        if(temp.solver == false){
          temp.solver = true;
        return ok(user.render(email,score,wordID,Form.form(Words.class)));
      }else{
        temp.solver = false;
        return ok(solver.render(email,score,word.word));
      }

    }
}

  public static Result newRound(String email, Integer score, Integer wordID) {
        List<Words> words = Words.find.all();
        int randomImage = (int) ((((Math.random()*100))%(words.size())) + 1);
        Words word = Words.find.byId(randomImage);
        Integer wordID2 = word.id;
        return ok(user.render(email,score,wordID2,Form.form(Words.class)));
  }
    /*
    public static Result solver(){
      List<Words> = allWords = Words.find.all();
      int randomWordInt = (int) ((Math.random()*100))%(allWords.size());
      Words wordString = this.wordStatic;
      String theWord = wordString.word;
      return ok(views.html.solver.render(this.email,this.score,theWord));
    }
*/
    public static Result user(String email, Integer score, Integer wordID) {//int id
    	//User user = User.findById(id);
    	return ok(user.render(email,score,wordID,Form.form(Words.class)));
  	}
  	

    public static Result sendFirstHelp(String email, int score, Integer wordID) {
      DynamicForm requestData = Form.form().bindFromRequest();
      String tanween_maksoor = requestData.get("tanween_maksoor");
      String kasra = requestData.get("kasra");
      String tanween_madmoom = requestData.get("tanween_madmoom");
      String damma = requestData.get("damma");
      String tanween_maftoo7 = requestData.get("tanween_maftoo7");
      String fat7a = requestData.get("fat7a");
      String sekon = requestData.get("sekon");
      String shadda = requestData.get("shadda");
      // if null, not checked, else checked.
      Signs s = new Signs(wordID,email);
          if(tanween_maksoor != null){
            s.tanween_maksoor = true ;
          }
          if(kasra != null){
            s.kasra =true ;
          }
          if(tanween_madmoom != null){
            s.tanween_madmoom =true ;
          }
          if(damma != null){
            s.damma =true;
          }
          if(tanween_maftoo7 != null){
            s.tanween_maftoo7 =true ;
          }
          if(fat7a != null){
            s.fat7a =true;
          }
          if(sekon != null){
            s.sekon =true ;
          }
          if(shadda != null){
            s.shadda =true ;
          }
          s.save();
      return ok(user.render(email,score,wordID,Form.form(Words.class)));
    }

	public static Result sendSecondHelp(String email, int score, Integer wordID) {
      DynamicForm requestData = Form.form().bindFromRequest();
      String nSigns = requestData.get("noOfSigns");
      
      List<Signs> signs = Signs.find.all();
      Object [] o = signs.toArray();
       System.out.println(o.length);
       for(int i=0;i<o.length;i++){
        Signs s = (Signs) o[i];
        if(s.word_id == wordID && s.hinter_email.equals(email)){
          s.noOfSigns = Integer.parseInt(nSigns);
          s.save();
        }
       }
      return ok(user.render(email,score,wordID,Form.form(Words.class)));
    }

  	public static Result sendThirdHelp(String email, int score, Integer wordID) {
      DynamicForm requestData = Form.form().bindFromRequest();
      String francoSent = requestData.get("franco");
      List<Signs> signs = Signs.find.all();
      Object [] o = signs.toArray();
       for(int i=0;i<o.length;i++){
        Signs s = (Signs) o[i];
        if(s.word_id == wordID && s.hinter_email.equals(email)){
          s.franco = francoSent;
          s.save();
        }
       }
       return newRound(email,score,wordID);
      //return ok(user.render(email,score,wordID,Form.form(Words.class)));
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

