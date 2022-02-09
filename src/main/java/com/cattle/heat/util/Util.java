package com.cattle.heat.util;

import com.cattle.heat.model.HeatBody;

import java.util.Map;

public class Util {

    private static final String COW_TAG = "Body";
    private static final String DEVICE_TAG = "From";

    public static HeatBody mapHeatBody(Map<String, String> data){
        HeatBody heat = new HeatBody();
        String cow = data.get(COW_TAG);
        String device = data.get(DEVICE_TAG);
        heat.setDevice(device);
        heat.setCowId(cow);
        return heat;
    }
}
