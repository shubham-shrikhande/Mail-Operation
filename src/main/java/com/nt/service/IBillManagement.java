package com.nt.service;

import javax.mail.MessagingException;

public interface IBillManagement {

	public String billMaker(String name,String item,Integer price,String fromMail) throws MessagingException;
}
