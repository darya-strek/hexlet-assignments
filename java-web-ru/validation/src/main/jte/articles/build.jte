@import exercise.dto.articles.BuildArticlePage

@param BuildArticlePage page

<html lang="en">
  <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
            crossorigin="anonymous">
    <title>New article</title>
    </head>
    <body>
        @if(page.getErrors() != null)
              <ul>
                  @for(var validator : page.getErrors().values())
                      @for(var error : validator)
                          <li>${error.getMessage()}</li>
                      @endfor
                  @endfor
              </ul>
        @endif

          <form action="/articles" method="post">
            <div>
              <label>
                Название статьи
                <input type="text" name="title" value="${page.getTitle()}" />
              </label>
            </div>
            <div>
              <label for="article">Текст статьи</label>
              <textarea id="article" name="content" rows="7" cols="30">${page.getContent()}</textarea>
            </div>
            <input type="submit" value="Сохранить статью" />
          </form>
    </body>
</html>