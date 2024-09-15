@import exercise.dto.users.UsersPage
@param UsersPage page

<html>
  <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <title>Users</title>
  </head>
  <body>
    <div class="mx-auto p-4 py-md-5">
      <main>
        <a href="/">Main page</a>
        <h1 class="h3">Users</h1>
        @if(page.getUsers().isEmpty())
          <p>No one user</p>
        @else
          <table class="table table-hover">
            <thead>
              <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
              </tr>
            </thead>
            <tbody>
              @for(var user : page.getUsers())
                <tr>
                  <td><a href="/users/${user.getId()}">${user.getId()}</a></td>
                  <td>${user.getFirstName()} ${user.getLastName()}</td>
                  <td>${user.getEmail()}</td>
                </tr>
              @endfor
            </tbody>
          </table>
        @endif
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
      </main>
    </div>
  </body>
</html>