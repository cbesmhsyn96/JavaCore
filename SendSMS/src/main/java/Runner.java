import helper.sms.SendSMSWithAPI;

import java.io.IOException;

import java.net.URISyntaxException;

public class Runner extends SendSMSWithAPI {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        sendMessage();
    }
}