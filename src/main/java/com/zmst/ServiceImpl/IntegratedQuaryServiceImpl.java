package com.zmst.ServiceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import javax.annotation.*;

import com.zmst.Domain.LargeGdp;
import com.zmst.Domain.LargeTravelGdp;
import com.zmst.Domain.TravelLargeGdpContribute;
import com.zmst.IDao.LargeGdpMapper;
import com.zmst.IDao.LargeTravelGdpMapper;
import com.zmst.IDao.TravelLargeGdpContributeMapper;
import com.zmst.Service.IntegratedQueryService;
import com.zmst.Tools.ContributeUtil;


@Service("integratedQueryService")
public class IntegratedQuaryServiceImpl implements IntegratedQueryService {

	@Resource
	private TravelLargeGdpContributeMapper  largeGdpContributeDao;
	@Resource
	private LargeGdpMapper largeGdpDao;
	@Resource
	private LargeTravelGdpMapper largeTravelGdpDao;
	
	public List<TravelLargeGdpContribute> getTravelLargeGdpContribute(String year, String place) {
		// TODO Auto-generated method stub
		List<TravelLargeGdpContribute> largeGdpContributeList = largeGdpContributeDao.getByYearPlace(year,place);
		return largeGdpContributeList;
	}

/**
 * 大类旅游gdp综合贡献
 */
	public List<TravelLargeGdpContribute> getLargeGdpContribute(
			List<TravelLargeGdpContribute> travelLargeGdpContributeList, String year, String place) {
		// TODO Auto-generated method stub
		   List<LargeTravelGdp> largeTravelGdpList = new  ArrayList<LargeTravelGdp>();
		   List<LargeGdp>largeGdp = new ArrayList<LargeGdp>();
		   largeGdp = largeGdpDao.findByYearPlace(year, place);
		   largeTravelGdpList = largeTravelGdpDao.findByYearPlace(year,place);
		   ContributeUtil.getLargeGdpContribute(year,place,travelLargeGdpContributeList,largeTravelGdpList,largeGdp);
		
		return null;
	}
	
	

}
