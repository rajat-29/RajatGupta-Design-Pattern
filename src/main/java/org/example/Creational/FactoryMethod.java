package org.example.Creational;

import java.io.*;

abstract class Plan{
    protected double unit_rate;
    abstract void getRate();

    public void calculateTotalBill(int unitsUsed){
        System.out.print("Calculated Bill is : ");
        System.out.println(unitsUsed*unit_rate);
    }
}

class DomesticPlan extends Plan{
    public void getRate(){
        unit_rate = 5;
    }
}

class CommercialPlan extends Plan{
    public void getRate(){
        unit_rate = 11;
    }
}

class InstitutionPlan extends Plan{
    public void getRate(){
        unit_rate = 8;
    }
}

class GetPlan{
    public Plan getPlanType(String planType){
        if(planType==null)
            return null;
        else if(planType.equalsIgnoreCase("Domestic"))
            return new DomesticPlan();
        else if(planType.equalsIgnoreCase("Commercial"))
            return new CommercialPlan();
        else if(planType.equalsIgnoreCase("Institution"))
            return new InstitutionPlan();
        else
            return null;
    }
}

public class FactoryMethod {
    public static void main(String args[]) throws IOException{
        GetPlan getPlan = new GetPlan();
        System.out.println("Choose one  : Domestic/ Commercial/ Institution");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String planTypeUser = br.readLine();
        System.out.println("Enter number of units used for bill : ");
        int units = Integer.parseInt(br.readLine());

        Plan plan = getPlan.getPlanType(planTypeUser);
        plan.getRate();
        plan.calculateTotalBill(units);
    }
}