package com.challenge.foro_alura.service;

import java.util.List;
import java.util.Map;

public interface TopicService {
    String registrarTopic(Map<String, String> nuevoTopic);

    List<Map<String, String>> listaTopic();

    Map<String, String> topicPorId(String idTopic);

    Map<String, String> actualizarTopic(Map<String, String> topic, String idTopic);

    String eliminarTopic(String idTopic);
}
