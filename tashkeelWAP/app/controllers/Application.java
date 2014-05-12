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

  static boolean init = false;
  static String email = "";
  static Words wordStatic = null;
  static Integer score = 0;

  public static Result index() {
      return ok(login.render(Form.form(Login.class),""));
	}

  public static Result login() {
      List<Words> words = Words.find.all();
      return ok(login.render(Form.form(Login.class),""));
  }

  public static Result register() {
      return ok(register.render("",Form.form(Register.class)));
  }

  public static Result requestHint(Integer session_num, String email,String username, Integer score, String wordHTML, Integer wordID){
    DynamicForm requestData = Form.form().bindFromRequest();
      if(requestData.hasErrors()){
      return badRequest();
      } else{
         Round current_round = Round.find.byId(session_num);
         if(!current_round.first_hint_requested){
            current_round.first_hint_requested = true;
         }else if(!current_round.second_hint_requested){
            current_round.second_hint_requested = true;
         }else if(!current_round.third_hint_requested){
            current_round.third_hint_requested = true;
         }
         current_round.save();
        return ok(solver.render(session_num,email,username,score,wordHTML,Form.form(Digitization.class),wordID,""));
  }
  }

  public static Result roundOverHinter(Integer session_num,String email,String username,Integer score,Integer wordID){
    if(!sendThirdHelp(session_num,email,username,score,wordID)){
        return badRequest(user.render(session_num, email,username,score,wordID,Form.form(Words.class)));
    }else{
        return ok(roundOver.render(email,username,score));
    }
  }

  public static Result roundOverSolver(Integer session_num,String email,String username,Integer score, 
    String wordHTML, Integer wordID){
    if(!addTashkeel(session_num,email,username,score,wordHTML,wordID)){
       return badRequest(solver.render(session_num,email,username,score,wordHTML,
       Form.form(Digitization.class),wordID,"Please insert a word in the text box"));
    }else{
      return ok(roundOver.render(email,username,score));
    }
  }
  
  public static Result summary(String email,String username,Integer score){
    return ok(roundOver.render(email,username,score));
  }

public static boolean addTashkeel(Integer session_num, String email,String username, Integer score, String wordHTML, Integer wordID){

      boolean result = false;
      DynamicForm requestData = Form.form().bindFromRequest();
      String status = "";
      if(requestData.field("digitization").valueOr("").isEmpty()){
        requestData.reject("digitization","you must insert word in the box");
        status = "Please insert a word in the text box";
      }
      else{
        result = true;
      String digitalWord = requestData.get("digitization");
      Words word = Words.find.byId(wordID);
      Digitization digitizedWord = new Digitization(session_num,wordID, email,digitalWord);
      digitizedWord.save();
    
      User player = User.find.byId(email);
      Round current_round = Round.find.byId(session_num);
        if(current_round.third_hint_requested){
          player.score = player.score+5;            
        }else if(current_round.second_hint_requested){
         player.score = player.score+10;
         }else if(current_round.first_hint_requested){
         player.score = player.score+15;
         }
         else {
            player.score = player.score+20;    
         }
         player.save();
      }
      return result;
    }

public static Result registration() {
  String status = "";
   DynamicForm requestData = Form.form().bindFromRequest();
   

    if(requestData.field("الإسم").valueOr("").isEmpty()){
    requestData.reject("الإسم","You cannot have empty name field");
    status = "Name field is empty";
  }else{

    if(requestData.field("البَريد الإلِكتروني").valueOr("").isEmpty()){
    requestData.reject("البَريد الإلِكتروني","You cannot have empty email field");
    status = "Email field is empty";
  }
}
   if(!requestData.field("كَلِمة السِر").valueOr("").isEmpty()){
          if(!requestData.get("كَلِمة السِر").equals(requestData.get("تأكيد كَلِمة السِر"))){
            requestData.reject("تأكيد كَلِمة السِر","Password doesn't match");
            status = "Password doesn't match";
          }
          
        }


  if(requestData.hasErrors()){
    return badRequest(register.render(
      status,Form.form(Register.class)));
  }else{
        String email = requestData.get("البَريد الإلِكتروني"); 
        String name = requestData.get("الإسم");
        String password = requestData.get("كَلِمة السِر");
        String password2 = requestData.get("تأكيد كَلِمة السِر");
        User newUser = new User(email,name,password);
        newUser.save();
        return ok(login.render(Form.form(Login.class),""));
  }
}

public static Result generateNewData(String email){
  User temp = User.find.byId(email);
  Integer score = temp.score;
  String username = temp.username;
  List<Words> words = Words.find.all();
  int randomImage = (int) ((((Math.random()*100))%(words.size())) + 1);
  Words word = Words.find.byId(randomImage);
  Integer wordID = word.id;
  return synchronize(email, username, score,word, wordID);
}

public static Result authenticate() {
  DynamicForm requestData = Form.form().bindFromRequest();
  String status = "";
  boolean emailExist = true;

  if(requestData.field("البَريد الإلِكتروني").valueOr("").isEmpty() || 
    requestData.field("كَلِمة السِر").valueOr("").isEmpty()){
    requestData.reject("البَريد الإلِكتروني","Empty email or password");
    status = "Empty email or password";
    return badRequest(login.render(Form.form(Login.class),status));

  }
  
  String emailForm = requestData.get("البَريد الإلِكتروني"); 
  String passwordForm = requestData.get("كَلِمة السِر");
  User temp = User.find.byId(emailForm);
  List<User> users = User.find.all();

  if(!emailExist){
    status = "This email doesn't exist";
    requestData.reject("البَريد الإلِكتروني","This email doesn't exist");
  }else{
    if(!(temp.password.equals(passwordForm))){
      status = "Wrong password";
      requestData.reject("كَلِمة السِر","wrong password");
    }
  }

  if (requestData.hasErrors()) {
        return badRequest(login.render(Form.form(Login.class),status));
    } else {
        session().clear();
        session("email", requestData.get("البَريد الإلِكتروني"));
        return generateNewData(emailForm);
    }
}

public static Result synchronize(String email, String username, Integer score, Words word, Integer wordID){
        List<Round> rounds = Round.find.all();
        if(rounds.size() == 0){
          Round new_round = new Round(email,true,wordID);
          new_round.save();
          Integer session_num = new_round.session_num;
          return ok(user.render(session_num, email,username,score,wordID,Form.form(Words.class)));
        }

        Round last_round = rounds.get(rounds.size()-1);
        if(last_round.solver_email == null){ // this is the second player, his turn is to be a solver 
          last_round.solver_email = email;
          last_round.save();
          Integer session_num = last_round.session_num;
            Words current_word = Words.find.byId(last_round.word_id);
          return ok(solver.render(session_num, email,username,score,current_word.word,Form.form(Digitization.class),current_word.id,""));
        }else if(last_round.hinter_email == null){ // this is the second player, his turn is to be a hinter
          last_round.hinter_email = email;
          last_round.save();
          Integer session_num = last_round.session_num;
          return ok(user.render(session_num, email,username,score,last_round.word_id,Form.form(Words.class)));
        }else { //this is the first player - create a new round
          Round new_round;
          if(last_round.hinter_first) { // this new turn the solver should be first
            new_round = new Round(email,false,wordID);
            new_round.save();
            Integer session_num = new_round.session_num;
            return ok(solver.render(session_num, email,username,score,word.word,Form.form(Digitization.class),wordID,""));
          }else { // this new turn the hinter should be first
            new_round = new Round(email,true,wordID);
            new_round.save();
            Integer session_num = new_round.session_num;
            return ok(user.render(session_num, email,username,score,wordID,Form.form(Words.class)));
          }
        }
}
  public static Result newRound(Integer session_num,String email,String username, Integer score, Integer wordID) {
        List<Words> words = Words.find.all();
        int randomImage = (int) ((((Math.random()*100))%(words.size())) + 1);
        Words word = Words.find.byId(randomImage);
        Integer wordID2 = word.id;
        return ok(user.render(session_num, email,username,score,wordID2,Form.form(Words.class)));
  }

    public static Result user(Integer session_num,String email, String username,Integer score, Integer wordID) {
    	return ok(user.render(session_num, email,username,score,wordID,Form.form(Words.class)));
  	}


  	public static Result checkRequestedHints(Integer session_num){
      DynamicForm requestData = Form.form().bindFromRequest();
      Round current_round = Round.find.byId(session_num);
        if(current_round.third_hint_requested && !current_round.third_hint_sent){
          return ok("3");
        }else if(current_round.second_hint_requested && !current_round.second_hint_sent){
          return ok("2");
        }else if(current_round.first_hint_requested && !current_round.first_hint_sent){
          return ok("1");
        }else{
          return ok("");
        }
    }

public static Result viewFirstHint(Integer session_num){
     DynamicForm requestData = Form.form().bindFromRequest();
     Round current_round = Round.find.byId(session_num);
     
      if (current_round.first_hint_sent){
      String hint = "";
      Signs sign = Signs.find.byId(session_num);
      if(sign.damma)
      hint = "ُ" + hint;
      if(sign.fat7a)
      hint = "َ"+ hint;
      if(sign.kasra)
      hint = "ِ"+ hint;
      if(sign.sekon)
      hint = "ْ"+ hint;
      if(sign.shadda)
      hint = "ّ"+ hint;
      if(sign.tanween_maftoo7)
      hint = "ً"+ hint;
      if(sign.tanween_maksoor)
      hint = "ٍ"+ hint;
      if(sign.tanween_madmoom)
      hint = "ٌ"+ hint;

         return ok(hint);
      }
      else {
          return ok("0");
      }  
      
}
public static Result viewSecondHint(Integer session_num){
      DynamicForm requestData = Form.form().bindFromRequest();
     Round current_round = Round.find.byId(session_num);
       
      if (current_round.second_hint_sent){
          Integer noOfSigns = Signs.find.byId(session_num).noOfSigns;
          return ok(" عدد حروف التشكيل المطلوبة " + noOfSigns);
      }
      else {
          return ok("0");
      } 
}

public static Result viewThirdHint(Integer session_num){
      DynamicForm requestData = Form.form().bindFromRequest();
      Round current_round = Round.find.byId(session_num);
      if(current_round.third_hint_sent){
          String franco = Signs.find.byId(session_num).franco;
          return ok(franco+" الكلمة بالفرانكو ");
      }
      else {
          return ok("0");
      }  
}
    public static Result sendFirstHelp(Integer session_num,String email, String username, int score, Integer wordID) {
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
      Signs s = new Signs(session_num, wordID,email);
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
          User temp = User.find.byId(email);
          temp.score += 5;
          temp.save();

		Round current_round = Round.find.byId(session_num);
		current_round.first_hint_sent = true;
		current_round.save();
      return ok(user.render(session_num, email,username,temp.score,wordID,Form.form(Words.class)));
    }

	public static Result sendSecondHelp(Integer session_num,String email, String username, int score, Integer wordID) {
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
          User temp = User.find.byId(email);
          temp.score += 10;
          temp.save();

		  Round current_round = Round.find.byId(session_num);
		  current_round.second_hint_sent = true;
		  current_round.save();
      return ok(user.render(session_num, email,username,temp.score,wordID,Form.form(Words.class)));
    }



  	public static boolean sendThirdHelp(Integer session_num,String email,String username, int score, Integer wordID) {
      boolean result = false;
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
          User temp = User.find.byId(email);
          temp.score += 20;
          temp.save();

        Round current_round = Round.find.byId(session_num);
		    current_round.third_hint_sent = true;
		    current_round.save();
        result = true;
		     return result;
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


public static class Register {
    public String email;
    public String password;
   public String validate() {
    if (User.authenticate(email, password) != null) {
        return "Already taken user or password";
    }
    return null;
  }

}

}