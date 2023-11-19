package com.eCommerce.dream.resources;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.eCommerce.dream.config.PropertiesConfiguration;
import com.eCommerce.dream.domain.Role;
import com.eCommerce.dream.domain.User;
import com.eCommerce.dream.dto.user.RoleToUserForm;
import com.eCommerce.dream.repository.UserRepository;
import com.eCommerce.dream.services.UserServices;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.net.URI;
import java.util.*;
import java.util.stream.Collectors;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value="/ecommerce/user")
public class UserResources {

    @Autowired
    private PropertiesConfiguration propertiesConfiguration;

    @Autowired
    private UserServices services;

    @Autowired
    private UserRepository repository;

    @GetMapping(value = "/all")
    ResponseEntity<List<User>> findAll(){
        return ResponseEntity.ok().body(services.getUsers());
    }

    @PostMapping(value = "/register")
    public ResponseEntity<User> saveUser(@RequestBody User newUser){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/ecommerce/user/register").toUriString());
        return ResponseEntity.created(uri).body(services.saveUser(newUser));
    }

    @PostMapping(value = "/role/register")
    public ResponseEntity<Role> saveRole(@RequestBody Role role){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/ecommerce/user/role/register").toUriString());
        return ResponseEntity.created(uri).body(services.saveRole(role));
    }

    @PostMapping(value = "/role/user")
    public ResponseEntity<?> addRoleToUser(@RequestBody RoleToUserForm form){
        services.addRoleToUser(form.getLogin(), form.getRoleName());
        return ResponseEntity.ok().build();
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) throws ObjectNotFoundException {
        Optional<User> user = repository.findById(id);
        return (!user.isEmpty()) ?
                ResponseEntity.ok().body(user.get()) :
                ResponseEntity.notFound().build();
    }

    @GetMapping(value  = "/refresh")
    public void refreshToken (HttpServletRequest request, HttpServletResponse response) throws IOException {
        String authorizationHeader = request.getHeader(AUTHORIZATION);

        if(authorizationHeader != null && authorizationHeader.startsWith("Bearer ")){

            try {
                String refresh_token = authorizationHeader.substring("Bearer ".length());
                Algorithm algorithm = Algorithm.HMAC256(propertiesConfiguration.getSecret().getBytes());
                JWTVerifier verifier = JWT.require(algorithm).build();
                DecodedJWT decodedJWT = verifier.verify(refresh_token);
                String username = decodedJWT.getSubject();
                User user = services.getUser(username);

                String access_token = JWT.create()
                        .withSubject(user.getUsername())
                        .withExpiresAt(new Date(System.currentTimeMillis() + 24 * 60 * 60 * 1000))
                        .withIssuer(request.getRequestURL().toString())
                        .withClaim("roles", user.getRoles().stream().map(Role::getName).collect(Collectors.toList()))
                        .sign(algorithm);

                Map<String, String> tokens = new HashMap<>();
                tokens.put("access_token", access_token);
                tokens.put("refresh_token", refresh_token);
                response.setContentType(APPLICATION_JSON_VALUE);

                new ObjectMapper().writeValue(response.getOutputStream(), tokens);

            }catch (Exception exception){
                response.setHeader("error", exception.getMessage());
                response.setStatus(FORBIDDEN.value());

                Map<String, String> error = new HashMap<>();
                error.put("error_message", exception.getMessage());
                response.setContentType(APPLICATION_JSON_VALUE);

                new ObjectMapper().writeValue(response.getOutputStream(), error);
            }
        } else {
            throw new RuntimeException("Refresh token is missing");
        }
    }
}