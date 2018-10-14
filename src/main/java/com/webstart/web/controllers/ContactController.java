package com.webstart.web.controllers;

import com.webstart.backend.service.EmailService;
import com.webstart.web.domain.frontend.FeedbackPojo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ContactController {

    private static final Logger LOG = LoggerFactory.getLogger(ContactController.class);

    public static final String FEEDBACK_MODEL_KEY = "feedback";

    private static final String CONTACT_US_VIEW_MODE = "contact/contact";

    @Autowired
    private EmailService emailService;

    @RequestMapping(value = "/contact", method = RequestMethod.GET)
    public String contactUsGET(ModelMap model){
        FeedbackPojo feedbackPojo = new FeedbackPojo();
        model.addAttribute(ContactController.FEEDBACK_MODEL_KEY, feedbackPojo);
        return ContactController.CONTACT_US_VIEW_MODE;
    }

    @RequestMapping(value = "/contact",method = RequestMethod.POST)
    public String contactUsPOST(@ModelAttribute(FEEDBACK_MODEL_KEY) FeedbackPojo feedback){
        LOG.debug("Feedback POJO content: {}", feedback);
        emailService.sendFeedbackEmail(feedback);
        return ContactController.CONTACT_US_VIEW_MODE;
    }
}
