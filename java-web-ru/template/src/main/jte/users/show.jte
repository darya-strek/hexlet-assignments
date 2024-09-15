@import exercise.dto.users.UserPage
@param UserPage page

<html>
  <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <title>User</title>
  </head>
  <body>
    <div class="mx-auto p-4 py-md-5">
      <main>
        <a href="/">Main page</a><span>           </span><a href="/users">Users</a>
        <h1>User ${page.getUser().getId()}</h1>
        <p class="h5">User ID: ${page.getUser().getId()}</p>
        <p class="h5">Name: ${page.getUser().getFirstName()} ${page.getUser().getLastName()}</p>
        <p class="h5">Email: ${page.getUser().getEmail()}</p>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
      </main>
    </div>
  </body>
</html>