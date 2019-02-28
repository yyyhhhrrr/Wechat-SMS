<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<script>
var ctx='${ctx}';
</script>
<!DOCTYPE html>
<html lang="zh-CN">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>教务管理系统</title>
<link rel="stylesheet" href="${ctx }/resource/login/one/css/style.css">
<script src="${ctx}/resource/admin/js/jquery-1.7.1.js" type="text/javascript"></script>
<script type="text/javascript" src="${ctx }/resource/My97DatePicker/WdatePicker.js"></script>
<body>
<div class="login-container">
	<h1>教务管理系统账号绑定</h1>
	<form action="" method="post" id="login_form">
		
			<%----%>
			<a href="javascript:showRegisterstudent();">
			<button type="button" class="register-tis">我要绑定</button>
			</a>
			
			 
	</form>
	<form action="" method="post" id="registerFormstudent" style="display: none;">
	
		<div>
			<input type="text" id="student_username" name="username" class="username" placeholder="用户名" autocomplete="off"/>
		</div>
		<div>
			<input type="password" id="student_password" name="password" class="password" placeholder="密码" oncontextmenu="return false" onpaste="return false" />
		</div>
		<div>
			<input type="hidden"  id="student_openid" name="openid" value='${userInfo.openId}'/>
		</div>
		<button id="submit" type="button" onclick="registerSavestudent();">点击绑定</button>
		
	
	</form>
	
</div>
<script src="${ctx }/resource/login/one/js/jquery.min.js"></script>
<!--背景图片自动更换-->
<script src="${ctx }/resource/login/one/js/supersized.3.2.7.min.js"></script>
</body>
<script type="text/javascript">
jQuery(function($){
    $.supersized({
        // 功能
        slide_interval     : 4000,    // 转换之间的长度
        transition         : 1,    // 0 - 无，1 - 淡入淡出，2 - 滑动顶，3 - 滑动向右，4 - 滑底，5 - 滑块向左，6 - 旋转木马右键，7 - 左旋转木马
        transition_speed   : 1000,    // 转型速度
        performance        : 1,    // 0 - 正常，1 - 混合速度/质量，2 - 更优的图像质量，三优的转换速度//（仅适用于火狐/ IE浏览器，而不是Webkit的）
        // 大小和位置
        min_width          : 0,    // 最小允许宽度（以像素为单位）
        min_height         : 0,    // 最小允许高度（以像素为单位）
        vertical_center    : 1,    // 垂直居中背景
        horizontal_center  : 1,    // 水平中心的背景
        fit_always         : 0,    // 图像绝不会超过浏览器的宽度或高度（忽略分钟。尺寸）
        fit_portrait       : 1,    // 纵向图像将不超过浏览器高度
        fit_landscape      : 0,    // 景观的图像将不超过宽度的浏览器
        // 组件
        slide_links        : 'blank',    // 个别环节为每张幻灯片（选项：假的，'民'，'名'，'空'）
        slides             : [    // 幻灯片影像
                                 {image : '${ctx}/resource/1.jpg'}
                       ]
    });
});

//重写alert
window.alert = function(name){
    var iframe = document.createElement("IFRAME");
    iframe.style.display="none";
    iframe.setAttribute("src", 'data:text/plain,');
    document.documentElement.appendChild(iframe);
    window.frames[0].window.alert(name);
    iframe.parentNode.removeChild(iframe);
}
//重写confirm 不显示ip地址  
var wConfirm = window.confirm;  
window.confirm = function (message) {  
    try {  
        var iframe = document.createElement("IFRAME");  
        iframe.style.display = "none";  
        iframe.setAttribute("src", 'data:text/plain,');  
        document.documentElement.appendChild(iframe);  
        var alertFrame = window.frames[0];  
        var iwindow = alertFrame.window;  
        if (iwindow == undefined) {  
            iwindow = alertFrame.contentWindow;  
        }  
        var result = iwindow.confirm(message);  
        iframe.parentNode.removeChild(iframe);  
        return result;  
    }  
    catch (exc) {  
        return wConfirm(message);  
    }  
}

//
	function showRegisterptadmin(){
		$("#login_form").hide();
		$("#registerFormptadmin").show();
		$("#registerFormstudent").hide();
		$("#registerFormteacher").hide();
	}
	function showRegisterstudent(){
		$("#login_form").hide();
		$("#registerFormstudent").show();
		$("#registerFormptadmin").hide();
		$("#registerFormteacher").hide();
	}
	function showRegisterteacher(){
		$("#login_form").hide();
		$("#registerFormteacher").show();
		$("#registerFormptadmin").hide();
		$("#registerFormstudent").hide();
	}
	function showLogin(){
		$("#login_form").show();
		$("#registerFormptadmin").hide();
		$("#registerFormstudent").hide();
		$("#registerFormteacher").hide();
	}	
	function loginCheck(){
		var username = $("#login_username").val();
		var password = $("#login_password").val();
		var type = $("#type").val();
		if(username==''||password==''){
			alert('用户名和密码必须填写');
			return false;
		}
		var aa="";
		var bb="";
		if(type=='教务人员'){
			aa="${ctx}/ptadminLogin/save.html";
			bb="${ctx}/ptadmin/index.html";
		}else if(type=='学生'){
			aa="${ctx}/studentLogin/save.html";
			bb="${ctx}/student/index.html";
		}else if(type=='老师'){
			aa="${ctx}/teacherLogin/save.html";
			bb="${ctx}/teacher/index.html";
		}else{
			aa="${ctx}/adminLogin/save.html";
			bb="${ctx}/admin/index.html";
		}
		$.ajax({
		      type: "POST",
		      async:false,  // 设置同步方式
		      cache:false,
		      url: aa,
				data:$("#login_form").serializeArray(),
				success:function(result){
				result = eval("("+result+")");
				if(result.status=='true'||result.status==true){
					if(result.msg=='1'){
						alert('登录成功');
						window.location.href=bb;
					}else if(result.msg=='0'){
						alert('密码或用户名错误');
					}
				}
		      }
			});
	}
	function registerSaveptadmin(){
		var username = $("#ptadmin_username").val();
		var password = $("#ptadmin_password").val();
	
		if(username==''||password==''){
			alert('用户名和密码必须填写');
			return false;
		}
		$.ajax({
		      type: "POST",
		      async:false,  // 设置同步方式
		      cache:false,
		      url: "${ctx}/ptadminLogin/registerSave.html",
				data:$("#registerFormptadmin").serializeArray(),
				success:function(result){
				result = eval("("+result+")");
				if(result.status=='true'||result.status==true){
						alert('注册成功');
						window.location.href="${ctx}/ptadmin/index.html";
				}
		      }
			});
	}
	function registerSavestudent(){
		var username = $("#student_username").val();
		var password = $("#student_password").val();
		var openid = $("#student_openid").val();
		if(username==''||password==''){
			alert('用户名和密码必须填写');
			return false;
		}
		
		$.ajax({
		      type: "POST",
		      async:false,  // 设置同步方式
		      cache:false,
		      url: "${ctx}/BDLogin/BDSave.html",
				data:$("#registerFormstudent").serializeArray(),
				success:function(result){
				result = eval("("+result+")");
				if(result.status=='true'||result.status==true){
						alert('绑定成功');
						window.location.href="${ctx}/MyJsp.jsp";
				}else{
					alert('用户已经绑定，不能重复绑定');
				}
		      }
			});
	}
	function registerSaveteacher(){
		var username = $("#teacher_username").val();
		var password = $("#teacher_password").val();
		if(username==''||password==''){
			alert('用户名和密码必须填写');
			return false;
		}
		var xh = $("#teacher_xh").val();
		if(xh==''){
			alert('请填写工号');
			return false;
		}
		$.ajax({
		      type: "POST",
		      async:false,  // 设置同步方式
		      cache:false,
		      url: "${ctx}/teacherLogin/registerSave.html",
				data:$("#registerFormteacher").serializeArray(),
				success:function(result){
				result = eval("("+result+")");
				if(result.status=='true'||result.status==true){
						alert('绑定成功');
						window.location.href="${ctx}/teacher/index.html";
				}else{
					alert('该学号不存在或该用户已经注册，不能重复注册');
				}
		      }
			});
	}
</script>
</html>
