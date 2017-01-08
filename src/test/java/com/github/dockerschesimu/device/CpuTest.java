package com.github.dockerschesimu.device;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.github.dockerschesimu.error.device.SetCoreUseError;
import com.github.dockerschesimu.error.device.SetCpuUseOutOfBoundError;
import com.github.dockerschesimu.manager.Task;

public class CpuTest {


	@Test
	public void testCpu() {
		Cpu cpu=new Cpu();
		Task task=new Task(2,3.0f,15);		
		cpu.init(37.5);
		cpu.monitor();		
//		System.out.println(cpu.getRecoverI());
//		Core[] cores=cpu.getCores();
//		for(Core core:cores){
//			System.out.println(core.getId()+","+core.getRecoverI());
//		}
		
		cpu.doTask(task);
		cpu.monitor();
		cpu.checkPoint();
		
		cpu.doTask(task);
		cpu.monitor();
		cpu.checkPoint();
		
		cpu.recover();
		cpu.monitor();
//		System.out.println(cpu.getRecoverI());
//		Core[] cores=cpu.getCores();
//		for(Core core:cores){
//			System.out.println(core.getId()+","+core.getRecoverI());
//		}
		
		cpu.recover(5);	//超出了，还是返回最后
		cpu.monitor();
		
	}

//	@Test
//	public void testCpuInt() {
//		Cpu cpu=new Cpu(4);
//		
//		cpu.init(30.56F, 2);
//		cpu.init(37.5F, 1);
//		cpu.init(37.5F, 3);
//		
//		cpu.monitor();		
//	}

}
