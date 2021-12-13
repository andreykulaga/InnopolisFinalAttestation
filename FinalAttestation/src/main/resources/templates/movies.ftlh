<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Фильмы</title>
</head>
<body>
<h1>Добавление фильма</h1>
<form method="post" action="/movies">
    <label>:
        <input name="title" placeholder="Название">
    </label>
    <label>:
        <input type="date" name="releaseDate" placeholder="release date">
    </label>
    <label>:
        <select name="genre">
            <option value="" selected disabled hidden>Выберите жанр</option>
            <option value="Драма">Драма</option>
            <option value="Боевик">Боевик</option>
            <option value="Мюзикл">Мюзикл</option>
        </select>
    </label>
    <input type="submit" value="Добавить">
</form>
<#if errors??>
    <h1 style="color: red">${errors}</h1>
</#if>

<table>
    <tr>
        <th>ID</th>
        <th>Название</th>
        <th>Дата выпуска</th>
        <th>Жанр</th>
        <th>Оценка</th>
    </tr>
    <#list movies as movie>
        <tr>
            <td>${movie.id}</td>
            <td>${movie.title}</td>
            <td>${movie.releaseDate}</td>
            <td>${movie.genre}</td>
            <td>${movie.mediumScore}</td>
            <td>
                <form method="post" action="/movies/${movie.id}/delete">
                    <input type="submit" value="Удалить">
                </form>
                <a href="/movies/${movie.id}">Перейти</a>
            </td>
        </tr>
    </#list>
</table>
</body>
</html>