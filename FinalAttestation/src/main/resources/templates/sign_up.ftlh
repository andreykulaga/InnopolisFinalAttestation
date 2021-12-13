<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Регистрация</title>
</head>
<body>
<h1>
    Укажите email и придумайте пароль
</h1>
<form method="post" action="/sign_up">
    <label>
        Имя пользователя <input type="email" name="email" placeholder="Укажите email">
    </label>
    <label>
        Пароль <input type="password" name="password" placeholder="Придумайте пароль">
    </label>
    <input type="submit" value="Регистрация">
</form>

</body>
</html>