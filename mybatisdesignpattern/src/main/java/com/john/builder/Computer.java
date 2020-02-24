package com.john.builder;

/**
 * @author:wenwei
 * @date:2020/02/24
 * @description:
 */
public class Computer {




    private String displayer;

    private String mainUnit;

    private String mouse;

    private String keyBoard;



    @Override
    public String toString() {
        return "Computer{" +
                "displayer='" + displayer + '\'' +
                ", mainUnit='" + mainUnit + '\'' +
                ", mouse='" + mouse + '\'' +
                ", keyBoard='" + keyBoard + '\'' +
                '}';
    }


    public String getDisplayer() {
        return displayer;
    }

    public void setDisplayer(String displayer) {
        this.displayer = displayer;
    }

    public String getMainUnit() {
        return mainUnit;
    }

    public void setMainUnit(String mainUnit) {
        this.mainUnit = mainUnit;
    }

    public String getMouse() {
        return mouse;
    }

    public void setMouse(String mouse) {
        this.mouse = mouse;
    }

    public String getKeyBoard() {
        return keyBoard;
    }

    public void setKeyBoard(String keyBoard) {
        this.keyBoard = keyBoard;
    }
}
