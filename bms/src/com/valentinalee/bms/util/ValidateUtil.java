package com.valentinalee.bms.util;

import com.valentinalee.bms.exception.ThisAppException;

public class ValidateUtil {

	public static String throwIfNone(String value,String errorMessage)throws RuntimeException{
		if(value==null||(value=value.trim()).length()==0){
			throw new ThisAppException(errorMessage);
		}
		return value;
	}
}
