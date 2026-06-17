package edu.kis.powp.jobs2d.command;

import edu.kis.powp.jobs2d.Job2dDriver;

public class CommandInvoker {

	private DriverCommand command;

	public CommandInvoker(DriverCommand command) {
		this.command = command;
	}

	public void setCommand(DriverCommand command) {
		this.command = command;
	}

	public void run(Job2dDriver driver) {
		command.execute(driver);
	}
}
