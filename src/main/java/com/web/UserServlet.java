package com.web;

import com.alibaba.fastjson.JSON;
import com.pojo.User;
import com.service.UserService;
import com.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/user/*")
public class UserServlet extends BaseServlet {
    private UserService service = new UserServiceImpl();

    private static String stringToJsonString(String s) {
        if(s == null) {
            return null;
        }
        String[] ss = s.split("&");
        Map<String, String> map = new HashMap<>();
        for(String str : ss) {
            if(str.startsWith("=") || str.endsWith("=")) {
                continue;
            }
            map.put(str.split("=")[0],str.split("=")[1]);
        }
        return JSON.toJSONString(map);
    }

    /**
     * 根据id和password查询  验证登录
     * @param request
     * @param response
     * @throws IOException
     * @throws ServletException
     */
    public void selectByIdAndPassword(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        //接收数据
//        String params = request.getReader().readLine();
//        System.out.println(params);//id=11&password=1
//
////            String id = params.split("&")[0].split("=")[1];
////            String password = params.split("&")[1].split("=")[1];
////            User user = service.selectByIdAndPassword(id, password);
//        if(!params.startsWith("{")) {
//            params = stringToJsonString(params);
//        }
//        User u = JSON.parseObject(params, User.class);
//        //调用方法
//        User user = service.selectByIdAndPassword(u.getId(), u.getPassword());
//        System.out.println(user);
        //接收数据
        String id = request.getParameter("id");
        String password = request.getParameter("password");
        String remember = request.getParameter("remember");
        if(id == null || password == null) {
            request.setAttribute("login_msg","账号或密码不能为空");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
            return;
        }
        User user = service.selectByIdAndPassword(id, password);
        System.out.println(id + "," + password);
        System.out.println(user);
        //反馈
        if (user != null) {
            //记住账号
            if("1".equals(remember)){
                //1. 创建Cookie对象
                Cookie c_id = new Cookie("id",id);
                Cookie c_password = new Cookie("password",password);
                // 设置Cookie的存活时间
                c_id.setMaxAge( 60 * 60 * 24 * 7);
                c_password.setMaxAge( 60 * 60 * 24 * 7);
                //2. 发送Cookie
                response.addCookie(c_id);
                response.addCookie(c_password);
            }
//            response.getWriter().write("success");
            System.out.println("success");

            HttpSession session = request.getSession();
            session.setAttribute("user", user);

            String contextPath = request.getContextPath();
            response.sendRedirect(contextPath + "/home.jsp");

        } else {
//            response.getWriter().write("failure");
            System.out.println("failure");
            request.setAttribute("login_msg","账号或密码错误");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
    }

    /**
     * 添加用户  注册账号
     * @param request
     * @param response
     * @throws IOException
     * @throws ServletException
     */
    public void add(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //接收数据
        String username = request.getParameter("username");
        String id = request.getParameter("id");
        String password = request.getParameter("password");
        //判断格式
        if(username == null || id == null || password == null) {
            request.setAttribute("login_msg","用户名、账号或密码不能为空");
            request.getRequestDispatcher("/register.jsp").forward(request,response);
            return;
        }
        User user = new User(username, id, password);
        //判断id是否存在
        if(service.selectById(user.getId()) != null) {
            request.setAttribute("register_msg","账号已存在");
            request.getRequestDispatcher("/register.jsp").forward(request,response);
        }else {
            service.add(user);
            request.setAttribute("register_msg","注册成功，请登录");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
    }

    /**
     * 修改用户信息
     * @param request
     * @param response
     * @throws IOException
     * @throws ServletException
     */
    public void update(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

    }
}
