/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2020-07-09 01:34:01 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.lecture;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Date;

public final class qnaRegist_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/views/lecture/videonote_js.jsp", Long.valueOf(1594192135621L));
    _jspx_dependants.put("/WEB-INF/views/board/qna/qna.js.jsp", Long.valueOf(1594251695570L));
  }

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

      out.write("<link href=\"");
      out.print(request.getContextPath() );
      out.write("/resources/css/qna/detail.css\" rel=\"stylesheet\">\r\n");
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
      out.write("<link href=\"");
      out.print(request.getContextPath() );
      out.write("/resources/css/lecture/lecture.css\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("<!-- 하단 슬라이더 -->\r\n");
      out.write("<!-- <link rel=\"stylesheet\" href=\"https://unpkg.com/swiper/css/swiper.min.css\"> -->\r\n");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/Swiper/4.5.1/css/swiper.min.css\">\r\n");
      out.write("<link href=\"");
      out.print(request.getContextPath() );
      out.write("/resources/css/lecture/video.css\" rel=\"stylesheet\">\r\n");
      out.write("<script src=\"https://cdnjs.cloudflare.com/ajax/libs/Swiper/4.5.1/js/swiper.min.js\"></script>\r\n");
      out.write(" \r\n");
      out.write("<script src=\"");
      out.print(request.getContextPath() );
      out.write("/resources/scripts/common.js\"></script>\r\n");
      out.write("\t\r\n");
      out.write("\t<link href=\"");
      out.print(request.getContextPath() );
      out.write("/resources/css/qna/dist/switchery.css\" rel=\"stylesheet\">\r\n");
      out.write("\t<script src=\"");
      out.print(request.getContextPath() );
      out.write("/resources/css/qna/dist/switchery.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<style>\r\n");
      out.write("body{\r\n");
      out.write("\t\t/* width: 345px;\r\n");
      out.write("    \theight: 607px; */\r\n");
      out.write("    \tpadding: 5px 10px 70px 10px;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("#detaildiv{\r\n");
      out.write("\tfont-size: 13px;\r\n");
      out.write("    height: 354px;\r\n");
      out.write("}\r\n");
      out.write("    \r\n");
      out.write("#answerTable,#answerdiv{\r\n");
      out.write("\tfont-size: 13px;\r\n");
      out.write("}\r\n");
      out.write(".btns{\r\n");
      out.write("    background-color: #6D6AB7;\r\n");
      out.write("    text-decoration: blink;\r\n");
      out.write("\r\n");
      out.write("}\r\n");
      out.write(".note-toolbar panel-heading{\r\n");
      out.write("\theight: 39px;\r\n");
      out.write("}\r\n");
      out.write(".note-fontname, .note-style, .note-insert, .note-table, .note-para{\r\n");
      out.write("\tdisplay: none;\r\n");
      out.write("} \r\n");
      out.write(".writerPwd{\t\r\n");
      out.write("    height: 8%;\r\n");
      out.write("    font-size: 14px;\t\r\n");
      out.write("}\r\n");
      out.write("#password{\r\n");
      out.write("\tfont-size: 13px;\r\n");
      out.write("}\r\n");
      out.write("#buttons{\r\n");
      out.write("\tfloat: right;\r\n");
      out.write("}\r\n");
      out.write(".titlecover{\r\n");
      out.write("    height: 35px;\r\n");
      out.write("}\r\n");
      out.write(".note-editor note-frame panel panel-default{\r\n");
      out.write("\tmargin-top: 15px;\r\n");
      out.write("}\r\n");
      out.write("#qnaRegist_content{\r\n");
      out.write("\tmargin-top: 15px;\r\n");
      out.write("}\r\n");
      out.write(".titletext{\r\n");
      out.write("\tmargin: 1%;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("\r\n");
      out.write("    <title>등록</title>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("  <div class=\"FormController\">\r\n");
      out.write("\r\n");
      out.write("    <section id=\"section-timesheet\" style=\"background-color: white; width: 100%;\">\r\n");
      out.write("      <div class=\"clearfix\" style=\"width: 100%; background-color: white; /* border-top: 2px solid steelblue */ height: 500px;\">\r\n");
      out.write("\r\n");
      out.write("        <form enctype=\"multipart/form-data\" name=\"regist\" method=\"post\" action=\"/lecture/regist?member_id=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${member_id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("&professor_id=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${professor_id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" style=\"height: 130%;\" >\r\n");
      out.write("\t\t\t<div class=\"clearfix\">\t   \r\n");
      out.write("\t\t\t\t \r\n");
      out.write("\t\t\t\t<div class=\"writerPwd\">\r\n");
      out.write("\t\t  \t       <div class=\"name\">\r\n");
      out.write("\t\t\t  \t       <label style=\"display:none; float: left; margin-left: 1%;\">작성자</label>\r\n");
      out.write("\t\t\t  \t       <input type=\"hidden\" class=\"col-xs-2\" style=\"heig\tht: 30px; font-size: 15px; \" id=\"qna_writer\" name=\"qna_writer\" type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${member_id }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"  required readonly=\"readonly\">\r\n");
      out.write("\t\t  \t       </div>\r\n");
      out.write("\t\t  \t       <div class=\"professor\">\r\n");
      out.write("\t\t\t  \t       <label style=\"display:none; float: left; margin-left: 1%;\">교수</label>\r\n");
      out.write("\t\t\t  \t       <input type=\"hidden\" class=\"col-xs-2\" style=\"heig\tht: 30px; font-size: 15px; \" id=\"professor_id\" name=\"professor_id\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${professor_id }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"  required readonly=\"readonly\">\r\n");
      out.write("\t\t  \t       </div>\r\n");
      out.write("\t\t  \t       <div class=\"titlecover\">\r\n");
      out.write("\t\t\t            <label class=\"titlename\" >제목</label>\r\n");
      out.write("\t\t\t           \t<input class=\"titletext\" id=\"title\" name=\"qna_title\" type=\"text\" placeholder=\"제목을 입력하세요\" required  >\r\n");
      out.write("\t\t\t           \t <div id=\"buttons\">\r\n");
      out.write("\t\t\t\t\t\t  \t<a href=\"#this\" class=\"btns\" id=\"regist\">등록</a>\r\n");
      out.write("\t\t\t\t\t  \t\t<a href=\"#this\" class=\"btns\" id=\"close\">닫기</a>\r\n");
      out.write("\t\t\t\t          </div> \r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t   <div class=\"btn-group pwd\">\t\r\n");
      out.write("\t\t\t\t\t   <label id=\"pass\" style=\"display: none;\"  >비밀번호 </label>\r\n");
      out.write("\t\t\t\t\t   <input id=\"password\" name=\"qna_password\" type=\"text\" value=\"\" placeholder=\"비밀번호를 입력하세요\" style=\" display: none; \" >\r\n");
      out.write("\t\t\t\t\t   <span >비밀글 </span>\r\n");
      out.write("\t\t\t\t\t   <input id=\"secret\" name=\"qna_type\" type=\"checkbox\" class=\"js-switch\" value=\"일반글\"/>\t\r\n");
      out.write("\t\t  \t       </div>\r\n");
      out.write("\t  \t        </div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("         \t\r\n");
      out.write("  \t       <br/>\r\n");
      out.write("          <textarea id=\"qnaRegist_content\" name=\"qna_content\"></textarea>\r\n");
      out.write("          \r\n");
      out.write("          \r\n");
      out.write("          \r\n");
      out.write("        </form>      \r\n");
      out.write("      </div>\r\n");
      out.write("    </section>\r\n");
      out.write("\r\n");
      out.write("  </div>\r\n");
      out.write("</body>\r\n");
      out.write("\t<script>\r\n");
      out.write("\tvar elem = document.querySelector('.js-switch');\r\n");
      out.write("\r\n");
      out.write("\tvar init =new Switchery(elem,{\r\n");
      out.write("\t\t    // primary color\r\n");
      out.write("\t\t    color             :'#FF0033',\r\n");
      out.write("\t\t    secondaryColor    :'#66FF00',\r\n");
      out.write("\t\t    className         :'switchery',\r\n");
      out.write("\t\t    disabled          :false,\r\n");
      out.write("\t\t    disabledOpacity   : 0.5,\r\n");
      out.write("\t\t    speed             :'0.4s',\r\n");
      out.write("\t\t    // 'small', 'large'\r\n");
      out.write("\t\t    size              :'default'\r\n");
      out.write("\t    \r\n");
      out.write("\t});\r\n");
      out.write("\r\n");
      out.write("\telem.onchange =function(){\r\n");
      out.write("\t\tif($(\"input:checkbox[name=qna_type]\").is(\":checked\") == true) {\r\n");
      out.write("\t\t\t$('#secret').attr('value', \"비밀글\");\r\n");
      out.write("\t\t\t$('#pass').attr('style', \"display: '';\")\r\n");
      out.write("\t\t\t$('#password').attr('style', \"display:'';\")\r\n");
      out.write("\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\telse{\r\n");
      out.write("\t\t\t$('#secret').attr(\"value\",\"일반글\");\r\n");
      out.write("\t\t\t$('#pass').attr('style', \"display:none;\")\r\n");
      out.write("\t\t\t$('#password').attr('style', \"display:none;\")\r\n");
      out.write("\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t// 등록 버튼\r\n");
      out.write("\t$('#regist').on('click', function(e){\r\n");
      out.write("\r\n");
      out.write("\t\tvar form = document.regist;\r\n");
      out.write("\t\tif(form.title.value==\"\"){\r\n");
      out.write("\t\t\talert(\"제목은 필수 입니다.\");\r\n");
      out.write("\t\t\treturn;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif(form.qnaRegist_content.value.length>1000){\r\n");
      out.write("\t\t\talert(\"글자수가 1000자를 초과할 수 없습니다.\");\r\n");
      out.write("\t\t\treturn;\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\tform.submit();\r\n");
      out.write("\t});\r\n");
      out.write("\t//닫기 버튼\r\n");
      out.write("\t$('#close').on('click', function(){\r\n");
      out.write("\t\thistory.go(-2);\r\n");
      out.write("\r\n");
      out.write("\t \t});\r\n");
      out.write("\r\n");
      out.write("\t</script>\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("</html>\r\n");
      out.write("<!-- summernote 0.8.12 -->\r\n");
      out.write("<script src=\"http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js\"></script> \r\n");
      out.write("<script src=\"http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js\"></script> \r\n");
      out.write("\r\n");
      out.write("<!-- include summernote css/js-->\r\n");
      out.write("<link href=\"http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.css\" rel=\"stylesheet\">\r\n");
      out.write("<script src=\"http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.js\"></script>\r\n");
      out.write("<script>\r\n");
      out.write("\r\n");
      out.write("$(function(){\r\n");
      out.write("\t$('#content').summernote({\r\n");
      out.write("\t\tplaceholder: '내용을 작성하세요.',\r\n");
      out.write("\t\ttabsize: 1,\r\n");
      out.write("\t\theight: 600,\r\n");
      out.write("\t\tfontNames : [ '맑은고딕', 'Arial', 'Arial Black', 'Comic Sans MS', 'Courier New', ],\r\n");
      out.write("\t\tfontNamesIgnoreCheck : [ '맑은고딕' ],\r\n");
      out.write("\t\tfocus: true,\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tcallbacks: {\r\n");
      out.write("\t\t\tonImageUpload : function(files, editor, welEditable) {\r\n");
      out.write("\t            for (var i = files.length - 1; i >= 0; i--) {\r\n");
      out.write("\t            \tif(files[i].size > 1024*1024*5){\r\n");
      out.write("\t            \t\talert(\"이미지는 5MB 미만입니다.\");\r\n");
      out.write("\t            \t}\r\n");
      out.write("\t            }\r\n");
      out.write("\t            for (var i = files.length - 1; i >= 0; i--) {\r\n");
      out.write("\t            \tsendFile(files[i], this);\r\n");
      out.write("\t            }\r\n");
      out.write("\t        },\r\n");
      out.write("\t        onMediaDelete : function(target) {               \r\n");
      out.write("\t        \tdeleteFile(target[0].src);\r\n");
      out.write("            }\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t});\r\n");
      out.write("\r\n");
      out.write("})\r\n");
      out.write("\r\n");
      out.write("$(function(){\r\n");
      out.write("\t$('#lecture_content').summernote({\r\n");
      out.write("\t\tplaceholder: '내용을 작성하세요.',\r\n");
      out.write("        tabsize: 1,\r\n");
      out.write("\t\theight: 260,\r\n");
      out.write("\t\tfontNames : [ '맑은고딕', 'Arial', 'Arial Black', 'Comic Sans MS', 'Courier New', ],\r\n");
      out.write("\t\tfontNamesIgnoreCheck : [ '맑은고딕' ],\r\n");
      out.write("\t\tfocus: true,\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tcallbacks: {\r\n");
      out.write("\t\t\tonImageUpload : function(files, editor, welEditable) {\r\n");
      out.write("\t            for (var i = files.length - 1; i >= 0; i--) {\r\n");
      out.write("\t            \tif(files[i].size > 1024*1024*5){\r\n");
      out.write("\t            \t\talert(\"이미지는 5MB 미만입니다.\");\r\n");
      out.write("\t            \t}\r\n");
      out.write("\t            }\r\n");
      out.write("\t            for (var i = files.length - 1; i >= 0; i--) {\r\n");
      out.write("\t            \tsendFile(files[i], this);\r\n");
      out.write("\t            }\r\n");
      out.write("\t        },\r\n");
      out.write("\t        onMediaDelete : function(target) {               \r\n");
      out.write("\t        \tdeleteFile(target[0].src);\r\n");
      out.write("            }\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t});\r\n");
      out.write("\r\n");
      out.write("})\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("$(function(){\r\n");
      out.write("\t$('#lecture_content2').summernote({\t\t\r\n");
      out.write("        tabsize: 1,\r\n");
      out.write("\t\theight: 260,\r\n");
      out.write("\t\tfontNames : [ '맑은고딕', 'Arial', 'Arial Black', 'Comic Sans MS', 'Courier New', ],\r\n");
      out.write("\t\tfontNamesIgnoreCheck : [ '맑은고딕' ],\r\n");
      out.write("\t\tfocus: true,\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tcallbacks: {\r\n");
      out.write("\t\t\tonImageUpload : function(files, editor, welEditable) {\r\n");
      out.write("\t            for (var i = files.length - 1; i >= 0; i--) {\r\n");
      out.write("\t            \tif(files[i].size > 1024*1024*5){\r\n");
      out.write("\t            \t\talert(\"이미지는 5MB 미만입니다.\");\r\n");
      out.write("\t            \t}\r\n");
      out.write("\t            }\r\n");
      out.write("\t            for (var i = files.length - 1; i >= 0; i--) {\r\n");
      out.write("\t            \tsendFile(files[i], this);\r\n");
      out.write("\t            }\r\n");
      out.write("\t        },\r\n");
      out.write("\t        onMediaDelete : function(target) {               \r\n");
      out.write("\t        \tdeleteFile(target[0].src);\r\n");
      out.write("            }\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t});\r\n");
      out.write("\r\n");
      out.write("});\r\n");
      out.write("$(function(){\r\n");
      out.write("\t$('#qnaRegist_content').summernote({\t\t\r\n");
      out.write("\t\theight: 551\r\n");
      out.write("\t});\r\n");
      out.write("\r\n");
      out.write("})\r\n");
      out.write("\r\n");
      out.write("function sendFile(file, el) {\r\n");
      out.write("\tvar form_data = new FormData();\r\n");
      out.write("  \tform_data.append(\"file\", file);\r\n");
      out.write("  \t$.ajax({\r\n");
      out.write("    \tdata: form_data,\r\n");
      out.write("    \ttype: \"POST\",\r\n");
      out.write("    \turl: '");
      out.print(request.getContextPath());
      out.write("/uploadImg',\r\n");
      out.write("    \tcache: false,\r\n");
      out.write("    \tcontentType: false,\r\n");
      out.write("    \tenctype: 'multipart/form-data',\r\n");
      out.write("    \tprocessData: false,\r\n");
      out.write("    \tsuccess: function(data) {\r\n");
      out.write(" \r\n");
      out.write("    \t\t $(el).summernote('editor.insertImage', data);\r\n");
      out.write("      \r\n");
      out.write("    \t}\r\n");
      out.write("  \t});\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("function deleteFile(src) {\r\n");
      out.write("\t\r\n");
      out.write("\tvar fileName = splitSrc[splitSrc.length-1];\r\n");
      out.write("    $.ajax({\r\n");
      out.write("        data: {fileName : fileName},\r\n");
      out.write("        type: \"POST\",\r\n");
      out.write("        url: \"");
      out.print(request.getContextPath());
      out.write("/deleteImg\", \r\n");
      out.write("        cache: false,\r\n");
      out.write("        success: function(resp) {\r\n");
      out.write("            console.log(resp);\r\n");
      out.write("        }\r\n");
      out.write("    });\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("</script>");
      out.write("<script>\r\n");
      out.write("var paging = $('[name=page]').val();\r\n");
      out.write("var perPageNum = $('[name=\"perPageNum\"]').val();\r\n");
      out.write("var searchType = $('[name=\"searchType\"]').val();\r\n");
      out.write("var keyword = $('[name=keyword]').val();\r\n");
      out.write("\r\n");
      out.write("function captureReturnKey(e) { \r\n");
      out.write("    if(e.keyCode==13) \r\n");
      out.write("    return false; \r\n");
      out.write("} \r\n");
      out.write("\r\n");
      out.write("//검색란에서 입력시\r\n");
      out.write("function enterkey(page,flag){\r\n");
      out.write("\tif (window.event.keyCode == 13) {\r\n");
      out.write("\t\tvar jobForm=$('#jobForm');\r\n");
      out.write("\t\tjobForm.find(\"[name='page']\").val(page);\r\n");
      out.write("\t\tjobForm.find(\"[name='searchType']\").val($('select[name=\"searchType\"]').val());\r\n");
      out.write("\t\tjobForm.find(\"[name='keyword']\").val($('input[name=\"keyword\"]').val());\t\r\n");
      out.write("\t\tjobForm.attr(\"method\",\"post\");\r\n");
      out.write("\t\tif(flag ==''){\r\n");
      out.write("\t\t\tjobForm.attr(\"action\",\"list\")\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tif(flag == '등록'){\r\n");
      out.write("\t\t\tjobForm.attr(\"action\",\"registList\")\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif(flag =='미완'){\r\n");
      out.write("\t\t\tjobForm.attr(\"action\",\"noRegistList\")\r\n");
      out.write("\t\t}\t\r\n");
      out.write("\t\tjobForm.submit();\r\n");
      out.write("\t\tflag==''\r\n");
      out.write("   }\r\n");
      out.write("\r\n");
      out.write("}\r\n");
      out.write("//버튼 클릭 및 페이지 이동 버튼\r\n");
      out.write("function searchList_go(page,flag){\r\n");
      out.write("\tvar jobForm=$('#jobForm');\r\n");
      out.write("\tjobForm.find(\"[name='page']\").val(page);\r\n");
      out.write("\tjobForm.find(\"[name='searchType']\").val($('select[name=\"searchType\"]').val());\r\n");
      out.write("\tjobForm.find(\"[name='keyword']\").val($('input[name=\"keyword\"]').val());\t\r\n");
      out.write("\tjobForm.attr(\"method\",\"post\");\r\n");
      out.write("\tif(flag ==''){\r\n");
      out.write("\t\tjobForm.attr(\"action\",\"list\")\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tif(flag == '등록'){\r\n");
      out.write("\t\tjobForm.attr(\"action\",\"registList\")\r\n");
      out.write("\t\t\r\n");
      out.write("\t}\r\n");
      out.write("\tif(flag =='미완'){\r\n");
      out.write("\t\tjobForm.attr(\"action\",\"noRegistList\")\r\n");
      out.write("\t}\t\r\n");
      out.write("\tjobForm.submit();\r\n");
      out.write("\tflag==''\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("//비밀글 설정\r\n");
      out.write("var secret = function(){\r\n");
      out.write("\t    $('#secret').attr('style',\"color:red;\")\r\n");
      out.write("\t\t$('#secret').attr('value', \"비밀글\");\r\n");
      out.write("\t\t$('#pass').attr('style', \"display:''; height:35px;\")\r\n");
      out.write("\t\t$('#password').attr('style', \"display:'';\")\r\n");
      out.write("\t}\r\n");
      out.write("//비밀글 해제\r\n");
      out.write("var nonsecret = function(){\r\n");
      out.write("\t$('#secret').attr('style',\"color:blue;\")\r\n");
      out.write("\t$('#secret').attr(\"value\",\"일반글\");\r\n");
      out.write("\t$('#pass').attr('style', \"display:none;\")\r\n");
      out.write("\t$('#password').attr('style', \"display:none;\")\r\n");
      out.write("}\r\n");
      out.write("//답변 등록글 조회\r\n");
      out.write("var registAnswer = function() {\r\n");
      out.write("\t    $('#status').attr('')\r\n");
      out.write("\t\tvar jobForm=$('#jobForm');\r\n");
      out.write("\t\tjobForm.find(\"[name='page']\").val(paging);\r\n");
      out.write("\t\tjobForm.find(\"[name='searchType']\").val($('select[name=\"searchType\"]').val());\r\n");
      out.write("\t\tjobForm.find(\"[name='keyword']\").val($('input[name=\"keyword\"]').val());\t\r\n");
      out.write("\t\tjobForm.attr(\"method\",\"post\");\r\n");
      out.write("\t\tjobForm.attr(\"action\",\"registList\")\r\n");
      out.write("\t\tjobForm.submit();\r\n");
      out.write("\t\tflag==''\r\n");
      out.write("}\r\n");
      out.write("//답변 미등록 글 조회\r\n");
      out.write("var nonRegistAnswer = function () {\r\n");
      out.write("\t\r\n");
      out.write("\tvar jobForm=$('#jobForm');\r\n");
      out.write("\tjobForm.find(\"[name='page']\").val(paging);\r\n");
      out.write("\tjobForm.find(\"[name='searchType']\").val($('select[name=\"searchType\"]').val());\r\n");
      out.write("\tjobForm.find(\"[name='keyword']\").val($('input[name=\"keyword\"]').val());\t\r\n");
      out.write("\tjobForm.attr(\"method\",\"post\");\r\n");
      out.write("\tjobForm.attr(\"action\",\"noRegistList\")\r\n");
      out.write("\r\n");
      out.write("\tjobForm.submit();\r\n");
      out.write("\tflag==''\r\n");
      out.write("\t\r\n");
      out.write("}\r\n");
      out.write("//전체조회\r\n");
      out.write("var allList = function () {\r\n");
      out.write("\tvar jobForm=$('#jobForm');\r\n");
      out.write("\tjobForm.find(\"[name='page']\").val(paging);\r\n");
      out.write("\tjobForm.find(\"[name='searchType']\").val($('select[name=\"searchType\"]').val());\r\n");
      out.write("\tjobForm.find(\"[name='keyword']\").val($('input[name=\"keyword\"]').val());\t\r\n");
      out.write("\tjobForm.attr(\"method\",\"post\");\r\n");
      out.write("\tjobForm.attr(\"action\",\"list\")\r\n");
      out.write("\r\n");
      out.write("\tjobForm.submit();\r\n");
      out.write("\tflag==''\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("}\r\n");
      out.write("//등록 폼 여는 버튼\r\n");
      out.write("$('#write').on('click', function() {\r\n");
      out.write("\tvar rule = $('#authority').val();\r\n");
      out.write("\tif(rule == 'PROFESSOR' || rule == 'ADMIN'){\r\n");
      out.write("\t\t$('#noRule').css('display','inline')\r\n");
      out.write("\t}\r\n");
      out.write("\telse{\r\n");
      out.write("\tvar form = $('#infoForm');\r\n");
      out.write("\tform.attr(\"action\",\"registForm\");\r\n");
      out.write("\tform.submit();\r\n");
      out.write("\t}\r\n");
      out.write("})\r\n");
      out.write("// 등록 버튼\r\n");
      out.write("$('#regist').on('click', function(e){\r\n");
      out.write("\t\r\n");
      out.write("\tvar form = document.regist;\r\n");
      out.write("\tif(form.title.value==\"\"){\r\n");
      out.write("\t\talert(\"제목은 필수 입니다.\");\r\n");
      out.write("\t\treturn;\r\n");
      out.write("\t}\r\n");
      out.write("\tif(form.content.value.length>1000){\r\n");
      out.write("\t\talert(\"글자수가 1000자를 초과할 수 없습니다.\");\r\n");
      out.write("\t\treturn;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\tform.submit();\r\n");
      out.write("});\r\n");
      out.write("//닫기 버튼\r\n");
      out.write("$('#close').on('click', function(){\r\n");
      out.write("\thistory.go(-1);\r\n");
      out.write("\r\n");
      out.write(" \t});\r\n");
      out.write("\r\n");
      out.write("function promp(qno,type,writer,authority){\r\n");
      out.write("\tvar id = $('#member_id').val();\r\n");
      out.write("\tif(id == writer){\r\n");
      out.write("\t\tvar form = $('#infoForm');\r\n");
      out.write("\t\tform.attr(\"action\",\"detail\");\r\n");
      out.write("\t\tform.attr(\"method\", \"Post\");\r\n");
      out.write("\t\tform.append($('<input/>', {type: 'hidden', name: 'qna_no', value:qno }));\r\n");
      out.write("\t\tform.submit();\r\n");
      out.write("\t\t\r\n");
      out.write("\t}else if(authority == 'PROFESSOR'){\r\n");
      out.write("\t\tvar form = $('#infoForm');\r\n");
      out.write("\t\tform.attr(\"action\",\"detail\");\r\n");
      out.write("\t\tform.attr(\"method\", \"Post\");\r\n");
      out.write("\t\tform.append($('<input/>', {type: 'hidden', name: 'qna_no', value:qno }));\r\n");
      out.write("\t\tform.submit();\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t}else if(type == '비밀글'){\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tvar form = $('#infoForm');\r\n");
      out.write("\t\tform.attr(\"action\",\"checkForm\");\r\n");
      out.write("\t\tform.attr(\"method\", \"Post\");\r\n");
      out.write("\t\tform.append($('<input/>', {type: 'hidden', name: 'qna_no', value:qno }));\r\n");
      out.write("\t\tform.submit();\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t}else{\r\n");
      out.write("\t\tvar form = $('#infoForm');\r\n");
      out.write("\t\tform.attr(\"action\",\"detail\");\r\n");
      out.write("\t\tform.attr(\"method\", \"Post\");\r\n");
      out.write("\t\tform.append($('<input/>', {type: 'hidden', name: 'qna_no', value:qno }));\r\n");
      out.write("\t\tform.submit();\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("$('#modifyBtn').on('click',function(){\r\n");
      out.write("\r\n");
      out.write("\tvar form = $('#modify');\r\n");
      out.write("\tvar title = $('#title').val();\r\n");
      out.write("\tvar content = $('#content').val();\r\n");
      out.write("\t\r\n");
      out.write("\tif(title.length > 50){\r\n");
      out.write("\t\talert('제목은 50자를 넘을 수 없습니다')\r\n");
      out.write("\t\treturn false\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tif(content.length > 1000){\r\n");
      out.write("\t\talert('내용은은 1000자를 넘을 수 없습니다')\r\n");
      out.write("\t\treturn false\r\n");
      out.write("\t}\r\n");
      out.write("\tform.submit();\r\n");
      out.write("});\r\n");
      out.write("\r\n");
      out.write("</script>");
      out.write("</body>\r\n");
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
