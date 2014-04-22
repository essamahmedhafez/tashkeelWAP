package models;

import javax.persistence.*;
import play.db.ebean.*;
import com.avaje.ebean.*;
import play.db.ebean.Model.Finder;

@Entity
public class Words extends Model{
    
    @Id
	public int id = 0;
    public String word;
    public String image_link;
    public int repetition_num;
    public String tashkeel;

    public Words(int id,String word, String imageLink){
    	this.id = id;
    	this.word = word;
    	this.image_link = image_link;
    }

       public static Finder<Integer,Words> find = new Finder<Integer,Words>(Integer.class, Words.class); 


}