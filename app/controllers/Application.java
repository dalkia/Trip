package controllers;

import com.avaje.ebean.Ebean;
import models.Match;
import play.*;
import play.data.Form;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {
  
  public static Result index() {
    return ok("1");
  }


  public static class FindMatchForm {
      public String name;
  }

  public static Result findMatch() {
      Form<FindMatchForm> findMatchForm = form(FindMatchForm.class).bindFromRequest();

      Match match = new Match();

      match.name = findMatchForm.get().name;

      Ebean.save(match);

      Ebean.update(match);

      return ok(match.id.toString());
  }
}