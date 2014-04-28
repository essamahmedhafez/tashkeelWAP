package models;

import javax.persistence.*;
import play.db.ebean.*;
import com.avaje.ebean.*;

@Entity
public class User extends Model{
    
	 @Id
    public String email;
    public String name;
    public String password;
    public int score;
    public boolean solver = false;
    //by default, if solver == false, the user will be solver, and solver will be set to true, so that next turn will be hinter
    
    public User(String email, String name, String password) {
      this.email = email;
      this.name = name;
      this.password = password;
      this.score = 0;
      this.solver = false;
    }


  public static User authenticate(String email, String password) {
        return find.where().eq("email", email)
            .eq("password", password).findUnique();
    }
   public static Finder<String,User> find = new Finder<String,User>(
        String.class, User.class
    ); 





    
}