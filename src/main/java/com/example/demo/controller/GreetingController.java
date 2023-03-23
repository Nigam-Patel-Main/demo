package com.example.demo.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Address;
import com.example.demo.dto.RequestDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class GreetingController {
	
	
	// 200, 404, 500, 400	
	@GetMapping("get/{id}")
	public String name(@RequestParam String name,@PathVariable String id) {
		return name + ":"+id;
	}
	
	@PostMapping("req-body")
	public RequestDTO requestBody(@RequestBody RequestDTO requestDTO) {
		System.out.println(requestDTO.getAddress());
		return requestDTO;
	}
	
	@PostMapping("req-body-map")
	public String requestBody(@RequestBody Map<String, Object> map) throws JsonProcessingException {
		
		ObjectMapper objectMapper = new ObjectMapper();
		String carAsString = objectMapper.writeValueAsString(map.get("address"));
		Address address = objectMapper.readValue(carAsString, Address.class);
		System.out.println(address.getCity());
		
		return "Hello";
	}
}
