@import exercise.util.NamedRoutes
@import exercise.dto.MainPage

@param MainPage mainPage

@template.layout.page(
    content = @`
        <main>
            <p>This is Main page</p>
        </main>
        <div>
            @if(mainPage.getName() != null)
                <p>Добро пожаловать, ${mainPage.getName().toString()}!</p>
                <form action="${NamedRoutes.logoutPath()}" method="post">
                    <input type="submit" value="Выйти" />
                </form>
            @else
                <p>Добро пожаловать!</p>
                <a href="${NamedRoutes.buildSessionPath()}">Войти</a>
            @endif
        </div>
    `
)