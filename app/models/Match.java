package models;

import com.avaje.ebean.Ebean;
import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Juani
 * Date: 9/17/12
 * Time: 8:14 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class Match extends Model {

    @Id
    public Long id;

    int status;

    public String name;

    @ManyToOne
    public Player attacker;

    @ManyToOne
    public Player defender;


    @Lob
    public byte[] attackerData;
    @Lob
    public byte[] defenderData;

    public static Model.Finder<String,Match> find = new Model.Finder(String.class, Match.class);

    public static void create(Match match) {
        Ebean.save(match);
        Ebean.update(match);
        //player.save();
    }

    public static void update(Match match) {
        Ebean.update(match);
    }



    public static List<Match> getAttackingMatches(Player player) {
        return find.where()
                .eq("attacker", player)
                .findList();
    }


    public static List<Match> getDefendingMatches(Player player) {
        return find.where()
                        .eq("defender", player)
                        .findList();
    }

    public static Match getMatchById(int matchID) {
        return find.where()
                .eq("id", matchID)
                .findUnique();
    }
}
