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



=======
>>>>>>> 1c88b459f5ea254dcdc1035db0a66795be4cf214
public static Result authenticate() {
  DynamicForm requestData = Form.form().bindFromRequest();
  //Form<Login> loginForm = form(Login.class).bindFromRequest();
   if (requestData.hasErrors()) {
        return badRequest();//login.render(loginForm)
    } else {
        session().clear();
        session("email", requestData.get("email"));
<<<<<<< HEAD
        String email = requestData.get("email");     
        String password = requestData.get("password");
        //get user
        User temp = User.find.byId(email);
        Integer score = temp.score;
=======

        String email = requestData.get("email"); 
        String password = requestData.get("password");
        //get user
        User temp = User.find.byId(email);
        System.out.println(temp);
        Integer score = temp.score;
        
>>>>>>> 1c88b459f5ea254dcdc1035db0a66795be4cf214
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
<<<<<<< HEAD
   
=======

  public static Result newRound(String email, Integer score) {
        List<Words> words = Words.find.all();
        int randomImage = (int) ((((Math.random()*100))%(words.size())) + 1);
        Words word = Words.find.byId(randomImage);
        Integer wordID = word.id;
        return ok(user.render(email,score,wordID,Form.form(Words.class)));
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
>>>>>>> 1c88b459f5ea254dcdc1035db0a66795be4cf214
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
      List<Digitization> digitizations = Digitization.find.all();
      Object [] d = digitizations.toArray();
      for(int i=0;i<d.length;i++){
        Digitization digitization = (Digitization) d[i];
        if(digitization.wordID == wordID && digitization.hinterID == 0){ //&& sessionno = sessiono
          //insert 3latool
          Signs s = new Signs(digitization.sessionNum,wordID,User.find.byId(email).id);
          if(tanween_maksoor != null){
            s.tanween_maksoor =1 ;
          }
          if(kasra != null){
            s.kasra =1 ;
          }
          if(tanween_madmoom != null){
            s.tanween_madmoom =1 ;
          }
          if(damma != null){
            s.damma =1 ;
          }
          if(tanween_maftoo7 != null){
            s.tanween_maftoo7 =1 ;
          }
          if(fat7a != null){
            s.fat7a =1 ;
          }
          if(sekon != null){
            s.sekon =1 ;
          }
          if(shadda != null){
            s.shadda =1 ;
          }
          s.save();
          return ok(user.render(email,score,wordID,Form.form(Words.class)));
        }
      }
      Digitization newDigi = new Digitization(wordID);
      newDigi.hinterID = User.find.byId(email).id;
      newDigi.save();
      Signs s = new Signs(newDigi.sessionNum,wordID,User.find.byId(email).id);
          if(tanween_maksoor != null){
            s.tanween_maksoor =1 ;
          }
          if(kasra != null){
            s.kasra =1 ;
          }
          if(tanween_madmoom != null){
            s.tanween_madmoom =1 ;
          }
          if(damma != null){
            s.damma =1 ;
          }
          if(tanween_maftoo7 != null){
            s.tanween_maftoo7 =1 ;
          }
          if(fat7a != null){
            s.fat7a =1 ;
          }
          if(sekon != null){
            s.sekon =1 ;
          }
          if(shadda != null){
            s.shadda =1 ;
          }
          s.save();
      return ok(user.render(email,score,wordID,Form.form(Words.class)));
    }

	public static Result sendSecondHelp(String email, int score, Integer wordID) {
      DynamicForm requestData = Form.form().bindFromRequest();
      String nSigns = requestData.get("noOfSigns");
      List<Digitization> digitizations = Digitization.find.all();
      Object [] d = digitizations.toArray();
      System.out.println(d.length + " l");
       for(int i=0;i<d.length;i++){
        Digitization digitization = (Digitization) d[i];
        if(digitization.wordID == wordID && digitization.hinterID == User.find.byId(email).id){
          digitization.noOfSigns = Integer.parseInt(nSigns);
          digitization.save();
        }
       }
      return ok(user.render(email,score,wordID,Form.form(Words.class)));
    }

  	public static Result sendThirdHelp(String email, int score, Integer wordID) {
      DynamicForm requestData = Form.form().bindFromRequest();
      String francoSent = requestData.get("franco");
      List<Digitization> digitizations = Digitization.find.all();
      Object [] d = digitizations.toArray();
       for(int i=0;i<d.length;i++){
        Digitization digitization = (Digitization) d[i];
        if(digitization.wordID == wordID && digitization.hinterID == User.find.byId(email).id){
          digitization.franco = francoSent;
          digitization.save();
        }
       }
       return newRound(email,score);
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

