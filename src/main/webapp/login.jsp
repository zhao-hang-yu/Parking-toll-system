<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>用户登录 -Parking</title>
	<base href="http://localhost:8080/Parking-toll-system/">
	<link href="css/login.css" rel="stylesheet">
</head>
<body>
	<div class="all">
		<div class="login">
			<div class="head">
<%--				<div id="errorMsg">${login_msg} ${register_msg}</div>--%>
			</div>
			<div class="loginHead">
				<div class="loginHead-img">
					<img src="imgs/parking.png" height="50px">
				</div>
				<div class="loginHead-span">
					<span class="titleSpan">停车收费系统</span>
				</div>
				<div class="loginHead-p">
					<p class="p1">Parking toll system</p>
				</div>
				<div id="errorMsg">
					<p>${login_msg} ${register_msg}</p>
				</div>
			</div>
			<div class="loginForm">
				<form action="/Parking-toll-system/user/selectByIdAndPassword" id="form" method="post">
					<p class="p2">账号:<input id="id" name="id" type="text" value="${cookie.id.value}"></p>
			        <p class="p2">密码:<input id="password" name="password" type="password" value="${cookie.password.value}"></p>
					<p class="p2">记住账号<input id="remember" name="remember" value="1" type="checkbox"></p>
					<p class="p2"><a href="register.jsp">新用户注册</a></p>
			        <div id="subDiv">
			            <input type="submit" class="button" value="登录">
<!--						<button class="button" @click="login">登录</button>-->
			             <input type="reset" class="button" value="清空">
			        </div>
    			</form>
			</div>
		</div>

	</div>
</body>

<script src="js/axios-0.18.0.js"></script>
<script src="js/vue.js"></script>
<script src="element-ui/lib/index.js"></script>
<link rel="stylesheet" href="element-ui/lib/theme-chalk/index.css">

<%--<script>--%>
<%--	import alert from "./element-ui/packages/alert";--%>

<%--	new Vue({--%>
<%--		el:".loginForm",--%>
<%--		methods:{--%>
<%--			login(){--%>
<%--				alert(this.user);--%>
<%--				axios({--%>
<%--					method:"post",--%>
<%--					url:"http://localhost:8080/Parking-toll-system/user/selectByIdAndPassword",--%>
<%--					// data: this.user--%>
<%--					data: this.user--%>
<%--				}).then(resp => {--%>
<%--					alert(this.user);--%>
<%--					this.$message({--%>
<%--						message: 'sb',--%>
<%--						type: 'success'--%>
<%--					});--%>
<%--					console.log("555")--%>
<%--					if(resp.data == "success") {--%>
<%--						// this.homepage;--%>
<%--						console.log("success")--%>
<%--						//消息提示--%>
<%--						this.$message({--%>
<%--							message: '登录成功',--%>
<%--							type: 'success'--%>
<%--						});--%>
<%--					} else {--%>
<%--						console.log("error")--%>
<%--						// this.loginPage;--%>
<%--						//消息提示--%>
<%--						this.$message({--%>
<%--							message: '登录失败',--%>
<%--							type: 'error'--%>
<%--						});--%>
<%--					}--%>
<%--				})--%>
<%--			},--%>
<%--			register(){--%>
<%--				axios({--%>
<%--					method:"post",--%>
<%--					url:"http://localhost:8080/Parking-toll-system/register.html"--%>
<%--				})--%>
<%--			},--%>
<%--			homepage(){--%>
<%--				axios({--%>
<%--					method:"post",--%>
<%--					url:"http://localhost:8080/Parking-toll-system"--%>
<%--				})--%>
<%--			},--%>
<%--			loginPage(){--%>
<%--				axios({--%>
<%--					url:"http://localhost:8080/Parking-toll-system/login"--%>
<%--				})--%>
<%--			}--%>
<%--		},--%>
<%--		data(){--%>
<%--			return{--%>
<%--				remember: 0,--%>
<%--				user: {--%>
<%--					username:"",--%>
<%--					id:"",--%>
<%--					password:""--%>
<%--				}--%>
<%--			}--%>
<%--		}--%>
<%--	})--%>
<%--</script>--%>
</html>