package com.webstart.backend.service;

import com.webstart.web.domain.frontend.FeedbackPojo;
import org.springframework.mail.SimpleMailMessage;

public interface EmailService {
    /**
     * Sends an email with the content in the Feedback Pojo.
     * @param feedbackPojo The feedback Pojo
     */
    public void sendFeedbackEmail(FeedbackPojo feedbackPojo);

    /**
     * Sends an email with the content of the Simple Mail Message object.
     * @param message The object containing the email content
     */
    public void sendGenericEmailMessage(SimpleMailMessage message);
}
