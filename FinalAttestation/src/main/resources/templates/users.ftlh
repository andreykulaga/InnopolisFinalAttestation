<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Пользователи</title>
</head>
<body>
<h1>Пользователи</h1>
<table>
    <tr>
        <th>ID</th>
        <th>email</th>
        <th>Текущая роль</th>
        <th>Редактировать роль</th>
    </tr>
    <#list users as user>
        <tr>
            <td>${user.id}</td>
            <td>${user.email}</td>
            <td>${user.role}</td>
            <td><a href="/users/${user.id}">Редактировать</a></td>

            <td>
                <form method="post" action="/users/${user.id}/delete">
                    <input type="submit" value="Удалить">
                </form>
            </td>
        </tr>
    </#list>
</table>

<#if errors??>
    <h1 style="color: red">${errors}</h1>
</#if>


</body>
</html>