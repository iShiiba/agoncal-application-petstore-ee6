package org.agoncal.application.petstore.web;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import lombok.Setter;

/**
 * @author Antonio Goncalves
 *         http://www.antoniogoncalves.org
 *         --
 */

@Named
@RequestScoped
@Setter
public class Credentials {

    // ======================================
    // = Attributes =
    // ======================================

    private String login;
    private String password;
    private String password2;

    // ======================================
    // = Getters & setters =
    // ======================================

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getPassword2() {
        return password2;
    }

}
