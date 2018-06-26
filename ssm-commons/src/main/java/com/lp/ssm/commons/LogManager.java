package com.lp.ssm.commons;

import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.MDC;

/**
 * 
 * @author liaopin
 *
 */
public class LogManager {
    private static final ThreadLocal<String> SID_THREAD_LOCAL = new ThreadLocal<String>();// 系统内部流水号
    private static final ThreadLocal<String> SID_THREAD_LOCAL_OUT = new ThreadLocal<String>();// 外部传入的流水号用于问题定位
    private static final ThreadLocal<Long> THREAD_LOCAL_TIMESTAMP = new ThreadLocal<Long>();// 接口调用时间戳

    private static final String MDC_SID = "SID";
    private static final String MDC_SID_OUT = "OUTSID";

    public static String getSid() {
        String sid = SID_THREAD_LOCAL.get();
        // 当sid为空时，则生成一个sid
        if (StringUtils.isEmpty(sid)) {
            sid = UUID.randomUUID().toString().replace("-", "").toUpperCase();
            setSid(sid);
        }
        return sid;
    }

    public static void setSid(String sid) {
        SID_THREAD_LOCAL.set(sid);
        MDC.put(MDC_SID, sid);
    }

    public static String getOutSid() {
        String outSid = SID_THREAD_LOCAL_OUT.get();
        // 当sid为空时，则生成一个sid
        if (StringUtils.isEmpty(outSid)) {
            outSid = UUID.randomUUID().toString().replace("-", "").toUpperCase();
            setOutSid(outSid);
        }
        return outSid;
    }

    public static void setOutSid(String sid) {
        SID_THREAD_LOCAL_OUT.set(sid);
        MDC.put(MDC_SID_OUT, sid);
    }

    public static Long getTimestamp() {
        return THREAD_LOCAL_TIMESTAMP.get();
    }

    public static void setTimestamp(Long timestamp) {
        THREAD_LOCAL_TIMESTAMP.set(timestamp);
    }

    public static void clear() {
        SID_THREAD_LOCAL.remove();
        SID_THREAD_LOCAL_OUT.remove();
        THREAD_LOCAL_TIMESTAMP.remove();
        MDC.remove(MDC_SID);
        MDC.remove(MDC_SID_OUT);
    }
}
