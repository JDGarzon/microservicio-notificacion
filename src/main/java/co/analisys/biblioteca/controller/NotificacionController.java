package co.analisys.biblioteca.controller;

import co.analisys.biblioteca.dto.NotificacionDTO;
import co.analisys.biblioteca.service.NotificacionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notificar")
public class NotificacionController {
    @Autowired
    private NotificacionService notificacionService;

    @Operation(
        summary = "Enviar notificación",
        description = "Permite enviar una notificación a un usuario específico. " +
                      "El contenido de la notificación se recibe en formato JSON como un objeto NotificacionDTO."
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Notificación enviada exitosamente"),
        @ApiResponse(responseCode = "400", description = "Solicitud inválida"),
        @ApiResponse(responseCode = "403", description = "Acceso no autorizado")
    })
    @PostMapping
    @PreAuthorize("hasRole('ROLE_EDITAR')")
    public void enviarNotificacion(@RequestBody NotificacionDTO notificacion) {
        notificacionService.enviarNotificacion(notificacion);
    }
}