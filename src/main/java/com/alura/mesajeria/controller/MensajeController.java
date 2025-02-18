package com.alura.mesajeria.controller;

import com.alura.mesajeria.dominio.DatosRegistraMensaje;
import com.alura.mesajeria.dominio.DatosSalidaMensaje;
import com.alura.mesajeria.dominio.Mensaje;
import com.alura.mesajeria.dominio.MensajeRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/mensajes")
public class MensajeController {

    @Autowired
    MensajeRepository mensajeRepository;

    @Transactional
    @PostMapping
    public ResponseEntity<DatosSalidaMensaje> guardaMensaje(@RequestBody @Valid DatosRegistraMensaje datosRegistraMensaje,
                                                            UriComponentsBuilder uriComponentsBuilder){
        Mensaje mensaje = mensajeRepository.save(
                new Mensaje(datosRegistraMensaje.id(),
                    datosRegistraMensaje.mensaje(),
                    datosRegistraMensaje.fecha()));
        URI uri = uriComponentsBuilder.path("/mensajes/{id}").buildAndExpand(mensaje.getId()).toUri();

        return ResponseEntity.created(uri).body(new DatosSalidaMensaje(mensaje.getId(),
                mensaje.getMensaje(),
                mensaje.getFecha()));
    }

    @GetMapping
    public ResponseEntity<Page<DatosSalidaMensaje>> obtenerDatos(Pageable paginacion){
        return ResponseEntity.ok( mensajeRepository.findAll(paginacion)
                .map(m-> new DatosSalidaMensaje(
                        m.getId()
                        , m.getMensaje()
                        , m.getFecha())));
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<DatosSalidaMensaje> eliminarMensaje(@PathVariable Long id) {
        // Verifica si el mensaje existe antes de intentar eliminarlo
        Optional<Mensaje> mensajeOptional = mensajeRepository.findById(id);

        if (mensajeOptional.isPresent()) {
            Mensaje mensaje = mensajeOptional.get();


            // Elimina el mensaje
            mensajeRepository.deleteById(id);
            // Retorna la respuesta con el mensaje eliminado en el cuerpo
            DatosSalidaMensaje datosSalida = new DatosSalidaMensaje(mensaje.getId(), mensaje.getMensaje(), mensaje.getFecha());

            return ResponseEntity.ok(datosSalida);
        } else {
            // Si no se encuentra el mensaje, devuelve un 404 con un mensaje de error
            return ResponseEntity.status(404).body(null);
        }
    }

}
