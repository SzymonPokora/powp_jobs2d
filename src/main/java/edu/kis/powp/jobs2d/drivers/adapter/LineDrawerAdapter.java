package edu.kis.powp.jobs2d.drivers.adapter;

import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.features.DrawerFeature;
import edu.kis.legacy.drawer.panel.DrawPanelController;
import edu.kis.legacy.drawer.shape.ILine;

public class LineDrawerAdapter implements Job2dDriver {

    private DrawPanelController controller;
    private ILine line;
    private int currentX;
    private int currentY;

    public LineDrawerAdapter(ILine line) {
        this.controller = DrawerFeature.getDrawerController();
        this.line = line;
    }

    @Override
    public void setPosition(int x, int y) {
        this.currentX = x;
        this.currentY = y;
    }

    @Override
    public void operateTo(int x, int y) {
        line.setStartCoordinates(currentX, currentY);
        line.setEndCoordinates(x, y);

        controller.drawLine(line);

        this.currentX = x;
        this.currentY = y;
    }
}