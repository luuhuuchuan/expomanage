/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Registration;

/**
 *
 * @author Hse7en
 */
public class BoothType {
    String BTName;
    int BTLength,BTRemain;
    public BoothType(){
        BTName = "";
        BTLength = BTRemain = 0;
    }
    public BoothType(String BTName,int BTLength, int BTRemain){
        this.BTName = BTName;
        this.BTLength = BTLength;
        this.BTRemain = BTRemain;
    }
    public String getBTName(){
        return BTName;
    }
    public int getBTLength(){
        return BTLength;
    }
    public int getBTRemain(){
        return BTRemain;
    }
}
