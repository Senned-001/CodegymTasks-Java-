package com.codegym.task.task39.task3906;

/* 
Interfaces will save us!

*/
public class Solution {
    public static void main(String[] args) {
        SecuritySystem securitySystem = new SecuritySystem();
        LightBulb lightBulb = new LightBulb();
        ElectricPowerSwitch electricPowerSwitch = new ElectricPowerSwitch(securitySystem);
        ElectricPowerSwitch electricPowerSwitch2=new ElectricPowerSwitch(lightBulb);
        electricPowerSwitch.press();
        electricPowerSwitch2.press();
    }
}
