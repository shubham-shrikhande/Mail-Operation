package com.nt.service;

import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class BillManageServiceImp implements IBillManagement {

	@Autowired
	private JavaMailSender sender;
	
	@Value("${spring.mail.username}")
	private String fromMail;
	
	
	@Override
	public String billMaker(String name, String item, Integer price, String toMail) throws MessagingException {
		
		String msg="Hi "+name+", Thank you for purchasing "+item+" with price "+price;
		String mailmsg=sendMail(msg, toMail);
		return mailmsg;
	}
	
	private String sendMail(String msg, String toMail) throws MessagingException {
		MimeMessage msg1=sender.createMimeMessage();
		MimeMessageHelper helper=new MimeMessageHelper(msg1,true);
		helper.setFrom(toMail);
		helper.setCc(toMail);
		helper.setSubject("Billing Information");
		helper.setSentDate(new Date());
		helper.setText(msg);
	
		//helper.addAttachment(toMail, null);
		sender.send(msg1);
		return "Mail sent successfully!!";
	}

}
