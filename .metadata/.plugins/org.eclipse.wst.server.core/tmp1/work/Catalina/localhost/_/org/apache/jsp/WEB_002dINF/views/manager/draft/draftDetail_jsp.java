/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2020-07-08 10:27:33 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.manager.draft;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class draftDetail_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.release();
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

      out.write("<head>\r\n");
      out.write("<title>기안서 상세 보기</title>\r\n");
      out.write("</head>\r\n");
      out.write("\t<link href=\"");
      out.print(request.getContextPath() );
      out.write("/resources/css/draft/bootstrap.min.css\" rel=\"stylesheet\" />\r\n");
      out.write("\t<link href=\"");
      out.print(request.getContextPath() );
      out.write("/resources/css/draft/style.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("\t<!-- JQuery 3.4.1 -->\r\n");
      out.write("\t<script src=\"https://code.jquery.com/jquery-3.4.1.min.js\"></script>\r\n");
      out.write("\t <script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath());
      out.write("/resources/js/filedownload/jquery.fileDownload.js\"></script>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<div class=\"container\">\r\n");
      out.write("\t<!--header start-->\r\n");
      out.write("\t<div class=\"row\">\r\n");
      out.write("    \t<div class=\"col-sm-12\">\r\n");
      out.write("        \t<div class=\"header bg-white\">            \t\t\r\n");
      out.write("         \t\t\t<div class=\"logo col-sm-9\">기안서 결재</div>\r\n");
      out.write("             \t\t<div class=\"rblock col-sm-2\">\r\n");
      out.write("             \t\t\t<label style=\"margin-top:10px;\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${draft.draft_no}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</label>\r\n");
      out.write("           \t\t\t</div>\r\n");
      out.write("             \t\t<div class=\"col-sm-1 rblock5\">문서<br>번호</div>\r\n");
      out.write("             \t\t<div class=\"col-sm-7\">             \t\t\r\n");
      out.write("              \t\t<div class=\"col-sm-4 lblock\"><label>기안자 ID</label></div>\r\n");
      out.write("              \t\t<div class=\"col-sm-8 lblock5\">\r\n");
      out.write("              \t\t\t<label>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${draft.professor_id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</label>\r\n");
      out.write("              \t\t</div>\r\n");
      out.write("              \t\t<div class=\"col-sm-4 lblock\"><label>기안일자</label></div>\r\n");
      out.write("              \t\t<div class=\"col-sm-8 lblock5\">\r\n");
      out.write("              \t\t\t<label>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${draft.draft_regdate}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</label>\r\n");
      out.write("              \t\t</div> \r\n");
      out.write("              \t\t<div class=\"col-sm-4 lblock\"><label>마감일자</label></div>\r\n");
      out.write("              \t\t<div class=\"col-sm-8 lblock5\">\r\n");
      out.write("              \t\t\t<label>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${draft.draft_deadline}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</label>\r\n");
      out.write("              \t\t</div> \r\n");
      out.write("              \t\t<div class=\"col-sm-4 lblock\"><label>기안</label></div>\r\n");
      out.write("              \t\t<div class=\"col-sm-8 lblock5\">\r\n");
      out.write("              \t\t\t<label>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${draft.draft_title}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</label>\r\n");
      out.write("              \t\t</div>                 \t\t          \t\r\n");
      out.write("          \t\t</div>\r\n");
      out.write("          \t\t\t<div class=\"col-sm-1 mblock\"><label class=\"mblocktext\">결<br>재</label></div>\r\n");
      out.write("          \t\t<div class=\"col-sm-4\">\r\n");
      out.write("          \t\t\t<div class=\"col-sm-6 rblock2\"><label>관리자</label></div>\r\n");
      out.write("          \t\t\t<div class=\"col-sm-6 rblock2\"><label>담당교수</label></div>\r\n");
      out.write("          \t\t\t<div class=\"col-sm-6 rblock3\">\r\n");
      out.write("\t\t\t\t\t\t\t");
      if (_jspx_meth_c_005fif_005f0(_jspx_page_context))
        return;
      if (_jspx_meth_c_005fif_005f1(_jspx_page_context))
        return;
      if (_jspx_meth_c_005fif_005f2(_jspx_page_context))
        return;
      out.write("</div>\r\n");
      out.write("         \t\t\t<div class=\"col-sm-6 rblock3\">\r\n");
      out.write("         \t\t\t\t<label style=\"font-size: 30px; margin-left: 15px; margin-top: 38px;\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${name}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</label>\r\n");
      out.write("         \t\t\t</div>\r\n");
      out.write("      \t\t\t      \t\t\t\r\n");
      out.write("          \t\t</div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    \r\n");
      out.write("    \r\n");
      out.write("    \t<!--left sidebar-->\r\n");
      out.write("\t\t            \r\n");
      out.write("        <div class=\"col-sm-12\">\r\n");
      out.write("        \t\r\n");
      out.write("            <!--main content-->           \r\n");
      out.write("            <div class=\"row\">\r\n");
      out.write("            \t<div class=\"col-sm-12\">\r\n");
      out.write("                \t<div class=\"main-content bg-white\">\r\n");
      out.write("           \t\t\t\t<div class=\"col-sm-10 lblock4\">\r\n");
      out.write("           \t\t\t\t\t<label style=\"margin-left: 10px;\">첨부파일</label>\r\n");
      out.write("           \t\t\t\t\t\t<div class=\"col-sm-2 pull-right\"> <!-- onclick=\"getFile()\" -->\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<select style=\"width:100px; margin-top:3px; height:30px;\"id=\"fileSelect\">\t\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t \t\t\t<option selected disabled>다운로드</option>\t\t\t           \t\r\n");
      out.write("\t\t\t\t\t\t\t\t<!-- <label style=\"border: 2px solid;\"> -->\r\n");
      out.write("\t\t\t\t\t\t\t \t\t\t");
      out.write("<option value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${data.lecture_data_filename}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write('"');
      out.write('>');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${videoFile}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</option>\r\n");
      out.write("\t\t\t\t\t\t\t \t\t\t<option value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${data.lecture_data_image}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write('"');
      out.write('>');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${imageFile}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</option>\r\n");
      out.write("\t\t\t\t\t\t\t \t\t</select>\r\n");
      out.write("\t\t\t\t\t\t\t \t\t<input type=\"hidden\" id=\"attach_path\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${path }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" >\r\n");
      out.write("\t           \t\t\t\t\t</div>\r\n");
      out.write("           \t\t\t\t\t<!-- <div class=\"pull-right\"> \r\n");
      out.write("\t\t\t\t\t\t\t  \t<input style=\"display:none;\" />\r\n");
      out.write("\t\t\t\t\t\t\t\t<button id=\"cBtn\" class=\"form-control\" type=\"button\"\r\n");
      out.write("\t\t\t\t\t\t\t\tstyle=\"color: black; border: 2px solid;margin-top: 10px;\">취소</button>\r\n");
      out.write("\t\t\t\t\t\t\t</div> -->\r\n");
      out.write("           \t\t\t\t</div>\r\n");
      out.write("              \t\t\t<div class=\"col-sm-2 lblock\">\r\n");
      out.write("              \t\t\t\t");
      if (_jspx_meth_c_005fif_005f3(_jspx_page_context))
        return;
      if (_jspx_meth_c_005fif_005f4(_jspx_page_context))
        return;
      out.write("</div>\r\n");
      out.write("              \t\t\t<div class=\"col-sm-12 lblock3\">\r\n");
      out.write("              \t\t\t\t<label style=\"font-size: 17px;font-weight: bold;margin-left: 10px;\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${draft.draft_content}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</label>\r\n");
      out.write("              \t\t\t</div>\r\n");
      out.write("              \t\t\t<div class=\"col-sm-4\"></div>\r\n");
      out.write("              \t\t\t<div class=\"col-sm-4\">\r\n");
      out.write("              \t\t\t\t<div class=\"pull-left\"> \r\n");
      out.write("\t\t\t\t\t\t\t  \t<input style=\"display:none;\" />\r\n");
      out.write("\t\t\t\t\t\t\t\t<button id=\"submitBtn\" class=\"form-control\" type=\"button\" onclick=\"modify();\"\r\n");
      out.write("\t\t\t\t\t\t\t\tstyle=\"color: black; border: 2px solid;margin-top: 10px;\">확인</button>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"pull-right\"> \r\n");
      out.write("\t\t\t\t\t\t\t  \t<input style=\"display:none;\" />\r\n");
      out.write("\t\t\t\t\t\t\t\t<button id=\"canselBtn\" class=\"form-control\" type=\"button\" onclick=\"cansel();\"\r\n");
      out.write("\t\t\t\t\t\t\t\tstyle=\"color: black; border: 2px solid;margin-top: 10px;\">취소</button>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("              \t\t\t</div>\r\n");
      out.write("              \t\t\t<div class=\"col-sm-4\"></div>\r\n");
      out.write("               \t    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>           \r\n");
      out.write("        </div>        \r\n");
      out.write("        <!--right sidebar-->      \r\n");
      out.write("    <!--footer start-->\r\n");
      out.write("    <div class=\"row\">\r\n");
      out.write("    \t<div class=\"col-sm-12\">\r\n");
      out.write("        \t<div class=\"footer bg-white\">\r\n");
      out.write("            \t<div class=\"copyright\">\r\n");
      out.write("                \t<p>Copyright &copy; NurlTheme 2020, Made from <a href=\"http://www.naver.com\" target=\"_blank\">누리.hand</a></p>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("function modify(){\r\n");
      out.write("\tvar change_status = $('#change_status').val();\r\n");
      out.write("\tlocation.href=\"");
      out.print(request.getContextPath());
      out.write("/manager/draft/modify_status?draft_no=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${draft.draft_no}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("&change_status=\"+ change_status\r\n");
      out.write("}; \r\n");
      out.write("\r\n");
      out.write("function cansel(){\r\n");
      out.write("\twindow.opener.location.reload();\r\n");
      out.write("\twindow.close();\r\n");
      out.write("};\r\n");
      out.write("\r\n");
      out.write("$(\"#fileSelect\").change(function(){\r\n");
      out.write("\tvar target = document.getElementById(\"fileSelect\");\r\n");
      out.write("\tvar fileName = $('#fileSelect').val();\r\n");
      out.write("\tvar filePath = $('#attach_path').val();\r\n");
      out.write("\tvar originalName = target.options[target.selectedIndex].text\r\n");
      out.write("\tvar file = { \"fileName\": fileName, \"filePath\": filePath, \"originalName\":originalName };\r\n");
      out.write("\tvar flag = confirm('파일을 다운로드 하겠습니까?');\r\n");
      out.write("\tif(flag == true){\r\n");
      out.write("\r\n");
      out.write("\t\t$.fileDownload(\"");
      out.print(request.getContextPath());
      out.write("/manager/draft/getDown\", {\r\n");
      out.write("\t\t\thttpMethod: \"POST\",\r\n");
      out.write("\t\t    data: file,\r\n");
      out.write("\t\t\tsuccessCallback: function(){\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t   \t\t\t\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\tfailCallback: function(){\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t}\r\n");
      out.write("\t});\r\n");
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

  private boolean _jspx_meth_c_005fif_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f0.setParent(null);
    // /WEB-INF/views/manager/draft/draftDetail.jsp(49,7) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${draft.draft_status eq '결재대기' }", java.lang.Boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
    if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("<select  class=\"form-control statusbox\" name=\"change_status\" id=\"change_status\">\r\n");
        out.write("\t\t\t\t\t\t\t\t\t<option value=\"결재대기\" selected=\"selected\">대 기</option>\r\n");
        out.write("\t\t\t\t\t\t\t\t\t<option value=\"결재승인\">승 인</option>\r\n");
        out.write("\t\t\t\t\t\t\t\t\t<option value=\"결재반려\">반 려</option>\t\t\t\t\t\r\n");
        out.write("\t\t\t\t\t\t\t\t</select>\t\r\n");
        out.write("\t\t\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_005fif_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f1(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f1.setParent(null);
    // /WEB-INF/views/manager/draft/draftDetail.jsp(56,7) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${draft.draft_status eq '결재승인' }", java.lang.Boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f1 = _jspx_th_c_005fif_005f1.doStartTag();
    if (_jspx_eval_c_005fif_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("<select  class=\"form-control statusbox\" name=\"change_status\" disabled=\"disabled\" id=\"change_status\">\t\t\t\t\t\t\t\t\r\n");
        out.write("\t\t\t\t\t\t\t\t\t<option value=\"결재승인\" selected=\"selected\">승 인</option>\r\n");
        out.write("\t\t\t\t\t\t\t\t\t<option value=\"결재대기\">대 기</option>\r\n");
        out.write("\t\t\t\t\t\t\t\t\t<option value=\"결재반려\">반 려</option>\r\n");
        out.write("\t\t\t\t\t\t\t\t</select>\r\n");
        out.write("\t\t\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_005fif_005f1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f1);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f2(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f2 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f2.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f2.setParent(null);
    // /WEB-INF/views/manager/draft/draftDetail.jsp(63,7) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f2.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${draft.draft_status eq '결재반려' }", java.lang.Boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f2 = _jspx_th_c_005fif_005f2.doStartTag();
    if (_jspx_eval_c_005fif_005f2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("<select  class=\"form-control statusbox\" name=\"change_status\" disabled=\"disabled\" id=\"change_status\">\r\n");
        out.write("\t\t\t\t\t\t\t\t\t<option value=\"결재반려\" selected=\"selected\">반 려</option>\r\n");
        out.write("\t\t\t\t\t\t\t\t\t<option value=\"결재승인\">승 인</option>\r\n");
        out.write("\t\t\t\t\t\t\t\t\t<option value=\"결재대기\">대 기</option>\r\n");
        out.write("\t\t\t\t\t\t\t\t</select>\r\n");
        out.write("\t\t\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_005fif_005f2.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f2);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f3(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f3 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f3.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f3.setParent(null);
    // /WEB-INF/views/manager/draft/draftDetail.jsp(108,18) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f3.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${draft.draft_check == 0 }", java.lang.Boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f3 = _jspx_th_c_005fif_005f3.doStartTag();
    if (_jspx_eval_c_005fif_005f3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("<label>MEDIA <input type=\"checkbox\" name=\"media\" value=\"media\" onclick=\"return false\" checked=\"checked\"></label>\r\n");
        out.write("              \t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_005fif_005f3.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f3);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f3);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f4(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f4 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f4.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f4.setParent(null);
    // /WEB-INF/views/manager/draft/draftDetail.jsp(111,18) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f4.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${draft.draft_check == 1 }", java.lang.Boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f4 = _jspx_th_c_005fif_005f4.doStartTag();
    if (_jspx_eval_c_005fif_005f4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("<label>MEDIA <input type=\"checkbox\" name=\"media\" value=\"lecture\" onclick=\"return false\"></label>\r\n");
        out.write("              \t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_005fif_005f4.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f4);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f4);
    return false;
  }
}
