@import exercise.dto.posts.PostsPage
@import exercise.util.NamedRoutes
@param PostsPage page

@template.layout.page(
    page = page,
    content = @`

        <a href="${NamedRoutes.buildPostPath()}">New post</a>

        @if(page.getPosts().isEmpty())
            <p>Пока не добавлено ни одного курса</p>
        @else
            @for(var post : page.getPosts())
               <div>
                   <h2><a href="${NamedRoutes.postPath(post.getId())}">${post.getName()}</a></h2>
                   <p>${post.getBody()}</p>
               </div>
            @endfor
        @endif
    `
)