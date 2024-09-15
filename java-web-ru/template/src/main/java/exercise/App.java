package exercise;

import io.javalin.Javalin;

import java.util.Comparator;
import java.util.List;
import io.javalin.http.NotFoundResponse;
import exercise.model.User;
import exercise.dto.users.UserPage;
import exercise.dto.users.UsersPage;
import io.javalin.rendering.template.JavalinJte;

import java.util.Collections;
import java.util.Objects;
import java.util.stream.Collectors;

import static io.javalin.rendering.template.TemplateUtil.model;

public final class App {

    // Каждый пользователь представлен объектом класса User
    private static final List<User> USERS = Data.getUsers();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.plugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });

        // BEGIN
        app.get("/users/{id}", ctx -> {
            var userId = ctx.pathParamAsClass("id", Long.class).get();
            var user = USERS.stream()
                    .filter(u -> Objects.equals(u.getId(), userId))
                    .findFirst()
                    .orElseThrow(() -> new NotFoundResponse("User not found"));
            var page = new UserPage(user);
            ctx.render("users/show.jte", model("page", page));
        });

        app.get("/users", ctx -> {
            var users = USERS.stream()
                    .sorted(Comparator.comparing(User::getId))
                    .collect(Collectors.toList());
            var page = new UsersPage(users);
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
