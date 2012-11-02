package models;

import com.avaje.ebean.Ebean;
import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;


/**
 * Created with IntelliJ IDEA.
 * User: Juani
 * Date: 10/17/12
 * Time: 5:42 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class Player extends Model {

    @Id
    public Long id;

    public String username;
    public String password;

    @OneToMany(mappedBy = "defender")
    public List<Match> defendingMatches = new ArrayList<Match>();
    @OneToMany(mappedBy = "attacker")
    public List<Match> attackingMatches = new ArrayList<Match>();

    public static Model.Finder<String,Player> find = new Model.Finder(String.class, Player.class);

    /**
     * Authenticate a User.
     */
    public static Player authenticate(String username, String password) {
        return find.where()
                .eq("email", username)
                .eq("password", password)
                .findUnique();
    }

    public static void create(Player player) {
        Ebean.save(player);
        Ebean.update(player);
        //player.save();
    }

    public static Player getPlayerByUsername(String username) {
        return find.where()
                .eq("username", username)
                .findUnique();
    }

}
