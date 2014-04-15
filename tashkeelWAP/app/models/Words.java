package models;

import javax.persistence.*;
import play.db.ebean.*;
import com.avaje.ebean.*;

@Entity
public class Words extends Model{
    
    @Id
	public int id = 0;
    public String word;
    public String imageLink;
    public String franco;
    public int noOfSigns;
    public String tashkeel;

    public Words(String word, String imageLink){
    	id++;
    	this.word = word;
    	this.imageLink = imageLink;
    }

   public static Finder<Integer,Words> find = new Finder<Integer,Words>(
        Integer.class, Words.class
    ); 

}