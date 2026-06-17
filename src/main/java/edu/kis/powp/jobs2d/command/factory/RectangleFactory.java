package edu.kis.powp.jobs2d.command.factory;

import edu.kis.powp.jobs2d.command.ComplexCommand;
import edu.kis.powp.jobs2d.command.DriverCommand;
import edu.kis.powp.jobs2d.command.OperateToCommand;
import edu.kis.powp.jobs2d.command.SetPositionCommand;

public final class RectangleFactory {

	private RectangleFactory() {
	}

	public static DriverCommand createRectangle(int x, int y, int width, int height) {
		ComplexCommand rectangle = new ComplexCommand();
		rectangle.addCommand(new SetPositionCommand(x, y));
		rectangle.addCommand(new OperateToCommand(x + width, y));
		rectangle.addCommand(new OperateToCommand(x + width, y + height));
		rectangle.addCommand(new OperateToCommand(x, y + height));
		rectangle.addCommand(new OperateToCommand(x, y));
		return rectangle;
	}
}
