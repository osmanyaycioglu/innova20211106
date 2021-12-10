package com.training.spring.order.integrations.restaurant;

import java.util.function.Predicate;

import com.ms.common.error.ErrorObj;
import com.ms.common.error.feign.MyFeignClientException;

public class MyRetryExceptionPredicate implements Predicate<Exception> {

    @Override
    public boolean test(final Exception tParam) {
        if (tParam instanceof MyFeignClientException) {
            MyFeignClientException exceptionLoc = (MyFeignClientException) tParam;
            ErrorObj errorObjLoc = exceptionLoc.getErrorObj();
            if (errorObjLoc.getErrorCode() == 19000) {
                return true;
            }
        }
        return false;
    }

}
