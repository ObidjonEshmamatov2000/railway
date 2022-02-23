package com.mafia.railway_api.util;

import com.mafia.railway_api.model.response.ApiResponse;
public abstract class ResponseUtils {

    public static ApiResponse SUCCESS = new ApiResponse(0, "success");

    public static ApiResponse USER_NOT_FOUND = new ApiResponse(1, "user not found");
    public static ApiResponse TRAIN_NOT_FOUND = new ApiResponse(2, "train not found");
    public static ApiResponse WAGON_NOT_FOUND = new ApiResponse(2, "wagon not found");
}
