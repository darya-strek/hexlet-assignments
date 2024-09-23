@import exercise.dto.users.UsersPage
@param UsersPage page

@template.layout.page(
    content = @`
        <form action="/users" method="get">
            <input type="search" name="term" value="${page.getTerm()}">
            <input type="submit" value="Search">
        </form>

        @if(page.getUsers().isEmpty())
            <p></p>
        @else
            @for(var user : page.getUsers())
                <div>
                    <p><a href="/users/${user.getId()}">${user.getId()}</a>
                    Name: ${user.getFirstName()} ${user.getLastName()},
                    Email: ${user.getEmail()}</p>
                </div>
            @endfor
        @endif
    `
)