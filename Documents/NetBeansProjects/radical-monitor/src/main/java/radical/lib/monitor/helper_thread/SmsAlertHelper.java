/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package radical.lib.monitor.helper_thread;

import com.easycoop.radical.lib.alert.TextAlert;
import com.easycoop.radical.lib.model.MessageDetails;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 *
 * @author emmanuel.idoko
 */
@Component
public class SmsAlertHelper {

    private static final Logger logger = LoggerFactory.getLogger(SmsAlertHelper.class);
    private @Autowired
    TextAlert textAlert;

    @Async("threadPoolTaskExecutor")
    @EventListener
    public void sendSingleTextMessage(MessageDetails message, String username) {
        logger.info("request to send single text message to {}, invoked by - [{}].", message.getTo(), username);
        try {
            textAlert.sendSingleText(message);
        } catch (Exception ex) {
            logger.info("Error sending single text message to the number [{}]. See error log - [{}]", message.getTo(), username);
            logger.error("Error sending single text message to the number. - [" + username + "]", ex);
        }
    }

    @Async("threadPoolTaskExecutor")
    @EventListener
    public void sendBulkTextMessage(List<MessageDetails> messages, String username) {
        logger.info("request to send bulk text messages, invoked by - [{}].", username);
        try {
            int index = 0;
            for (MessageDetails md : messages) {
                index++;
                textAlert.sendSingleText(md);
                logger.info("sent message to phone number {} at index {}, invoked by - [{}].", md.getTo(), index, username);
            }
            logger.info("finished sending bulk text messages - [{}]", username);
        } catch (Exception ex) {
            logger.info("Error sending bulk text messages. See error log - [{}]", username);
            logger.error("Error sending bulk text messages. - [" + username + "]", ex);
        }
    }
}
