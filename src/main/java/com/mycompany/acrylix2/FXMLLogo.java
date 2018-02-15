/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.acrylix2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class FXMLLogo implements Initializable {
    
    JMonetRunner runner;
    
    public void setJMonetRunner(JMonetRunner run) {
        this.runner = run;
    }
    
    @FXML
    private void clickNewFile(ActionEvent event){
        System.out.println("New File");
        //runner.newCanvas();
    } 
    
    @FXML
    private void clickSelectPrevious(ActionEvent event){
        System.out.println("Select Previous");
    } 
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    } 

}
