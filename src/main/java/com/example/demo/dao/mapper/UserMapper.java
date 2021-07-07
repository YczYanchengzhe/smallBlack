package com.example.demo.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.dao.modol.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * @ClassName: UserMapper
 * @Description: TODO
 * @Create by: A
 * @Date: 2021/7/7 22:59
 */
@Mapper
@Component
public interface UserMapper extends BaseMapper<UserInfo> {
}