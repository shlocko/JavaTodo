package com.company;

import java.util.HashMap;
import java.util.function.Consumer;

public class InputHandler {
    
    HashMap<String, Consumer<String[]>> commands = new HashMap<>();
    List list;
    
    public InputHandler(List list){
        this.list = list;
        
        // Populate commands
        commands.put("list", (String[] args) -> {
            
            // List all ToDos
            for(String item : list.getList()){
                System.out.println(item);
            }
        });
        commands.put("add", (String[] args) -> {
            StringBuilder text = new StringBuilder();
            
            // Turn all remaining arguments into string
            for(int i = 1; i < args.length; i++){
                text.append(args[i]);
                text.append(" ");
            }
            list.add(text.toString());
        });
    }
    
    public boolean handle(String command){
        String[] cmdList = command.split(" ");
        
        // Check for exit condition
        if(cmdList[0].equalsIgnoreCase("exit")){
            return false;
        }
        
        // Check for valid command and run it
        if(commands.containsKey(cmdList[0].toLowerCase())){
            commands.get(cmdList[0].toLowerCase()).accept(cmdList);
        } else {
            System.out.println("Command not recognized.");
        }
        return true;
    }
    
}
