package com.zmst.Controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.zmst.Domain.TravelLargeGdpContribute;
import com.zmst.Service.IntegratedQueryService;
import com.zmst.Tools.HttpReturn;
 

/**
 * 
 * @author Zhou
 *综合查询
 */
@Controller
@RequestMapping("/IntegratedQuery")
public class IntegratedQueryController {

	private IntegratedQueryService integratedQueryService;
	/**
	 * gdp综合查询
	 */
	
	@RequestMapping(value="/travelLargeComSearch",method=RequestMethod.POST)
	@ResponseBody
	public void travelGdpget(HttpServletRequest request,HttpServletResponse response){

		
		
		String path = "D:\\Users";  
        HttpSession session = request.getSession();		 
		String year = (String) session.getAttribute("year");
		String city =null;
		city=(String) session.getAttribute("city");
		String county=null; 
		county= (String)session.getAttribute("county");
		String place = null;
		if(county!=null){
			 place=county;
		}else{
			place=city;
		}
		
         List<TravelLargeGdpContribute> travelLargeGdpContributeList = new ArrayList<TravelLargeGdpContribute>();
         
         travelLargeGdpContributeList = integratedQueryService.getTravelLargeGdpContribute(year,place);
		if(travelLargeGdpContributeList.size()==0){
			travelLargeGdpContributeList = integratedQueryService.getLargeGdpContribute(travelLargeGdpContributeList,year, place);
			 
		 
			}
			
		
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  //这里不设置编码会有乱码
	      response.setContentType("text/html;charset=utf-8");
		  String json = JSON.toJSONString(travelLargeGdpContributeList);
		  HttpReturn.reponseBody(response, json);
		 
	}
	
}
