/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author David
 */
public class Util {
    
    public static final String PATTERN_LETRAS = "[^A-Za-zñÑáéíóúüÁÉÍÓÚ \\- ]";
    
    public static final String PATTERN_ALFA_NUMERICO = "[^A-Za-z0-9]";
    
    public static final String PATTERN_EMAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    
    public static final String PATTERN_NUMEROS = ".*[^0-9].*";
        
    public static void sendInfoMessage(String string) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", string));
    }

    public static void sendErroMessage(String string) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "", string));
    }

    public static void sendWarnMessage(String string) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "", string));
    }
    
    public static boolean isWritten(String string) {
        return !(string == null || string.trim().length() == 0);
    }
    
    public static boolean containsOnlyLetters(String string) {
        Pattern pattern = Pattern.compile(PATTERN_LETRAS);
        Matcher matcher = pattern.matcher(string);
        return matcher.find() != true;
    }

    public static boolean isAlphanumeric(String string) {
        Pattern pattern = Pattern.compile(PATTERN_ALFA_NUMERICO);
        Matcher matcher = pattern.matcher(string);
        return matcher.find() != true;
    }

    public static boolean isValidEmail(String string) {
        Pattern pattern = Pattern.compile(PATTERN_EMAIL);
        Matcher matcher = pattern.matcher(string);
        return matcher.find();
    }

    public static boolean containsOnlyNumbers(String string) {
        Pattern pattern = Pattern.compile(PATTERN_NUMEROS);
        Matcher matcher = pattern.matcher(string);
        return matcher.find() != true;
    }
}