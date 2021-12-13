<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>${user.email}</title>
</head>
<body>
<h3>Email - ${user.email}</h3>
<h3>Текущая роль - ${user.role}</h3>

<br>
<form method="post" action="/users/${user.id}/update">
    <label>
        Роль
        <select id="mySelect" name="role">
            <option value="" selected disabled hidden>Выберите роль</option>
            <option value="ADMIN">ADMIN</option>
            <option value="USER">USER</option>
        </select>
        <script>
            var temp = "${user.role}";
            var mySelect = document.getElementById('mySelect');

            for(var i, j = 0; i = mySelect.options[j]; j++) {
                if(i.value == temp) {
                    mySelect.selectedIndex = j;
                    break;
                }
            }
        </script>
    </label>
    <input type="submit" value="Сохранить">
</form>
</body>
</html>
