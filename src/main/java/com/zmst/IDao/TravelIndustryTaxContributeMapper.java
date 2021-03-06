package com.zmst.IDao;

import java.util.List;

import com.zmst.Domain.TravelIndustryTaxContribute;

public interface TravelIndustryTaxContributeMapper {
    int deleteByPrimaryKey(Integer titid);

    int insert(TravelIndustryTaxContribute record);

    int insertSelective(TravelIndustryTaxContribute record);

    TravelIndustryTaxContribute selectByPrimaryKey(Integer titid);

    int updateByPrimaryKeySelective(TravelIndustryTaxContribute record);

    int updateByPrimaryKey(TravelIndustryTaxContribute record);

	void deleteByYearPlace(String year, String place);

	List<TravelIndustryTaxContribute> findByYearPlace(String year, String place);

	void save(TravelIndustryTaxContribute inContribute);
}