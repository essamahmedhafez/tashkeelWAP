package models;

import javax.persistence.*;
import play.db.ebean.*;
import com.avaje.ebean.*;
import play.db.ebean.Model.Finder;

@Entity
public class Digitization extends Model{
    
    @Id
	public int sessionNum = 0;
    public String digitization;
    //@Required
    public int wordID;
    public String franco;
    public int noOfSigns;
    public int hinterID;
    public int solverID;

    public Digitization(int sessioNum,int wordID, String digitization){
    	this.sessionNum = sessionNum;
        this.wordID = wordID;
    	this.digitization = digitization;
    	// this.franco = franco;
     //    this.noOfSigns = noOfSigns;
    }

       public static Finder<Integer,Digitization> find = new Finder<Integer,Digitization>(Integer.class, Digitization.class); 


}