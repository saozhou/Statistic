package com.zmst.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zmst.Domain.TravelClassGdpContribute;
import com.zmst.Domain.TravelClassTaxContribute;
import com.zmst.Domain.TravelIndustryGdpContribute;
import com.zmst.Domain.TravelIndustryTaxContribute;
import com.zmst.Domain.TravelLargeGdpContribute;
import com.zmst.Domain.TravelLargeTaxContribute;

/**
 * 
 * @author Zhou
 * 综合查询service
 */ 
public interface IntegratedQueryService {

	List<TravelLargeGdpContribute> getTravelLargeGdpContribute(String year, String place);

	List<TravelLargeGdpContribute> getLargeGdpContribute(List<TravelLargeGdpContribute> travelLargeGdpContributeList,
			String year, String place);

	List<TravelClassGdpContribute> getClassGdpContribute(String year, String place,
			List<TravelClassGdpContribute> classGdpContributeList);

	List<TravelClassGdpContribute> getClassGdpContributeList(List<TravelClassGdpContribute> classGdpContributeList,
			String year, String place);

	List<TravelIndustryGdpContribute> getIndustryGdpContribute(String year, String place,
			List<TravelIndustryGdpContribute> industryGdpContributeList);

	List<TravelIndustryGdpContribute> getIndustryGdpContributeList(
			List<TravelIndustryGdpContribute> industryGdpContributeList, String year, String place);

	List<TravelLargeTaxContribute> getTravelLargeTaxContribute(String year, String place,
			List<TravelLargeTaxContribute> travelLargeTaxContributeList);

	List<TravelLargeTaxContribute> getLargeTaxContribute(List<TravelLargeTaxContribute> travelLargeTaxContributeList,
			String year, String place);

	List<TravelClassTaxContribute> getClassTaxContribute(String year, String place,
			List<TravelClassTaxContribute> classTaxContributeList);

	List<TravelClassTaxContribute> getClassTaxContributeList(List<TravelClassTaxContribute> classTaxContributeList,
			String year, String place);

	List<TravelIndustryTaxContribute> getIndustryTaxContribute(String year, String place,
			List<TravelIndustryTaxContribute> industryTaxContributeList);

	List<TravelIndustryTaxContribute> getIndustryTaxContributeList(
			List<TravelIndustryTaxContribute> industryTaxContributeList, String year, String place);

}
