package com.riwi.Sistema_Gestion_Redencion_Cupones.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.riwi.Sistema_Gestion_Redencion_Cupones.api.dtos.requests.UserRequest;
import com.riwi.Sistema_Gestion_Redencion_Cupones.api.dtos.responses.UserResponse;
import com.riwi.Sistema_Gestion_Redencion_Cupones.infrastructure.abstract_services.IUserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/users")
@Tag(name = "User Controller", description = "Controller for managing users")
public class UserController {

  @Autowired
  private final IUserService userService;

  @Operation(summary = "Get user by ID", description = "Retrieve a user by their ID")
  @ApiResponses(value = {
          @ApiResponse(responseCode = "200", description = "User retrieved successfully"),
          @ApiResponse(responseCode = "404", description = "User not found")
  })
  @GetMapping(path = "/{id}")
  public ResponseEntity<UserResponse> showUser(@PathVariable Long id) {
    return ResponseEntity.ok(this.userService.get(id));
  }

  @Operation(summary = "Add a new user", description = "Create a new user")
  @ApiResponses(value = {
          @ApiResponse(responseCode = "200", description = "User created successfully"),
          @ApiResponse(responseCode = "400", description = "Invalid input data")
  })
  @PostMapping(path = "/add")
  public ResponseEntity<UserResponse> addUser(@RequestBody UserRequest userRequest) {
    return ResponseEntity.ok(this.userService.create(userRequest));
  }

  @Operation(summary = "Update user by ID", description = "Update an existing user by their ID")
  @ApiResponses(value = {
          @ApiResponse(responseCode = "200", description = "User updated successfully"),
          @ApiResponse(responseCode = "404", description = "User not found"),
          @ApiResponse(responseCode = "400", description = "Invalid input data")
  })
  @PutMapping(path = "/update/{id}")
  public ResponseEntity<UserResponse> updateUser(@RequestBody UserRequest userRequest,
                                                 @PathVariable Long id) {
    return ResponseEntity.ok(this.userService.update(id, userRequest));
  }

  @Operation(summary = "Delete user by ID", description = "Delete a user by their ID")
  @ApiResponses(value = {
          @ApiResponse(responseCode = "204", description = "User deleted successfully"),
          @ApiResponse(responseCode = "404", description = "User not found")
  })
  @DeleteMapping(path = "/{id}")
  public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
    this.userService.delete(id);
    return ResponseEntity.noContent().build();
  }
}
