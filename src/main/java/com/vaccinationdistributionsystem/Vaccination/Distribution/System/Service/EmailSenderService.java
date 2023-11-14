package com.vaccinationdistributionsystem.Vaccination.Distribution.System.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {
    @Autowired
    private JavaMailSender javaMailSender;

    public void sendemail(String toEmail,String subject,String body)
    {
        SimpleMailMessage message=new SimpleMailMessage();
        message.setFrom("nitinbhattacharyya@gmail.com");
        message.setTo(toEmail);
        message.setText(body);
        message.setSubject(subject);

        javaMailSender.send(message);
    }
}
