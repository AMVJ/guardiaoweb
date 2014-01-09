package br.com.guardiao.validador;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

public class EmailValidator implements Validator{

	public void validate(FacesContext facesContext, 
        UIComponent uIComponent, Object object) throws ValidatorException {
        
        String enteredEmail = (String)object;
        //Set the email pattern string
        Pattern p = Pattern.compile(".+@.+\\.[a-z]+");
        
        //Match the given string with the pattern
        Matcher m = p.matcher(enteredEmail);
        
        //Check whether match is found
        boolean matchFound = m.matches();
        
        if (!matchFound) {
            FacesMessage message = new FacesMessage();
            message.setDetail("E-mail incorreto!");
            message.setSummary("E-mail incorreto!");
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(message);
        }
    }
}