package com.example.takeTicket.dao;

import com.example.takeTicket.domain.GetPointRecord;

public interface getPointRecordMapper {
    int insert(GetPointRecord record);

    int insertSelective(GetPointRecord record);
}