/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2020-07-09 03:26:20 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.commons;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class idForgot_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<title>아이디찾기</title>\r\n");
      out.write("<style>\r\n");
      out.write("\t.wrap{\r\n");
      out.write("\t\tpadding: 80px 0px 0px;\r\n");
      out.write("\t    font-size: 32px;\r\n");
      out.write("\t    width: 70%;\r\n");
      out.write("\t    font-family: 'Karla';\r\n");
      out.write("\t    margin: 0 auto;\r\n");
      out.write("\t    text-align: left;\r\n");
      out.write("\t}\r\n");
      out.write("\t .breadcrumb {\r\n");
      out.write("\t    padding: 0px;\r\n");
      out.write("\t\tbackground: #D4D4D4;\r\n");
      out.write("\t\tlist-style: none; \r\n");
      out.write("\t\toverflow: hidden;\r\n");
      out.write("\t\tfloat: right;\r\n");
      out.write("\t}\r\n");
      out.write("\t.breadcrumb>li+li:before {\r\n");
      out.write("\t\tpadding: 0;\r\n");
      out.write("\t}\r\n");
      out.write("\t.breadcrumb li { \r\n");
      out.write("\t\tfloat: left; \r\n");
      out.write("\t}\r\n");
      out.write("\t.breadcrumb li.active a {\r\n");
      out.write("\t\tbackground: brown;                 \r\n");
      out.write("\t\tbackground: #ffc107 ; \r\n");
      out.write("\t}\r\n");
      out.write("\t.breadcrumb li.completed a {\r\n");
      out.write("\t\tbackground: brown;                  \r\n");
      out.write("\t\tbackground: hsla(153, 57%, 51%, 1); \r\n");
      out.write("\t}\r\n");
      out.write("\t.breadcrumb li.active a:after {\r\n");
      out.write("\t\tborder-left: 30px solid #ffc107 ;\r\n");
      out.write("\t}\r\n");
      out.write("\t.breadcrumb li.completed a:after {\r\n");
      out.write("\t\tborder-left: 30px solid hsla(153, 57%, 51%, 1);\r\n");
      out.write("\t} \r\n");
      out.write("\r\n");
      out.write("\t.breadcrumb li a {\r\n");
      out.write("\t\tcolor: white;\r\n");
      out.write("\t\ttext-decoration: none; \r\n");
      out.write("\t\tpadding: 10px 0 10px 45px;\r\n");
      out.write("\t\tposition: relative; \r\n");
      out.write("\t\tdisplay: block;\r\n");
      out.write("\t\tfloat: left;\r\n");
      out.write("\t}\r\n");
      out.write("\t.breadcrumb li a:after { \r\n");
      out.write("\t\tcontent: \" \"; \r\n");
      out.write("\t\tdisplay: block; \r\n");
      out.write("\t\twidth: 0; \r\n");
      out.write("\t\theight: 0;\r\n");
      out.write("\t\tborder-top: 50px solid transparent;          \r\n");
      out.write("\t\tborder-bottom: 50px solid transparent;\r\n");
      out.write("\t\tborder-left: 30px solid hsla(0, 0%, 83%, 1);\r\n");
      out.write("\t\tposition: absolute;\r\n");
      out.write("\t\ttop: 50%;\r\n");
      out.write("\t\tmargin-top: -50px; \r\n");
      out.write("\t\tleft: 100%;\r\n");
      out.write("\t\tz-index: 2; \r\n");
      out.write("\t}\t\r\n");
      out.write("\t.breadcrumb li a:before { \r\n");
      out.write("\t\tcontent: \" \"; \r\n");
      out.write("\t\tdisplay: block; \r\n");
      out.write("\t\twidth: 0; \r\n");
      out.write("\t\theight: 0;\r\n");
      out.write("\t\tborder-top: 50px solid transparent;           \r\n");
      out.write("\t\tborder-bottom: 50px solid transparent;\r\n");
      out.write("\t\tborder-left: 30px solid white;\r\n");
      out.write("\t\tposition: absolute;\r\n");
      out.write("\t\ttop: 50%;\r\n");
      out.write("\t\tmargin-top: -50px; \r\n");
      out.write("\t\tmargin-left: 1px;\r\n");
      out.write("\t\tleft: 100%;\r\n");
      out.write("\t\tz-index: 1; \r\n");
      out.write("\t}\t\r\n");
      out.write("\t.breadcrumb li:first-child a {\r\n");
      out.write("\t\tpadding-left: 15px;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t.wrap .row{\r\n");
      out.write("\t\tborder-bottom: 1px solid black;\r\n");
      out.write("\t\tmargin-bottom: 10%; \r\n");
      out.write("\t}\r\n");
      out.write("\tspan.glyphicon{\r\n");
      out.write("\t\tfloat: left;\r\n");
      out.write("\t}\r\n");
      out.write("\tul{\r\n");
      out.write("\t   list-style:none;\r\n");
      out.write("\t   font-size: 15px;\r\n");
      out.write("   }\r\n");
      out.write("   li>button{\r\n");
      out.write("\t\twidth: 50%;\r\n");
      out.write("   }\r\n");
      out.write("   .tit{\r\n");
      out.write("\t\tfont-size: 32px;\r\n");
      out.write("   }\r\n");
      out.write("   div label{\r\n");
      out.write("\t\tfont-size: 20px;\r\n");
      out.write("\t}\r\n");
      out.write("\t.foundbox{\r\n");
      out.write("\t\tmargin: 30px;\r\n");
      out.write("\t    padding: 30px 330px 30px 49px;\r\n");
      out.write("\t}\r\n");
      out.write("\tinput[name=\"member_name\"],input[name=\"member_email\"],input[name=\"member_hp\"],button[name=\"checkBtn\"]{\r\n");
      out.write("\t\twidth:  100%;\r\n");
      out.write("\t\tmargin-bottom: 10px;\r\n");
      out.write("\t    font-size: 23px;\r\n");
      out.write("\t}\r\n");
      out.write("\tbutton[name='idOpenBtn']{\r\n");
      out.write("\t\twidth: 60px;\r\n");
      out.write("\t}\r\n");
      out.write("\t.writeNum{\r\n");
      out.write("\t\tfont-size: 23px;\r\n");
      out.write("    \tmargin-right: 27px;\r\n");
      out.write("\t}\r\n");
      out.write("</style>\r\n");
      out.write("<body>\r\n");
      out.write("<div class=\"wrap\">\r\n");
      out.write("<span class=\"glyphicon glyphicon-search\" aria-hidden=\"true\">아이디찾기</span>\r\n");
      out.write("\t<div class=\"row\">\r\n");
      out.write("\t<ul class=\"col-sm-6 breadcrumb\">\r\n");
      out.write("\t\t\t<li class=\"breadcrumb-item active\"><a href=\"javascript:void(0);\">1.찾기방식 선택</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"javascript:void(0);\">2.인증 확인</a></li>\r\n");
      out.write("\t\t\t<li><a href=\"javascript:void(0);\">3.인증완료</a></li>\r\n");
      out.write("\t\t</ul>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div class=\"comfirm_area first\">\r\n");
      out.write("\t\t<div class=\"tit_box\">\r\n");
      out.write("\t\t\t<h3 class=\"tit\">회원 정보</h3>\r\n");
      out.write("\t\t\t<div class=\"form-check emailRadioCheck\">\r\n");
      out.write("\t\t\t  <input class=\"form-check-input\" type=\"radio\" name=\"check\" id=\"emailCheck\" value=\"\" >\r\n");
      out.write("\t\t\t  <label class=\"form-check-label\" for=\"emailCheck\">\r\n");
      out.write("\t\t\t   \t이메일 주소로 찾기\r\n");
      out.write("\t\t\t  </label>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"form-check hpRadioCheck\">\r\n");
      out.write("\t\t\t  <input class=\"form-check-input\" type=\"radio\" name=\"check\" id=\"hpCheck\" value=\"\">\r\n");
      out.write("\t\t\t  <label class=\"form-check-label\" for=\"hpCheck\">\r\n");
      out.write("\t\t\t    휴대폰 인증으로 찾기\r\n");
      out.write("\t\t\t  </label>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<form action=\"");
      out.print(request.getContextPath() );
      out.write("/commons/idCheck_HpCertify\" method=\"post\" class=\"numberCheckForm\">\r\n");
      out.write("\t\t<input type=\"hidden\" name=\"CheckNum\" value=\"\" />\r\n");
      out.write("\t</form>\r\n");
      out.write("</div>\r\n");
      out.write("<script src=\"https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/4.1.2/handlebars.min.js\"></script>\r\n");
      out.write("<script id=\"templateEmailInfo\" type=\"text/x-handlebars-template\">\r\n");
      out.write("\t<form method=\"post\" action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/commons/idCheck_EmailCertify\" name=\"idCheckForm\" class=\"joinEmail_write foundbox\">\r\n");
      out.write("\t\t<fieldset >\r\n");
      out.write("\t\t\t<ul>\r\n");
      out.write("\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t<input type=\"text\" name=\"member_name\" id=\"memberName\" class=\"inp\" placeholder=\"이름\" maxlength=\"50\"\r\n");
      out.write("\t\t\t\t\t onkeyup=\"this.value=this.value.replace(/[0-9~!@#$%^&*()_+|<>?:{}\\- ]/g,'');\">\r\n");
      out.write("\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t<input type=\"text\" name=\"member_email\" id=\"memberEmailAddr\" class=\"inp\" placeholder=\"이메일\" maxlength=\"80\">\r\n");
      out.write("\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t<button class=\"btn btn-danger\" name=\"checkBtn\"><span>찾기</span></button>\r\n");
      out.write("\t\t\t\t</li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t</fieldset>\r\n");
      out.write("\t</form>\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<script id=\"templatehpInfo\" type=\"text/x-handlebars-template\">\r\n");
      out.write("\t<div class=\"joinHp_write foundbox\">\r\n");
      out.write("\t\t<fieldset>\r\n");
      out.write("\t\t<ul>\r\n");
      out.write("\t\t\t<li>\r\n");
      out.write("\t\t\t\t<input type=\"text\" name=\"member_name\" id=\"memberName\" class=\"inp\" placeholder=\"이름\"  maxlength=\"50\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tonkeyup=\"this.value=this.value.replace(/[0-9~!@#$%^&*()_+|<>?:{}\\- ]/g,'');\">\r\n");
      out.write("\t\t\t\t<p class=\"warningNameMsg\"></p>\r\n");
      out.write("\t\t\t</li>\r\n");
      out.write("\t\t\t<li>\r\n");
      out.write("\t\t\t\t<input type=\"text\" name=\"member_hp\" id=\"memberhp\" class=\"inp\" placeholder=\"'-'을 생략\"\" maxlength=\"11\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tonkeyup=\"this.value=this.value.replace(/[ㄱ-ㅎㅏ-ㅣ가-힣 a-z A-Z~!@#$%^&*()_+|<>?:{}\\- ]/g,'');\">\r\n");
      out.write("\t\t\t\t<p class=\"warningHpMsg\"></p>\r\n");
      out.write("\t\t\t</li>\r\n");
      out.write("\t\t\t<li class=\"liParent\">\r\n");
      out.write("\t\t\t\t<button type=\"button\" class=\"btn btn-danger certifyNum\" onclick=\"doSns();\" name=\"checkBtn\"><span>인증하기</span></button>\r\n");
      out.write("\t\t\t\t<button class=\"btn btn-danger col-xs-2\" name=\"idOpenBtn\" onclick=\"idOpenBtn()\">찾기</button>\r\n");
      out.write("\t\t\t\t<button class=\"btn btn-danger col-xs-2\" name=\"idCancelBtn\" onclick=\"idCancelBtn()\">취소</button>\t\t\r\n");
      out.write("\t\t\t</li>\r\n");
      out.write("\t\t\t\t<input type=\"hidden\"  name='saveWriteNum' />\t\r\n");
      out.write("\t\t</ul>\r\n");
      out.write("\t\t</fieldset>\r\n");
      out.write("\t</div>\r\n");
      out.write("</script>\r\n");
      out.write("<script>\r\n");
      out.write("\r\n");
      out.write("\t//체크박스에 의한 이메일인증 작업선택\r\n");
      out.write("\t$(\"input[id='emailCheck']\").on(\"click\",function(){\r\n");
      out.write("\t\t\tvar certify =$(\"input:radio[id='emailCheck']\").is(':checked');\r\n");
      out.write("\t\t\tif(certify){\r\n");
      out.write("\t\t\t\tif($(\"div.emailRadioCheck > form\").length == 0){\r\n");
      out.write("\t\t\t\t\tvar template=Handlebars.compile($('#templateEmailInfo').html());\r\n");
      out.write("\t\t\t\t\t$(\".emailRadioCheck\").append(template);\r\n");
      out.write("\t\t\t\t\t$(\".joinHp_write\").remove();\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t})\r\n");
      out.write("\r\n");
      out.write("\t//체크박스에 의한 휴대폰인증 작업선택\r\n");
      out.write("\t$(\"input[id='hpCheck']\").on(\"click\",function(){\r\n");
      out.write("\t\t\tvar certify =$(\"input:radio[id='hpCheck']\").is(':checked');\r\n");
      out.write("\t\t\tif(certify){\r\n");
      out.write("\t \t\t\tif($(\"div.hpRadioCheck > div.foundbox\").length == 0){ \r\n");
      out.write("\t\t\t\t\tvar template=Handlebars.compile($('#templatehpInfo').html());\r\n");
      out.write("\t\t\t\t\t$(\".hpRadioCheck\").append(template);\r\n");
      out.write("\t\t\t\t\t$(\".joinEmail_write\").remove();\r\n");
      out.write("\t\t\t\t\t$(\"button[name='idOpenBtn']\").hide();\r\n");
      out.write("\t\t\t\t\t$(\"button[name='idCancelBtn']\").hide();\r\n");
      out.write("\t \t\t\t} \r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t})\r\n");
      out.write("\t\r\n");
      out.write("\tfunction doSns(){\r\n");
      out.write("\t\t//입력한 이름 및 휴대폰 번호\r\n");
      out.write("\t\tvar searchName = $(\"input[name='member_name']\").val();\r\n");
      out.write("\t\tvar searchHp   = $(\"input[name='member_hp']\").val();\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tif(searchName==\"\"){\r\n");
      out.write("\t\t\t$(\".warningNameMsg\").text(\"입력 필수\").css(\"color\" , \"red\");\r\n");
      out.write("\t\t\treturn;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\t$(\".warningNameMsg\").empty();\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tif(searchHp==\"\"){\r\n");
      out.write("\t\t\t$(\".warningHpMsg\").text(\"입력 필수\").css(\"color\" , \"red\");\r\n");
      out.write("\t\t\treturn;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\t$(\".warningHpMsg\").empty();\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tvar data={ \r\n");
      out.write("\t\t\t\t\t\"name\" : searchName,\r\n");
      out.write("\t\t\t\t\t\"hp\"   : searchHp\r\n");
      out.write("\t\t\t\t }\r\n");
      out.write("\t\t$('.certifyNum').after($(\"<input type='text' placeholder='인증번호' name='writeNum' class='col-xs-5' />\"));\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t   $.ajax({\r\n");
      out.write("\t\t\turl:\"");
      out.print(request.getContextPath());
      out.write("/commons/idCheck_Send\",\r\n");
      out.write("\t\t\ttype:\"post\",\r\n");
      out.write("\t\t\tdata : JSON.stringify(data),\r\n");
      out.write("\t\t\tcontentType:\"application/json; charset=UTF-8\" , //보내는 data 형식 지정\r\n");
      out.write("\t\t\tsuccess:function(suc){\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\talert(\"인증문자가 발송 되었습니다.\");\r\n");
      out.write("\t\t\t\t$(\"button[name='checkBtn']\").text('다시보내기');\r\n");
      out.write("\t\t\t\t$(\"input[name='member_name']\").prop('readonly', true).css('background','#dedbdb');\r\n");
      out.write("\t\t\t\t$(\"input[name='member_hp']\").prop('readonly', true).css('background','#dedbdb');\r\n");
      out.write("\t\t\t\t$(\"input[name='saveWriteNum']\").val(suc);\r\n");
      out.write("\t\t\t\t$(\"button[name='idOpenBtn']\").show();\r\n");
      out.write("\t\t\t\t$(\"button[name='idCancelBtn']\").show();\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\terror:function(err){\r\n");
      out.write("\t\t\t\talert(err);\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t}) \r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tfunction idOpenBtn(){\r\n");
      out.write("\t\t//입력한 이름 및 휴대폰 번호\r\n");
      out.write("\t\tvar searchName = $(\"input[name='member_name']\").val();\r\n");
      out.write("\t\tvar searchHp   = $(\"input[name='member_hp']\").val();\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tvar data={ \r\n");
      out.write("\t\t\t\t\"member_name\" : searchName,\r\n");
      out.write("\t\t\t\t\"member_phone\"   : searchHp\r\n");
      out.write("\t\t\t }\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tvar writeNum= $(\"input[name='writeNum']\").val();\r\n");
      out.write("\t\tvar saveWriteNum= $(\"input[name='saveWriteNum']\").val();\r\n");
      out.write("\t\tif(writeNum == saveWriteNum){\r\n");
      out.write("\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\turl:\"");
      out.print(request.getContextPath());
      out.write("/commons/idcheckLoading\",\r\n");
      out.write("\t\t\t\ttype:\"post\",\r\n");
      out.write("\t\t\t\tdata: JSON.stringify(data),\r\n");
      out.write("\t\t\t\tcontentType :\"application/json; charset=UTF-8\" , //보내는 data 형식 지정\r\n");
      out.write("\t\t\t\tsuccess:function(suc){\r\n");
      out.write("\t\t\t\t\tlocation.href=\"");
      out.print(request.getContextPath());
      out.write("/commons/idcheckPage?member_name=\"+searchName+\"&member_phone=\"+searchHp;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t})\r\n");
      out.write("\t\t}else{\r\n");
      out.write("\t\t\talert(\"인증문자 불일치\");\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tfunction idCancelBtn(){\r\n");
      out.write("\t\talert(\"CancelTest\");\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("</script>\r\n");
      out.write("</body>\r\n");
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
