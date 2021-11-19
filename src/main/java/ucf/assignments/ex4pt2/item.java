package ucf.assignments.ex4pt2;

import java.text.ParseException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class item {

    private String description;
    private Date date;
    private boolean complete;

    public item(String d, Date deight){
        description = d;
        date = deight;
        complete = false;
    }

    //getters
    //this will return the description provided
    public String getDescription(){
        return description;
    }
    //this will return the date provided
    public Date getDate(){
        return date;
    }
    //this will return a true or false value to say if the item is complete or not
    public boolean getComplete(){
        return complete;
    }

    //setters
    //this will set the description to what is provided
    public void setDescription(String description){
        this.description = description;
    }
    //this will set the date to the Due Date provided
    public void setDate(Date date)
    {
        this.date = date;
    }
    //this will set the boolean complete based off of the clicks
    public void setComplete(boolean complete)
    {
        this.complete = complete;
    }

}
