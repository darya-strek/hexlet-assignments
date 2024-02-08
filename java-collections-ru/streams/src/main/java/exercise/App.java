package exercise;

import java.util.List;

// BEGIN
class App {

    public static long getCountOfFreeEmails(List<String> emails) {
        long emailsFreeList = emails.stream()
                .filter(email -> isFreeEmail(email))
                .count();
        return emailsFreeList;
    }

    private static boolean isFreeEmail(String email) {
        return email.contains("@gmail.com") || email.contains("@yandex.ru") || email.contains("@hotmail.com");
    }
}
// END
