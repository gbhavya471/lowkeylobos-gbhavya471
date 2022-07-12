package com.app.directv.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class Augmentation {

	private Constraints constraints;

	public Constraints getConstraints() {
		return constraints;
	}

	public void setConstraints(Constraints constraints) {
		this.constraints = constraints;
	}
	

}
