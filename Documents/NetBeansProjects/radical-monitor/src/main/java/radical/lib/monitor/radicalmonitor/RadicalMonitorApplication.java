package radical.lib.monitor.radicalmonitor;

import com.easycoop.radical.lib.model.MessageDetails;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import radical.lib.monitor.radicalmonitor.helper_thread.SmsAlertHelper;

@SpringBootApplication
public class RadicalMonitorApplication {

    public static void main(String[] args) {
        SpringApplication.run(RadicalMonitorApplication.class, args);
    }

//    @Override
//    public void run(String... args) {
//        System.out.println("Testing radical-monitor asynchronous sms call..");
//        SmsAlertHelper alert = new SmsAlertHelper();
//        MessageDetails msg = new MessageDetails();
//        
//        msg.setFrom("INFOSMS");
//        msg.setMemberName("Idoko Emmaneul");
//        msg.setText("Dear " + msg.getMemberName() + ",This is just a test message from exchange point API.");
//        msg.setTo("+2347066109948");
//        alert.sendSingleTextMessage(msg, "emmytoonaiz");
//        System.out.println("Done sending message.");
//    }
}
