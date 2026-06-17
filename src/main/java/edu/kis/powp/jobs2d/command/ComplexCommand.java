package edu.kis.powp.jobs2d.command;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import edu.kis.powp.jobs2d.Job2dDriver;

public class ComplexCommand implements DriverCommand {

	private final List<DriverCommand> commands = new ArrayList<>();

	public ComplexCommand() {
	}

	public ComplexCommand(DriverCommand... commands) {
		this.commands.addAll(Arrays.asList(commands));
	}

	public void addCommand(DriverCommand command) {
		commands.add(command);
	}

	public List<DriverCommand> getCommands() {
		return Collections.unmodifiableList(commands);
	}

	@Override
	public void execute(Job2dDriver driver) {
		for (DriverCommand command : commands) {
			command.execute(driver);
		}
	}
}
