package com.codegym.task.task36.task3609;

public class CarController {
    private CarModel model;
    private SpeedometerView view;

    public CarController(CarModel model, SpeedometerView view) {
        this.model = model;
        this.view = view;
    }

    public String getCarBrand() {
        return model.getBrand();
    }

    public String getCarModel() {
        return model.getModel();
    }

    public void setCarSpeed(int speed) {
        model.setSpeed(speed);
    }

    public int getCarSpeed() {
        return model.getSpeed();
    }

    public int getCarMaxSpeed() {
        return model.getMaxSpeed();
    }

    public void updateView() {
        view.printCarDetails(getCarBrand(), getCarModel(), getCarSpeed());
    }

    public void increaseSpeed(int seconds) {
        if (model.getSpeed() < model.getMaxSpeed()) {
            setCarSpeed((int)(model.getSpeed()+ (3.5 * seconds)));
        }
        if (model.getSpeed() > model.getMaxSpeed()) {
            setCarSpeed(model.getMaxSpeed());
        }
    }

    public void decreaseSpeed(int seconds) {
        if (model.getSpeed() > 0) {
            setCarSpeed( model.getSpeed()- (12 * seconds));
        }
        if (model.getSpeed() < 0) {
            setCarSpeed(0);
        }
    }
}