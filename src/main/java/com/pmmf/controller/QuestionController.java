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

import com.pmmf.entity.Question;
import com.pmmf.service.QuestionService;

@Controller
@RequestMapping("/question")
public class QuestionController {

	// inject the question Service
	@Autowired
	private QuestionService questionService;
	
	@RequestMapping("/list")
	public String ListQuestions(Model theModel) {
		
		// get questions from the Service
		List<Question> theQuestions = questionService.getQuestions();
		
		// add the answers to the model
		theModel.addAttribute("questions", theQuestions);
		
		return "list-questions";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		Question theQuestion = new Question();
		
		theModel.addAttribute("question", theQuestion);
		
		return "question-form";
	}
	
	@PostMapping("/saveQuestion")
	public String saveQuestion(@ModelAttribute("question") Question theQuestion) {
		
		// save the question using the service
		questionService.saveQuestion(theQuestion);
		
		return "redirect:/question/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("questionId") int theId,
									Model theModel) {
		
		// get question from the service
		Question theQuestion = questionService.getQuestion(theId);
		
		// set question as a model attribute to pre-populate the form
		theModel.addAttribute("question", theQuestion);
		
		return "question-form";
	}
	
	@GetMapping("/delete")
	public String deleteQuestion(@RequestParam("questionId") int theId) {
		
		// delete the question
		questionService.deleteQuestion(theId);
		
		return "redirect:/question/list";
	}
}
