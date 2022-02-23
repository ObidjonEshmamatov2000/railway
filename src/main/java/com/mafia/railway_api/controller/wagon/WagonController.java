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
        return ResponseEntity.ok(wagonService.add(wagonReceiveDTO));
    }

    @GetMapping("/list")
    public ResponseEntity<?> getAllTrains() {
        return ResponseEntity.ok(wagonService.getList());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getById(
            @RequestParam long id
    ) {
        return ResponseEntity.ok(wagonService.get(id));
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<?> update(
            @RequestParam long id, @RequestBody WagonReceiveDTO wagonReceiveDTO
    ) {
        return ResponseEntity.ok(wagonService.edit(id,wagonReceiveDTO));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(
            @RequestParam long id
    ) {
        return ResponseEntity.ok(wagonService.delete(id));
    }

}
