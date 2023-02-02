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
import com.pmmf.service.AnswerService;

@Controller
@RequestMapping("/answer")
public class AnswerController {
	
	// inject the answer Service
	@Autowired
	private AnswerService answerService;
	
	@RequestMapping("/list")
	public String listAnswers(Model theModel) {
		
		// get answers from the Service
		List<Answer> theAnswers = answerService.getAnswers();
		
		// add the answers to the model
		theModel.addAttribute("answers", theAnswers);
				
		return "list-answers";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		Answer theAnswer = new Answer();
		
		theModel.addAttribute("answer", theAnswer);
		
		return "answer-form";
	}
	
	@PostMapping("/saveAnswer")
	public String saveAnswer(@ModelAttribute("answer") Answer theAnswer) {
		
		// save the answer using the service
		answerService.saveAnswer(theAnswer);
		
		return "redirect:/answer/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("answerId") int theId,
									Model theModel) {
		
		// get answer from the service
		Answer theAnswer = answerService.getAnswer(theId);
		
		// set answer as a model attribute to pre-populate the form
		theModel.addAttribute("answer", theAnswer);
		
		return "answer-form";
	}
	
	@GetMapping("/delete")
	public String deleteAnswer(@RequestParam("answerId") int theId) {
		
		// delete the answer
		answerService.deleteAnswer(theId);
		
		return "redirect:/answer/list";
	}

}
