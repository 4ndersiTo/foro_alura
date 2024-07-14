package com.challenge.foro_alura.service;

import java.util.Map;

public interface AuthService {
    Map<String, String> login(Map<String, String> credenciales);

    String register(Map<String,String> loginRequestDto);
}
