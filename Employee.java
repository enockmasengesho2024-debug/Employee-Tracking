public class Employee {
    private String fName;
    private String lName;
    private String proPossAdj;
    private String proSubj;
    private String proObj;
    private String address;
    private boolean choose;
    private int age;
    private int miles;
    private int punchIn;
    private int punchOut;
    private int hourlyRate;
    private int totalSalary;
    private int numEmployees;

    // Constructor
    public Employee(String fName, String lName, String proPossAdj, String proSubj,
                    String proObj, String address, boolean choose, int age, int miles,
                    int punchIn, int punchOut, int hourlyRate, int totalSalary, int numEmployees) {
        this.fName = fName;
        this.lName = lName;

        this.proPossAdj = proPossAdj;  //  his, hers, theirs
        this.proSubj = proSubj;  // he, she, they
        this.proObj = proObj;// her, him them


        this.address = address;
        this.choose = choose;
        this.age = age;
        this.miles = miles;
        this.punchIn = punchIn;
        this.punchOut = punchOut;
        this.hourlyRate = hourlyRate;
        this.totalSalary = totalSalary;
        this.numEmployees = numEmployees;
    }

   
    public String getFullName() { 
        return fName + " " + lName; 
    }
    public String getPossAdj() { 
        return proPossAdj;
     }
    public String getSubj() { return proSubj; }

    public String getObj() { return proObj; }
    public String getAddress() { return address; }
    public boolean getChoice() { return choose; }
    public int getAge() { return age; }
    public int getMiles() { return miles; }
    public int getPunchIn() { return punchIn; }
    public int getPunchOut() { return punchOut; }
    public int getHourlyRate() { return hourlyRate; }
    public int getTotalSalary() { return totalSalary; }
    public int getNumEmployees() { return numEmployees; }


    // Setters can be added if needed
    public void setFullName(String fName, String lName) { 
        this.fName = fName;
        this.lName = lName;

    }
  public void setProPossAdj(String proPossAdj) { 
        this.proPossAdj = proPossAdj; 
    }
    public void setSubj(String proSubj) { 
        this.proSubj = proSubj; 
    }

    public void setObj(String proObj) { 
        this. proObj = proObj;
     }

    public void setAddress(String address) { 
        this.address = address;
     }
    public void setChoice(boolean choose) {
         this.choose = choose;
         }
    public void setAge(int age) { 
        this.age = age;
     }
    public void setMiles(int miles) { 
        this.miles = miles;
     }
    public void setPunchIn(int punchIn) {
        this.punchIn = punchIn;
     }
    public void setPunchOut(int punchOut) { 
        this.punchOut = punchOut; 
    }
    public void setHourlyRate(int hourlRate) {
        this.hourlyRate = hourlRate;
     }
    public void setTotalSalary(int totalSalary) { 
        this.totalSalary = totalSalary;
     }
    public void setNumEmployees(int numEmployees) { 
        this.numEmployees = numEmployees; 
    }


}
