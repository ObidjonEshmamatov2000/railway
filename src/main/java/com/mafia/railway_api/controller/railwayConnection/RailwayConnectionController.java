package com.mafia.railway_api.controller.railwayConnection;

import com.mafia.railway_api.model.receive.RailwayConnectionReceiveDTO;
import com.mafia.railway_api.service.RailwayConnectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/railway-connection")
public class RailwayConnectionController {
    private final RailwayConnectionService railwayConnectionService;

    @PostMapping("/add")
    public ResponseEntity<?> add(
            @Valid @RequestBody RailwayConnectionReceiveDTO railwayConnectionReceiveDTO
    ) {
        return ResponseEntity.ok(railwayConnectionService.add(railwayConnectionReceiveDTO));
    }

    @GetMapping("/list")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(railwayConnectionService.getList());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> get(
            @PathVariable Long id
    ) {
        return ResponseEntity.ok(railwayConnectionService.get(id));
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<?> edit(
            @PathVariable Long id, @RequestBody RailwayConnectionReceiveDTO railwayConnectionReceiveDTO
    ) {
        return ResponseEntity.ok(railwayConnectionService.edit(id, railwayConnectionReceiveDTO));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(
            @PathVariable Long id
    ) {
        return ResponseEntity.ok(railwayConnectionService.delete(id));
    }
}
