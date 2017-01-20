package com.dave.materialdesignsample.event;

import com.dave.materialdesignsample.model.RegistrationVo;

/**
 * Created by osingh on 20-Jan-17.
 */
public class RegistrationEvent {

    RegistrationVo registrationVo;

    public RegistrationEvent(RegistrationVo registrationVo) {
        this.registrationVo = registrationVo;
    }

    public RegistrationVo getRegistrationVo() {
        return registrationVo;
    }
}
