package com.example.demo.result;

import lombok.extern.slf4j.Slf4j;


/**
 * 统一处理 中文处理 urlencoder
 */
@Slf4j
public class ApiActionResult {

    private ApiStatus status;

    private Object result;

    private ApiActionResult(ApiStatus status, Object result) {
        this.status = status;
        this.result = result;
    }

    public static ApiActionResult newSuccess(Object result) {
        return new ApiActionResult(ApiStatus.SUCCESS, result);
    }

    public static ApiActionResult newSuccess(ApiStatus apiStatus) {
        return new ApiActionResult(apiStatus, null);
    }


    public static ApiActionResult newSuccess(Object result,ApiStatus apiStatus) {
        return new ApiActionResult(apiStatus, result);
    }
    /**
     * do not use this unless no error defined in this class
     *
     * @param apiStatus
     * @return
     */
    public static ApiActionResult newError(ApiStatus apiStatus) {
        return new ApiActionResult(apiStatus, null);
    }


    public static ApiActionResult newError(String error) {
        return newError(new ApiStatus(1, error));
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ApiActionResult{");
        sb.append("status=").append(status);
        sb.append(", result=").append(result);
        sb.append('}');
        return sb.toString();
    }

    public ApiStatus getStatus() {
        return status;
    }

    public void setStatus(ApiStatus status) {
        this.status = status;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    /**
     * inner class
     */
    public static class ApiStatus {

        public static ApiStatus SUCCESS = new ApiStatus(0, "success");

        private int code;

        private String desc;

        private String tipFileds;

        public String getTipFileds() {
            return tipFileds;
        }

        public void setTipFileds(String tipFileds) {
            this.tipFileds = tipFileds;
        }

        /**
         * @param code 0表示成功，其他表示失败
         * @param desc
         */
        public ApiStatus(int code, String desc) {
            this(code, desc, "");
        }

        /**
         * @param code 0表示成功，其他表示失败
         * @param desc
         */
        public ApiStatus(int code, String desc, String tipFileds) {
            this.code = code;
            this.desc = desc;
            this.tipFileds = tipFileds;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        @Override
        public String toString() {
            final StringBuffer sb = new StringBuffer("ApiStatus{");
            sb.append("code=").append(code);
            sb.append(", desc='").append(desc).append('\'');
            sb.append('}');
            return sb.toString();
        }
    }
}
