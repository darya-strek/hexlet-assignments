@import exercise.dto.users.UsersPage

@param UsersPage page

@template.layout.page(
    content = @`
        <h2>Users</h2>
        <form>
            <input type="search" name="term" value="${page.getTerm()}">
            <input type="submit" value="Search">
        </form>
        @for(var user : page.getUsers())
            <div>
                <p>${user.getFirstName()} ${user.getLastName()}</p>
            </div>
        @endfor
    `
)