package com.mafia.railway_api.controller.user;

import com.mafia.railway_api.model.receive.ConnectionReceiveDTO;
import com.mafia.railway_api.model.receive.UserReceiveDTO;
import com.mafia.railway_api.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/user")
public class UserController {
    @Autowired
    private final UserService userService;

    @PostMapping("/add")
    public ResponseEntity<?> add(
            @Valid @RequestBody UserReceiveDTO userReceiveDTO
    ) {
        return ResponseEntity.ok(userService.add(userReceiveDTO));
    }

    @GetMapping("/list")
    public ResponseEntity<?> getUsers(  ) {
        return ResponseEntity.ok(userService.getList());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getUserById(@PathVariable long id  ) {
        return ResponseEntity.ok(userService.get(id));
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<?> edit(
            @PathVariable Long id, @RequestBody UserReceiveDTO userReceiveDTO
    ) {
        return ResponseEntity.ok(userService.edit(id,userReceiveDTO));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete( @PathVariable Long id  ) {
        return ResponseEntity.ok(userService.delete(id));
    }

}
