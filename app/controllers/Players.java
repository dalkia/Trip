package controllers;

import models.Player;
import play.mvc.Controller;

/**
 * Created with IntelliJ IDEA.
 * User: Juani
 * Date: 10/22/12
 * Time: 7:27 PM
 * To change this template use File | Settings | File Templates.
 */
public class Players extends Controller {

    public Player login(String username, String password){
        return Player.authenticate(username, password);
    }

    public static void create(Player player) {
        player.save();
    }
}
