package edu.kis.powp.jobs2d.command.generator;

import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.command.ComplexCommand;
import edu.kis.powp.jobs2d.command.DriverCommand;
import edu.kis.powp.jobs2d.command.OperateToCommand;
import edu.kis.powp.jobs2d.command.SetPositionCommand;
import edu.kis.powp.jobs2d.magicpresets.FiguresJoe;

public final class FiguresJoeCommandsGenerator {

	private FiguresJoeCommandsGenerator() {
	}

	public static DriverCommand figureScript1() {
		CommandRecorder recorder = new CommandRecorder();
		FiguresJoe.figureScript1(recorder);
		return recorder.getRecordedCommand();
	}

	public static DriverCommand figureScript2() {
		CommandRecorder recorder = new CommandRecorder();
		FiguresJoe.figureScript2(recorder);
		return recorder.getRecordedCommand();
	}

	private static class CommandRecorder implements Job2dDriver {

		private final ComplexCommand complexCommand = new ComplexCommand();

		@Override
		public void setPosition(int x, int y) {
			complexCommand.addCommand(new SetPositionCommand(x, y));
		}

		@Override
		public void operateTo(int x, int y) {
			complexCommand.addCommand(new OperateToCommand(x, y));
		}

		public DriverCommand getRecordedCommand() {
			return complexCommand;
		}
	}
}
