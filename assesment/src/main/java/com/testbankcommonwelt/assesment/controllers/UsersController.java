package com.testbankcommonwelt.assesment.controllers;

import com.testbankcommonwelt.assesment.entities.Users;
import com.testbankcommonwelt.assesment.requests.UserRequest;
import com.testbankcommonwelt.assesment.responses.Response;
import com.testbankcommonwelt.assesment.services.users.UsersService;
import io.swagger.v3.oas.annotations.Operation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UsersController {


    @Autowired
    private UsersService usersService;

    @PostMapping("/create")
    @Operation(summary = "Create user")
    public ResponseEntity<?> createUsers(HttpServletRequest request,
                                                 @Valid @RequestBody UserRequest request_data) {
        Response response = null;
        response = usersService.save(request_data);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update user")
    public ResponseEntity<?> updateUsers (
            HttpServletRequest request,
            @PathVariable Long id,
            @Valid @RequestBody UserRequest userRequest
    ) {
        Response response = null;
        Users before = usersService.findById(id);
        response = usersService.updateUser(id, userRequest);
        Users after = usersService.findById(before.getId());
        response = response != null ? new Response("Success", after) : new Response(null);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/delete")
    @Operation(summary = "Delete user")
    public ResponseEntity<?> deleteUsers(
            HttpServletRequest request,
            @PathVariable Long id
    ) {
        Response response = null;
        Users before = usersService.findById(id);
        response = usersService.deleteUser(id);
        Users after = usersService.findById(before.getId());
        response = response != null ? new Response("Success", after) : new Response(null);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/view/user-list")
    @Operation(summary = "list Users list")
    public ResponseEntity<?> getAllUserPage(
            HttpServletRequest request,
            @RequestParam(name = "page_no", defaultValue = "0") Integer pageNo,
            @RequestParam(name = "page_size", defaultValue = "20") Integer pageSize,
            @RequestParam(name = "sort_by", defaultValue = "id") String sortBy,
            @RequestParam(name = "sort", defaultValue = "ASC") String sort,
            @RequestParam(name = "name", defaultValue = "") Optional<String> name) throws ParseException {
        Response response = null;
        Map<String, Object> result = new HashMap<>();
        result = usersService.findAllUsersPage(pageNo, pageSize, sortBy, sort, name.orElse(null));
        return ResponseEntity.ok(new Response(Long.valueOf(result.get("total_result").toString()),
                Long.valueOf(result.get("total_page").toString()), result.get("data")));
    }
}
