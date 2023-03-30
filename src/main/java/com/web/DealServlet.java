package com.web;

import com.alibaba.fastjson.JSON;
import com.pojo.Deal;
import com.pojo.Vehicle;
import com.service.DealService;
import com.service.VehicleService;
import com.service.impl.DealServiceImpl;
import com.service.impl.VehicleServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/deal/*")
public class DealServlet extends BaseServlet{
    //创建service对象
    private VehicleService vService = new VehicleServiceImpl();
    private DealService service = new DealServiceImpl();

    public void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("--DealServlet--add");
        //读取数据
        String params = request.getReader().readLine();
        System.out.println("params:" + params);
        //转int
        Integer id = JSON.parseObject(params, Integer.class);
        //查询Vehicle对象
        Vehicle vehicle = vService.selectById(id);
        System.out.println("vehicle:" + vehicle);
        //调用service
        Deal deal = new Deal(vehicle);
        deal.calculateMoney();
        System.out.println("deal:" + deal);
        service.add(deal);
        //成功标记
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write("success");
    }

    public void selectAll(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("--DealServlet--selectAll");
        //调用service
        List<Deal> deals = service.selectAll();
        //转JSON
        String jsonString = JSON.toJSONString(deals);
        //写JSON
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }
}
