package exercise.controller;

import static io.javalin.rendering.template.TemplateUtil.model;
import exercise.dto.posts.PostsPage;
import exercise.dto.posts.PostPage;
import exercise.model.Post;
import exercise.repository.PostRepository;
import exercise.dto.posts.BuildPostPage;
import exercise.util.NamedRoutes;
import io.javalin.http.Context;
import io.javalin.validation.ValidationException;
import io.javalin.http.NotFoundResponse;

public class PostsController {

    public static void build(Context ctx) {
        var page = new BuildPostPage();
        ctx.render("posts/build.jte", model("page", page));
    }

    // BEGIN
    public static void index(Context ctx) {
        var posts = PostRepository.getEntities();
        var page = new PostsPage(posts);
        page.setFlash(ctx.consumeSessionAttribute("flash"));
        page.setStatus(ctx.consumeSessionAttribute("status"));
        ctx.render("posts/index.jte", model("page", page));
    }

    public static void create(Context ctx) {
        var name = ctx.formParam("name").trim();
        var body = ctx.formParam("body");

        try {
            var checkedName = ctx.formParamAsClass("name", String.class)
                    .check(value -> value.length() >= 2, "Post's name must be longer 1 symbol!")
                    .get();

            var post = new Post(checkedName, body);
            PostRepository.save(post);

            ctx.sessionAttribute("flash", "Post was successfully created!");
            ctx.sessionAttribute("status", "positive");
            ctx.redirect(NamedRoutes.postsPath());

        } catch (ValidationException e) {
            ctx.sessionAttribute("flash", "Post's creating has been failed!");
            ctx.sessionAttribute("status", "negative");

            var page = new BuildPostPage(name, body, e.getErrors());
            page.setFlash(ctx.consumeSessionAttribute("flash"));
            page.setStatus(ctx.consumeSessionAttribute("status"));

            ctx.render("posts/build.jte", model("page", page));
        }
    }
    // END

    public static void show(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var post = PostRepository.find(id)
            .orElseThrow(() -> new NotFoundResponse("Post not found"));

        var page = new PostPage(post);
        ctx.render("posts/show.jte", model("page", page));
    }
}
