package models;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class Hello {
    public Hello() {}
    public String toUpperCase(String in) {
        return in.toUpperCase();
    }
}