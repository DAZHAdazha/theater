package com.util;

import java.awt.image.BufferedImage;
import java.io.Console;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import com.alibaba.fastjson.JSONObject;
import com.controller.MovieController;
import com.controller.ScheduleController;
import com.entity.Hall;
import com.entity.Order;
import com.entity.Schedule;
import com.github.pagehelper.PageInfo;
import com.mapper.*;
import com.service.IOrderService;
import com.service.IUserService;
import com.service.imp.OrderServiceImp;
import com.service.imp.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.testng.annotations.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.sql.DataSource;

public class test {

	private OrderMapper orderMapper;
	private UserMapper userMapper;
	private ScheduleMapper scheduleMapper;
	private HallMapper hallMapper;
	private CinemaMapper cinemaMapper;
	private MovieMapper movieMapper;

	public static void main(String[] args) {
//		Date date = new Date();
//		java.sql.Date zdate = new java.sql.Date(date.getYear(), date.getMonth(), date.getDay());
//		System.out.println(date);
//		System.out.println(zdate);
//		for(int i = 0;i<20;i++) {
//		float random = 5 + (new Random().nextFloat() * 4);
//		DecimalFormat fnum = new DecimalFormat("##0.0");  
//		String score = fnum.format(random);
//		//String rs = String.valueOf(random);
//		System.out.println("score:" + score);
//		}
		
		
//		JSONObject obj = new JSONObject();
//		JSONObject hallobj = new JSONObject();
//		//ArrayList<String> cinemalist= new ArrayList<String>();
//		for(int i = 0; i < 2;i++) {
//			ArrayList<String> cinemalist= new ArrayList<String>();
//			for(int j=0;j<2;j++) {
//				cinemalist.add(String.valueOf(j+1)+"号厅");
//			}
//			hallobj.put("影院"+String.valueOf(i),cinemalist);
//		}
//		obj.put("cinema", hallobj);
//		System.out.println(obj);
//		JSONObject obj2 = obj.getJSONObject("cinema");
//		//解析 1级
//		System.out.println(obj2);
//		//解析 2级
//		ArrayList<String> halllist= new ArrayList<String>();
//		halllist = (ArrayList<String>)obj2.get("影院0");
//		System.out.println(halllist.get(0));
		
//		ArrayList<Integer> arr = new ArrayList<Integer>();
//		for(int i = 0;i < 5;i++) {
//			arr.add(i);
//		}
//		System.out.println(arr.get(4));
		
		
//		Date date = new Date();
//		SimpleDateFormat dateFormat = new SimpleDateFormat("YYYYMMdd");
//		String str = "";
//		str += dateFormat.format(date);
//		System.out.println(str);
//		String [] str = {"3排4座","10排1座","5排12座","11排12座"};
//		ArrayList<String> arr = new ArrayList<String>();
//		for(int i = 0;i < str.length;i++) {
//			//System.out.println(str[i].length());
//			String index = "";
//			switch(str[i].length()) {
//				case 4: 
//					index = "0" + str[i].replaceAll("排", "0");
//					index = index.replaceAll("座", "");
//					break;
//				case 5:
//					if(str[i].charAt(2) >= 48 && str[i].charAt(2) <= 57) {
//						index = "0" + str[i].replaceAll("排", "");
//						index = index.replaceAll("座", "");
//					}else {
//						index = str[i].replaceAll("排", "0");
//						index = index.replaceAll("座", "");
//					}
//					break;
//				case 6:
//					index = str[i].replaceAll("排", ""); 
//					index = index.replaceAll("座", "");
//					break;
//			}
//			arr.add(index);
//		}
//		System.out.println(arr);
		
		//int price = 29;
		//float box = (float)price /10000;
		//System.out.println((float)price /10000);;
//		DecimalFormat fnum = new DecimalFormat("##0.0000");  
//		String score = fnum.format(random);
		
		ArrayList<Integer> arr = new ArrayList<>();
		ArrayList<Integer> indexz = new ArrayList<>();
		int num[] = {1,2,3,0,5,0,6};
		for(int i = 0;i<num.length;i++) {
			arr.add(num[i]);
		}
		for(int z = 0;z<arr.size();z++) {
			if(arr.get(z) == 0) {
				indexz.add(z);
			}
		}
		System.out.println(arr);
		System.out.println(indexz);
//		arr.remove(3);
		for(int y =0;y<indexz.size();y++) {
			int test = 0;
			int index = (indexz.get(y))-test;
			System.out.println(index);
			arr.remove(index);
			test = test + 2;
		}
		System.out.println(arr);
	}

	@Test
	public void test10() throws SQLException {
		ApplicationContext app = new ClassPathXmlApplicationContext("spring.xml");
		DataSource dataSource= app.getBean(DataSource.class);
		System.out.println(dataSource.getConnection());
	}

	@Test
	public void testOrder(){
		ApplicationContext app = new ClassPathXmlApplicationContext("spring.xml");
		IOrderService orderService = app.getBean(IOrderService.class);
		PageInfo<Order> info = orderService.findOrdersByUserName(1, 10, "admin");
		List<Order> arrayList = info.getList();
		for (Order order:arrayList){
			System.out.println(order.getOrder_position());
		}
	}

	@Test
	public void testImage(){
		ApplicationContext app = new ClassPathXmlApplicationContext("spring.xml");
		IUserService userService = app.getBean(UserServiceImp.class);

	}

	@Test
	public void testQR() throws IOException {
		BufferedImage image= QrcodeGenerator.encode("123",350,350);
		File file =new File("QRImage");
		ImageIO.write(image, "png",file);
	}

	@Test
	public void testQRTick() throws IOException{
		ApplicationContext app = new ClassPathXmlApplicationContext("spring.xml");
		IOrderService orderService = app.getBean(IOrderService.class);
		PageInfo<Order> info = orderService.findOrdersByUserName(1, 10, "admin");
		List<Order> arrayList = info.getList();
		for (Order order:arrayList){
			System.out.println(order.getQRImage());
		}
	}
}
