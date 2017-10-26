package com.zmst.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zmst.Domain.TravelLargeGdpContribute;

/**
 * 
 * @author Zhou
 * 综合查询service
 */ 
public interface IntegratedQueryService {

	List<TravelLargeGdpContribute> getTravelLargeGdpContribute(String year, String place);

	List<TravelLargeGdpContribute> getLargeGdpContribute(List<TravelLargeGdpContribute> travelLargeGdpContributeList,
			String year, String place);

}
