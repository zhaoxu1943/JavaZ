package com.concentration.controller;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class ConfigControllerTest {



    @Test
    public void getUserInfo() {
        ConfigController configController = new ConfigController();
        configController.getUserInfo();

    }
}