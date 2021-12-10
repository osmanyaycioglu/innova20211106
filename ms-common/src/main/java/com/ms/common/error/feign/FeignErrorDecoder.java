package com.ms.common.error.feign;

import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ms.common.error.ErrorObj;

import feign.Response;
import feign.codec.ErrorDecoder;

public class FeignErrorDecoder implements ErrorDecoder {

    private static final Logger        logger         = LoggerFactory.getLogger(FeignErrorDecoder.class);

    private final ErrorDecoder.Default defaultDecoder = new Default();

    @Override
    public Exception decode(final String methodKeyParam,
                            final Response responseParam) {
        try {
            InputStream asInputStreamLoc = responseParam.body()
                                                        .asInputStream();
            ObjectMapper mapperLoc = new ObjectMapper();
            ErrorObj readValueLoc = mapperLoc.readValue(asInputStreamLoc,
                                                        ErrorObj.class);
            //            if (readValueLoc.getErrorCode() > 1500) {
            //                throw new RetryableException(0,
            //                                             methodKeyParam,
            //                                             null,
            //                                             null,
            //                                             null);
            //            }
            return new MyFeignClientException(readValueLoc);
        } catch (Exception eLoc) {
            FeignErrorDecoder.logger.error("[FeignErrorDecoder][decode]-> *Error* : " + eLoc.getMessage(),
                                           eLoc);
        }
        return this.defaultDecoder.decode(methodKeyParam,
                                          responseParam);
    }

}
