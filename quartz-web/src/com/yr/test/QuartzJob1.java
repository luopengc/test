package com.yr.test;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class QuartzJob1 implements Job{

	@Override
	public void execute(JobExecutionContext job) throws JobExecutionException {
		System.out.println("1111");
	}

}
