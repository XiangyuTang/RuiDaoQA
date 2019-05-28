package com.neu.ruidaoQA.service;

import java.util.List;

import com.neu.ruidaoQA.entity.User;

public interface FansMessageService {
	List<User> selectFans(int id);
}
