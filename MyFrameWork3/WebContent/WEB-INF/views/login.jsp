<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Login</title>
<%@include file="header.jsp"%>
</head>
<body>
	<div class="container">
		<div class="page-header">请登录系统</div>
		<div class="panel panel-default">
			<div class="panel-body">
				<div class="content">
					<form>
						<div class="form-group">
							<label for="name">用户名</label>
							<input type="text" class="form-control" id="name" placeholder="请输入用户名"/>
						</div>
						<div class="form-group">
							<label for="password">密码</label>
							<input type="password" class="form-control" id="password" placeholder="请输入密码"/>
						</div>
						<button type="button" class="btn btn-default" id="btnLogin">登录</button>
					</form>					
				</div>
			</div>
		</div>
	</div>
</body>
<%@include file="footer.jsp"%>
<script src="./js/page/login.js"></script>
</html>