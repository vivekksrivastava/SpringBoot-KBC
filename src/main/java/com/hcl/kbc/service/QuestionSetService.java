package com.hcl.kbc.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hcl.kbc.model.Question;

@Service
public class QuestionSetService {
	
	private static List<Question> questionSet = new ArrayList<>();
	
	static {
		refreshList();
	}
	
	 static public void refreshList(){
		 
		 clearListOfQuestions();
		 
		Question question1 = new Question(1,
				"Largest Country in the World", "Russia", Arrays.asList(
						"India", "Russia", "United States", "China"));
		Question question2 = new Question(2,
				"Most Populus Country in the World", "China", Arrays.asList(
						"India", "Russia", "United States", "China"));
		Question question3 = new Question(3,
				"Highest GDP in the World", "United States", Arrays.asList(
						"India", "Russia", "United States", "China"));
		Question question4 = new Question(4,
				"Second largest english speaking country", "India", Arrays
						.asList("India", "Russia", "United States", "China"));
		
		Question question5 = new Question(5,
				"Java was originally developed by", "James Gosling", Arrays
						.asList("James Gosling", "Punit Sharma", "Vivek", "Anupma"));
		
		Question question6 = new Question(6,
				"Google was originally developed by", "Larry Page, Sergey Brin", Arrays
						.asList("James Gosling", "Larry Page, Sergey Brin", "Sunder Pichai", "Salil Parekh"));
		Question question7 = new Question(7,
				"Largest Country in the World", "Russia", Arrays.asList(
						"India", "Russia", "United States", "China"));
		Question question8 = new Question(8,
				"Most Populus Country in the World", "China", Arrays.asList(
						"India", "Russia", "United States", "China"));
		Question question9 = new Question(9,
				"Highest GDP in the World", "United States", Arrays.asList(
						"India", "Russia", "United States", "China"));
		Question question10 = new Question(10,
				"Second largest english speaking country", "India", Arrays
						.asList("India", "Russia", "United States", "China"));
		
		Question question11 = new Question(11,
				"Java was originally developed by", "James Gosling", Arrays
						.asList("James Gosling", "Punit Sharma", "Vivek", "Anupma"));
		
		Question question12 = new Question(12,
				"Google was originally developed by", "Larry Page, Sergey Brin", Arrays
						.asList("James Gosling", "Larry Page, Sergey Brin", "Sunder Pichai", "Salil Parekh"));
		

		questionSet.add(question1);
		questionSet.add(question2);
		questionSet.add(question3);
		questionSet.add(question4);
		questionSet.add(question5);
		questionSet.add(question6);
		questionSet.add(question7);
		questionSet.add(question8);
		questionSet.add(question9);
		questionSet.add(question10);
		questionSet.add(question11);
		questionSet.add(question12);
	}


	public static void clearListOfQuestions() {
		if(questionSet.isEmpty() != true)
			 questionSet.clear();
	}
	
	
	public void addQuestionToQuestionSet(Question quest)
	{
		questionSet.add(quest);
	}
	
	public List<Question> getAllQuestions(){
		return questionSet;
	}

	public Question retrieveQuestion() {
		if(questionSet.size() != 0)
		return questionSet.get(0);
		else
		{
			return null;
		}
	}
	
	public void removeQuestion(Question quest) {
		questionSet.remove(quest);
	}
	

	
	
}
