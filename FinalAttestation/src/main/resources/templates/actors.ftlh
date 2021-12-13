<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Актеры</title>
</head>
<body>
<h1>Актера фильма</h1>
<form method="post" action="/actors">
    <label>:
        <input name="firstName" placeholder="Имя">
    </label>
    <label>:
        <input name="lastName" placeholder="Фамилия">
    </label>
    <label>:
        <input type="date" name="birthday" placeholder="День рождения">
    </label>
    <input type="submit" value="Добавить">
</form>
<#if errors??>
    <h1 style="color: red">${errors}</h1>
</#if>

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
                <form method="post" action="/actors/${actor.id}/delete">
                    <input type="submit" value="Удалить">
                </form>
                <a href="/actors/${actor.id}">Перейти</a>
            </td>
        </tr>
    </#list>
</table>
</body>
</html>