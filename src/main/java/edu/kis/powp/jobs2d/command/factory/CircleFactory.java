package edu.kis.powp.jobs2d.command.factory;

import edu.kis.powp.jobs2d.command.ComplexCommand;
import edu.kis.powp.jobs2d.command.DriverCommand;
import edu.kis.powp.jobs2d.command.OperateToCommand;
import edu.kis.powp.jobs2d.command.SetPositionCommand;

public final class CircleFactory {

	private static final int DEFAULT_SEGMENTS = 36;

	private CircleFactory() {
	}

	public static DriverCommand createCircle(int centerX, int centerY, int radius) {
		return createCircle(centerX, centerY, radius, DEFAULT_SEGMENTS);
	}

	public static DriverCommand createCircle(int centerX, int centerY, int radius, int segments) {
		ComplexCommand circle = new ComplexCommand();
		double angleStep = 2 * Math.PI / segments;
		int startX = centerX + radius;
		int startY = centerY;

		circle.addCommand(new SetPositionCommand(startX, startY));

		for (int i = 1; i <= segments; i++) {
			double angle = i * angleStep;
			int x = centerX + (int) Math.round(radius * Math.cos(angle));
			int y = centerY + (int) Math.round(radius * Math.sin(angle));
			circle.addCommand(new OperateToCommand(x, y));
		}

		return circle;
	}
}
