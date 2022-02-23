package com.mafia.railway_api.model.receive;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserReceiveDTO{
    @JsonProperty("is_active")
    private boolean isActive;

    @JsonProperty("user_role")
    private String userRole;

    private String name;
    private String passport;
    private String email;
    private String username;
    private String password;
}
