@import exercise.util.NamedRoutes
@import exercise.dto.posts.PostsPage
@param PostsPage page

@template.layout.page(
    content = @`
        <div class="mx-auto p-4 py-md-5">
            <main>
                @if(page.getPosts().isEmpty())
                    <p>Пока не добавлено ни одного поста</p>
                @else
                    @for(var post : page.getPosts())
                        <p><a href="${NamedRoutes.postPath(post.getId())}">${post.getName()}</a></p>
                    @endfor
                @endif
                <nav aria-label="Page navigation example">
                  <ul class="pagination">
                    <li class="page-item"><a class="page-link" href="${page.getPreviousPage()}">Previous</a></li>
                    <li class="page-item"><a class="page-link" href="${page.getNextPage()}">Next</a></li>
                  </ul>
                </nav>
            </main>
        </div>
    `
)