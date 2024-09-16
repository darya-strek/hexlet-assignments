@import exercise.dto.users.UsersPage

@param UsersPage page

@template.layout.page(
    content = @`
        <div class="mx-auto p-4 py-md-5">
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
        </div>
    `
)