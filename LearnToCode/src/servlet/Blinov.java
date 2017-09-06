package servlet;

public class Blinov {

}
/**
 * ��������� ������������ �������� ���� ������ � �����-����������� ������������� ��������.
 *  �������, � ������� ������� ������ ���������� ����� ��������� ��� ��������� � �������� (1):
	Servlet
	ServletRequest
	ServletResponse
4)	ServletConflg
	ServletContext

����������� ����������� API �������� �������� ��������� Servlet. 
��������� ServletRequest ������������� ����� ������� � ��������. 
��������� ServletResponse ������������� �������� ����� �������� � ��������. 
��������� ServletContext ������������ ��� �������������� � ����������� ���������. 
��������� ServletConfig ������������ ����� ������������ ��������, ������������, 
� ��������, �� ����� �������������.
�����: 4.



 */
/**
������� ������� URL, ������������ � �������� ������ �������� � ������������
 http-������ �������� ������� POST (1):
	http://localhost:8080/Quests/Quest?method=post
	POST http://localhost:8080/Quests/Quest
	[POST]http://localhost:8080/Quests/Quest
	http://localhost:8080/Quests/Quest[posl]
5)	������ �� ������������������
������ 15.2.
������� http-������ �� �������� ������ �������� ������� POST ������.
�����: 5.

*/
/*
������ 15.3.
������� �����, ������� �� ��������� ���� �������� ����� ���� ������ ����� ������ ���� (1):
	init()
2)	service()
	destroy()
	����������� ��������
������ 15.3.
���-��������� ������� ������ ��������, �������� ����� init(). 
����� serviceO ���������� � �������� ��� ���������� ������ ��������. 
����� ������������ ������� ��������� ������� ����� destroy()
�����: 2.
*/
/**
 * ��� ���
 * public class Quest extends HttpServlet {
protected void doGet(HttpServletRequest request,
HttpServlctResponse response) throws ServletException, IOException 
{ String strl = request.getParameter"param 1");
String str2 = request.getParameter("param2"); 
response.getWriter().println(strl + " " + str2);
}}
������� ������� ������ URL, � ���������� ������� �������� � 
������� �������������� ���������� strl � �������� one, � ���������� str2 � �������� two:
1)	http://localhost:8080/Tests3-18/Quest?paraml=\"one\"&param2=\"two\"
2)	http://localhost:8080/Tests3-18/Quest?paraml="one"&param2="two"
3)	http ://localhost:8080/Tests3-18/Quest?param l=one&param2=two
4)	http ://localhost:8080/Tests3-18/Quest?param l=one+param2=tvvo
5)	http ://localhost:8080/Tests3-18/Quest?param l=one?param2=two
6)	http://localhost:8080/Tests3-18/Qucst?paraml="one"?param2="two"
������ �� ���������� ���������� �������� �?�, ��������� ����� ����� � �������� �&�.
�����: 3.
*/

