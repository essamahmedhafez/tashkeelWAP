package models;

import javax.persistence.*;
import play.db.ebean.*;
import com.avaje.ebean.*;

@Entity
public class Hinter extends Model{
    
	 @Id
    public String email;
    public String name;
    public String password;
    public int score;
    
    public Hinter(String email, String name, String password) {
      this.email = email;
      this.name = name;
      this.password = password;
      score = 0;
    }


  public static Hinter authenticate(String email, String password) {
        return find.where().eq("email", email)
            .eq("password", password).findUnique();
    }
   public static Finder<String,Hinter> find = new Finder<String,Hinter>(
        String.class, Hinter.class
    ); 





    
}