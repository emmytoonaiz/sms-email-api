/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package radical.lib.monitor.radicalmonitor.controller;

import com.easycoop.radical.lib.model.EmailMessage;
import com.easycoop.radical.lib.model.MessageDetails;
import com.wordnik.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import radical.lib.monitor.radicalmonitor.helper_thread.EmailAlertHelper;

/**
 *
 * @author emmanuel.idoko
 */
@RestController
@RequestMapping("/api/radicalmonitor/v1/email")
@Api(value = "radical-monitor email alert controller API calls")
public class EmailResource {

    private static final Logger logger = LoggerFactory.getLogger(SMSResource.class);
    EmailAlertHelper emailAlert = new EmailAlertHelper();

    @PostMapping("/sendsingleemail")
    @ResponseStatus(value = HttpStatus.OK)
    public void sendSingleEmail(@RequestBody EmailMessage message) {

        if (message != null) {
            logger.info("message object is not empty, calling method to send email now.");
            emailAlert.sendSingleEmail(message);
            logger.info("Done sending single email.");
        } else {
            logger.info("email message object is null.");
        }

    }

    @PostMapping("/sendbulkemail")
    @ResponseStatus(value = HttpStatus.OK)
    public void sendBulkEmail(@RequestBody EmailMessage message) {

        if (message != null) {
            logger.info("message object is not empty, calling method to send bulk email now.");
            emailAlert.sendBulkEmail(message);
            logger.info("Done sending bulk email.");
        } else {
            logger.info("email message object is null.");
        }

    }

}
