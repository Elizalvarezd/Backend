package com.dh.Xplorando.controller;
import com.dh.Xplorando.entity.Reserva;
import com.dh.Xplorando.exceptions.ResourceNotFoundException;
import com.dh.Xplorando.service.impl.ReservaService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reservas")
public class ReservaController {
    //instanciamos los servicios que le daremos a nuestra api
    @Autowired
    ReservaService reservaService;
    //get por id
    @Operation(summary = "Buscar reserva por id")
    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN') or (hasRole('ROLE_USER') and #email == principal.username)")
    public ResponseEntity<Reserva> buscarReserva(@PathVariable Long id) throws ResourceNotFoundException {
        Optional<Reserva> reservaBuscada = reservaService.buscarReservaXId(id);
        return reservaBuscada.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    //metodo get por producto id
    @Operation(summary = "trae una lista de reservas segun el id de su producto")
    @GetMapping("/producto/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity <List<Reserva>> buscarReservasXproducto(@PathVariable Long id)  {
        Optional<List<Reserva>> reservasBuscadas=reservaService.listarReservasXProductoId(id);
        return reservasBuscadas.map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
    //metodo get por usuario id
    @Operation(summary = "trae una lista de reservas segun el id de su usuario")
    @GetMapping("/usuario/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN') or (hasRole('ROLE_USER') and #email == principal.username)")
    public ResponseEntity<List<Reserva>>buscarReservasXusuario(@PathVariable Long id){
        Optional<List<Reserva>> reservasBuscadas=reservaService.listarReservasXUsuarioId(id);
        return reservasBuscadas.map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.status(HttpStatus.NOT_FOUND).build());

    }
    //listar todas las reservas
    @Operation(summary = "busca todas las reservas " )
    @GetMapping("/todas")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<Reserva>> listarReservas() {
        return ResponseEntity.ok(reservaService.listarReservas());
    }
    //metodo post
    @Operation(summary = "Crear una nueva reserva")
    @PostMapping("/crear")
    @PreAuthorize("hasRole('ROLE_ADMIN') or (hasRole('ROLE_USER') and #email == principal.username)")
    public ResponseEntity <Reserva> agregarReserva(@RequestBody Reserva reserva) throws ResourceNotFoundException {
        return ResponseEntity.status(HttpStatus.CREATED).body(reservaService.agregarReserva(reserva));
    }
    //metodo put (opcional)
    @Operation(summary = "Edita una reserva ")
    @PutMapping("/editar")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Reserva> editarReserva(@RequestBody Reserva reserva) throws ResourceNotFoundException {
        Reserva reservaeditada=reservaService.editarReserva(reserva);
        return ResponseEntity.ok(reservaeditada);
    }
    //metodo delete(opcional)
    @Operation(summary = "Borra a la reserva que especificamos por su id ")
    @DeleteMapping("/eliminar/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<String> eliminarReserva(@PathVariable Long id ) throws ResourceNotFoundException {
        reservaService.eliminarReservaXId(id);
        return ResponseEntity.ok("Reserva con id "+ id+" fue eliminada con exito. ");
    }
}