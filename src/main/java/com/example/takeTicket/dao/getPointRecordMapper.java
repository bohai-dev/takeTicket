package com.example.takeTicket.dao;

import com.example.takeTicket.domain.CustUser;
import com.example.takeTicket.domain.GetPointRecord;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface getPointRecordMapper {
    int insert(GetPointRecord record);

    int insertSelective(GetPointRecord record);


}