package com.riwi.Sistema_Gestion_Redencion_Cupones.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.Sistema_Gestion_Redencion_Cupones.api.dtos.requests.UserRequest;
import com.riwi.Sistema_Gestion_Redencion_Cupones.api.dtos.responses.UserResponse;
import com.riwi.Sistema_Gestion_Redencion_Cupones.infrastructure.abstract_services.IUserService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/users")
public class UserController {

  @Autowired
  private final IUserService userService;

  @GetMapping(path = "/{id}")
  public ResponseEntity<UserResponse> showUser(@PathVariable Long id) {

    return ResponseEntity.ok(this.userService.get(id));
  }

  @PostMapping(path = "/add")
  public ResponseEntity<UserResponse> addUser(@RequestBody UserRequest userRequest) {

    return ResponseEntity.ok(this.userService.create(userRequest));
  }

  @PutMapping(path = "/update/{id}")
  public ResponseEntity<UserResponse> updateUser(@RequestBody UserRequest userRequest,
      @PathVariable Long id) {

    return ResponseEntity.ok(this.userService.update(id, userRequest));
  }

  @DeleteMapping(path = "/{id}")
  public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
    this.userService.delete(id);
    return ResponseEntity.noContent().build();
  }

}
