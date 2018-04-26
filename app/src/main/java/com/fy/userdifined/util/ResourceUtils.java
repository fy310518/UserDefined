package com.fy.userdifined.util;

import android.graphics.Color;

import java.util.Random;

/**
 * 通过 getResources() 获取资源
 * Created by fangs on 2017/9/13.
 */
public class ResourceUtils {

    private ResourceUtils() {
        /* cannot be instantiated */
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    /**
     * 生成随机颜色
     * @return
     */
    public static int getRandomColor(){
        Random random = new Random();
        int r = random.nextInt(256);
        int g = random.nextInt(256);
        int b = random.nextInt(256);

        return Color.rgb(r,g,b);
    }



}
