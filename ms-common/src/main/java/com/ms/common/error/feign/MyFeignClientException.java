package com.ms.common.error.feign;

import com.ms.common.error.ErrorObj;

public class MyFeignClientException extends Exception {

    private static final long serialVersionUID = -5353554070181987084L;
    private ErrorObj          errorObj;

    public MyFeignClientException() {
    }


    public MyFeignClientException(final ErrorObj errorObjParam) {
        super();
        this.errorObj = errorObjParam;
    }


    public ErrorObj getErrorObj() {
        return this.errorObj;
    }


    public void setErrorObj(final ErrorObj errorObjParam) {
        this.errorObj = errorObjParam;
    }


}
