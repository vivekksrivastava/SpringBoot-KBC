package com.hcl.kbc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.kbc.model.Question;
import com.hcl.kbc.service.QuestionSetService;

@RestController
public class KBCController {

	@Autowired
	QuestionSetService questionSetService;
	
	@RequestMapping(value="/questions", method=RequestMethod.GET)
	public List<Question> getQuestionsList()
	{
		return questionSetService.getAllQuestions() ;
	}
	
	@RequestMapping(value="/refreshList", method=RequestMethod.GET)
	public String RefreshList()
	{
		QuestionSetService.refreshList();
		return "The List of Questions is refreshed." ;
	}
	
	
	@PostMapping("/questions/add")
	public Question addQuestion(@RequestBody Question quest)
	{
		questionSetService.addQuestionToQuestionSet(quest);
		return quest;
		
	}
	
	
	@GetMapping("/retrieveQuestion")
	public Question retrieveQuestion()
	{
		Question quest = questionSetService.retrieveQuestion();
		if(quest != null)
		questionSetService.removeQuestion(quest);
		return quest;
	}
}
