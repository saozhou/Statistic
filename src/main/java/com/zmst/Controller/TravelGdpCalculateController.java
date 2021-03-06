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
import javax.annotation.*;


import com.alibaba.fastjson.JSON;
import com.zmst.Domain.SubGdp;
import com.zmst.Domain.SubTravelGdp;
import com.zmst.IDao.SubTravelGdpMapper;
import com.zmst.Service.TravelGdpCalculateService;
import com.zmst.Tools.HttpReturn;

/**
 * 
 * @author Zhou
 *旅游gdp计算控制类
 */
@Controller
@RequestMapping("/TravelGdpCalculate")
public class TravelGdpCalculateController {
	@Resource
	private TravelGdpCalculateService travelGdpCalculateService;
	
	
	@RequestMapping(value="/subTravelGdpCaculate",method=RequestMethod.POST)  
    @ResponseBody
    public void subTravelGdpCaculate(HttpServletRequest request,HttpServletResponse response){		 
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
	    List<SubTravelGdp>subTravelGdpList = new ArrayList<SubTravelGdp>(); 
	    subTravelGdpList=travelGdpCalculateService.findByYearPlace(year,place);
	    if(subTravelGdpList.size()==0){
			 
	    	subTravelGdpList = travelGdpCalculateService.getSubTravelGdp(year,place);  
			
	    }		    
		 try {
				request.setCharacterEncoding("utf-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  //这里不设置编码会有乱码
		      response.setContentType("text/html;charset=utf-8");
			  String json = JSON.toJSONString(subTravelGdpList);
			  HttpReturn.reponseBody(response, json);
	
	}
}
