package com.challenge.foro_alura.controller;

import com.challenge.foro_alura.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/topic")
public class TopicController {

    @Autowired
    private TopicService topicService;

    @PostMapping("/registrar")
    public ResponseEntity<String> registrarTopic(@RequestBody Map<String, String> nuevoTopic) {
        return ResponseEntity.ok(this.topicService.registrarTopic(nuevoTopic));
    }

    @GetMapping("/lista")
    public ResponseEntity<List< Map<String, String>>> listaTopic() {
        return ResponseEntity.ok(this.topicService.listaTopic()) ;
    }

    @GetMapping("/porId/{id}")
    public ResponseEntity<Map<String, String>> topicPorId(@PathVariable("id") String idTopic) {
        return ResponseEntity.ok(this.topicService.topicPorId(idTopic)) ;
    }

    @PutMapping("actualizar/{id}")
    public ResponseEntity<Map<String, String>> actualizarTopic(@RequestBody Map<String, String> topic, @PathVariable("id") String idTopic) {
        return ResponseEntity.ok(this.topicService.actualizarTopic(topic, idTopic)) ;
    }

    @DeleteMapping("eliminar/{id}")
    public ResponseEntity<String> eliminarTopic(@PathVariable("id") String idTopic) {
        return ResponseEntity.ok(this.topicService.eliminarTopic(idTopic)) ;
    }
}
