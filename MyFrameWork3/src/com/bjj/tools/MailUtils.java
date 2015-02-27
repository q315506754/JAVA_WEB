package com.bjj.tools;

import org.apache.commons.mail.HtmlEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MailUtils {
	@Autowired
	private PropertiesUtil propUtil;
	/**
	 * 发送HTML格式的邮件
	 * */
	public boolean sendmail(String to, String subject, String msg) {
		boolean flag = false;
		try {
			HtmlEmail email = new HtmlEmail();
			email.setHostName(propUtil.readStringValue("email_host"));
			email.setCharset("utf-8");
			email.addTo(to);
			email.setFrom(propUtil.readStringValue("email_from"));
			email.setAuthentication(
					propUtil.readStringValue("email_from"),
					propUtil.readStringValue("email_password"));
			email.setSubject(subject);
			email.setHtmlMsg(msg);
			email.send();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
}
