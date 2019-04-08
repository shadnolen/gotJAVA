/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.text.Format;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.text.TextAlignment;
import javafx.util.Callback;

/**
 *
 * @author shadn
 */
public abstract class Formatted<S, T> implements Callback<TableColumn<S,T>, TableCell<S, T>>{
    private TextAlignment alig;
    private Format format;
    
    public TextAlignment getAlig(){
        return alig;
    } 
    
    public void  setAlig(TextAlignment alig){
        this.alig = alig;
    }
public Format getFormat(){
    return format;
}

public void setFormat(Format format){
    this.format = format;
}



}
