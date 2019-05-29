package com.neu.ruidaoQA.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import com.neu.ruidaoQA.dao.QuestionTypeDao;
import com.neu.ruidaoQA.dbutil.BaseDao;
import com.neu.ruidaoQA.entity.QuestionType;

public class QuestionTypeDaoimpl extends BaseDao implements QuestionTypeDao{
	 public ArrayList<QuestionType> getQuestiontypes(){
		 String sql="select * from questype order by kinds_id ";
		 ArrayList<QuestionType> types=new ArrayList<QuestionType>();
		 ResultSet rs=super.executeSelect(sql, null);
		 try {
			while(rs.next()) {
				int type_id=rs.getInt(1);
				String type_name=rs.getString(2);
				 QuestionType questionType=new QuestionType(type_id,type_name);
				 types.add(questionType);
				 
				 
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			super.closeAll(BaseDao.con, BaseDao.pst, rs);

		}
		return types;
		 
	 }
		
	
}
