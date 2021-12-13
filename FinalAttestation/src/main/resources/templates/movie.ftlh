<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>${movie.title}</title>
</head>
<body>
<h3>Название - ${movie.title}</h3>
<h3>Оценка - ${movie.mediumScore}</h3>
<h3>Дата выпуска - ${movie.releaseDate}</h3>
<h3>Жанр - ${movie.genre}</h3>
<h3>Актеры:</h3>
<#list movie.actors as actor>
<ul>
    <a href="/actors/${actor.id}">${actor.firstName} ${actor.lastName}</a>
</ul>
</#list>
<a href="/${movie.id}/add_actor">Добавить актёра</a>

<br>
<form method="post" action="/movies/${movie.id}/update">
    <label>
        Название <input name="title" value="${movie.title}">
    </label>
    <label>
        Дата выпуска <input type="date" name="releaseDate" value="${movie.releaseDate}">
    </label>
    <label>
        Жанр
        <select id="mySelect" name="genre">
            <option value="" selected disabled hidden>Выберите жанр</option>
            <option value="Драма">Драма</option>
            <option value="Боевик">Боевик</option>
            <option value="Мюзикл">Мюзикл</option>
        </select>
        <script>
            var temp = "${movie.genre}";
            var mySelect = document.getElementById('mySelect');

            for(var i, j = 0; i = mySelect.options[j]; j++) {
                if(i.value == temp) {
                    mySelect.selectedIndex = j;
                    break;
                }
            }
        </script>
    </label>
    <label>
        Оценка <input name="mediumScore" value="${movie.mediumScore}">
    </label>
    <input type="submit" value="Сохранить">
</form>
</body>
</html>
