<!-- BEGIN -->
@import exercise.dto.BasePage
@import exercise.util.NamedRoutes

@import gg.jte.Content

@param BasePage page = null
@param Content content

<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Main page</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    </head>
    <body>
        @if(page != null && page.getFlash() != null)
            @if(page.getStatus().equals("positive"))
                <div class="alert alert-success" role="alert">
                  <p>${page.getFlash()}</p>
                </div>
            @else
                <div class="alert alert-danger" role="alert">
                  <p>${page.getFlash()}</p>
                </div>
            @endif
        @endif

        <h1>Main page</h1>
        <p>
          <a href="${NamedRoutes.postsPath()}">Posts</a><span>    </span>
          <a href="${NamedRoutes.buildPostPath()}">New post</a>
        </p>
        <div>
            ${content}
        </div>
    </body>
</html>
<!-- END -->
