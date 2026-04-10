package com.tg.nutricode.service;

import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class ConfirmationTokenService {

    public String generateConfirmationToken() {
        return UUID.randomUUID().toString();
    }
}