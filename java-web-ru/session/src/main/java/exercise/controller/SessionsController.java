package exercise.controller;

import static io.javalin.rendering.template.TemplateUtil.model;
import exercise.dto.MainPage;
import exercise.dto.LoginPage;
import exercise.repository.UsersRepository;
import static exercise.util.Security.encrypt;

import exercise.util.NamedRoutes;
import io.javalin.http.Context;

public class SessionsController {

    // BEGIN
    public static void index(Context ctx) {
        String currentUser = ctx.sessionAttribute("currentUser");
        var mainPage =  new MainPage(currentUser);
        ctx.render("index.jte", model("mainPage", mainPage));
    }

    public static void build(Context ctx) {
        String name = ctx.sessionAttribute("currentUser");
        var loginPage = new LoginPage(name, null);
        ctx.render("build.jte", model("loginPage", loginPage));
    }

    public static void login(Context ctx) {
        String name = ctx.formParam("name");
        String password = ctx.formParam("password");
        String encryptedPassword = encrypt(password);

        if(!UsersRepository.existsByName(name)) {
            String error = "Wrong username or password";
            String currentUser = ctx.sessionAttribute("currentUser");
            var loginPage = new LoginPage(currentUser, error);
            ctx.render("build.jte", model("loginPage", loginPage));
            return;
        }

        var user = UsersRepository.findByName(name).get();

        if(encryptedPassword.equals(user.getPassword())) {
            ctx.sessionAttribute("currentUser", name);
            ctx.redirect(NamedRoutes.rootPath());
        } else {
            String error = "Wrong username or password";
            var loginPage = new LoginPage(ctx.sessionAttribute("currentUser"), error);
            ctx.render("build.jte", model("loginPage", loginPage));
        }
    }

    public static void logout(Context ctx) {
        ctx.sessionAttribute("currentUser", null);
        ctx.redirect(NamedRoutes.rootPath());
    }
    // END
}
