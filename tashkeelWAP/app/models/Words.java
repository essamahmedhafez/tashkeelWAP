package models;

import javax.persistence.*;
import play.db.ebean.*;
import com.avaje.ebean.*;
import play.db.ebean.Model.Finder;

@Entity
public class Words extends Model{
    
    @Id
	public int id;
    public String word;
    public String image_link;
    public int repetition_num;
    public String tashkeel;

    public Words(String word, String image_link){
    	this.word = word;
    	this.image_link = image_link;
        this.repetition_num =0;
        this.tashkeel ="";
    }

       public static Finder<Integer,Words> find = new Finder<Integer,Words>(Integer.class, Words.class); 


}