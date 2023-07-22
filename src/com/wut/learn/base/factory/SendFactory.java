package com.wut.learn.base.factory;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: sunshine
 * @Date: 2023/05/14/20:51
 * @Description:
 */
public class SendFactory {
        public Sender produce(String type){
            if("mail".equals(type)){
                return new MailSender();
            }else if("sms".equals(type)) {
                return new SmsSender();
            }else{
                System.out.println("请输入正确类型");
                return null;
            }
        }

        public static void main(String[] args){
            SendFactory sendFactory = new SendFactory();
            Sender mail = sendFactory.produce("mail");
            System.out.println(mail.toString());
        }

}





