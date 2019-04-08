/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import static java.lang.reflect.Array.set;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author shadn
 */
public class Parts {
    private final SimpleStringProperty firstName = new SimpleStringProperty(" ");
      private final SimpleStringProperty lastName = new SimpleStringProperty(" ");
        private final SimpleStringProperty emailAddress = new SimpleStringProperty(" ");
        
        
        public Parts(){
            this(" ", " ", " ");
        }
        
        public Parts(String firstName, String lastName, String emailAddress){
            setFirstName(firstName);
            setLastName(lastName);
            setEmailAddress(emailAddress);
        }
        
        public String getFirstName(){
          return firstName.get();
        }
        
        public void setFirstName(String first){
            firstName.set(first);
        }
        
        public String getLastName(){
            return lastName.get();
        }
        
        public void setLastName(String last){
            lastName.set(last);
        }
        
        public String getEmailAddress(){
            return emailAddress.get();
        }
        
        public void setEmailAddress(String email){
            emailAddress.set(email);
        }
        
}
