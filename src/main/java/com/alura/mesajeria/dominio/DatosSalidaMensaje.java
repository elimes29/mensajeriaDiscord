package com.alura.mesajeria.dominio;

import java.time.LocalDateTime;

public record DatosSalidaMensaje(Long id, String mensaje, LocalDateTime fecha) {
}
