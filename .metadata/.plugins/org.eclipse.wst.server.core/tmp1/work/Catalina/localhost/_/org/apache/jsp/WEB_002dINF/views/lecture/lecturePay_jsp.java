/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2020-07-09 05:00:16 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.lecture;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class lecturePay_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/WEB-INF/views/lecture/lecturePay_js.jsp", Long.valueOf(1594192135612L));
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<style>\r\n");
      out.write(".payLectBtn{\r\n");
      out.write("\tbackground-color: #3162C7;\r\n");
      out.write("\tcolor: #fff;\r\n");
      out.write("}\r\n");
      out.write(".payLectBtn:hover {\r\n");
      out.write("\tbackground-color: #fff;\r\n");
      out.write("\tcolor:#3162C7;\r\n");
      out.write("}\r\n");
      out.write("#payText{\r\n");
      out.write("\tbackground-image: url('");
      out.print(request.getContextPath());
      out.write("/resources/images/결제.png');\r\n");
      out.write("\tbackground-position: center;\r\n");
      out.write("    background-repeat: no-repeat;\r\n");
      out.write("    background-size: 100% 100%;\r\n");
      out.write("    height: 600px;\r\n");
      out.write("    width: 550px;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\t\r\n");
      out.write("\t<div>\r\n");
      out.write("      <div class=\"pay-group\" id=\"payText\" style=\"padding-top: 80px; padding-bottom:25px; margin: auto;\">\r\n");
      out.write("          <div>\r\n");
      out.write("          <table style=\"margin-left:auto; margin-right:auto; \">\r\n");
      out.write("          \t<tr style=\"border-bottom: 2px solid;\">\r\n");
      out.write("          \t\t<td colspan=\"2\" ><h3>결제를 진행 하시겠습니까?</h3></td>\r\n");
      out.write("          \t</tr>\r\n");
      out.write("          \t<tr style=\"height: 100px;\">\r\n");
      out.write("          \t\t<td>\r\n");
      out.write("          \t\t\t<h3>결제금액 :</h3>\r\n");
      out.write("          \t\t</td>\r\n");
      out.write("          \t\t<td style=\"text-align:center;\">\r\n");
      out.write("          \t\t\t<h2 style=\"color: #5D5D5D;\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${lecture.lecture_price }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write(" 원</h2>\r\n");
      out.write("          \t\t</td>\r\n");
      out.write("          \t</tr>\r\n");
      out.write("          \t<tr style=\"height: 150px; border-bottom: 2px solid;\">\r\n");
      out.write("          \t\t<td >\r\n");
      out.write("          \t\t\t<h3>신청한 강의 :</h3>\r\n");
      out.write("          \t\t</td>\r\n");
      out.write("          \t\t<td style=\"text-align:center;\">\r\n");
      out.write("          \t\t\t<h2 style=\"color: #5D5D5D;\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${lecture.lecture_title }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</h2>\r\n");
      out.write("          \t\t</td>\r\n");
      out.write("          \t\t\r\n");
      out.write("          \t</tr>\r\n");
      out.write("          </table>\r\n");
      out.write("              \r\n");
      out.write("          </div>\r\n");
      out.write("          <div class=\"lecturePayBtn\" align=\"center\" style=\"padding-top: 18px;\">\r\n");
      out.write("          <button id=\"cansle\" type=\"button\" class=\"btn payLectBtn\">취소</button>\r\n");
      out.write("          <button id=\"payButton\" class=\"btn payLectBtn\" type=\"button\"> 결제 </button>\r\n");
      out.write("          </div>\r\n");
      out.write("       \r\n");
      out.write("      </div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\" src=\"https://cdn.iamport.kr/js/iamport.payment-1.1.5.js\"></script>\r\n");
      out.write("<body>\r\n");
      out.write("    <script>\r\n");
      out.write("    $('#payButton').on('click',function(){\r\n");
      out.write("        var IMP = window.IMP; // 생략가능\r\n");
      out.write("        IMP.init('imp43485671'); // 'iamport' 대신 부여받은 \"가맹점 식별코드\"를 사용\r\n");
      out.write("        var msg;\r\n");
      out.write("        var pay_no='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${payDetail.pay_no}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("';\r\n");
      out.write("        var student_id='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${loginUser.member_id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("';\r\n");
      out.write("        var lecture_no='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${lecture.lecture_no}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("';\r\n");
      out.write("        var professor_id='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${lecture.professor_id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("';\r\n");
      out.write("        var lecture_title='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${lecture.lecture_title}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("';\r\n");
      out.write("        var pay_price='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${lecture.lecture_price}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("';\r\n");
      out.write("        var class_name='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${payDetail.class_name}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("';\r\n");
      out.write("        var member_id='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${loginUser.member_id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("';\r\n");
      out.write("        var lecture_price='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${payDetail.lecture_price}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("';\r\n");
      out.write("       \t\r\n");
      out.write("        var jsonData= {\r\n");
      out.write("        \t\t\"pay_no\":pay_no,\r\n");
      out.write("        \t\t\"lecture_no\":lecture_no,\r\n");
      out.write("        \t    \"professor_id\":professor_id,\r\n");
      out.write("        \t    \"student_id\":student_id,\r\n");
      out.write("        \t\t\"lecture_title\":lecture_title,\r\n");
      out.write("        \t\t\"pay_price\":pay_price,\r\n");
      out.write("        \t\t\"class_name\":class_name,\r\n");
      out.write("        \t\t\"member_id\":member_id,\r\n");
      out.write("        \t\t\"lecture_price\":lecture_price\r\n");
      out.write("        \t\t};\r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("        IMP.request_pay({\r\n");
      out.write("            pg : 'kakaopay',\r\n");
      out.write("            pay_method : 'card',\r\n");
      out.write("            merchant_uid : 'merchant_' + new Date().getTime(),\r\n");
      out.write("            name : '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${lecture.lecture_title}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("',\r\n");
      out.write("            amount : '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${lecture.lecture_price }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("',\r\n");
      out.write("            buyer_postcode : '123-456',\r\n");
      out.write("            //m_redirect_url : 'http://www.naver.com'\r\n");
      out.write("        }, function(rsp) {\r\n");
      out.write("            if ( rsp.success ) {\r\n");
      out.write("                //[1] 서버단에서 결제정보 조회를 위해 jQuery ajax로 imp_uid 전달하기\r\n");
      out.write("                \r\n");
      out.write("                jQuery.ajax({\r\n");
      out.write("                    url: \"/pay/payIng\", //cross-domain error가 발생하지 않도록 주의해주세요\r\n");
      out.write("            \t\tdataType : 'text',\r\n");
      out.write("            \t\ttype : 'POST',\r\n");
      out.write("            \t\tdata : JSON.stringify(jsonData), //그냥 member 사용하면 error 발생!\r\n");
      out.write("            \t\tcontentType : 'application/json; charset=UTF-8',\r\n");
      out.write("            \t\t\r\n");
      out.write("            \t\tsuccess:function(result) {\r\n");
      out.write("            \t\t\tlocation.href=\"");
      out.print(request.getContextPath());
      out.write("/pay/paySuccess\";\r\n");
      out.write("            \t\t},\r\n");
      out.write("            \t\terror:function(err){\r\n");
      out.write("            \t\t\tlocation.href=\"");
      out.print(request.getContextPath());
      out.write("/pay/payFail\";\r\n");
      out.write("            \t\t}                    /*dataType: 'json',\r\n");
      out.write("                    data: {\r\n");
      out.write("                        imp_uid : rsp.imp_uid,\r\n");
      out.write("                        jsonData : jsonData\r\n");
      out.write("                        \r\n");
      out.write("                    }*/\r\n");
      out.write("                });\r\n");
      out.write("            } else {\r\n");
      out.write("                msg = '결제에 실패하였습니다.';\r\n");
      out.write("                msg += '에러내용 : ' + rsp.error_msg;\r\n");
      out.write("                //실패시 이동할 페이지\r\n");
      out.write("                location.href=\"");
      out.print(request.getContextPath());
      out.write("/pay/payFail\";\r\n");
      out.write("                alert(msg);\r\n");
      out.write("            }\r\n");
      out.write("        });\r\n");
      out.write("        \r\n");
      out.write("    });\r\n");
      out.write("    </script>\r\n");
      out.write(" \r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("<script>\r\n");
      out.write("$('#cansle').on('click',function(){\r\n");
      out.write("\thistory.go(-1);\r\n");
      out.write("})\r\n");
      out.write("\r\n");
      out.write("$.ajax({\r\n");
      out.write("\turl:\"");
      out.print(request.getContextPath());
      out.write("/pay/lecturePay\",\r\n");
      out.write("\ttype:\"get\",\r\n");
      out.write("\tsuccess:function(src){\r\n");
      out.write("\t\t\r\n");
      out.write("\t},\r\n");
      out.write("\terror:function(err){\r\n");
      out.write("\t\talert(\"이미 수강내역이 있습니다\")\r\n");
      out.write("\t\tlocation.href=history.go(-1);\t\t\r\n");
      out.write("\t}\r\n");
      out.write("})\r\n");
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
