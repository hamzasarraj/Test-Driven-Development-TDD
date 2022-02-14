package com.eql.dummy;

public class DummyEmailService implements EmailService{

    @Override
    public void sendMail(String message) {
        throw new AssertionError("Method not implemented !");
    }
}
