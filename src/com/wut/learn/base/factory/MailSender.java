package com.wut.learn.base.factory;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: sunshine
 * @Date: 2023/05/14/21:00
 * @Description:
 */
public class MailSender extends Sender {
        private String name;
        public MailSender(){
            this.name="mailSender";
        }
        @Override
        public String toString(){
            return String.valueOf(name);
        }


}
