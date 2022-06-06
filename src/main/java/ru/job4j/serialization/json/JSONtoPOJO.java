package ru.job4j.serialization.json;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JSONtoPOJO {
    public static void main(String[] args) {
        Person user = new Person(false, 30, new Contact("11-111"), new String[] {"Worker", "Married"});
        Person friend = new Person(false, 27, new Contact("22-131"), new String[] {"Student"});
        Account account = new Account("user12", user, 234, false, new Person[]{friend});

        /* Преобразуем объект account в json-строку */
        System.out.println(new JSONObject(account));

        /* JSONObject из json-строки строки */
        JSONObject jsonUserContact = new JSONObject("{\"phone\":\"11-111\"}");
        JSONObject jsonFriendContact = new JSONObject("{\"phone\":\"22-131\"}");

        /* JSONArray из ArrayList */
        List<String> userStatuses = new ArrayList<>();
        userStatuses.add("Worker");
        userStatuses.add("Married");
        JSONArray jsonUserStatuses = new JSONArray(userStatuses);
        List<String> friendStatuses = new ArrayList<>();
        friendStatuses.add("Student");
        JSONArray jsonFriendStatuses = new JSONArray(friendStatuses);

        /* JSONObject напрямую методом put */
        JSONObject jsonUserObject = new JSONObject();
        jsonUserObject.put("sex", user.isSex());
        jsonUserObject.put("age", user.getAge());
        jsonUserObject.put("contact", jsonUserContact);
        jsonUserObject.put("statuses", jsonUserStatuses);

        JSONObject jsonFriendObject = new JSONObject();
        jsonFriendObject.put("sex", friend.isSex());
        jsonFriendObject.put("age", friend.getAge());
        jsonFriendObject.put("contact", jsonFriendContact);
        jsonFriendObject.put("statuses", jsonFriendStatuses);

        /* JSONArray из ArrayList */
        List<JSONObject> friends = new ArrayList<>();
        friends.add(jsonFriendObject);
        JSONArray jsonFriends = new JSONArray(friends);

        /* JSONObject напрямую методом put */
        JSONObject jsonAccountObject = new JSONObject();
        jsonAccountObject.put("login", account.getLogin());
        jsonAccountObject.put("user", jsonUserObject);
        jsonAccountObject.put("id", account.getId());
        jsonAccountObject.put("subscription", account.isSubscription());
        jsonAccountObject.put("friends", jsonFriends);

        /* Выведем результат в консоль */
        System.out.println(jsonAccountObject);
    }
}
