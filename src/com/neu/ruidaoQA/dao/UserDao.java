package com.neu.ruidaoQA.dao;
import java.util.ArrayList;

import com.neu.ruidaoQA.entity.Comment;
import javax.jws.soap.SOAPBinding.Use;

import com.neu.ruidaoQA.entity.User;

public interface UserDao {
	User selectUser(int user_id);//����user_idѡ����Ӧ���û���Ϣ
	User selectUserByAnswer_id(int question_id);//����Answer_idѡ�����Ӧ���û�
	User selectUserByComment_id(int comment_id);//����comment_idѡ�����Ӧ���û�
	public ArrayList<Comment> getComments(int user_id);
}
