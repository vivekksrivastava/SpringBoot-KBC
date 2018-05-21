package com.hcl.kbc.frontEndController;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.hcl.kbc.service.QuestionSetService;

@Controller
public class WebController {
	
	
	@RequestMapping(value="/")
	public String index()
	{
		return "index";
	}

	@RequestMapping(value="/index")
	public String index1()
	{
		return "index";
	}
	
	@RequestMapping(value="/showGame")
	public String showGamePage()
	{
		return "gamePage";
	}
	
	
	@RequestMapping(value="/showFinalScore")
	public String showFinalScore(@RequestParam String score, ModelMap model)
	{
		QuestionSetService.clearListOfQuestions();
		model.put("score", score);
		return "finalScorePage";
	}
	
}