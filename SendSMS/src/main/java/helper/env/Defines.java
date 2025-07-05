package helper.env;

import java.net.http.*;
import java.util.ArrayList;
import java.util.List;

public class Defines extends SecretEnvironmentDefines{
    protected static HttpClient client;
    protected static HttpRequest request;
    protected static String messageText;
    protected static List<String> messageTextPartitions = new ArrayList<>();
    public static String getMessageText() {
        return messageText;
    }

    public static void setMessageText(String messageText) {
        Defines.messageText = messageText;
    }
}
