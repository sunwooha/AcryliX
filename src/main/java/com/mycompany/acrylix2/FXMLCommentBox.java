/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.acrylix2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import java.util.*;

/**
 *
 * @author jenniferha
 */
public class FXMLCommentBox implements Initializable {
    
    JMonetRunner runner;
    
    @FXML
    TextArea textArea;
    
    public void setJMonetRunner(JMonetRunner run) {
        this.runner = run;
    }
    
    public TextArea getTextArea(){
        return textArea;
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
         
    }

}

