package com.mafia.railway_api.controller.connection;

import com.mafia.railway_api.model.receive.ConnectionReceiveDTO;
import com.mafia.railway_api.service.ConnectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/connection")
public class ConnectionController {
    private final ConnectionService connectionService;

    @PostMapping("/add")
    public ResponseEntity<?> add(
            @Valid @RequestBody ConnectionReceiveDTO connectionReceiveDTO
            ) {
        return ResponseEntity.ok(connectionService.addConnection(connectionReceiveDTO));
    }

    @GetMapping("/list")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(connectionService.getConnectionList());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> get(
            @PathVariable Long id
    ) {
        return ResponseEntity.ok(connectionService.getConnection(id));
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<?> edit(
            @PathVariable Long id, @RequestBody ConnectionReceiveDTO connectionReceiveDTO
    ) {
        return ResponseEntity.ok(connectionService.editConnection(id, connectionReceiveDTO));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(
            @PathVariable Long id
    ) {
        return ResponseEntity.ok(connectionService.deleteConnection(id));
    }
}
