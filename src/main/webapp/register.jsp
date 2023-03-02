<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>用户登录 -Parking</title>
	<base href="http://localhost:8080/Parking-toll-system/">
	<link href="css/register.css" rel="stylesheet">
</head>
<body>
	<div class="all">
		<div class="login">
			<div class="head">
<%--				<div class="err_msg">${register_msg}</div>--%>
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
				<div class="err_msg">
					<p>${register_msg}</p>
				</div>
			</div>
			<div class="loginForm">
				<form action="/Parking-toll-system/user/add" id="form" method="post">
					<p class="p2">用户名:<input id="username" name="username" type="text"></p>
			        <p class="p2">账&nbsp&nbsp&nbsp号:<input id="id" name="id" type="text"></p>
			        <p class="p2">密&nbsp&nbsp&nbsp码:<input id="password" name="password" type="password"></p>
			        <p class="p2"><a href="login.jsp">老用户登录</a></p>

					<div id="subDiv">
			            <input type="submit" class="button" value="注册" >
						<!-- <button class="button" @click="register">注册</button> -->
			            <input type="reset" class="button" value="清空">
			            <!-- <a href="/Parking-toll-system/login.html"><button class="button">返回</button></a> -->
<!--			            <a href="http://localhost:8080/Parking-toll-system/login.html"><button class="button">返回</button></a>-->
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