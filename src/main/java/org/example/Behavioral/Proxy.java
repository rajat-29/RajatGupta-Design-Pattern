package org.example.Behavioral;

interface OfficeNetworkAccess{
    public void grantNetAccess();
}

class RealNetworkAccess implements OfficeNetworkAccess{
    private String employeeName;

    public RealNetworkAccess(String employeeName){
        this.employeeName = employeeName;
    }

    @Override
    public void grantNetAccess() {
        System.out.println("Access has been granted to employee : "+employeeName);
    }
}

class ProxyNetAccess implements OfficeNetworkAccess{
    private String employeeName;
    private RealNetworkAccess realNetworkAccess;

    public ProxyNetAccess(String employeeName){
        this.employeeName=employeeName;
    }

    public int getRole(String employeeNames){
        return employeeNames.length();
    }

    @Override
    public void grantNetAccess() {
        if(getRole(employeeName) > 5){
            realNetworkAccess = new RealNetworkAccess(employeeName);
            realNetworkAccess.grantNetAccess();
        }
        else
            System.out.println("Access cannot be granted. Your job level should be above 5");
    }
}
public class Proxy {
    public static void main(String args[]){
        OfficeNetworkAccess officeNetworkAccess = new ProxyNetAccess("RajatGupta");
        officeNetworkAccess.grantNetAccess();
    }
}