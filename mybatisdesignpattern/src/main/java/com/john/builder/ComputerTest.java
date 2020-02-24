package com.john.builder;

/**
 * @author:wenwei
 * @date:2020/02/24
 * @description:
 */
public class ComputerTest {
    public static void main(String[] args) {
        ComputerBuiler computerBuiler = new ComputerBuiler();
        computerBuiler.installDisplayer("display");
        computerBuiler.installKeyborder("keyboard");
        computerBuiler.installMainUnit("mainUnit");
        computerBuiler.installMouse("mouse");

        Computer computer = computerBuiler.getComputer();
        System.out.println(computer);
    }
}
