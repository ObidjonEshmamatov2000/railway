package com.mafia.railway_api.controller.wagon;


import com.mafia.railway_api.model.receive.WagonReceiveDTO;
import com.mafia.railway_api.service.WagonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/wagon")
public class WagonController {
    private final WagonService wagonService;

    @PostMapping("/add")
    public ResponseEntity<?> addTrain(
            @RequestBody WagonReceiveDTO wagonReceiveDTO
    ) {
        return ResponseEntity.ok(wagonService.addWagon(wagonReceiveDTO));
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllTrains() {
        return ResponseEntity.ok(wagonService.getAllTrains());
    }

    @GetMapping("/get")
    public ResponseEntity<?> getById(
            @RequestParam long id
    ) {
        return ResponseEntity.ok(wagonService.getById(id));
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(
            @RequestBody WagonReceiveDTO wagonReceiveDTO
    ) {
        return ResponseEntity.ok(wagonService.update(wagonReceiveDTO));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(
            @RequestParam long id
    ) {
        return ResponseEntity.ok(wagonService.deleteById(id));
    }

}
