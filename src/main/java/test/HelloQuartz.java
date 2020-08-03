package test;

import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

public class HelloQuartz implements Job {

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {

		JobDetail detail = context.getJobDetail();
		// 根据属性得到值
		System.out.println(detail.getJobDataMap().get("name"));
		System.out.println(detail.getJobDataMap().get("age"));
	}

}
