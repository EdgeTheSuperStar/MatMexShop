import java.util.HashMap;
import java.util.Map;

public class MessageStorage {
    private Map<String, String> storage;
    public MessageStorage() {
        storage = new HashMap();
        storage.put("/start", "Привет, ты в магазинчике у Матмеха! Напиши Команды, чтобы увидеть, что может делать бот.");
        storage.put("привет", "Привет, ты в магазинчике у Матмеха! Напиши Команды, чтобы увидеть, что может делать бот.");
        storage.put("/help", "Вот список команд: \n" + "/catalog - Каталог \n"  +  "/about - О нас \n");
        storage.put("команды", "Вот список команд: \n" + "/catalog - Каталог \n"  +  "/about - О нас \n");
        storage.put("/about", "Группа студентов 2 курса Матмеха\n");
        storage.put("о нас", "Группа студентов 2 курса Матмеха\n");
        storage.put("/catalog", "Тут пока ничего нет, зачем ты зашел сюда? Выйди отсюда, розбийник!");
        storage.put("каталог", "Тут пока ничего нет, зачем ты зашел сюда? Выйди отсюда, розбийник!");
    }

    public String getAnswer(String str){
        str = str.toLowerCase();
        return storage.containsKey(str) ? storage.get(str) : storage.get("/help");
    }
}

