/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2020-07-08 08:43:27 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.enterprise;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Date;

public final class enterprise_005fcoming_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<title>찾아오는 길</title>\r\n");
      out.write("<style type=\"text/css\" id=\"fontFamilyStyleSheet\">\r\n");
      out.write("body { \r\n");
      out.write("\tfont-family: 'Malgun Gothic', sans-serif !important; \r\n");
      out.write("}\r\n");
      out.write(".fileDrop{\r\n");
      out.write("\twidth:90%;\r\n");
      out.write("\theight:100px;\r\n");
      out.write("\tmargin:auto;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("input:read-only, \r\n");
      out.write("textarea:read-only{\r\n");
      out.write("  cursor: not-allowed;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("div#picturePreView{\r\n");
      out.write("\theight:500px;\r\n");
      out.write("\twidth:1050px;\r\n");
      out.write("\tmargin:0 auto;\r\n");
      out.write("\tmargin-top : 15px;\t  \t\t\r\n");
      out.write("\tbackground-image:url(\"");
      out.print(request.getContextPath());
      out.write("/manager/picture/enterprise_coming/");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${manager_board.manager_board_no}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\");\r\n");
      out.write("\tbackground-repeat:no-repeat;\r\n");
      out.write("\tbackground-position:center;\r\n");
      out.write("\tbackground-size:cover;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".enterprise_coming{\r\n");
      out.write("\tborder: none;\r\n");
      out.write("\toverflow:hidden; \r\n");
      out.write("\tfont-size : 15px; \r\n");
      out.write("\twidth :400px;\r\n");
      out.write("\theight: 200px; \r\n");
      out.write("}\r\n");
      out.write("#commingDiv{\r\n");
      out.write("\tpadding: 20px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("<body >\r\n");
      out.write("\r\n");
      out.write("<form role=\"form\" id= \"modifyform\" name='modifyform' method=post enctype=\"multipart/form-data\">\r\n");
      out.write("\t<div id=\"commingDiv\">\r\n");
      out.write("\t\t<div class=\"textComing\" style=\"margin-left: 35px;\">\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t <div role=\"manager_data_filename\">\r\n");
      out.write("\t\t\t<div id=\"picturePreView\">\r\n");
      out.write("\t\t\t\t<div id = \"buttonset2\">\r\n");
      out.write("\t\t\t\t\t<input type=\"file\" id=\"manager_data_filename\" name=\"manager_data_filename\" style=\"display:none;\"/>\r\n");
      out.write("\t\t\t \t\t<input type=\"hidden\" id=\"old_manager_data_filename\" name=\"old_manager_data_filename\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${manager_board.manager_data_filename }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"/>\t\t\r\n");
      out.write("\t\t \t\t</div>\r\n");
      out.write("\t\t\t</div>\t\t\r\n");
      out.write("\t\t </div>\r\n");
      out.write("\t\t <input type=\"hidden\" readonly name=\"enterprise_introduce_no\" class=\"col-sm-12 enterprise_modifyset\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${manager_board.manager_board_no}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\">\r\n");
      out.write("\t\t<br>\r\n");
      out.write("\t\t  <div class=\"col-sm-8\" >\r\n");
      out.write("\t\t\t<div  style=\"\r\n");
      out.write("\t\t\t\t\t\t\t\t      font-size:1.4em;\r\n");
      out.write("\t\t\t\t\t\t\t\t      margin: 18px 0px 0px 14.1875px;\r\n");
      out.write("\t\t\t\t\t\t\t\t      width: 700px;\r\n");
      out.write("\t\t\t\t\t\t\t\t      height: 100px;\r\n");
      out.write("\t\t\t\t\t\t\t\t      \" class=\"col-sm-12 enterprise_modifyset\" name =\"enterprise_coming\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${manager_board.enterprise_coming}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</div>     \r\n");
      out.write("\t\t </div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\t \r\n");
      out.write("</form>\r\n");
      out.write("\r\n");
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
