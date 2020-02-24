package com.john.builder;

/**
 * @author:wenwei
 * @date:2020/02/24
 * @description:
 */
public class ComputerBuiler {
    //parse xmlconfigure
    private Computer computer = new Computer();;

    public void installDisplayer(String display){
        computer.setDisplayer(display);
    }

    public void installMainUnit(String mainUnit){
        computer.setMainUnit(mainUnit);
    }
    public void installKeyborder(String keyBoard){
        computer.setKeyBoard(keyBoard);
    }

    public void installMouse(String mouse){
        computer.setMouse(mouse);
    }

    public Computer getComputer(){
        return computer;
    }
}
