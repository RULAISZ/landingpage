package com.jinguizi.mapper;

import com.jinguizi.pojo.Behavior;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Title: landingpage
 * @description:
 * @Author: liuzhiwen
 * @Create: 2021-01-29 15:00
 **/
@Mapper
public interface BehaviorMapper {
    void insertBehavior(Behavior behavior);

    void updateBehavior(Behavior behavior);

    Behavior findBehaviorByFuid(String fuid);

    Integer findBehaviorCount(Behavior behavior);

    List<Behavior> findAllBehavior();

}
