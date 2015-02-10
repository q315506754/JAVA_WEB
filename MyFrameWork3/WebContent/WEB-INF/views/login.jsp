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
	<header id="header"> <span id="extr-page-header-space">
		<span class="hidden-mobile hidden-xs">Need an account?</span>
	</span> </header>

	<div id="main" role="main">

		<!-- MAIN CONTENT -->
		<div id="content" class="container">

			<div class="row">
				<div class="col-xs-12 col-sm-12 col-md-5 col-lg-4">
					<div class="well no-padding">
						<form action="index.html" id="login-form"
							class="smart-form client-form">
							<header> 登录系统 </header>

							<fieldset>

								<section> <label class="label">账号</label> <label
									class="input"> <i class="icon-append fa fa-user"></i> <input
									type=text name="name" id="name"> <b
									class="tooltip tooltip-top-right"><i
										class="fa fa-user txt-color-teal"></i>请输入你的账号</b></label> </section>

								<section> <label class="label">密码</label> <label
									class="input"> <i class="icon-append fa fa-lock"></i> <input
									type="password" name="password" id="password"> <b
									class="tooltip tooltip-top-right"><i
										class="fa fa-lock txt-color-teal"></i> 请输入你的密码</b>
								</label> </section>
							</fieldset>
							<footer>
							<button type="button" id="btnLogin" class="btn btn-primary">登录</button>
							</footer>
						</form>
					</div>
				</div>
			</div>
		</div>

	</div>
</body>
<%@include file="footer.jsp"%>
<script src="./js/page/login.js"></script>
</html>