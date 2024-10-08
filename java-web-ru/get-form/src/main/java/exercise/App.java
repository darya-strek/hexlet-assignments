package exercise;

import io.javalin.Javalin;

import java.util.Comparator;
import java.util.List;
import exercise.model.User;
import exercise.dto.users.UsersPage;
import java.util.Collections;
import org.apache.commons.lang3.StringUtils;

import static io.javalin.rendering.template.TemplateUtil.model;

public final class App {

    // Каждый пользователь представлен объектом класса User
    private static final List<User> USERS = Data.getUsers();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.plugins.enableDevLogging();
        });

        // BEGIN
        app.get("/users", ctx -> {
            var term = ctx.queryParam("term");
            List<User> users;
            if (term != null) {
                users = USERS.stream()
                        .filter(user -> StringUtils.containsIgnoreCase(user.getFirstName(), term))
                        .toList();
            } else {
                users = USERS.stream()
                        .sorted(Comparator.comparing(User::getFirstName))
                        .toList();
            }
            var page = new UsersPage(users, term);
            ctx.render("users/index.jte", model("page", page));
        });
        // END

        app.get("/", ctx -> {
            ctx.render("index.jte");
        });

        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
