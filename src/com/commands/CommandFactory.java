package com.commands;

public class CommandFactory {

    public static CommandExecutor getCommandExecutor(String command){
        if(command.equalsIgnoreCase("1")){
            return new SingleRunCommandExecutor();
        }else if(command.equalsIgnoreCase("2")) {
            return new TwoCommandExecutor();
        }else if(command.equalsIgnoreCase("3")) {
            return new ThreeCommandExecutor();
        }else if(command.equalsIgnoreCase("4")) {
            return new FourCommandExecutor();
        }else if(command.equalsIgnoreCase("6")) {
            return new FourCommandExecutor();
        }else if(command.equalsIgnoreCase("w")) {
            return new WicketCommandExecutor();
        }else if(command.equalsIgnoreCase("wd")) {
            return new WideCommandExecutor();
        }else if(command.equalsIgnoreCase("N")) {
            return new NoBallCommandExecutor();
        }else {
            throw new RuntimeException("invalid command");
        }
    }
}
