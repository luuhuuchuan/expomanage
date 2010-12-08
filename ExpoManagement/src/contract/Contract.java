/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package contract;

/**
 *
 * @author Hse7en
 */
public class Contract {
    String Expo,RDate,Name,NumBooths,sentDate,returnDate,lastChange,Paid;
    Boolean Status;
    public Contract()
    {
        Expo = RDate = Name = NumBooths = sentDate = returnDate = lastChange = Paid = "";
        Status = false;
    }
    public Contract(String Expo,String RDate,String Name,Boolean Status,String NumBooths,String sentDate,String returnDate,String lastChange,String Paid)
    {
        this.Expo = Expo;
        this.RDate = RDate;
        this.Name = Name;
        this.Status = Status;
        this.NumBooths = NumBooths;
        this.sentDate = sentDate;
        this.returnDate = returnDate;
        this.lastChange = lastChange;
        this.Paid = Paid;
    }
    public String getExpo(){
        return Expo;
    }
    public String getRDate(){
        return RDate;
    }
    public String getName(){
        return Name;
    }
    public Boolean getStatus(){
        return Status;
    }
    public String getNumBooths(){
        return NumBooths;
    }
    public String getSentDate(){
        return sentDate;
    }
    public String getLastDate(){
        return lastChange;
    }
    public String getReturnDate(){
        return returnDate;
    }
    public String getPaid(){
        return Paid;
    }
}
