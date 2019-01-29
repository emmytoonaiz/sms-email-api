/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package radical.lib.monitor.radicalmonitor.controller;

import com.easycoop.radical.lib.model.MessageDetails;
import com.wordnik.swagger.annotations.Api;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import radical.lib.monitor.radicalmonitor.helper_thread.SmsAlertHelper;

/**
 *
 * @author emmanuel.idoko
 */
@RestController
@RequestMapping("/api/radicalmonitor/v1")
@Api(value = "radical-monitor alert controller API calls")
public class SMSResource {

    private static final Logger logger = LoggerFactory.getLogger(SMSResource.class);
    //private @Autowired
    SmsAlertHelper request = new SmsAlertHelper();

    @PostMapping("/sendsingletext")
    @ResponseStatus(value = HttpStatus.OK)
    public void sendSingleTextMessage(@RequestBody MessageDetails message) {

        if (message != null && !message.getTo().trim().isEmpty() && !message.getText().trim().isEmpty() && !message.getFrom().trim().isEmpty()) {
            logger.info("all necessary parameters are set, calling method to send sms now.");
            request.sendSingleTextMessage(message);
        } else {
            logger.info("all necessary parameters are not set.");
        }

    }

    @PostMapping("/sendbulktext")
    @ResponseStatus(value = HttpStatus.OK)
    public void sendBulkTextMessage(@RequestBody List<MessageDetails> messages) {

        if (!messages.isEmpty()) {
            logger.info("calling method to send bulk sms now.");
            request.sendBulkTextMessage(messages);
        } else {
            logger.info("all necessary parameters are not set.");
        }

    }
}
