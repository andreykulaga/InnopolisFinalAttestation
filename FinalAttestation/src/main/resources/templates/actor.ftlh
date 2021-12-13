<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>${actor.firstName} ${actor.lastName}</title>
</head>
<body>
<h3>Имя - ${actor.firstName}</h3>
<h3>Фамилия - ${actor.lastName}</h3>
<h3>День рождения - ${actor.birthday}</h3>
<h3>Фильмы:</h3>
<#list actor.movies as movie>
    <ul>
        <a href="/movies/${movie.id}">${movie.title}</a>
    </ul>
</#list>

<br>
<form method="post" action="/actors/${actor.id}/update">
    <label>
        Название <input name="firstName" value="${actor.firstName}">
    </label>
    <label>
        Название <input name="lastName" value="${actor.lastName}">
    </label>
    <label>
        День рождения <input type="date" name="birthday" value="${actor.birthday}">
    </label>
    <input type="submit" value="Сохранить">
</form>
</body>
</html>
