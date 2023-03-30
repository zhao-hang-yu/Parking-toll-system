<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>主页 -Parking</title>
    <base href="http://localhost:8080/Parking-toll-system/">
    <link href="./css/home.css" rel="stylesheet">
</head>
<body>
    <div class="all">
        <el-container>
            <el-header class="el-header">
                <h1>用户名：${user.username} &nbsp&nbsp&nbsp&nbsp 账号：${user.id}</h1>
            </el-header>

            <el-container>
                <el-aside width="200px" class="el-aside">
                    <el-row class="tac">
                        <el-col :span="24">
                            <el-menu
                                    default-active="1"
                                    class="el-menu-vertical-demo"
                                    background-color="#ffffff"
                                    @close="handleClose"
                                    :router="true">
                                <el-menu-item index="1" v-on:click="openUrl('html/home.html')">
                                    <i class="el-icon-s-home"></i>
                                    <span slot="title">首页</span>
                                </el-menu-item>
                                <el-submenu index="2">
                                    <template slot="title">
                                        <i class="el-icon-menu"></i>
                                        <span>车辆管理</span>
                                    </template>
                                    <el-menu-item index="2-1" v-on:click="openUrl('html/car1.html')">场内车辆</el-menu-item>
                                    <el-menu-item index="2-2" v-on:click="openUrl('html/car2.html')">所有车辆</el-menu-item>
                                </el-submenu>
                                <el-menu-item index="3" v-on:click="openUrl('html/money.html')">
                                    <i class="el-icon-s-order"></i>
                                    <span slot="title">收费详情</span>
                                </el-menu-item>
                                <el-menu-item index="4" v-on:click="openUrl('html/user.html')">
                                    <i class="el-icon-document"></i>
                                    <span slot="title">用户</span>
                                </el-menu-item>
                            </el-menu>
                        </el-col>
                    </el-row>
                </el-aside>

                <el-main class="el-main">
                    <iframe v-bind:src="iframeUrl" width="100%" height="850px" frameborder="0"></iframe>
                </el-main>

            </el-container>
        </el-container>

    </div>
</body>

<script src="js/axios-0.18.0.js"></script>
<script src="js/vue.js"></script>
<script src="element-ui/lib/index.js"></script>
<link rel="stylesheet" href="element-ui/lib/theme-chalk/index.css">

<script>
    new Vue({
        el: ".all",
        data: {
            iframeUrl: "./html/home.html",
            value: true
        },
        methods: {
            handleClose(key, keyPath) {
                console.log(key, keyPath);
            },
            openUrl: function (url) {
                this.iframeUrl=url;
            },
        }
    })
</script>


</html>