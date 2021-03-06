package models;

import javax.persistence.*;
import play.db.ebean.*;
import com.avaje.ebean.*;

@Entity
public class User extends Model{
    
	 @Id
    public String email;
    public String username;
    public String password;
    public int score;
    
    public User(String email, String username, String password) {
      this.email = email;
      this.username = username;
      this.password = password;
      this.score = 0;
    }


  public static User authenticate(String email, String password) {
        return find.where().eq("email", email)
            .eq("password", password).findUnique();
    }
   public static Finder<String,User> find = new Finder<String,User>(
        String.class, User.class
    ); 





    
}