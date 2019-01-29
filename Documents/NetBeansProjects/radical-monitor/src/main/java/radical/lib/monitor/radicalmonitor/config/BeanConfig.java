/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package radical.lib.monitor.radicalmonitor.config;

import com.easycoop.radical.lib.alert.TextAlert;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author emmanuel.idoko
 */
@Configuration
public class BeanConfig {

    @Bean
    public TextAlert getTextAlert() {
        return new TextAlert();
    }
}
