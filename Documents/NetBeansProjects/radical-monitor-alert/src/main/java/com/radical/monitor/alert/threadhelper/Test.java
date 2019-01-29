/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.radical.monitor.alert.threadhelper;

import com.mashape.unirest.http.exceptions.UnirestException;
import com.radical.monitor.alert.model.EmailMessage;
import com.radical.monitor.alert.model.MessageDetails;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author emmanuel.idoko
 */
public class Test {

    //private static @Autowired
    private static final SmsAlertHelper alert = new SmsAlertHelper();

    public static void main(String[] args) throws UnirestException {
       List<MessageDetails> all_msg = new ArrayList<>();
        MessageDetails msg = new MessageDetails();

        msg.setFrom("INFOSMS");
        msg.setMemberName("Idoko Emmaneul");
        msg.setText("Dear " + msg.getMemberName() + ",welcome to spring, gone!!!!");
        msg.setTo("+2348032626521");
        
        MessageDetails msg2 = new MessageDetails();

        msg2.setFrom("INFOSMS");
        msg2.setMemberName("Gbenga Daniels");
        msg2.setText("Dear " + msg.getMemberName() + ",welcome to spring boot application testing");
        msg2.setTo("+2348153103519");
        
        all_msg.add(msg2);
        all_msg.add(msg);
        alert.sendBulkTextMessage(all_msg);

        

    }
}
