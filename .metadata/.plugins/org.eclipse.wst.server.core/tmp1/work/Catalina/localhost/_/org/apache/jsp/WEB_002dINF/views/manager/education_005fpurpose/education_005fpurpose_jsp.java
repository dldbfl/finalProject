/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2020-07-08 08:42:21 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.manager.education_005fpurpose;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Date;

public final class education_005fpurpose_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<head>\r\n");
      out.write("<title>교육목표 관리</title>\r\n");
      out.write("<style type=\"text/css\" id=\"fontFamilyStyleSheet\">\r\n");
      out.write("body { \r\n");
      out.write("\tfont-family: 'Malgun Gothic', sans-serif !important; \r\n");
      out.write("}\r\n");
      out.write(".fileDrop{\r\n");
      out.write("\twidth:90%;\r\n");
      out.write("\theight:100px;\r\n");
      out.write("\tborder:1px dotted gray;\r\n");
      out.write("\tmargin:auto;\r\n");
      out.write("}\r\n");
      out.write("select:disabled {\r\n");
      out.write("\tbackground: lightgray;\r\n");
      out.write("  \tborder:1px solid gray; \r\n");
      out.write("}\r\n");
      out.write("input:read-only, \r\n");
      out.write("textarea:read-only{\r\n");
      out.write("  cursor: not-allowed;\r\n");
      out.write("}\r\n");
      out.write("div#picturePreView{\r\n");
      out.write("\tmargin-left: 100px;\r\n");
      out.write("    height: 467px;\r\n");
      out.write("    width: 930px;\r\n");
      out.write("    margin-top: 40px;\t\r\n");
      out.write("\tbackground-image:url(\"");
      out.print(request.getContextPath());
      out.write("/manager/picture/education_purpose/");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${manager_board.manager_board_no}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\");\r\n");
      out.write("\tbackground-repeat: no-repeat;\r\n");
      out.write("    background-position: center;\r\n");
      out.write("    background-size: cover;\t\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("<script src=\"");
      out.print(request.getContextPath());
      out.write("/resources/scripts/common.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<body >\r\n");
      out.write("<div class=\"bookcover\">\r\n");
      out.write("<h1>교육목표 관리</h1>\r\n");
      out.write("<div id = \"buttonset\">\r\n");
      out.write("<button id = \"modify\" type=\"button\" class=\"btn btn-sm btn-white btn-bold\" onclick=\"Modfiy_go();\">\r\n");
      out.write("\t<i class=\"red ace-icon fa fa-check bigger-120\"></i><b>수정</b>\r\n");
      out.write("</button>\r\n");
      out.write("<button id = \"submit\" disabled type=\"button\" class=\"btn btn-sm btn-white btn-bold\" onclick=\"goSubmit('post');\">\r\n");
      out.write("\t<i class=\"red ace-icon fa fa-check bigger-120\"></i><b>확인</b>\r\n");
      out.write("</button>\r\n");
      out.write("<button id = \"cansel\" disabled type=\"reset\" class=\"btn btn-sm btn-white btn-bold\" onclick=\"Cansel_go();\">\r\n");
      out.write("\t<i class=\"grey ace-icon fa fa-times bigger-120\"></i><b>취소</b>\r\n");
      out.write("</button>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<form role=\"form\" id= \"modifyform\" name='modifyform' method=post enctype=\"multipart/form-data\">\r\n");
      out.write("\t<div class=\"col-sm-12\">\r\n");
      out.write("\t <div  class=\"col-sm-8\" role=\"manager_data_filename\">\r\n");
      out.write("\t\t<div id=\"picturePreView\">\r\n");
      out.write("\t\t\t<div id = \"buttonset2\">\r\n");
      out.write("\t\t\t\t<label for=\"manager_data_filename\"  id = \"data_change\" class=\"btn btn-xs btn-info\" style=\"width:110px;margin-bottom:2px;visibility: hidden;\">사진변경</label>\r\n");
      out.write("\t\t\t\t<input type=\"file\" id=\"manager_data_filename\" name=\"manager_data_filename\" style=\"display:none;\"/>\r\n");
      out.write("\t\t \t\t<input type=\"hidden\" id=\"old_manager_data_filename\" name=\"old_manager_data_filename\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${manager_board.manager_data_filename }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"/>\t\t\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\t\t\r\n");
      out.write("\t </div>\r\n");
      out.write("\t\r\n");
      out.write("\t <div  > \r\n");
      out.write("\t\t <textarea  style=\"display: none;font-size : 18px; height: 360px; margin-top: 80px; border: pink;\" readonly class=\"col-sm-12 enterprise_modifyset\" name =\"education_purpose\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${manager_board.education_purpose}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</textarea>     \r\n");
      out.write("\t </div>\r\n");
      out.write("\t");
      out.write("<input type=\"hidden\" readonly name=\"manager_board_no\" class=\"col-sm-12 enterprise_modifyset\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${manager_board.manager_board_no}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\">\r\n");
      out.write("\t</div>\r\n");
      out.write("</form>\r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("<!-- form submit -->\r\n");
      out.write("<script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("function Modfiy_go(){\r\n");
      out.write("\t$('#modify').attr('disabled', true);\r\n");
      out.write("\t$('#cansel').removeAttr(\"disabled\");\r\n");
      out.write("\t$('#submit').removeAttr(\"disabled\");\r\n");
      out.write("\t$('.enterprise_modifyset').removeAttr(\"readonly\");\r\n");
      out.write("\t$('#data_change').css({'visibility':'visible'});\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function Cansel_go(){\r\n");
      out.write("\t$('#modify').removeAttr(\"disabled\");\r\n");
      out.write("\t$('#cansel').attr('disabled', true);\r\n");
      out.write("\t$('#submit').attr('disabled', true);\r\n");
      out.write("\t$('.enterprise_modifyset').attr('readonly', true);\t\r\n");
      out.write("\t$('#data_change').css({'visibility':'hidden'});\r\n");
      out.write("\t$('#modifyform').each(function(){\r\n");
      out.write("        this.reset();\r\n");
      out.write("    });\r\n");
      out.write("\t$('#picturePreView').css({'background-image':'url(\"");
      out.print(request.getContextPath());
      out.write("/manager/picture/education_purpose/");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${manager_board.manager_board_no}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"'});\r\n");
      out.write("\talert('취소된 이미지는 저장되지 않습니다.')\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* 사진업로드 */\r\n");
      out.write("$('input[name=\"manager_data_filename\"]').on('change',function(){\r\n");
      out.write("\tconsole.log('테스트')\r\n");
      out.write("  //$('#picturePreView').on('click',function(){\r\n");
      out.write("\t$('input[name=\"checkUpload\"]').val(0);\r\n");
      out.write("\tconsole.log('작동확인');\r\n");
      out.write("\t//이미지 확장자 jpg 확인\r\n");
      out.write("\tvar fileFormat=\r\n");
      out.write("\t\tthis.value.substr(this.value.lastIndexOf(\".\")+1).toUpperCase();\r\n");
      out.write("\tif(fileFormat!=\"JPG\" && fileFormat!=\"JPEG\"){\r\n");
      out.write("\t\talert(\"이미지는 jpg 형식만 가능합니다.\");\t\t\t\r\n");
      out.write("\t\treturn false;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t//이미지 파일 용량 체크\r\n");
      out.write("\tif(this.files[0].size>1024*1024*1){\r\n");
      out.write("\t\talert(\"사진 용량은 1MB 이하만 가능합니다.\");\r\n");
      out.write("\t\treturn false;\r\n");
      out.write("\t};\t\r\n");
      out.write("\t\r\n");
      out.write("\tif (this.files && this.files[0]) {\r\n");
      out.write("\t\t\r\n");
      out.write("        var reader = new FileReader();\r\n");
      out.write("        \r\n");
      out.write("        reader.onload = function (e) {\r\n");
      out.write("        \t//이미지 미리보기\t        \t\r\n");
      out.write("        \t$('div#picturePreView')\r\n");
      out.write("        \t.css({'background-image':'url('+e.target.result+')',\r\n");
      out.write("\t\t\t\t  'background-position':'center',\r\n");
      out.write("\t\t\t\t  'background-size':'cover',\r\n");
      out.write("\t\t\t\t  'background-repeat':'no-repeat'\r\n");
      out.write("        \t\t});\r\n");
      out.write("        }\r\n");
      out.write("        \r\n");
      out.write("        reader.readAsDataURL(this.files[0]);\r\n");
      out.write("\t}\r\n");
      out.write(" });\t\r\n");
      out.write("  \r\n");
      out.write("/* //form submit (사진 업로드 확인 alert 메서드때문에 공통사항은 아니라 regist.jsp에서 작성해도 무방\r\n");
      out.write("  function SubmitMemberRegist(formRole){\r\n");
      out.write("  \tvar uploadCheck = $('input[name=\"checkUpload\"]').val();\r\n");
      out.write("  \tif(!(uploadCheck>0)){\r\n");
      out.write("  \t\talert(\"사진 업로드는 필수입니다.\");\r\n");
      out.write("  \t\t//$('input[name=\"pictureFile\"]').click();\r\n");
      out.write("  \t\treturn;\r\n");
      out.write("  \t}\r\n");
      out.write("  \tvar form = $('form[role=\"' + formRole + '\"]');\r\n");
      out.write("  \tform.submit();\r\n");
      out.write("  } */\r\n");
      out.write("function goSubmit(cmd){ \r\n");
      out.write("\tvar form = document.modifyform;\r\n");
      out.write("\tswitch(cmd) {\r\n");
      out.write("\tcase \"post\":\t\t\r\n");
      out.write("\t\tform.submit();\t\t\r\n");
      out.write("\t\tbreak;\r\n");
      out.write("\tcase \"close\":\r\n");
      out.write("\t\twindow.close();\r\n");
      out.write("\t\treturn;\r\n");
      out.write("\t\tbreak;\r\n");
      out.write("\tdefault:\r\n");
      out.write("\t\treturn;\r\n");
      out.write("\t\tbreak;\r\n");
      out.write("\t}\t\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
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
