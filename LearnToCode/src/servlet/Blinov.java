package servlet;

public class Blinov {

}
/**
 * Параметры конфигурации сервлета были заданы в файле-дескрипторе развертывания сервлета.
 *  Указать, с помощью методов какого интерфейса можно прочитать эти параметры в сервлете (1):
	Servlet
	ServletRequest
	ServletResponse
4)	ServletConflg
	ServletContext

Центральной абстракцией API сервлета является интерфейс Servlet. 
Интерфейс ServletRequest инкапсулирует связь клиента с сервером. 
Интерфейс ServletResponse инкапсулирует обратную связь сервлета с клиентом. 
Интерфейс ServletContext используется для взаимодействия с контейнером сервлетов. 
Интерфейс ServletConfig представляет собой конфигурацию сервлета, используется, 
в основном, на этапе инициализации.
Ответ: 4.



 */
/**
Выбрать вариант URL, определяемый в адресной строке браузера и отправляющий
 http-запрос сервлету методом POST (1):
	http://localhost:8080/Quests/Quest?method=post
	POST http://localhost:8080/Quests/Quest
	[POST]http://localhost:8080/Quests/Quest
	http://localhost:8080/Quests/Quest[posl]
5)	ничего из вышеперечисленного
Вопрос 15.2.
Послать http-запрос из адресной строки браузера методом POST нельзя.
Ответ: 5.

*/
/*
Вопрос 15.3.
Выбрать метод, который за жизненный цикл сервлета может быть вызван более одного раза (1):
	init()
2)	service()
	destroy()
	конструктор сервлета
Вопрос 15.3.
Веб-контейнер создает объект сервлета, вызывает метод init(). 
Метод serviceO вызывается в сервлете для управления каждым запросом. 
Перед уничтожением объекта контейнер вызовет метод destroy()
Ответ: 2.
*/
/**
 * Дан код
 * public class Quest extends HttpServlet {
protected void doGet(HttpServletRequest request,
HttpServlctResponse response) throws ServletException, IOException 
{ String strl = request.getParameter"param 1");
String str2 = request.getParameter("param2"); 
response.getWriter().println(strl + " " + str2);
}}
Указать вариант записи URL, в результате запроса которого в 
сервлет инициализирует переменную strl в значение one, а переменную str2 в значение two:
1)	http://localhost:8080/Tests3-18/Quest?paraml=\"one\"&param2=\"two\"
2)	http://localhost:8080/Tests3-18/Quest?paraml="one"&param2="two"
3)	http ://localhost:8080/Tests3-18/Quest?param l=one&param2=two
4)	http ://localhost:8080/Tests3-18/Quest?param l=one+param2=tvvo
5)	http ://localhost:8080/Tests3-18/Quest?param l=one?param2=two
6)	http://localhost:8080/Tests3-18/Qucst?paraml="one"?param2="two"
Запрос от параметров отделяется символом «?», параметры между собой — символом «&».
Ответ: 3.
*/
/**
 * Выберите корректные утверждения (2):
1)	сессия может использоваться разными сервлетами для доступа
 к одному клиенту;
2)	сессия может быть завершена только автоматически;
3)	сессия не может быть повторно завершена;
4)	если промежуток активного времени для сессии установить в ноль или отрицательное число,
 то сессию невозможно будет создать.

*Сессия может использоваться разными сервлетами для доступа к одному клиенту. 
*Сессия пользователя может быть завершена вручную или, в зависимости от того, 
*где запущен сервлет, автоматически. Метод invalidate() выдает InvalidStateException, 
*если вызывается для сессии, которая была завершена. Отрицательное или нулевое значение 
*времени жизни для сессии приводит к тому, что сессия никогда не завершается.
Ответ: 1, 3.
*/
/**
Дан код:
protected void doGet(HttpServletRequest request,
HttpServletResponse response) throws ServletException, IOException { 
HttpSession session = request.getSession(false); 
if (session == null) {
response.getWriter().println("no session"); 
session = rcquest.getSession(true);
} else {
// i - статическое поле сервлета; static int i = 1 при объявлении 
response.getWriter().println("session " + /);

}
}
Какая информация будет результатом выполнения трехкратного 
запроса к указанному методу doGet,
если у клиента запрещен прием cookie-файлов (1)?
1)	no session;
2)	session 1;
3)	session 2;
4)	session 3;
5)	ничего из вышеперечисленного.

Сессия клиента идентифицируется с помощью передачи идентификатора сессии 
(session id) между клиентом, осуществляющим запрос, и сервером.
Ответ: 1.
*/

/**
 *protected void doGet(HttpServletRequest request,
HttpServletResponse response) throws ServletException, IOException { 
//i - статическое поле сервлета; static int i = 1 при объявлении 
Cookie[] cook = request. getCookies(); 
if (cook != null) (
Cookie cook2 = new Cookie(i + "", i + "");
i++;
cook2.setMaxAge(10); 
response.addCookie(cook2);
response.getWriter().println("cookies = " + cook.length);
} else {
Cookie cook2 = new Cookie(0 +""	0 + "");
cook2.setMaxAge( 10); 
response.addCookie(cook2); 
response.getWriter().println("one cookie");
} 

Укажите, сколько cookie-записей уйдет в ответе клиенту (response), 
если один клиент осуществит вызов метода doGct 5 раз в течение 10 секунд (1):
1)	5;
2)	4;
3)	3;
4)	2;
5)	1;
6)	0;
7) произойдет ошибка компиляции.
Вопрос 17.3.
Файлы Cookie хранятся на стороне клиента и отправляются 
клиентом серверу автоматически при осуществлении запроса.
Ответ: 5.

 */


/**
 * Укажите типы событий, которые обрабатывают listener-объекты 
 * уровня сессии, определяющие жизненный цикл сессии (3):
1)	session creation
2)	addition of session attributes
3)	removal of session attributes
4)	replacement of session attributes
5)	session invalidation
6)	session timeout
Вопрос 17.4.
Слушатели уровня сессии, определяющие жизненный цикл сессии — 
это: session creation, session invalidation, session timeout. 
Остальные относятся к событиям, изменяющим атрибуты сессии.
Ответ: 1,5,6.

Вопрос 17.5.
Выберите корректные утверждения (2):
1)	фильтры позволяют создавать объекты, которые могут изменять заголовок запроса;
2)	фильтры не позволяют создавать объекты, которые могут изменять заголовок ответа;
3)	фильтры могут создать новый запрос и ответ;
4)	фильтр можно использовать для фильтрации более одного сервлета.
Вопрос 17.5.
Фильтры могут изменять заголовок и содержимое запроса и ответа. 
Фильтры не создают запрос или ответ. Фильтр можно использовать для фильтрации 
более одного сервлета. Ответ: 1, 4.
 */


