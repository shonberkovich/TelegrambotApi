package org.example;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.TelegramBot;

import java.util.List;

public class MyFirstBot extends TelegramLongPollingBot {
   private List<Long> chatId;
   private int vnum;
    @Override
    public void onUpdateReceived(Update update) {
        String text = update.getMessage().getText();
        long chatId = update.getMessage().getChatId();
        String answerFromChat = new Api().sendMessage(text + " אם כתבתי לך פעולה ומספר אז תחזיר לי בפורמט הזה ,  עוד הבספר שכתבתי לך תעשה את הפעולה שכתבתי לך, בלי שום טקסט אחר ");

        SendMessage sendMessage = new SendMessage(String.valueOf(chatId), answerFromChat);
        if (text.contains(Integer.MIN_VALUE + "")) {
            Thread.sleep(500);
            try {
                execute(sendMessage);
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }

        }
    }
    @Override
    public String getBotUsername() {
        return "shon12345";
    }

    public  String getBotToken(){
        return"7407672650:AAEYi_JUirU-UqyT_65HxhrgI2TSPo12qyo";
    }
}
