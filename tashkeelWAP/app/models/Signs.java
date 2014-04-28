package models;

import javax.persistence.*;
import play.db.ebean.*;
import com.avaje.ebean.*;
import play.db.ebean.Model.Finder;

@Entity
public class Signs extends Model{
    
    @Id
    public int session_num;
	public int word_id;
    public String hinter_email;
    public String franco;
    public int noOfSigns;
    public boolean damma;
    public boolean fat7a;
    public boolean kasra;
    public boolean sekon;
    public boolean shadda;
    public boolean tanween_maftoo7;
    public boolean tanween_maksoor;
    public boolean tanween_madmoom;

    public Signs(int word_id, String hinter_email){
        this.session_num = session_num;
    	this.word_id = word_id;
        this.hinter_email = hinter_email;
        this.franco = "";
        this.noOfSigns = 0;
        this.damma = false;
        this.fat7a = false;
        this.kasra = false;
        this.sekon = false;
        this.shadda= false;
        this.tanween_maftoo7 = false;
        this.tanween_maksoor = false;
        this.tanween_madmoom = false;
    }

       public static Finder<Integer,Signs> find = new Finder<Integer,Signs>(Integer.class, Signs.class); 


} 