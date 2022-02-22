package com.mafia.railway_api.model.receive;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserReceiveDTO{
    private boolean isActive;
    private String userRole;
    private String name;
    private String passport;
    private String email;
    private String username;
    private String password;
}
