package models;

import javax.persistence.*;
import play.db.ebean.*;
import com.avaje.ebean.*;
import play.db.ebean.Model.Finder;

@Entity
public class Words extends Model{
    
    @Id
	public int id = 1;
    public String word;
    public String imageLink;
    public int repetitionNum;
    public String tashkeel;

    public Words(String word, String imageLink){
    	this.id++;
    	this.word = word;
    	this.imageLink = imageLink;
    }

       public static Finder<Integer,Words> find = new Finder<Integer,Words>(Integer.class, Words.class); 


}