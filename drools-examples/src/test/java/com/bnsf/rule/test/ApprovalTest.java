package com.bnsf.rule.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bnsf.model.CustomerCoverage;

public class ApprovalTest {
	public void setup() {

	}

	@Test
	public void approvalTest() {
		KieServices ks = KieServices.Factory.get();
		KieContainer kContainer = ks.getKieClasspathContainer();
		KieSession ksession = kContainer.newKieSession("approvalKS");

		Logger ruleLogger = LoggerFactory.getLogger("approvalKS");
		ksession.setGlobal("log", ruleLogger);
		CustomerCoverage custCov = new CustomerCoverage();
		custCov.setAge(20);

		ksession.insert(custCov);
	
		ksession.fireAllRules();
		System.out.println("Test Case is Approved : "+custCov.isApproved());
		assertEquals(true, custCov.isApproved());
		
		
	}
}
