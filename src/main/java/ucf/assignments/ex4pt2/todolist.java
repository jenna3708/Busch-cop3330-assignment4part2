package ucf.assignments.ex4pt2;

import java.io.File;
import java.io.*;
import java.util.*;

public class todolist {
    private String title;
    private ArrayList<item> items;

    public todolist(String t){
        title = t;
        items = new ArrayList<item>();
    }

    //this will return the title of our ToDoList
    public String getTitle(){
        return title;
    }

    //this sets our title to equal the title
    public void setTitle(String title){
        this.title = title;
    }

    public ArrayList<item> getToDoList(){
        return items;
    }

    //this will add an item to our ToDoList
    public item addItem(String description, Date date){
        //create a new item
        item newItem = new item(description, date);
        //initialize the new item with the info required
        //add the item to the array list of items
        this.items.add(newItem);
        return newItem;
    }

    //this will delete an item from our ToDoList
    public void deleteItem(item toDelete){
        //take in the array list and the specified item
        //search through the array list for the item
        this.items.remove(toDelete);
        //delete the item
        //move the array list down
    }

    //this clears the to do list
    public void clear(){
        this.items.clear();
    }

}
