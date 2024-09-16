@import exercise.dto.users.UserPage

@param UserPage page

@template.layout.page(
    content = @`
        <div class="mx-auto p-4 py-md-5">
            <h3>User:</h3>
            <p class="h5">User ID: ${page.getUser().getId()}</p>
            <p class="h5">Name: ${page.getUser().getFirstName()} ${page.getUser().getLastName()}</p>
            <p class="h5">Email: ${page.getUser().getEmail()}</p>
        </div>
    `
)