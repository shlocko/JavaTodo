package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

public class InputHandler {
    
    HashMap<String, Consumer<String[]>> commands = new HashMap<>();
    List list;
    
    public InputHandler(List list){
        this.list = list;
        commands.put("list", (String[] args) -> {
            for(String item : list.getList()){
                System.out.println(item);
            }
        });
        commands.put("add", (String[] args) -> {
            StringBuilder text = new StringBuilder();
            for(int i = 1; i < args.length; i++){
                text.append(args[i]);
                text.append(" ");
            }
            list.add(text.toString());
        });
    }
    
    public boolean handle(String command){
        String[] cmdList = command.split(" ");
        if(cmdList[0].equalsIgnoreCase("exit")){
            return false;
        }
        if(commands.containsKey(cmdList[0])){
            commands.get(cmdList[0]).accept(cmdList);
        }
        return true;
    }
    
}
