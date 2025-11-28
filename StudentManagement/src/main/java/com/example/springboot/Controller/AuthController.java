package com.example.springboot.Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.springboot.Dto.JWTAuthResponse;
import com.example.springboot.Dto.LoginDto;
import com.example.springboot.Security.JwtTokenProvider;

@RestController
@RequestMapping("/Auth")
public class AuthController {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	private final String externalUrl = "http://35.154.202.51:8085/api/getAll";

	@Autowired
	private JwtTokenProvider jwtTokenProvider;
	
	@Autowired
	private RestTemplate restTemplate;

	@PostMapping("/login")
	public ResponseEntity<JWTAuthResponse> loginUser(@RequestBody LoginDto loginDto) {
		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String token = jwtTokenProvider.generateToken(authentication);
		return ResponseEntity.ok(new JWTAuthResponse(token));
	}
	

	
	@GetMapping("/msg")
	public String getMsg(){
		return "Hello world";
	}
	
	@GetMapping("/java")
	public String getMethod() {
		return "Java is simple";
	}
	@GetMapping("/external")
	public Map<String, Object> callExternalApi() {

	    // Get real parsed JSON instead of String
	    Map<String, Object> externalResponse = restTemplate.getForObject(externalUrl, Map.class);

	    Map<String, Object> response = new HashMap<>();
	    response.put("result", "success");
	    response.put("data", externalResponse.get("data")); // extract only users array

	    return response;
	}

	
	

	

}
