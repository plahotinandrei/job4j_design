package ru.job4j.question;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Analyze {

    public static Info diff(Set<User> previous, Set<User> current) {
        int added = 0;
        int changed = 0;
        Map<Integer, User> users = new HashMap<>();
        for (User user:previous) {
            users.put(user.getId(), user);
        }
        for (User user:current) {
            User containedUser = users.get(user.getId());
            if (containedUser == null) {
                added++;
            } else if (!user.equals(containedUser)) {
                changed++;
            }
            users.remove(user.getId());
        }
        int deleted = users.size();
        return new Info(added, changed, deleted);
    }
}

