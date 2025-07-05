package helper.sms;

import com.vonage.client.VonageClient;
import com.vonage.client.sms.MessageStatus;
import com.vonage.client.sms.SmsSubmissionResponse;
import com.vonage.client.sms.messages.TextMessage;
import helper.env.Defines;

import java.util.List;
import java.util.Scanner;
import java.util.SortedMap;

public class SendSMSWithAPI extends Defines {
    private static void sendSMS(String from, String messageTextValue){
        setMessageText(messageTextValue);
        VonageClient client = VonageClient.builder().apiKey(API_KEY).apiSecret(API_SECRET).build();
        TextMessage message = new TextMessage(from,
                PHONE_NUMBER,
                getMessageText()
        );
        SmsSubmissionResponse response = client.getSmsClient().submitMessage(message);
        if (response.getMessages().get(0).getStatus() == MessageStatus.OK) {
            System.out.println(getMessageText() + " mesajı başarıyla gönderildi.");
        } else {
            System.out.println("Mesaj hata nedeniyle gönderilemedi: " + response.getMessages().get(0).getErrorText());
        }
    }

    private static List<String> analiyseMessage(){
        String str = getMessageText();
        int beginIndex = 0;
        int endIndex = 0;

        messageTextPartitions.clear();

        while (endIndex!=str.length()){
            if(beginIndex == 0){
                messageTextPartitions.add(str.substring(beginIndex,beginIndex + 36));
                beginIndex = beginIndex + 36;
            }
            if(beginIndex+36>=str.length()){
                endIndex = str.length();
                messageTextPartitions.add(str.substring(beginIndex,endIndex));
            }else{
                beginIndex = beginIndex + 36;
                if(beginIndex + 36>=str.length()){
                   endIndex = str.length();
                }else{
                    endIndex = beginIndex + 36;
                }
                messageTextPartitions.add(str.substring(beginIndex,endIndex));
            }
        }

        return messageTextPartitions;
    }

    protected static void sendMessage(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Gönderen adı :");
        String nameValue = scanner.nextLine();
        System.out.print("Mesajı girin :");
        String messageValue = scanner.nextLine();
        if (patternName.matcher(nameValue).matches()&&patternMessage.matcher(messageValue).matches()){
            sendSMS(nameValue,messageValue);
            System.out.println();
            System.out.println("Mesaj en fazla 36 karakterli dizgelere ayrıldı. Liste;");
            System.out.println("-------------------------------------------------------");
            analiyseMessage().forEach(System.out::println);
        }
    }
}