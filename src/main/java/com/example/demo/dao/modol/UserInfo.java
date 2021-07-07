package com.example.demo.dao.modol;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @ClassName: UserInfo
 * @Description: TODO
 * @Create by: A
 * @Date: 2021/7/7 22:57
 */
@TableName(value = "t_user")
@Data
@ToString
public class UserInfo {

    public static final String FIELD_ID = "id";
    public static final String FIELD_NAME = "name";
    public static final String FIELD_TEL = "tel";
    public static final String FIELD_PLATE = "plate";
    public static final String FIELD_DISTANCE = "distance";
    public static final String FIELD_SERVICE = "service";
    public static final String FIELD_CREATE_TIME = "createTime";
    public static final String FIELD_UPDATE_TIME = "updateTime";


    /**
     * 主键Id 自增
     */
    @TableField(FIELD_ID)
    private long id;
    /**
     * 用户名
     */
    @TableField(FIELD_NAME)
    private String name;
    /**
     * 电话号
     */
    @TableField(FIELD_TEL)
    private int tel;
    /**
     * 车牌号
     */
    @TableField(FIELD_PLATE)
    private String plate;
    /**
     * 行驶里程数
     */
    @TableField(FIELD_DISTANCE)
    private long distance;
    /**
     * 服务项目
     */
    @TableField(FIELD_SERVICE)
    private String service;
    /**
     * 创建时间
     */
    @TableField(FIELD_CREATE_TIME)
    private LocalDateTime createTime;
    /**
     * 更新时间
     */
    @TableField(FIELD_UPDATE_TIME)
    private LocalDateTime updateTime;
}
