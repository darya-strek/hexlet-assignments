@import exercise.dto.users.UsersPage

@param UsersPage page

@template.layout.page(
    content = @`
        <div class="mx-auto p-4 py-md-5">
          <h>List of all users</h>
            <table class="table">
              <thead>
                <tr>
                  <th scope="col">ID</th>
                  <th scope="col">Name</th>
                </tr>
              </thead>
              <tbody>
                @for(var user : page.getUsers())
                  <tr>
                    <td><a href="/users/${user.getId()}">${user.getId()}</a></td>
                    <td>${user.getFirstName()} ${user.getLastName()}</td>
                  </tr>
                @endfor
              </tbody>
            </table>
        </div>
    `
)