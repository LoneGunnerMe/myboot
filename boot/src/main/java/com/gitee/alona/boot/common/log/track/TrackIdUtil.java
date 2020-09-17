package com.gitee.alona.boot.common.log.track;


import com.alibaba.ttl.TransmittableThreadLocal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

/**
 * @author 孤胆枪手
 * @version 1.0
 */
public final class TrackIdUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(TrackIdUtil.class);

    public static final String TRACK_ID_NAME = "trackId";

    @Deprecated
    private static final ThreadLocal<String> TRACK_ID_THREAD_LOCAL = new TransmittableThreadLocal<>();

    @Deprecated
    public static String getTrackId() {
        return Optional.ofNullable(TRACK_ID_THREAD_LOCAL.get())
                .orElseGet(() -> {
                    String trackId = generate();
                    TRACK_ID_THREAD_LOCAL.set(trackId);
                    return trackId;
                });
    }

    @Deprecated
    public static void removeTrackId() {
        TRACK_ID_THREAD_LOCAL.remove();
    }

    protected static String generate() {
        return cn.hutool.core.util.IdUtil.createSnowflake(0L, 0L).nextIdStr();
//        return java.util.UUID.randomUUID().toString().replaceAll("-", "");
    }

    private TrackIdUtil() {
    }
}
