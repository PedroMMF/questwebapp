package com.pmmf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pmmf.entity.Test;
import com.pmmf.service.TestService;

@Controller
@RequestMapping("/test")
public class TestController {

// inject the test Service
@Autowired
private TestService testService;

@RequestMapping("/list")
public String ListTests(Model theModel) {
	
	// get tests from the Service
	List<Test> theTests = testService.getTests();
	
	// add the tests to the model
	theModel.addAttribute("tests", theTests);
	
	return "list-tests";
}

@GetMapping("/showFormForAdd")
public String showFormForAdd(Model theModel) {
	
	// create model attribute to bind form data
	Test theTest = new Test();
	
	theModel.addAttribute("test", theTest);
	
	return "test-form";
}

@PostMapping("/saveTest")
public String saveTest(@ModelAttribute("test") Test theTest) {
	
	// save the test using the service
	testService.saveTest(theTest);
	
	return "redirect:/test/list";
}

@GetMapping("/showFormForUpdate")
public String showFormForUpdate(@RequestParam("testId") int theId,
								Model theModel) {
	
	// get test from the service
	Test theTest = testService.getTest(theId);
	
	// set test as a model attribute to pre-populate the form
	theModel.addAttribute("test", theTest);
	
	return "test-form";
}

@GetMapping("/delete")
public String deleteTest(@RequestParam("testId") int theId) {
	
	// delete the test
	testService.deleteTest(theId);
	
	return "redirect:/test/list";
}
}
