package models;

import javax.persistence.*;
import play.db.ebean.*;
import com.avaje.ebean.*;
import play.db.ebean.Model.Finder;

@Entity
public class Round extends Model{
    
    @Id
    public int session_num;
    public String hinter_email;
    public String solver_email;
    public boolean hinter_first;
    public boolean first_hint_requested;
    public boolean second_hint_requested;
    public boolean third_hint_requested;
    public boolean first_hint_sent;
    public boolean second_hint_sent;
    public boolean third_hint_sent;


    public Round(String email, boolean hinter_first){
        this.hinter_first = hinter_first;

        if(hinter_first){
            this.hinter_email = email;
        } else {
            this.solver_email = email;
        }
        
        this.first_hint_requested = false;
        this.second_hint_requested = false;
        this.third_hint_requested = false;

        this.first_hint_sent = false;
        this.second_hint_sent = false;
        this.third_hint_sent = false;

    }

    public static Finder<Integer,Round> find = new Finder<Integer,Round>(Integer.class, Round.class); 

} 