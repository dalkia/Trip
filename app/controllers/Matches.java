package controllers;

import models.Match;
import models.Player;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Juani
 * Date: 10/28/12
 * Time: 6:10 PM
 * To change this template use File | Settings | File Templates.
 */
public class Matches extends Controller {

    public static class AttackForm {
        public String attackData;
        public String attacker;
        public String defender;
        public int matchID;
    }

    public static class MatchDataForm {
        public int matchID;
    }


    /*
    public static Result getAttackingMatches(Player player){
         List<Match> attackingMatches = Match.getAttackingMatches(player);
         String aux = "";
         for(Match m : attackingMatches){
             aux += m.id + "," + m.defender.username;
         }
        return ok(aux);
    }
    */
    public static Result getDefendingMatches(){

        Form<Application.LoginForm> loginForm = form(Application.LoginForm.class).bindFromRequest();

        Player defender = Player.getPlayerByUsername(loginForm.get().username);

        List<Match> defendingMatches = Match.getDefendingMatches(defender);
        String aux = "";
        for(Match m : defendingMatches){
            aux += m.id + "," + m.attacker.username + ";";
        }
        return ok(aux);
    }

    public static Result getAllMatches(){
        Form<Application.LoginForm> loginForm = form(Application.LoginForm.class).bindFromRequest();

        return ok("1,1,1");

    }

    public static Result sendAttackData(){
        Form<AttackForm> attackForm = form(AttackForm.class).bindFromRequest();
        Match m;
        int matchID = attackForm.get().matchID;
        if(matchID == -1){
            m =  new Match();
            setMatchParameters(attackForm, m);
            Match.create(m);
        }else{
           m = Match.getMatchById(matchID);
           setMatchParameters(attackForm, m);
           Match.update(m);
        }
        return ok("ok");
    }

    public static Result getMatchData(){
        Form<MatchDataForm> matchDataForm = form(MatchDataForm.class).bindFromRequest();
        int matchID = matchDataForm.get().matchID;
        Match m = Match.getMatchById(matchID);
        return ok(m.attackerData.toString());
    }



    private static void setMatchParameters(Form<AttackForm> attackForm, Match m) {
        m.attacker = Player.getPlayerByUsername(attackForm.get().attacker);
        m.defender = Player.getPlayerByUsername(attackForm.get().defender);
        System.out.print(m.defender.username);
        m.attackerData = attackForm.get().attackData.getBytes();
    }


}
