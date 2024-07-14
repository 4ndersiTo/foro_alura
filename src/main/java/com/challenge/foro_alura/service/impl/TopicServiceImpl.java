package com.challenge.foro_alura.service.impl;

import com.challenge.foro_alura.entity.TopicoEntity;
import com.challenge.foro_alura.repository.TopicRepository;
import com.challenge.foro_alura.service.CursoService;
import com.challenge.foro_alura.service.TopicService;
import com.challenge.foro_alura.service.UsuarioService;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class TopicServiceImpl implements TopicService {

    @Autowired
    TopicRepository topicRepository;

    @Autowired
    CursoService cursoService;

    @Autowired
    UsuarioService usuarioService;

    @Override
    public String registrarTopic(Map<String, String> nuevoTopic) {

        TopicoEntity newTopic = new TopicoEntity();
        newTopic.setTituloTopico(nuevoTopic.get("titulo"));
        newTopic.setMensajeTopico(nuevoTopic.get("mensaje"));
        newTopic.setEstadoTopico(nuevoTopic.get("estado"));
        newTopic.setCursoTopico(this.cursoService.cursoPorId(nuevoTopic.get("id_curso")));
        newTopic.setAutorTopico(this.usuarioService.usuarioPorId(nuevoTopic.get("id_usuario")));

        this.topicRepository.save(newTopic);
        return "Se registró el topico con éxito";
    }

    @Override
    public List<Map<String, String>> listaTopic() {
        return this.topicRepository.findAll().stream().map(topic ->
                Map.of(
                        "id", topic.getIdTopico(),
                        "titulo", topic.getTituloTopico(),
                        "mensaje", topic.getMensajeTopico(),
                        "autor", topic.getAutorTopico().getNombreUsuario(),
                        "curso", topic.getCursoTopico().getNombreCurso(),
                        "estado", topic.getEstadoTopico()
                )
        ).toList();
    }

    @Override
    public Map<String, String> topicPorId(String idTopic) {

        TopicoEntity topic = this.topicRepository.findById(idTopic).orElseThrow(() -> new RuntimeException("No se encontró un topico con el ID: " + idTopic));

        return Map.of(
                "id", topic.getIdTopico(),
                "titulo", topic.getTituloTopico(),
                "mensaje", topic.getMensajeTopico(),
                "autor", topic.getAutorTopico().getNombreUsuario(),
                "curso", topic.getCursoTopico().getNombreCurso(),
                "estado", topic.getEstadoTopico()
        );
    }

    @Override
    public Map<String, String> actualizarTopic(Map<String, String> topic, String idTopic) {

        TopicoEntity findTopic = this.topicRepository.findById(idTopic).orElseThrow(() -> new RuntimeException("No se encontró un topic con ID: " + idTopic));

        findTopic.setTituloTopico(topic.get("titulo"));
        findTopic.setMensajeTopico(topic.get("mensaje"));
        findTopic.setEstadoTopico(topic.get("estado"));
        findTopic.setCursoTopico(this.cursoService.cursoPorId(topic.get("id_curso")));
        findTopic.setAutorTopico(this.usuarioService.usuarioPorId(topic.get("id_usuario")));

        TopicoEntity topicoActualizado = this.topicRepository.save(findTopic);

        return Map.of(
                "id", topicoActualizado.getIdTopico(),
                "titulo", topicoActualizado.getTituloTopico(),
                "mensaje", topicoActualizado.getMensajeTopico(),
                "autor", topicoActualizado.getAutorTopico().getNombreUsuario(),
                "curso", topicoActualizado.getCursoTopico().getNombreCurso(),
                "estado", topicoActualizado.getEstadoTopico()
        );
    }

    @Override
    public String eliminarTopic(String idTopic) {

        Optional<TopicoEntity> optionalTopico = this.topicRepository.findById(idTopic);

        // info -> v1
        if (optionalTopico.isPresent()) {
            this.topicRepository.delete(optionalTopico.get());
        } else {
            throw new RuntimeException("El topic con ID " + idTopic + "no existe.");
        }

        // info -> v2
//        optionalTopico.ifPresentOrElse(topicoEntity -> this.topicRepository.delete(topicoEntity), () -> System.out.println("Tópico no encontrado con id: "));
        return "Se eliminó con éxito el topic con Id: " + idTopic;

    }
}
