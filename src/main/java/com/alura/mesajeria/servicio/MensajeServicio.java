package com.alura.mesajeria.servicio;

import com.alura.mesajeria.dominio.Mensaje;
import com.alura.mesajeria.dominio.MensajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MensajeServicio {

    @Autowired
    MensajeRepository mensajeRepository;

    @Scheduled(cron = "0 0/1 * * * ?") //cada cinco minutos chequea los mensajes
    public void mostrarMensajeAutomatico (){
        List<Mensaje> mensajes = mensajeRepository.findAll();
        LocalDateTime fechaActualAntes = LocalDateTime.now().minusMinutes(1);
        LocalDateTime fechaActual= LocalDateTime.now();

        int contador = 0;

        for (Mensaje mensaje:mensajes){
            if ((mensaje.getFecha().isAfter(fechaActualAntes)) && (mensaje.getFecha().isBefore(fechaActual))){
                System.out.println("****************************");
                System.out.println("Manda mensaje: "+ mensaje.getMensaje() + " a las "+mensaje.getFecha());
                System.out.println("****************************");
                contador++;
            }
        }

        if (contador==0){
            System.out.println("Pasé sin novedad a las "+ fechaActual);
        }

    }
}
