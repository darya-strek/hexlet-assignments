@import exercise.util.NamedRoutes
@import exercise.dto.LoginPage

@param LoginPage loginPage

@template.layout.page(
    content = @`
            @if(loginPage.getError() != null)
                <ul>
                    <h5>${loginPage.getError()}</h5>
                </ul>
            @endif

            <form action="${NamedRoutes.loginPath()}" method="post">
              <label>
                Имя:
                <input type="text" id="name" name="name" />
              </label>
              <label>
                Пароль:
                <input type="password" id="password" name="password" />
              </label>
              <input type="submit" value="Войти" />
            </form>
    `
)