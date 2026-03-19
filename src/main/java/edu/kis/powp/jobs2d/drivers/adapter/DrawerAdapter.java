package edu.kis.powp.jobs2d.drivers.adapter;

import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.features.DrawerFeature;
import edu.kis.legacy.drawer.panel.DrawPanelController;
import edu.kis.legacy.drawer.shape.ILine;
import edu.kis.legacy.drawer.shape.LineFactory;

public class DrawerAdapter implements Job2dDriver {

    private DrawPanelController controller;
    private int currentX;
    private int currentY;
    private boolean isFirst = true;

    public DrawerAdapter() {
        this.controller = DrawerFeature.getDrawerController();
        this.controller.clearPanel();
    }

    @Override
    public void setPosition(int x, int y) {
        this.currentX = x;
        this.currentY = y;
        this.isFirst = false;
    }

    @Override
    public void operateTo(int x, int y) {
        if (isFirst) {
            currentX = x;
            currentY = y;
            isFirst = false;
            return;
        }

        ILine line = LineFactory.getBasicLine();

        line.setStartCoordinates(currentX, currentY);
        line.setEndCoordinates(x, y);

        controller.drawLine(line);

        this.currentX = x;
        this.currentY = y;
    }
}