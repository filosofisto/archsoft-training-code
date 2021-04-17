package com.archsoft.service.impl;

import com.archsoft.model.Log;

public class LogService {

    public void sendLog(Log log) {
        // do something more interesting
        log.getException().printStackTrace();
    }
}
