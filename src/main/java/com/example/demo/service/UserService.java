package com.example.demo.service;

import com.example.demo.dao.modol.UserInfo;
import com.example.demo.dao.service.UserServiceDao;
import com.example.demo.util.StringsUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @ClassName: UserService
 * @Description: TODO
 * @Create by: A
 * @Date: 2021/7/7 23:02
 */
@Service
@Slf4j
public class UserService {

    @Autowired
    private UserServiceDao userServiceDao;

    public boolean addUser(String userName, int tel, String plate, long distance, String service) {
        try {
            UserInfo userInfo = new UserInfo();
            userInfo.setName(userName);
            userInfo.setTel(tel);
            userInfo.setPlate(plate);
            userInfo.setDistance(distance);
            userInfo.setService(service);
            userInfo.setCreateTime(LocalDateTime.now());
            userInfo.setUpdateTime(LocalDateTime.now());
            return userServiceDao.save(userInfo);
        } catch (Exception e) {
            log.error("addUser error ,info is :  ", e);
            throw e;
        }
    }

    public boolean updateUser(String userName, int tel, String plate, long distance, String service) {
        try {
            UserInfo userInfo = userServiceDao.getByUser(userName);
            if (Objects.isNull(userInfo)) {
                // 说明没有注册过
                return addUser(userName, tel, plate, distance, service);
            } else {
                // 执行更新逻辑
                if (tel > 0) {
                    // TODO 正则检验
                    userInfo.setTel(tel);
                }
                if (distance > 0) {
                    userInfo.setDistance(distance);
                }
                if (StringsUtil.isNotNullOrEmpty(plate)) {
                    userInfo.setPlate(plate);
                }
                if (StringsUtil.isNotNullOrEmpty(service)) {
                    userInfo.setService(service);
                }
                userInfo.setUpdateTime(LocalDateTime.now());
                return userServiceDao.updateByUser(userInfo);
            }
        } catch (Exception e) {
            log.error("updateUser  error ,info is :  ", e);
            throw e;
        }
    }

    /**
     * 条件查询指定数据
     *
     * @param userName 用户名
     * @param tel      电话号
     * @return
     */
    public List<UserInfo> searchList(String userName, int tel) {
        try {
            return userServiceDao.getUserList(userName, tel);
        } catch (Exception e) {
            log.error("searchList error info is", e);
            throw e;
        }
    }

    /**
     * 根据用户删除用户信息
     *
     * @param userName 用户名
     * @return
     */
    public boolean deleteByUser(String userName) {
        try {
            return userServiceDao.deleteByUser(userName);
        } catch (Exception e) {
            log.error("deleteByUser error info is", e);
            throw e;
        }
    }

}
