@import exercise.dto.users.UserPage

@param UserPage page

@template.layout.page(
    content = @`
        <div class="mx-auto p-4 py-md-5">
            <main>
                <h2>${page.getUser().getFirstName()} ${page.getUser().getLastName()}</h2>
                <p><i>First name: </i>${page.getUser().getFirstName()}</p>
                <p><i>Last name: </i>${page.getUser().getLastName()}</p>
                <p><i>User's ID: </i>${page.getUser().getId()}</p>
                <p><i>Email: </i>${page.getUser().getEmail()}</p>
            </main>
        </div>
    `
)