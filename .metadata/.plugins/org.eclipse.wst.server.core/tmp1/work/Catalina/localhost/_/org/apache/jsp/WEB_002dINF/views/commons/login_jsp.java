/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2020-07-08 07:20:19 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.commons;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<!-- 메인 로그인 CSS -->\r\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath() );
      out.write("/resources/css/login/loginMain.css\">\r\n");
      out.write("<style>\r\n");
      out.write("\t.loginFailText{\r\n");
      out.write("\t    font-size: 18px;\r\n");
      out.write("\t    color: red;\r\n");
      out.write("\t}\r\n");
      out.write("\t.logo2Imge{\r\n");
      out.write("    \twidth: inherit;\r\n");
      out.write("\t}\r\n");
      out.write("</style>\r\n");
      out.write("<title>로그인</title>\r\n");
      out.write("</head>\r\n");
      out.write("<script>\r\n");
      out.write("</script>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div class='wrap'>\r\n");
      out.write("\t<img class=\"logo2Imge\" src=\"");
      out.print(request.getContextPath() );
      out.write("/resources/images/loginLogo2.png\" />\r\n");
      out.write("\t<form name=\"loginForm\" action=\"/commons/loginCheck\" method=\"post\">\r\n");
      out.write("\t\t<input type='text' id='member_id' name=\"member_id\" placeholder='아이디' value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${member_id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\">\r\n");
      out.write("\t\t<input type='password' id='member_pwd' name=\"member_pwd\" placeholder='비밀번호'> \t<br>\r\n");
      out.write("\t\t<button class='login' onclick=\"SubmitLogin();\">로그인</button>\r\n");
      out.write("\t</form>\r\n");
      out.write("\t<button class='forgot' onclick=\"location.href='idForgot'\">아이디 찾기 </button>\r\n");
      out.write("\t<button class='forgot' onclick=\"location.href='pwdFoget'\">비밀번호 찾기 </button>\r\n");
      out.write("\t<button class='signUp' onclick=\"location.href='registFormChoose'\">회원가입</button>\r\n");
      out.write("\t<span class=\"loginFailText\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${msg }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</span>\r\n");
      out.write("\t<div><br>\r\n");
      out.write("\t\t<h3>불편사항 문의</h3>\r\n");
      out.write("\t\t<h4>1577-3525</h4>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("\t//아이디 또는 비밀번호가 틀렸을때 해당 비밀번호 지우고 포커스이동\r\n");
      out.write("\tif(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${msg}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"){\r\n");
      out.write("\t\t$(\"#member_pwd\").val(\"\");\r\n");
      out.write("\t\t$(\"#member_pwd\").focus();\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t//login submit!\r\n");
      out.write("\tfunction SubmitLogin(){\r\n");
      out.write("\t\tvar form= $(\"form[name='loginForm']\");\r\n");
      out.write("\t\tform.submit();\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}