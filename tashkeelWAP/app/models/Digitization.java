package models;

import javax.persistence.*;
import play.db.ebean.*;
import com.avaje.ebean.*;
import play.db.ebean.Model.Finder;

@Entity
public class Digitization extends Model{
    
    @Id
	public int session_num;
    public int word_id;
    public String solver_email;
    public String digitization;

    public Digitization(int word_id, String solver_email, String digitization){
        this.word_id = word_id;
        this.solver_email = solver_email;
    	this.digitization = digitization;
    }

    public static Finder<Integer,Digitization> find = new Finder<Integer,Digitization>(Integer.class, Digitization.class); 


}