@import exercise.dto.users.UserPage
@param UserPage page

<!doctype html>

<html lang="en">
  <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
            crossorigin="anonymous">
    <title>User ${page.getUser().getFirstName()} ${page.getUser().getLastName()}</title>
  </head>
  <body>
    <div class="mx-auto p-4 py-md-5">
      <main>
            <h2>${page.getUser().getFirstName()} ${page.getUser().getLastName()}</h2>
            <p><i>First name: </i>${page.getUser().getFirstName()}</p>
            <p><i>Last name: </i>${page.getUser().getLastName()}</p>
            <p><i>User's ID: </i>${page.getUser().getId()}</p>
            <p><i>Email: </i>${page.getUser().getEmail()}</p>
      </main>
    </div>
  </body>
</html>