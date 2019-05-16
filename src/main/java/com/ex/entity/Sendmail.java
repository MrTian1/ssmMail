package com.ex.entity;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Sendmail extends Thread {
    //用于给用户发送邮件的邮箱
    private String from = "1171507663@qq.com";
    //邮箱的用户名
    private String username = "1171507663@qq.com";
    //邮箱的密码
    private String password = "wmozxvddjqqsgicc";
    //发送邮件的服务器地址
    private String host = "smtp.qq.com";

    private EUser user;
    public Sendmail(EUser user){
        this.user = user;
    }

    @Override
    public void run() {
         try {
             Properties prop = new Properties();
             prop.setProperty("mail.host", host);
             prop.setProperty("mail.transport.protocol", "smtp");
             prop.setProperty("mail.smtp.auth", "true");
             Session session = Session.getInstance(prop);
             session.setDebug(true);
             Transport ts = session.getTransport();
             ts.connect(host, username, password);
             Message message = createEmail(session,user);
             ts.sendMessage(message, message.getAllRecipients());
             System.out.println("发送邮件成功...");
             ts.close();
         }catch (Exception e) {
             throw new RuntimeException(e);
         }
    }

    /**
     *
     * @Description: 创建要发送的邮件
     *
     */
    public Message createEmail(Session session,EUser user) throws Exception{

        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(from));
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(user.getMail()));
        message.setSubject("用户注册邮件", "utf-8");

        String info = "恭喜您注册成功，您的用户名：" + user.getUsername() + ",您的密码：" + user.getPassword() + "，请妥善保管，如有问题前联系《全村人的希望》小姐在线客服!";
        message.setContent(info, "text/html;charset=UTF-8");
        message.saveChanges();
        return message;
    }
}