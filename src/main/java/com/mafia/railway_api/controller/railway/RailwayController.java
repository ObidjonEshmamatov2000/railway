package com.mafia.railway_api.controller.railway;

import com.mafia.railway_api.model.receive.ConnectionReceiveDTO;
import com.mafia.railway_api.model.receive.RailwayReceiveDTO;
import com.mafia.railway_api.service.RailwayService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/railway")
public class RailwayController {
    private final RailwayService railwayService;

    @PostMapping("/add")
    public ResponseEntity<?> add(
            @Valid @RequestBody RailwayReceiveDTO railwayReceiveDTO
    ) {
        return ResponseEntity.ok(railwayService.add(railwayReceiveDTO));
    }

    @GetMapping("/list")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(railwayService.getList());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> get(
            @PathVariable Long id
    ) {
        return ResponseEntity.ok(railwayService.get(id));
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<?> edit(
            @PathVariable Long id, @RequestBody RailwayReceiveDTO railwayReceiveDTO
    ) {
        return ResponseEntity.ok(railwayService.edit(id, railwayReceiveDTO));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(
            @PathVariable Long id
    ) {
        return ResponseEntity.ok(railwayService.delete(id));
    }
}
