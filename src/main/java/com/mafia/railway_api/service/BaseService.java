package com.mafia.railway_api.service;

import com.mafia.railway_api.model.response.ApiResponse;
import com.mafia.railway_api.util.ResponseUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.MappedSuperclass;

public interface BaseService<T> {

    ApiResponse add(T t);
    ApiResponse getList();
    ApiResponse get(long id);
    ApiResponse delete(long id);
    ApiResponse edit(long id, T t);
}
