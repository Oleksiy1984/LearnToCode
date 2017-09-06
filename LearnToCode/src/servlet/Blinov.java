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
/**
 * �������� ���������� ����������� (2):
1)	������ ����� �������������� ������� ���������� ��� �������
 � ������ �������;
2)	������ ����� ���� ��������� ������ �������������;
3)	������ �� ����� ���� �������� ���������;
4)	���� ���������� ��������� ������� ��� ������ ���������� � ���� ��� ������������� �����,
 �� ������ ���������� ����� �������.

*������ ����� �������������� ������� ���������� ��� ������� � ������ �������. 
*������ ������������ ����� ���� ��������� ������� ���, � ����������� �� ����, 
*��� ������� �������, �������������. ����� invalidate() ������ InvalidStateException, 
*���� ���������� ��� ������, ������� ���� ���������. ������������� ��� ������� �������� 
*������� ����� ��� ������ �������� � ����, ��� ������ ������� �� �����������.
�����: 1, 3.
*/
/**
��� ���:
protected void doGet(HttpServletRequest request,
HttpServletResponse response) throws ServletException, IOException { 
HttpSession session = request.getSession(false); 
if (session == null) {
response.getWriter().println("no session"); 
session = rcquest.getSession(true);
} else {
// i - ����������� ���� ��������; static int i = 1 ��� ���������� 
response.getWriter().println("session " + /);

}
}
����� ���������� ����� ����������� ���������� ������������ 
������� � ���������� ������ doGet,
���� � ������� �������� ����� cookie-������ (1)?
1)	no session;
2)	session 1;
3)	session 2;
4)	session 3;
5)	������ �� ������������������.

������ ������� ���������������� � ������� �������� �������������� ������ 
(session id) ����� ��������, �������������� ������, � ��������.
�����: 1.
*/

/**
 *protected void doGet(HttpServletRequest request,
HttpServletResponse response) throws ServletException, IOException { 
//i - ����������� ���� ��������; static int i = 1 ��� ���������� 
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

�������, ������� cookie-������� ����� � ������ ������� (response), 
���� ���� ������ ���������� ����� ������ doGct 5 ��� � ������� 10 ������ (1):
1)	5;
2)	4;
3)	3;
4)	2;
5)	1;
6)	0;
7) ���������� ������ ����������.
������ 17.3.
����� Cookie �������� �� ������� ������� � ������������ 
�������� ������� ������������� ��� ������������� �������.
�����: 5.

 */


/**
 * ������� ���� �������, ������� ������������ listener-������� 
 * ������ ������, ������������ ��������� ���� ������ (3):
1)	session creation
2)	addition of session attributes
3)	removal of session attributes
4)	replacement of session attributes
5)	session invalidation
6)	session timeout
������ 17.4.
��������� ������ ������, ������������ ��������� ���� ������ � 
���: session creation, session invalidation, session timeout. 
��������� ��������� � ��������, ���������� �������� ������.
�����: 1,5,6.

������ 17.5.
�������� ���������� ����������� (2):
1)	������� ��������� ��������� �������, ������� ����� �������� ��������� �������;
2)	������� �� ��������� ��������� �������, ������� ����� �������� ��������� ������;
3)	������� ����� ������� ����� ������ � �����;
4)	������ ����� ������������ ��� ���������� ����� ������ ��������.
������ 17.5.
������� ����� �������� ��������� � ���������� ������� � ������. 
������� �� ������� ������ ��� �����. ������ ����� ������������ ��� ���������� 
����� ������ ��������. �����: 1, 4.
 */


