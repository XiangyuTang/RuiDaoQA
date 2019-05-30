package com.neu.ruidaoQA.service.impl;

import com.neu.ruidaoQA.SensitiveWordFilteringUtil.BadWordUtil2;
import com.neu.ruidaoQA.service.sensitiveWordService;

public class sensitiveWordimpl implements sensitiveWordService{

	@Override
	public String replaceBadWord(String txt, int matchType, String replaceChar) {
		return BadWordUtil2.replaceBadWord(txt, 2, "*");
	}

}
