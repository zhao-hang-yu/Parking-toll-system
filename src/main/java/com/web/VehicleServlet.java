package com.web;

import com.alibaba.fastjson.JSON;
import com.pojo.PageBean;
import com.pojo.Vehicle;
import com.service.VehicleService;
import com.service.impl.VehicleServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/vehicle/*")
public class VehicleServlet extends BaseServlet{
    private VehicleService service = new VehicleServiceImpl();

    public void selectAll(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //调用service
        List<Vehicle> vehicles = service.selectAll();
        System.out.println(vehicles);
        //转为JSON
        String jsonString = JSON.toJSONString(vehicles);
        //写JSON
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

    public void selectByPageAndCondition(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //接收 当前页码 和 每页展示条数    url?currentPage=1&pageSize=5
        String _currentPage = request.getParameter("currentPage");
        String _pageSize = request.getParameter("pageSize");
        //转为int
        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);
        //接收Vehicle对象
        String params = request.getReader().readLine();
        //转为Vehicle
        Vehicle vehicle = JSON.parseObject(params, Vehicle.class);
        //查询
        PageBean<Vehicle> pageBean = service.selectByPageAndCondition(currentPage, pageSize, vehicle);
        System.out.println(pageBean.toString());
        String jsonString = JSON.toJSONString(pageBean);
        System.out.println(jsonString);
        //写数据
        response.setContentType("test/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

    public void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //接收数据
        String params = request.getReader().readLine();
        //转Vehicle
        Vehicle vehicle = JSON.parseObject(params, Vehicle.class);
        if(vehicle.getStopNumber() == null) {
            vehicle.setStopNumber(0);
        }
        System.out.println("vehicle " + vehicle);
        service.add(vehicle);
        //成功标记
        response.getWriter().write("success");
    }

    public void exitByIds(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //读取数据
        String params = request.getReader().readLine();
        //转int[]
        int[] ids = JSON.parseObject(params, int[].class);
        //调用
        service.exitByIds(ids);
        //成功标记
        response.getWriter().write("success");
    }

    public void enterByIds(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //读取数据
        String params = request.getReader().readLine();
        //转int[]
        int[] ids = JSON.parseObject(params, int[].class);
        //调用
        service.enterByIds(ids);
        //成功标记
        response.getWriter().write("success");
    }
}
