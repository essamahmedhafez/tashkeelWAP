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
    public int hinter_id;
    public int damma;
    public int fat7a;
    public int kasra;
    public int sekon;
    public int shadda;
    public int tanween_maftoo7;
    public int tanween_maksoor;
    public int tanween_madmoom;

    public Signs(int session_num, int word_id, int hinter_id){
        this.session_num = session_num;
    	this.word_id = word_id;
        this.hinter_id = hinter_id;
        this.damma = 0;
        this.fat7a = 0;
        this.kasra = 0;
        this.sekon = 0;
        this.shadda= 0;
        this.tanween_maftoo7 = 0;
        this.tanween_maksoor = 0;
        this.tanween_madmoom = 0;
    }

       public static Finder<Integer,Signs> find = new Finder<Integer,Signs>(Integer.class, Signs.class); 


} 