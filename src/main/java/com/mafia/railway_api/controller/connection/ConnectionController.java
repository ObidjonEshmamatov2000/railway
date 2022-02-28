package com.mafia.railway_api.controller.connection;

import com.mafia.railway_api.model.receive.ConnectionReceiveDTO;
import com.mafia.railway_api.service.ConnectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/connection")
public class ConnectionController {
    @Autowired
    private final ConnectionService connectionService;

    @PostMapping("/add")
    public ResponseEntity<?> add(
            @Valid @RequestBody ConnectionReceiveDTO connectionReceiveDTO
            ) {
        return ResponseEntity.ok(connectionService.add(connectionReceiveDTO));
    }

    @GetMapping("/list")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(connectionService.getList());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> get(
            @PathVariable Long id
    ) {
        return ResponseEntity.ok(connectionService.get(id));
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<?> edit(
            @PathVariable Long id, @RequestBody ConnectionReceiveDTO connectionReceiveDTO
    ) {
        return ResponseEntity.ok(connectionService.edit(id, connectionReceiveDTO));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(
            @PathVariable Long id
    ) {
        return ResponseEntity.ok(connectionService.delete(id));
    }
}
