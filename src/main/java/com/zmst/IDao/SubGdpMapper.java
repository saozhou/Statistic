package com.zmst.IDao;

import com.zmst.Domain.SubGdp;

public interface SubGdpMapper {
    int deleteByPrimaryKey(Integer sgid);

    int insert(SubGdp record);

    int insertSelective(SubGdp record);

    SubGdp selectByPrimaryKey(Integer sgid);

    int updateByPrimaryKeySelective(SubGdp record);

    int updateByPrimaryKey(SubGdp record);

	void deleteByYearPlace(String year, String place);

	void save(SubGdp sub);
}