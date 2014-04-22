package models;

import javax.persistence.*;
import play.db.ebean.*;
import com.avaje.ebean.*;

@Entity
public class User extends Model{
    
	 @Id
    public String email;
    public int id;
    public String name;
    public String password;
    public int score;
    
    public User(int id, String email, String name, String password) {
      this.id = id;
      this.email = email;
      this.name = name;
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