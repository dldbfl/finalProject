/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2020-07-09 03:11:43 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.commons;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class registFormChoose_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<style>\r\n");
      out.write("\t.registFormChoose{\r\n");
      out.write("\t\tposition: relative;\r\n");
      out.write("\t    padding-bottom: 28px;\r\n");
      out.write("\t    margin-bottom: 20%;\r\n");
      out.write("\t    border-bottom: 5px solid #333;\r\n");
      out.write("\t    margin-top: 4%;\r\n");
      out.write("\t\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t.registFormChoose .steps li{\r\n");
      out.write("\t\tfloat: left;\r\n");
      out.write("\t    margin-left: 18px;\r\n");
      out.write("\t    font-size: 15px;\r\n");
      out.write("\t    letter-spacing: -0.5px;\r\n");
      out.write("\t    color: #999;\r\n");
      out.write("\t    list-style: none;\r\n");
      out.write("\t}\r\n");
      out.write("\t.registFormChoose .steps li.on{\r\n");
      out.write("\t\tcolor: #111;\r\n");
      out.write("\t    font-weight: bold;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t.steps{\r\n");
      out.write("\t\tfloat: right;\r\n");
      out.write("\t}\r\n");
      out.write("\t.memberMenu{\r\n");
      out.write("\t\ttext-align: center;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t.memberMenu button,.memberMenu span{\r\n");
      out.write("\t\tfont-size: 20px;\r\n");
      out.write("\t\tfont-weight: bold;\r\n");
      out.write("\t\t\r\n");
      out.write("\t}\r\n");
      out.write("\t.student{\r\n");
      out.write("\t\tfloat: left;\r\n");
      out.write("\t\tborder: 2px solid;\r\n");
      out.write("\t\twidth: 50%;\r\n");
      out.write("\t\theight: 300px;\r\n");
      out.write("    \tpadding: 10%;\r\n");
      out.write("\t}\r\n");
      out.write("\t.professor{\r\n");
      out.write("\t\tfloat: right;\r\n");
      out.write("\t\tborder: 2px solid;\r\n");
      out.write("\t\twidth: 50%;\r\n");
      out.write("\t\theight: 300px;\r\n");
      out.write("    \tpadding: 10%;\r\n");
      out.write("\t}\r\n");
      out.write("\t.memberImgeBox i{\r\n");
      out.write("\t\tdisplay: block;\r\n");
      out.write("\t}\r\n");
      out.write("\t.wrap-content{\r\n");
      out.write("\t\tborder-bottom: 1px solid gray;\r\n");
      out.write("\t}\r\n");
      out.write("\t.student:hover, .professor:hover{\r\n");
      out.write("\t\tbackground-color: #b0fff8;\r\n");
      out.write("\t}\r\n");
      out.write("\t.step1,.step2,.step3,.step4{\r\n");
      out.write("\t    font-size: 22px;\r\n");
      out.write("\t}\r\n");
      out.write("</style>\r\n");
      out.write("<body>\r\n");
      out.write("<div class=\"wrap\">\r\n");
      out.write("\t\t\t<div class=\"registFormChoose\">\r\n");
      out.write("\t\t\t\t<h1>\r\n");
      out.write("\t\t\t\t\t<a href=\"");
      out.print(request.getContextPath() );
      out.write("/main\" class=\"logoImage\"></a>\r\n");
      out.write("\t\t\t\t\t<span>회원가입</span>\r\n");
      out.write("\t\t\t\t</h1>\r\n");
      out.write("\t\t\t\t<ol class=\"steps\">\r\n");
      out.write("\t\t\t\t\t<li class=\"step1 on\">1.회원선택</li>\r\n");
      out.write("\t\t\t\t\t<li class=\"step2\">2.약관동의</li>\r\n");
      out.write("\t\t\t\t\t<li class=\"step3\">3.정보입력</li>\r\n");
      out.write("\t\t\t\t\t<li class=\"step4\">4.가입완료</li>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t</ol>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"memberMenu col-xs-offset-1 col-xs-10\">\r\n");
      out.write("\t\t\t\t<div class=\"memberGroup\">\r\n");
      out.write("\t\t\t\t\t<div class=\"student\">\r\n");
      out.write("\t\t\t\t\t\t<span class=\"member_student\">수강생 회원</span>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"memberImgeBox\">\r\n");
      out.write("\t\t\t\t\t\t\t<i class=\"fa fa-user fa-4x\" aria-hidden=\"true\"></i>\r\n");
      out.write("\t\t\t\t\t\t\t<br>\r\n");
      out.write("\t\t\t\t\t\t\t<button class=\"btn btn-info\" onclick=\"location.href='");
      out.print(request.getContextPath() );
      out.write("/commons/termsOfService?member=student'\">가입하기</button>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"professor\">\r\n");
      out.write("\t\t\t\t\t\t<span class=\"member_professor\">교수 회원</span>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"memberImgeBox\">\r\n");
      out.write("\t\t\t\t\t\t\t<i class=\"fa fa-user fa-4x\" aria-hidden=\"true\"></i>\r\n");
      out.write("\t\t\t\t\t\t\t<br>\r\n");
      out.write("\t\t\t\t\t\t\t<button class=\"btn btn-info\" onclick=\"location.href='");
      out.print(request.getContextPath() );
      out.write("/commons/termsOfService?member=professor'\" >가입하기</button>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<!-- Iframe 보류 -->\r\n");
      out.write("\t\t\t<!-- <div id=\"if_list_div\" style=\"position:relative;padding:0;\" class=\"hide\">\r\n");
      out.write("\t\t\t<iframe id=\"if_list\" name=\"if_list\" frameborder=\"0\" scrolling=\"0\" src=\"\" style=\"position: absolute; top: 0px; left: 0px; bottom: 0px; height: 830px; width: 100%; border: 0px;\"></iframe>\r\n");
      out.write("\t\t</div>\t -->\r\n");
      out.write("\t</div>\t\r\n");
      out.write("\t\r\n");
      out.write("</body>\r\n");
      out.write("<script>\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
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
