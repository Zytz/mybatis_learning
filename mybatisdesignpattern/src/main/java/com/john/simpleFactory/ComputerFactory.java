package com.john.simpleFactory;

/**
 * @author:wenwei
 * @date:2020/02/24
 * @description:
 */
public class ComputerFactory {

//openSession
    public static Computer createComputer(String type){
        Computer computer = null;
//        switch (type){
//            case "lenovo":
//                computer= new LenovoComputer();
//                break;
//            case "hp":
//                computer = new HpComputer();
//                break;
//
//        }
        return computer;
    }
}
