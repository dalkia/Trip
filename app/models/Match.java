package models;

import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

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

    @Lob
    byte[] data;
}
