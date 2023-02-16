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

import com.pmmf.entity.Answer;
import com.pmmf.entity.Questionnaire;
import com.pmmf.entity.Test;
import com.pmmf.service.QuestionnaireService;
import com.pmmf.service.TestService;

@Controller
@RequestMapping("/questionnaire")
public class QuestionnaireController {

	// inject the questionnaire Service
	@Autowired
	private QuestionnaireService questionnaireService;
	
	// inject the test Service
	@Autowired
	private TestService testService;
	
	@RequestMapping("/list")
	public String ListQuestions(Model theModel) {
		
		// get questionnaires from the Service
		List<Questionnaire> theQuestionnaires = questionnaireService.getQuestionnaires();
		
		// add the questionnaires to the model
		theModel.addAttribute("questionnaires", theQuestionnaires);
		
		return "list-questionnaires";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		Questionnaire theQuestionnaire = new Questionnaire();
		
		theModel.addAttribute("questionnaire", theQuestionnaire);
		
		return "questionnaire-form";
	}
	
	@PostMapping("/saveQuestionnaire")
	public String saveQuestionnaire(@ModelAttribute("questionnaire") Questionnaire theQuestionnaire) {
		
		// save the questionnaire using the service
		questionnaireService.saveQuestionnaire(theQuestionnaire);
		
		return "redirect:/questionnaire/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("questionnaireId") int theId,
									Model theModel) {
		
		// get questionnaire from the service
		Questionnaire theQuestionnaire = questionnaireService.getQuestionnaire(theId);
		
		// set questionnaire as a model attribute to pre-populate the form
		theModel.addAttribute("questionnaire", theQuestionnaire);
		
		return "questionnaire-form";
	}
		
	@GetMapping("/delete")
	public String deleteQuestionnaire(@RequestParam("questionnaireId") int theId) {
			
		// delete the questionnaire
		questionnaireService.deleteQuestionnaire(theId);
			
		return "redirect:/questionnaire/list";
	}
	
	@ModelAttribute("tests")
	public List<Test> initializeTests(){
		return testService.getTests();
	}
	
	@GetMapping("/addTest")
	public String addTest(@RequestParam("testId") int theTestId,
			@RequestParam("questionnaire") Questionnaire theQuestionnaire,
			
			Model theModel) {
		
		Test theTest = testService.getTest(theTestId);
			
		// add test to the tests list
		//questionnaireService.addTest(theId);
		
		System.out.println(theQuestionnaire.getTitle());

		
		System.out.println(theTest.getTitle());
		
		
		return "questionnaire-form";		
	}
	
}
