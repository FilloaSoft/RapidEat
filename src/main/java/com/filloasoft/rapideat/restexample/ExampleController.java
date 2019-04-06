package com.filloasoft.rapideat.restexample;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {
	
    @Autowired
    ExampleService exampleServiceImpl;
    
    @GetMapping("/example")
	public List<Example> getAll() {
		return exampleServiceImpl.getList();
	}

	@PostMapping("/example")
	public Example newExample(@RequestBody Example newExample) {
		return exampleServiceImpl.addElementToList(newExample);
	}
}
