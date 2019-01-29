/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package radical.lib.monitor.radicalmonitor.helper_thread;

import com.easycoop.radical.lib.alert.EmailSender;
import com.easycoop.radical.lib.model.EmailMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 *
 * @author emmanuel.idoko
 */
@Component
public class EmailAlertHelper {

    private static final Logger logger = LoggerFactory.getLogger(SmsAlertHelper.class);
    EmailSender emailAlert = new EmailSender();

    @Async("threadPoolTaskExecutor")
    @EventListener
    public void sendBulkEmail(EmailMessage emailMessage) {
        logger.info("request to send single bulk email message to {},", emailMessage.getTo_emails());
        try {
            emailAlert.sendBulkEmail(emailMessage.getFromUser(), emailMessage.getFromUserEmailPassword(), emailMessage.getTo_emails(),
                    emailMessage.getSubject(), emailMessage.getEmailBody(), emailMessage.getTemplate());
            logger.info("finished sending bulk email to {} ", emailMessage.getTo_emails());
        } catch (Exception ex) {
            logger.info("Error sending bulk email message. See error log");
            logger.error("Error sending bulk email message - ", ex);
        }
    }

    @Async("threadPoolTaskExecutor")
    @EventListener
    public void sendSingleEmail(EmailMessage emailMessage) {
        logger.info("request to send single bulk email message to {},", emailMessage.getTo_emails());
        try {
            emailAlert.sendSingleEmail(emailMessage.getFromUser(), emailMessage.getFromUserEmailPassword(), emailMessage.getTo_email(),
                    emailMessage.getSubject(), emailMessage.getEmailBody(), emailMessage.getTemplate());
            logger.info("finished sending single email to {} ", emailMessage.getTo_email());
        } catch (Exception ex) {
            logger.info("Error sending single email message. See error log");
            logger.error("Error sending single email message - ", ex);
        }
    }
}
