/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2020-07-08 07:20:19 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.tiles;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class loginLayout_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("\r\n");
      out.write("<!-- JQuery 3.4.1 -->\r\n");
      out.write("<script src=\"https://code.jquery.com/jquery-3.4.1.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<!--  JQuery 1.12.1 UI -->\r\n");
      out.write("<script src=\"https://code.jquery.com/ui/1.12.1/jquery-ui.min.js\"></script>\r\n");
      out.write("<!-- Optional theme -->\r\n");
      out.write("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css\">\r\n");
      out.write("<!-- Latest compiled and minified JavaScript -->\r\n");
      out.write("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js\"></script>\r\n");
      out.write("<!-- JQuery 2.2.0 Color -->\r\n");
      out.write("<script src=\"https://code.jquery.com/color/jquery.color-2.2.0.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<!-- Latest compiled and minified CSS -->\r\n");
      out.write("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css\">\r\n");
      out.write("\r\n");
      out.write("<!-- 웹 폰트 -->\r\n");
      out.write("    <link href=\"https://fonts.googleapis.com/css?family=Nanum+Gothic\" rel=\"stylesheet\">\r\n");
      out.write("    <link href=\"https://fonts.googleapis.com/css?family=Nanum+Brush+Script\" rel=\"stylesheet\">\r\n");
      out.write("    <link href=\"https://fonts.googleapis.com/css?family=Abel&display=swap\" rel=\"stylesheet\">\r\n");
      out.write("<!-- 아이콘 포트 및 파비콘 -->\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\r\n");
      out.write("<!-- JQuery 1.9.0 datepick -->\r\n");
      out.write("\t<link href=\"http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css\" rel=\"stylesheet\" type=\"text/css\"/>\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js\">\r\n");
      out.write("\r\n");
      out.write("<title></title>\r\n");
      out.write(" <style>\r\n");
      out.write("        * {margin: 0; padding: 0;}\r\n");
      out.write("        header {width: 100%; height: 100%; background: #2089ef;}\r\n");
      out.write("        section {float: inherit; width:  76.6%; height: 800px; }\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t.header_menu{\r\n");
      out.write("\t\t\tfloat: right;\r\n");
      out.write("\t\t\ttext-align: right;\r\n");
      out.write("\t\t\tmargin-top: 1%;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t.header_menu a{\r\n");
      out.write("\t\t\tmargin-right: 30px;\r\n");
      out.write("\t\t\tfont-size: 17px;\r\n");
      out.write("    \t\tcolor: snow;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t.header_logo{\r\n");
      out.write("\t\t\tfloat: left;\r\n");
      out.write("\t\t\t   background-image:\r\n");
      out.write("  \t\t\t   url('");
      out.print(request.getContextPath());
      out.write("/resources/images/loginLogo.png');\r\n");
      out.write("\t\t\t   background-position: center;\r\n");
      out.write("\t\t\t   background-repeat: no-repeat;\r\n");
      out.write("\t\t\t   background-size: contain;\r\n");
      out.write("\t\t\t   width: 125px;\r\n");
      out.write("    \t\t   height: 46px;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t/* .header_container{\r\n");
      out.write("\t\t\tpadding-left: 15px;\r\n");
      out.write(" \t\t\tpadding-right: 60px;\r\n");
      out.write("\t\t} */\r\n");
      out.write("\t\t.nav_menu{\r\n");
      out.write("\t\t\tmargin-top: 43px;\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t.navigation{\r\n");
      out.write("\t\t\t width: 50px;\r\n");
      out.write("\t\t\t height: 20px;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("        /* 화면 너비 0 ~ 1200px */\r\n");
      out.write("        @media (max-width: 1220px){\r\n");
      out.write("            #wrap {width: 95%;}\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        /* 화면 너비 0 ~ 768px */\r\n");
      out.write("        @media (max-width: 768px){\r\n");
      out.write("            #wrap {width: 100%;}\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        /* 화면 너비 0 ~ 480px */\r\n");
      out.write("        @media (max-width: 480px){\r\n");
      out.write("            #wrap {width: 100%;}\r\n");
      out.write("            header {height: 300px;}\r\n");
      out.write("            aside {float: none; width: 100%; height: 300px;}\r\n");
      out.write("            section {float: none; width: 100%; height: 300px;}\r\n");
      out.write("        }\r\n");
      out.write("    </style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<header>");
      if (_jspx_meth_tiles_005finsertAttribute_005f0(_jspx_page_context))
        return;
      out.write("</header>\r\n");
      out.write("\t<section class=\"container\">");
      if (_jspx_meth_tiles_005finsertAttribute_005f1(_jspx_page_context))
        return;
      out.write("</section>\r\n");
      out.write("</body>\r\n");
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

  private boolean _jspx_meth_tiles_005finsertAttribute_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  tiles:insertAttribute
    org.apache.tiles.jsp.taglib.InsertAttributeTag _jspx_th_tiles_005finsertAttribute_005f0 = (new org.apache.tiles.jsp.taglib.InsertAttributeTag());
    _jsp_instancemanager.newInstance(_jspx_th_tiles_005finsertAttribute_005f0);
    _jspx_th_tiles_005finsertAttribute_005f0.setJspContext(_jspx_page_context);
    // /WEB-INF/tiles/loginLayout.jsp(94,9) name = name type = java.lang.String reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_tiles_005finsertAttribute_005f0.setName("login_header");
    // /WEB-INF/tiles/loginLayout.jsp(94,9) name = ignore type = boolean reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_tiles_005finsertAttribute_005f0.setIgnore(true);
    _jspx_th_tiles_005finsertAttribute_005f0.doTag();
    _jsp_instancemanager.destroyInstance(_jspx_th_tiles_005finsertAttribute_005f0);
    return false;
  }

  private boolean _jspx_meth_tiles_005finsertAttribute_005f1(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  tiles:insertAttribute
    org.apache.tiles.jsp.taglib.InsertAttributeTag _jspx_th_tiles_005finsertAttribute_005f1 = (new org.apache.tiles.jsp.taglib.InsertAttributeTag());
    _jsp_instancemanager.newInstance(_jspx_th_tiles_005finsertAttribute_005f1);
    _jspx_th_tiles_005finsertAttribute_005f1.setJspContext(_jspx_page_context);
    // /WEB-INF/tiles/loginLayout.jsp(95,28) name = name type = java.lang.String reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_tiles_005finsertAttribute_005f1.setName("body");
    // /WEB-INF/tiles/loginLayout.jsp(95,28) name = ignore type = boolean reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_tiles_005finsertAttribute_005f1.setIgnore(true);
    _jspx_th_tiles_005finsertAttribute_005f1.doTag();
    _jsp_instancemanager.destroyInstance(_jspx_th_tiles_005finsertAttribute_005f1);
    return false;
  }
}
