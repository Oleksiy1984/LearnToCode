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

