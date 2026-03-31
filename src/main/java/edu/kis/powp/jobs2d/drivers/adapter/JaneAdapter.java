package edu.kis.powp.jobs2d.drivers.adapter;

import edu.kis.powp.jobs2d.AbstractDriver;
import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.features.DriverFeature;

public class JaneAdapter extends AbstractDriver {

    private Job2dDriver driver;

    public JaneAdapter() {
        super(0, 0);
        this.driver = DriverFeature.getDriverManager().getCurrentDriver();
    }

    @Override
    public void operateTo(int x, int y) {
        driver.operateTo(x, y);
    }
}