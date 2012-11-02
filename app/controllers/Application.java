package controllers;

import com.avaje.ebean.Ebean;
import models.Match;
import models.Player;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

public class Application extends Controller {
  
  public static Result index() {
    return ok("1");
  }


  public static class FindMatchForm {
      public String name;
  }

  public static class LoginForm {
      public String username;
      public String password;
  }



  public static Result findMatch() {
      Form<FindMatchForm> findMatchForm = form(FindMatchForm.class).bindFromRequest();

      Match match = new Match();

      match.name = findMatchForm.get().name;

      Ebean.save(match);

      Ebean.update(match);

      return ok(match.id.toString());
  }

  public static Result login(){
      Form<LoginForm> loginForm = form(LoginForm.class).bindFromRequest();

      Player player = Player.getPlayerByUsername(loginForm.get().username);

      if(player==null){
        player = new Player();
        player.username = loginForm.get().username;
        player.password = loginForm.get().password;
        Player.create(player);
      }

      return ok(player.username);
  }


}