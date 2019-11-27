import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.User;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;


public class Bot  extends TelegramLongPollingBot {
    private MessageStorage ms;
    public Bot() {
        ms = new MessageStorage();
    }

    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();
        System.out.println("onUpdateRecieve");
        if ((message != null) && (message.hasText())) {
            String text = message.getText();
            sendMsg(update, ms.getAnswer(text));
        }
    }

    private void sendMsg(Update update, String answer) {
        SendMessage sm = new SendMessage();
        sm.setChatId(update.getMessage().getChatId());
        sm.setText(answer);
        try {
            execute(sm);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public String getBotUsername() {
        return "MatMexShop";
    }

    public String getBotToken() {
        return "";
    }
}

