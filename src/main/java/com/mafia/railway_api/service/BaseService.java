package com.mafia.railway_api.service;

import com.mafia.railway_api.model.response.ApiResponse;
import com.mafia.railway_api.util.ResponseUtils;

public interface BaseService<T> {
    ApiResponse add(T t);
    ApiResponse getList();
    ApiResponse get(long id);
    ApiResponse delete(long id);
    ApiResponse edit(long id, T t);
}
