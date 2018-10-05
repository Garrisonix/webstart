package com.webstart.web.i18n;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class I18nService {
    @Autowired
    private MessageSource messageSource;

    /**
     * Returns a message for the given string and the default locale in the session context
     * @param id The key to the message resource file
     */
    public String getMessage(String id){
        Locale locale = LocaleContextHolder.getLocale();
        return getMessage(id, locale);
    }

    /**
     * Returns a message for the given message id and locale
     * @param id The key to the message resource file
     * @param locale the Locale
     */
    public String getMessage(String id, Locale locale){
        return messageSource.getMessage(id, null, locale);
    }
}
