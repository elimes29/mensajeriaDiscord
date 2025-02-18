package com.alura.mesajeria.dominio;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DatosRegistraMensaje(
        Long id,
        @NotBlank String mensaje,
        @NotNull LocalDateTime fecha
) {
}
