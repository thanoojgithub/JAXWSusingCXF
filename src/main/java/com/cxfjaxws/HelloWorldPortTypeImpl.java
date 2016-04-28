package com.cxfjaxws;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.cxfjaxws.EmployeeRequest;
import com.cxfjaxws.EmployeeResponse;
import com.cxfjaxws.HelloWorldPortType;

@Component
public class HelloWorldPortTypeImpl implements HelloWorldPortType {

	private final Logger logger = LoggerFactory.getLogger(HelloWorldPortTypeImpl.class);

	@Override
	public EmployeeResponse getEmployee(EmployeeRequest parameters) {
		ObjectFactory objectFactory = new ObjectFactory();
		logger.info("##################");
		logger.info("ID, " + parameters.getId());
		logger.info("##################");
		EmployeeResponse createEmployeeResponse = objectFactory.createEmployeeResponse();
		createEmployeeResponse.setFirstname("Sriram");
		createEmployeeResponse.setLastname("Ayodya");
		createEmployeeResponse.setId(parameters.getId());
		return createEmployeeResponse;
	}

}
