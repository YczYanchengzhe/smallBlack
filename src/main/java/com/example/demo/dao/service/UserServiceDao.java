package com.example.demo.dao.service;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.dao.mapper.UserMapper;
import com.example.demo.dao.modol.UserInfo;
import com.example.demo.util.StringsUtil;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * @ClassName: UserService
 * @Description: TODO
 * @Create by: A
 * @Date: 2021/7/7 23:00
 */
@Service
public class UserServiceDao<T> extends ServiceImpl<UserMapper, UserInfo> {


    /**
     * 根据同户名称更新用户
     *
     * @param user 用户信息
     * @return
     */
    public boolean updateByUser(UserInfo user) {
        return update(user, Wrappers.<UserInfo>query()
                .eq(Objects.nonNull(user.getName()), UserInfo.FIELD_NAME, user.getName()));
    }

    /**
     * 根据用户名获取用户
     *
     * @param userName
     * @return
     */
    public UserInfo getByUser(String userName) {
        return getOne(Wrappers.<UserInfo>query()
                .eq(Objects.nonNull(userName), UserInfo.FIELD_NAME, userName));
    }

    /**
     * 根据用户名和电话号查询
     *
     * @param userName
     * @param tel
     * @return
     */
    public List<UserInfo> getUserList(String userName, int tel) {
        return list(Wrappers.<UserInfo>query()
                .eq(StringsUtil.isNotNullOrEmpty(userName), UserInfo.FIELD_NAME, userName)
                .eq(tel > 0, UserInfo.FIELD_TEL, tel));
    }

    /**
     * 根据用户删除用户信息
     *
     * @param userName
     * @return
     */
    public boolean deleteByUser(String userName) {
       return  remove(Wrappers.<UserInfo>query()
                .eq(Objects.nonNull(userName), UserInfo.FIELD_NAME, userName));
    }
}
