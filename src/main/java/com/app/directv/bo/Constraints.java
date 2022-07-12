package com.app.directv.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class Constraints {
	
	private boolean isRecordable;

	public boolean isRecordable() {
		return isRecordable;
	}

	public void setRecordable(boolean isRecordable) {
		this.isRecordable = isRecordable;
	}
	
}
