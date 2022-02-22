package com.mafia.railway_api.controller.train;

import com.mafia.railway_api.model.receive.TrainReceiveDTO;
import com.mafia.railway_api.service.TrainService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/train")
public class TrainController {
    private final TrainService trainService;

    @PostMapping("/add")
    public ResponseEntity<?> addTrain(
            @RequestBody TrainReceiveDTO trainReceiveDTO
    ) {
        return ResponseEntity.ok(trainService.addTrain(trainReceiveDTO));
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllTrains() {
        return ResponseEntity.ok(trainService.getAllTrains());
    }

    @GetMapping("/get")
    public ResponseEntity<?> getById(
            @RequestParam long id
    ) {
        return ResponseEntity.ok(trainService.getById(id));
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(
            @RequestBody TrainReceiveDTO trainReceiveDTO
    ) {
        return ResponseEntity.ok(trainService.update(trainReceiveDTO));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(
            @RequestParam long id
    ) {
        return ResponseEntity.ok(trainService.deleteById(id));
    }

}
