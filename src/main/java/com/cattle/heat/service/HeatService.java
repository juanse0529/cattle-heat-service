package com.cattle.heat.service;

import com.cattle.commons.model.Cade;
import com.cattle.commons.model.Cow;
import com.cattle.commons.model.Heat;
import com.cattle.commons.repository.AnimalRestRepository;
import com.cattle.commons.repository.CadeRestRepository;
import com.cattle.heat.model.HeatBody;
import com.cattle.heat.repository.HeatRepository;
import com.cattle.heat.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class HeatService {

    @Autowired
    private AnimalRestRepository animalRepository;
    @Autowired
    private CadeRestRepository cadeRepository;
    @Autowired
    private HeatRepository heatRepository;

    public ResponseEntity detectHeat(Map<String, String> data){
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());

        HeatBody heatBody = Util.mapHeatBody(data);
        Cow cow = animalRepository.findById(heatBody.getCowId());
        Cade cade = cadeRepository.findByPhoneNumber(heatBody.getDevice());
        Heat heat = new Heat();
        heat.setCow(cow);
        heat.setDetectedBy(cade);
        heat.setDetectedAt(LocalDateTime.now());
        Heat result = heatRepository.save(heat);
        return ResponseEntity.ok(result);
    }

    public ResponseEntity findAll(){
        List<Heat> heats = (List<Heat>) heatRepository.findAll();
        return ResponseEntity.ok(heats);
    }
}
