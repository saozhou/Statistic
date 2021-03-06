package com.zmst.IDao;

import java.util.List;

import com.zmst.Domain.ClassGdp;

public interface ClassGdpMapper {
    int deleteByPrimaryKey(Integer cgid);

    int insert(ClassGdp record);

    int insertSelective(ClassGdp record);

    ClassGdp selectByPrimaryKey(Integer cgid);

    int updateByPrimaryKeySelective(ClassGdp record);

    int updateByPrimaryKey(ClassGdp record);

	void deleteByYearPlace(String year, String place);

	void save(ClassGdp cla);

	List<ClassGdp> findByYearPlace(String year, String place);
}