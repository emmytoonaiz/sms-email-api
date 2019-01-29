/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package radical.lib.monitor.radicalmonitor.helper_thread;

import com.easycoop.radical.lib.alert.EmailSender;
import com.easycoop.radical.lib.alert.Util;
import com.easycoop.radical.lib.model.MessageDetails;
import java.util.ArrayList;
import java.util.List;
import javax.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;



/**
 *
 * @author emmanuel.idoko
 */
public class TestTextSender {
    
    public static void main(String[] args) throws MessagingException {
        EmailSender sender = new EmailSender();
        List<String> emails = new ArrayList<>();
        emails.add("emmanuel.idoko@africaprudential.com");
        emails.add("gbolahan.folarin@africaprudential.com");
        //javaEmail.createEmailMessage();
       
        String subject = "Cooperative Licence Activation.";
                String emailBody = "<p>The licence for the United Capital PLC"
                        + ", has been activated successfully.</p>";
        String template = Util.getEmailTemplate("C:\\Users\\emmanuel.idoko\\Documents\\development tools", "template.html");
        sender.sendSingleEmail("killmewithdlord", "desterity", "emmanuel.idoko@africaprudential.com", subject,emailBody, template);

    }
}
