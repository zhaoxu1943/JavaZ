package com.concentration.service.logs;

import com.concentration.entity.Logs;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author zhaoxu
 * @className LogServiceImpl
 * @projectName JavaConcentration

 * @date 3/24/2020 10:43 PM
 */
public class LogServiceImpl implements LogService {

    @Autowired
    SqlSessionTemplate sqlSessionTemplate;

    @Override
    public List<Logs> getLogs() {
        return null;
    }
}
