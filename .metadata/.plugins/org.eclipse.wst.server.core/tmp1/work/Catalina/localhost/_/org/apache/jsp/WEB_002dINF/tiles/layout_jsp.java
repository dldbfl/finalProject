/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2020-07-08 07:18:18 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.tiles;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class layout_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("\r\n");
      out.write("<!-- JQuery 3.4.1 -->\r\n");
      out.write("<script src=\"https://code.jquery.com/jquery-3.4.1.min.js\"></script>\r\n");
      out.write("<!--  JQuery 1.12.1 UI -->\r\n");
      out.write("<script src=\"https://code.jquery.com/ui/1.12.1/jquery-ui.min.js\"></script>\r\n");
      out.write("<!-- JQuery 2.2.0 Color -->\r\n");
      out.write("<script src=\"https://code.jquery.com/color/jquery.color-2.2.0.min.js\"></script>\r\n");
      out.write("<!-- Latest compiled and minified CSS -->\r\n");
      out.write("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css\">\r\n");
      out.write("\r\n");
      out.write("<!-- Optional theme -->\r\n");
      out.write("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css\">\r\n");
      out.write("\r\n");
      out.write("<!-- Latest compiled and minified JavaScript -->\r\n");
      out.write("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js\"></script>\r\n");
      out.write("<!-- 웹 폰트 -->\r\n");
      out.write("    <link href=\"https://fonts.googleapis.com/css?family=Nanum+Gothic\" rel=\"stylesheet\">\r\n");
      out.write("    <link href=\"https://fonts.googleapis.com/css?family=Nanum+Brush+Script\" rel=\"stylesheet\">\r\n");
      out.write("    <link href=\"https://fonts.googleapis.com/css?family=Abel&display=swap\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("<!-- 파비콘 -->\r\n");
      out.write("\t<link rel=\"icon\" type=\"image/png\" sizes=\"32x32\" href=\"");
      out.print(request.getContextPath() );
      out.write("resources/images/favicon-32x32.png\">\r\n");
      out.write("<!-- 아이콘 모음 -->\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\r\n");
      out.write("\r\n");
      out.write("<!-- 합쳐지고 최소화된 최신 CSS -->\r\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath());
      out.write("/resources/css/message/messenger_bootstrap.min.css\">\r\n");
      out.write("<!-- 합쳐지고 최소화된 최신 자바스크립트 -->\r\n");
      out.write("<script src=\"");
      out.print(request.getContextPath());
      out.write("/resources/js/message/message.js\"></script>\r\n");
      out.write("<title>D-LMS 창업 교육 센터</title>\r\n");
      out.write("  <style>\r\n");
      out.write("        * {margin: 0; padding: 0;}\r\n");
      out.write("        header {\r\n");
      out.write("        \twidth: 100%;\r\n");
      out.write("        \tposition: fixed;\r\n");
      out.write("  \t\t\tz-index: 100;\r\n");
      out.write("        }\r\n");
      out.write("        aside {width: 100%; height: 115px; background: #0000;}\r\n");
      out.write("        section {float: inherit; width:  76.6%;height: auto;background: white; }\r\n");
      out.write("        footer {clear: both; width: 100%; height: 180px; background: olive;}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t.header_menu{\r\n");
      out.write("\t\t\tfloat: right;\r\n");
      out.write("\t\t\ttext-align: right;\r\n");
      out.write("\t\t\tmargin-top:;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t.header_menu a{\r\n");
      out.write("\t\t\tmargin-right:;\r\n");
      out.write("    \t\tcolor: black;\r\n");
      out.write("    \t\tcolor: #292fd6;\r\n");
      out.write("    \t\tfont-weight: bold;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t.header_logo{\r\n");
      out.write("\t\t\tfloat: left;\r\n");
      out.write("\t\t\t   background-image:\r\n");
      out.write("  \t\t\t   url('");
      out.print(request.getContextPath());
      out.write("/resources/images/logo.png');\r\n");
      out.write("\t\t\t   background-position: center;\r\n");
      out.write("\t\t\t   background-repeat: no-repeat;\r\n");
      out.write("\t\t\t   background-size: contain;\r\n");
      out.write("\t\t\t   width: 125px;\r\n");
      out.write("    \t\t   height: 94px;\r\n");
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
      out.write("        section#main-container{\r\n");
      out.write("        \theight: auto;\r\n");
      out.write("        \tmargin-top: 19px;\r\n");
      out.write("        \tmin-height: 663px;\r\n");
      out.write("        }\r\n");
      out.write("        #wrap{\r\n");
      out.write("        background: white;\r\n");
      out.write("        }\r\n");
      out.write("        \r\n");
      out.write("    </style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div id=\"wrap\">\r\n");
      out.write("        <header>");
      if (_jspx_meth_tiles_005finsertAttribute_005f0(_jspx_page_context))
        return;
      out.write("</header>\r\n");
      out.write("        <aside>");
      if (_jspx_meth_tiles_005finsertAttribute_005f1(_jspx_page_context))
        return;
      out.write("</aside>\r\n");
      out.write("        <section class=\"container\" id=\"main-container\">");
      if (_jspx_meth_tiles_005finsertAttribute_005f2(_jspx_page_context))
        return;
      out.write("</section>\r\n");
      out.write("        <footer style=\"height: 140px;\">");
      if (_jspx_meth_tiles_005finsertAttribute_005f3(_jspx_page_context))
        return;
      out.write("</footer>\r\n");
      out.write("\t</div>\r\n");
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
    // /WEB-INF/tiles/layout.jsp(115,16) name = name type = java.lang.String reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_tiles_005finsertAttribute_005f0.setName("header");
    // /WEB-INF/tiles/layout.jsp(115,16) name = ignore type = boolean reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
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
    // /WEB-INF/tiles/layout.jsp(116,15) name = name type = java.lang.String reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_tiles_005finsertAttribute_005f1.setName("aside");
    // /WEB-INF/tiles/layout.jsp(116,15) name = ignore type = boolean reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_tiles_005finsertAttribute_005f1.setIgnore(true);
    _jspx_th_tiles_005finsertAttribute_005f1.doTag();
    _jsp_instancemanager.destroyInstance(_jspx_th_tiles_005finsertAttribute_005f1);
    return false;
  }

  private boolean _jspx_meth_tiles_005finsertAttribute_005f2(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  tiles:insertAttribute
    org.apache.tiles.jsp.taglib.InsertAttributeTag _jspx_th_tiles_005finsertAttribute_005f2 = (new org.apache.tiles.jsp.taglib.InsertAttributeTag());
    _jsp_instancemanager.newInstance(_jspx_th_tiles_005finsertAttribute_005f2);
    _jspx_th_tiles_005finsertAttribute_005f2.setJspContext(_jspx_page_context);
    // /WEB-INF/tiles/layout.jsp(117,55) name = name type = java.lang.String reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_tiles_005finsertAttribute_005f2.setName("body");
    // /WEB-INF/tiles/layout.jsp(117,55) name = ignore type = boolean reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_tiles_005finsertAttribute_005f2.setIgnore(true);
    _jspx_th_tiles_005finsertAttribute_005f2.doTag();
    _jsp_instancemanager.destroyInstance(_jspx_th_tiles_005finsertAttribute_005f2);
    return false;
  }

  private boolean _jspx_meth_tiles_005finsertAttribute_005f3(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  tiles:insertAttribute
    org.apache.tiles.jsp.taglib.InsertAttributeTag _jspx_th_tiles_005finsertAttribute_005f3 = (new org.apache.tiles.jsp.taglib.InsertAttributeTag());
    _jsp_instancemanager.newInstance(_jspx_th_tiles_005finsertAttribute_005f3);
    _jspx_th_tiles_005finsertAttribute_005f3.setJspContext(_jspx_page_context);
    // /WEB-INF/tiles/layout.jsp(118,39) name = name type = java.lang.String reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_tiles_005finsertAttribute_005f3.setName("footer");
    // /WEB-INF/tiles/layout.jsp(118,39) name = ignore type = boolean reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_tiles_005finsertAttribute_005f3.setIgnore(true);
    _jspx_th_tiles_005finsertAttribute_005f3.doTag();
    _jsp_instancemanager.destroyInstance(_jspx_th_tiles_005finsertAttribute_005f3);
    return false;
  }
}
