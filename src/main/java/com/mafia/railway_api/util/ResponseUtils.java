package com.mafia.railway_api.util;

import com.mafia.railway_api.model.response.ApiResponse;
public abstract class ResponseUtils {

    public ApiResponse SUCCESS = new ApiResponse(0, "success");

    public ApiResponse USER_NOT_FOUND = new ApiResponse(1, "user not found");
    public ApiResponse TICKET_NOT_FOUND = new ApiResponse(3, "ticket not found");
    public ApiResponse TRAIN_NOT_FOUND = new ApiResponse(2, "train not found");
    public ApiResponse WAGON_NOT_FOUND = new ApiResponse(2, "wagon not found");
}
