package com.mafia.railway_api.controller.train;

import com.mafia.railway_api.model.receive.TrainReceiveDTO;
import com.mafia.railway_api.service.TrainService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/train")
public class TrainController {
    @Autowired
    private final TrainService trainService;

    @PostMapping("/add")
    public ResponseEntity<?> addTrain(
            @RequestBody TrainReceiveDTO trainReceiveDTO
    ) {
        return ResponseEntity.ok(trainService.add(trainReceiveDTO));
    }

    @GetMapping("/list")
    public ResponseEntity<?> getAllTrains() {
        return ResponseEntity.ok(trainService.getList());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getById(
            @RequestParam long id
    ) {
        return ResponseEntity.ok(trainService.get(id));
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<?> update(
            @RequestParam long id, @RequestBody TrainReceiveDTO trainReceiveDTO
    ) {
        return ResponseEntity.ok(trainService.edit(id, trainReceiveDTO));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(
            @RequestParam long id
    ) {
        return ResponseEntity.ok(trainService.delete(id));
    }

}
