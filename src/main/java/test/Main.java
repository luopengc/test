package test;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class Main {
	public static void main(String[] args) throws Exception {
		new Main().startScheduler();
	}

	public void startScheduler() throws Exception {
		// 调试器
		Scheduler scheduler = new StdSchedulerFactory().getScheduler();

		// 执行的具体的调试类(调试任务)
		JobDetail job = JobBuilder.newJob().ofType(HelloQuartz.class).withIdentity("部落冲突", "瓦力基女武神")
				.usingJobData("name", "lpc").usingJobData("age", "19").build();

		// 调试时间配置
		Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "瓦力基女武神").startNow()
				/**
				 * 三种不同的方式
				 */
				// 每5秒钟执行一次
				.withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * * *  ?"))
				// 每两秒钟执行一次
				// .withSchedule(SimpleScheduleBuilder.repeatSecondlyForTotalCount(10,
				// 2))
				// 每两秒钟执行一次
				// .withSchedule(CalendarIntervalScheduleBuilder.calendarIntervalSchedule().withIntervalInSeconds(2))
				.build();
		// 加入调度
		scheduler.scheduleJob(job, trigger);
		// 启动
		scheduler.start();
		// 运行一段时间后关闭,可以永不关闭
		// Thread.sleep(15000);
		// 自动关闭
		// scheduler.shutdown(true);
	}
}
