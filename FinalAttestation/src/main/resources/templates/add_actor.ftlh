<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Актеры</title>
</head>
<body>
<h1>Актера добавленные в фильм ${movie.title}</h1>
<#list movie.actors as actor>
<ul>
    <a href="/actors/${actor.id}">${actor.firstName} ${actor.lastName}</a>
</ul>
</#list>

<h1>Актеры доступные для добавления</h1>
<table>
    <tr>
        <th>ID</th>
        <th>Имя</th>
        <th>Фамилия</th>
        <th>День рождения</th>
    </tr>
    <#list actors as actor>
        <tr>
            <td>${actor.id}</td>
            <td>${actor.firstName}</td>
            <td>${actor.lastName}</td>
            <td>${actor.birthday}</td>
            <td>
                <form method="post" action="/${movie.id}/add_actor/${actor.id}">
                    <input type="submit" value="Добавить">
                </form>
            </td>
        </tr>
    </#list>
</table>
</body>
</html>