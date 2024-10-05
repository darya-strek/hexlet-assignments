@import exercise.util.NamedRoutes
@import exercise.dto.posts.PostPage
@param PostPage page

@template.layout.page(
    content = @`
        <div class="mx-auto p-4 py-md-5">
            <main>
                <a href="${NamedRoutes.postsPath()}">Все посты</a>
                <h3>${page.getPost().getName()}</h3>
                <p>Post's ID: ${page.getPost().getId()}</p>
                <p>${page.getPost().getBody()}</p>
            </main>
        </div>
    `
)