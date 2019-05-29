package com.neu.ruidaoQA.service.impl;

import java.util.ArrayList;

import com.neu.ruidaoQA.entity.QuestionType;
import com.neu.ruidaoQA.service.QuestionTypeService;
import com.neu.ruidaoQA.dao.impl.QuestionTypeDaoimpl;
public class QuestionTypeServiceimpl implements QuestionTypeService{
	 public ArrayList<QuestionType> getQuestiontypes(){
		 QuestionTypeDaoimpl qtImpl=new QuestionTypeDaoimpl();
		 return qtImpl.getQuestiontypes();
	 }

}
