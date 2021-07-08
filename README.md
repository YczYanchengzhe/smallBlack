# smallBlack 

##  一. 接口文档

### 1. UserController 用户接口

- 访问地址 : http://8.131.89.161:8080/

#### 1.1 添加用户

| 接口描述                                  | 添加用户                                                     |
| ----------------------------------------- | ------------------------------------------------------------ |
| 请求地址                                  | /user/addUser                                                |
| 请求类型                                  | POST                                                         |
| 请求参数<br />参数名 : 含义 例子 是否必填 | userName : 用户名 xiaohei 必填<br />tel : 电话号 123 必填<br />plate : 车牌号 web 必填<br />distance : 里程数 123 必填<br />service : 服务名 qqq 必填 |
| 响应结果                                  |                                                              |

```json
{
    "status": {
        "code": 0,
        "desc": "success",
        "tipFileds": ""
    },
    "result": "添加成功"
}
```

#### 1.2  修改用户

| 接口描述                                  | 修改用户                                                     |
| ----------------------------------------- | ------------------------------------------------------------ |
| 请求地址                                  | /user/updateUser                                             |
| 请求类型                                  | POST                                                         |
| 请求参数<br />参数名 : 含义 例子 是否必填 | userName : 用户名 xiaohei 必填<br />tel : 电话号 123 非必填<br />plate : 车牌号 web 非必填<br />distance : 里程数 123 非必填<br />service : 服务名 qqq 非必填 |
| 响应结果                                  |                                                              |

```json
{
    "status": {
        "code": 0,
        "desc": "success",
        "tipFileds": ""
    },
    "result": "修改成功"
}
```

#### 1.3 查询用户

| 接口描述                                  | 查询用户                                                     |
| ----------------------------------------- | ------------------------------------------------------------ |
| 请求地址                                  | /user/search                                                 |
| 请求类型                                  | GET                                                          |
| 请求参数<br />参数名 : 含义 例子 是否必填 | userName : 用户名 xiaohei 非必填<br />tel : 电话号 123 非必填 |
| 响应结果                                  |                                                              |

```json
{
    "status": {
        "code": 0,
        "desc": "success",
        "tipFileds": ""
    },
    "result": "删除成功"
}
```

#### 1.3 删除用户

| 接口描述                                  | 删除用户                       |
| ----------------------------------------- | ------------------------------ |
| 请求地址                                  | /user/delete                   |
| 请求类型                                  | GET                            |
| 请求参数<br />参数名 : 含义 例子 是否必填 | userName : 用户名 xiaohei 必填 |
| 响应结果                                  |                                |

```json
{
    "status": {
        "code": 0,
        "desc": "success",
        "tipFileds": ""
    },
    "result": [
        {
            "id": 6,
            "name": "xiaohei",
            "tel": 123,
            "plate": "web",
            "distance": 123,
            "service": "qqq",
            "createTime": "2021-07-08T00:31:25",
            "updateTime": "2021-07-08T00:31:25"
        }
    ]
}
```
