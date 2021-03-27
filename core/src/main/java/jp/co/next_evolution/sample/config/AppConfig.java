package jp.co.next_evolution.sample.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.NoSuchMessageException;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class AppConfig {

    @Autowired
    MessageConfig messageConfig;

    public String getMessage(String messageKey) {
        try {
            return messageConfig.messageSource().getMessage(messageKey, null, Locale.JAPAN);
        } catch (NoSuchMessageException e) {
            return null;
        }
    }

    public String getMessage(String messageKey, String param) {
        try {
            return messageConfig.messageSource().getMessage(messageKey, new String[]{param}, Locale.JAPAN);
        } catch (NoSuchMessageException e) {
            return null;
        }
    }

}
