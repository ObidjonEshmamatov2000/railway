package com.mafia.railway_api.service;

import com.mafia.railway_api.entity.user.UserEntity;

import com.mafia.railway_api.exception.user.UserCustomException;
import com.mafia.railway_api.exception.user.UserNotFound;
import com.mafia.railway_api.model.receive.UserReceiveDTO;
import com.mafia.railway_api.model.response.ApiResponse;
import com.mafia.railway_api.repository.UserRepository;
import com.mafia.railway_api.util.ResponseUtils;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements BaseService<UserReceiveDTO>{
    private final ModelMapper modelMapper;

    private final UserRepository userRepository;

    private final ResponseUtils responseUtils;



    private void checkUser(String username){
        Optional<UserEntity> optionalUserEntity = userRepository
                .findByUsername(username);
        if (optionalUserEntity.isPresent())
            throw new UserCustomException(username + " user is exist");
    }


    @Override
    public ApiResponse add(UserReceiveDTO userReceiveDTO) {
        checkUser(userReceiveDTO.getUsername());
        UserEntity userEntity = modelMapper.map(userReceiveDTO, UserEntity.class);

        ApiResponse success = responseUtils.SUCCESS;
        userRepository.save(userEntity);
        return success;
    }

    @Override
    public ApiResponse getList() {
        List<UserEntity> userEntities=userRepository.findAll();
        ApiResponse success = responseUtils.SUCCESS;
        success.setData(userEntities);
        return success;
    }


    public ApiResponse get(long id) {
        ApiResponse success = responseUtils.SUCCESS;
        Optional< UserEntity > byId = userRepository.findById(id);
        if (byId.isEmpty()){
            throw new UserNotFound(id + "user not found");
        }

        success.setData(byId.get());
        return success;
    }

    @Override
    public ApiResponse delete(long id) {
        Optional< UserEntity > byId = userRepository.findById(id);
        if (byId.isEmpty()) {
            throw new UserNotFound(id+"user is not found");
        }
        userRepository.deleteById(id);
        return responseUtils.SUCCESS;
    }

    @Override
    public ApiResponse edit(long id, UserReceiveDTO userReceiveDTO) {
        Optional< UserEntity > byId = userRepository.findById(id);
        if (byId.isEmpty()){
            throw new UserNotFound(id+"user not found");
        }

        UserEntity userEntity=byId.get();
        if (userReceiveDTO.getName()!=null)
            userEntity.setName(userReceiveDTO.getName());

        if (userReceiveDTO.getEmail()!=null)
            userEntity.setEmail(userReceiveDTO.getEmail());

        if (userReceiveDTO.getUsername()!=null)
            userEntity.setUsername(userReceiveDTO.getUsername());

        if (userReceiveDTO.getPassword()!=null)
            userEntity.setPassword(userReceiveDTO.getPassword());

        if (userReceiveDTO.getPassport() != null)
            userEntity.setPassport(userReceiveDTO.getPassport());

        userRepository.save(userEntity);

        ApiResponse apiResponse= responseUtils.SUCCESS;
        apiResponse.setData(userEntity);

        return apiResponse;
    }
}
