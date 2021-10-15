// package com.company;
import java.util.*;

class vaccine{
    private String vaccineName;
    private int noOfDoses;
    private int gapTime;

    public vaccine(String vaccineName, int noOfDoses, int gapTime) {
        this.vaccineName = vaccineName;
        this.noOfDoses = noOfDoses;
        this.gapTime = gapTime;
    }
    public String getVaccineName(){
        return vaccineName;
    }

    public int getNoOfDoses(){
        return noOfDoses;
    }
    public int getGapTime(){
        return gapTime;
    }
}

class hospital {
    private String hospitalName;
    private int hospitalPinCode;
    private int hospitalUID;
    private ArrayList<slot> slotList;

    public hospital(String hospitalName, int hospitalPinCode, int hospitalUID) {
        this.hospitalName = hospitalName;
        this.hospitalPinCode = hospitalPinCode;
        this.hospitalUID = hospitalUID;
        this.slotList = slotList;
    }

    public ArrayList<slot> getSlotList() { //getter for slotList
        return slotList;
    }

    public void setSlotList(ArrayList<slot> slotList) { //setter for slotList
        this.slotList = slotList;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public int getHospitalPinCode() {
        return hospitalPinCode;
    }

    public int getHospitalUID() {
        return hospitalUID;
    }
}

class citizen {
    private static String citizenName;
    private String citizenVaccinestatus;
    private static int citizenAge;
    private long uniquenumID;
    private String vaccineName;
    private int vaccinePreviousDate;
    private int vaccineDueDate;
    private int gapTime;
    private int noOfDosestaken;


    public citizen(long uniquenumID, String citizenVaccinestatus, String vaccineName, int vaccinePreviousDate, int vaccineDueDate, int gapTime, int noOfDosestaken) {
        this.citizenVaccinestatus = citizenVaccinestatus;
        this.uniquenumID = uniquenumID;
        this.vaccineName = vaccineName;
        this.vaccinePreviousDate = vaccinePreviousDate;
        this.vaccineDueDate = vaccineDueDate;
        this.gapTime = gapTime;
        this.noOfDosestaken = noOfDosestaken;
    }

    public citizen(long uniquenumID, String citizenVaccinestatus, String citizenName, int citizenAge) {
        this.citizenName = citizenName;
        this.citizenVaccinestatus = citizenVaccinestatus;
        this.citizenAge = citizenAge;
        this.uniquenumID = uniquenumID;
    }

    public void setVaccineName(String vaccineName) {
        this.vaccineName = vaccineName;
    }

    public String getVaccineName() {
        return vaccineName;
    }

    public int getVaccinePreviousDate() {
        return vaccinePreviousDate;
    }

    public int getVaccineDueDate() {
        return vaccineDueDate;
    }

    public int getGapTime() {
        return gapTime;
    }

    public int getNoOfDosestaken() {
        return noOfDosestaken;
    }

    public void setVaccinePreviousDate(int vaccinePreviousDate) {
        this.vaccinePreviousDate = vaccinePreviousDate;
    }

    public void setVaccineDueDate(int vaccineDueDate) {
        this.vaccineDueDate = vaccineDueDate;
    }

    public void setGapTime(int gapTime) {
        this.gapTime = gapTime;
    }

    public void setNoOfDosestaken(int noOfDosestaken) {
        this.noOfDosestaken = noOfDosestaken;
    }

    public void setCitizenVaccinestatus(String citizenVaccinestatus) {
        this.citizenVaccinestatus = citizenVaccinestatus;
    }

    public citizen(long uniquenumID, String citizenVaccinestatus){
        this(uniquenumID, citizenVaccinestatus, citizenName, citizenAge);
    }

    public String getCitizenName() {
        return citizenName;
    }

    public String getCitizenVaccinestatus() {
        return citizenVaccinestatus;
    }

    public int getCitizenAge() {
        return citizenAge;
    }

    public long getUniquenumID() {
        return uniquenumID;
    }
}

class slot {
    private int hospitalUID;
    private int slotdayNumber;
    private int vaccineQuantity;
    private String choosenVaccine;

    public slot(int hospitalUID, int slotdayNumber, int vaccineQuantity, String choosenVaccine) {
        this.hospitalUID = hospitalUID;
        this.slotdayNumber = slotdayNumber;
        this.vaccineQuantity = vaccineQuantity;
        this.choosenVaccine = choosenVaccine;
    }

    public void setVaccineQuantity(int vaccineQuantity) {
        this.vaccineQuantity = vaccineQuantity;
    }

    public int getHospitalUID() {
        return hospitalUID;
    }

    public int getSlotdayNumber() {
        return slotdayNumber;
    }

    public int getVaccineQuantity() {
        return vaccineQuantity;
    }

    public String getChoosenVaccine() {
        return choosenVaccine;
    }
}


public class Main {

    private static ArrayList<vaccine> vaccineList =new ArrayList<vaccine>();
    private static ArrayList<hospital> hospitalList =new ArrayList<hospital>();
    private static ArrayList<citizen> citizenList =new ArrayList<citizen>();


    static void printMenu(){
        System.out.println("COVIN Portal intitalized ...");
        System.out.println("-----------------------------");
        System.out.println("\n 1. Add Vaccine \n 2. Register Hospital \n 3. Register Citizen \n 4. Add Slot for Vaccination");
        System.out.println("\n 5. Book Slot for Vaccination \n 6. List all slots for a hospital \n 7. Check Vaccination Status \n 8. Exit");
        System.out.println("-----------------------------");
    }

    static void Menu() {
        Scanner scan = new Scanner(System.in);
        boolean bool = true;
        final int ID = 100000;
        int IDGenerator = 0;
        while (bool){
            printMenu();
            int option = scan.nextInt();
            switch (option) {
                case 1:
                    boolean vcontains = false;
                    System.out.println("Vaccine Name : ");
                    String vaccineName = scan.next();
                    for (vaccine i : vaccineList) {
                        if (i.getVaccineName().equalsIgnoreCase(vaccineName)) {
                            vcontains = true;
                        }
                    }
                    int gapTime;
                    if (!vcontains) {
                        System.out.println("Number of total doses required : ");
                        int noOfDoses = scan.nextInt();
                        if (noOfDoses <= 0) {
                            System.out.println("Invalid value, number of doses cannot be less than 1!. Please try again!");
                            break;
                        } else if (noOfDoses == 1) {
                            gapTime = 0;
                        } else {
                            System.out.println("Gap Between Doses");
                            gapTime = scan.nextInt();
                            if (gapTime <= 0) {
                                System.out.println("Invalid gap time between vaccine, please enter correct gap time (in days)!!");
                                break;
                            }
                        }
                        vaccineList.add(new vaccine(vaccineName, noOfDoses, gapTime));
                        System.out.println("Vaccine Name: " + vaccineName + ", Number of Doses: " + noOfDoses + ", Gap Time: " + gapTime);
                    } else {
                        System.out.println("Vaccine already exists in database!");
                    }
                    break;
                case 2:
                    int hospitalUID;
                    System.out.println("Hospital Name: ");
                    String hospitalName = scan.next();
                    boolean hcontains = false;
                    for (hospital i : hospitalList) {
                        if (i.getHospitalName().equalsIgnoreCase(hospitalName)) {
                            hcontains = true;
                        }
                    }
                    if (hcontains) {
                        System.out.println("Hospital already exists in database!");
                        break;
                    } else {
                        System.out.println("PinCode: ");
                        int hospitalPinCode = scan.nextInt();
                        if (hospitalPinCode <= 0) {
                            System.out.println("Invalid entry! Please enter a valid pinCode (pinCode is a six digit POSITIVE integer");
                            break;
                        }
                        int cnt = 0;
                        int pindigitChecker = hospitalPinCode;
                        while (pindigitChecker != 0) {
                            pindigitChecker /= 10;
                            cnt++;
                        }
                        if (cnt != 6) {
                            System.out.println("Invalid entry! Please enter a valid pinCode (pinCode is a SIX digit positive integer");
                            break;
                        }
                        hospitalUID = ID + IDGenerator;
                        IDGenerator++;
                        hospitalList.add(new hospital(hospitalName, hospitalPinCode, hospitalUID));
                        System.out.println("Hospital Name: " + hospitalName + ", PinCode: " + hospitalPinCode + ", Unique ID: " + hospitalUID);
                        break;
                    }
                case 3:
                    String status;
                    int cont = 0;
                    System.out.println("Citizen Name: ");
                    String citizenName = scan.next();
                    System.out.println("Citizen Age: ");
                    int citizenAge = scan.nextInt();
                    if (citizenAge < 18) {
                        System.out.println("Only above 18 are allowed");
                        break;
                    }
                    System.out.println("Enter 12 digit Unique ID");
                    long uniquenumID = scan.nextLong();
                    long IDdigitChecker = uniquenumID;
                    if (uniquenumID <= 0) {
                        System.out.println("Invalid entry! Unique ID is a 12 digit POSITIVE number");
                    }
                    for (; IDdigitChecker != 0; IDdigitChecker /= 10, ++cont) { //count the number of elements in unique ID
                    }
                    if (cont != 12) {
                        System.out.println("Invalid entry! Unique ID is a 12 digit number");
                        break;
                    }
                    boolean bcontains = false;
                    for (citizen i : citizenList) {
                        if (i.getCitizenName().equalsIgnoreCase(citizenName)) {
                            bcontains = true;
                        }
                    }
                    if (bcontains) {
                        System.out.println("User ID already exists in database!");
                        break;
                    }
                    status = "REGISTERED";
                    citizenList.add(new citizen(uniquenumID, status, citizenName, citizenAge));
                    System.out.println("Citizen Name: " + citizenName + ", Age: " + citizenAge + ", Unique ID: " + uniquenumID);
                    break;

                case 4: //Slot registration
                    ArrayList<slot> tempslotArrayList = new ArrayList<slot>();
                    System.out.println("Enter the Hospital ID: (6 Digit ID given at time of registration of hospital) ");
                    //An extra line of code can be inserted which checks that the number of digits is six. But, the condition is checked by equating with the list we already have.
                    int hospitalID = scan.nextInt();
                    boolean scontains = false;
                    int indexOfhospital = 0;
                    for (hospital i : hospitalList) {
                        if (i.getHospitalUID() == hospitalID) {
                            indexOfhospital = hospitalList.indexOf(i);
                            scontains = true;
                        }
                    }
                    if (!scontains) {
                        System.out.println("Hospital ID not in record, Please enter correct ID or register on covin Portal! (press 2 on Menu)..");
                        break;
                    }
                    System.out.println("Enter number of Slots to be added: ");
                    int noOfSlots = scan.nextInt();
                    if (noOfSlots <= 0) {
                        System.out.println("Slots have to be greater than 1! Please try again");
                    }
                    for (int i = 0; i < noOfSlots; i++) {
                        System.out.println("Enter Day Number: ");
                        int dayNumber = scan.nextInt();
                        if (dayNumber <= 0) {
                            System.out.println("Day number is greater than zero!");
                            break;
                        }
                        System.out.println("Enter Quantity: ");
                        int quantity = scan.nextInt();
                        if (quantity <= 0) {
                            System.out.println("Quantity has to be greater than zero!");
                            break;
                        }
                        System.out.println("Select Vaccine");
                        int k = 0;
                        for (vaccine j : vaccineList) {
                            System.out.println(k + "." + j.getVaccineName());
                            k++;
                        }
                        int chosenVaccine = scan.nextInt();
                        vaccineList.get(chosenVaccine).getVaccineName();
                        if ((chosenVaccine < 0) && (chosenVaccine < vaccineList.size() - 1)) {
                            System.out.println("Please choose from the given vaccine list (input correct index number )");
                            break;
                        }
                        String slotVaccine = vaccineList.get(chosenVaccine).getVaccineName();
                        String tempVaccineName = vaccineList.get(chosenVaccine).getVaccineName();
                        tempslotArrayList.add(new slot(hospitalID, dayNumber, quantity, tempVaccineName));
                        hospitalList.get(indexOfhospital).setSlotList(tempslotArrayList);
                        System.out.println("Slot added by Hospital " + hospitalID + " for Day: " + dayNumber + ", Available Quantity: " + quantity + " of Vaccine " + tempVaccineName);
                    }
                    break;
                case 5:
                    System.out.println("Unique ID: ");
                    long uniqueID = scan.nextLong();
                    boolean checker = false;
                    int citizenIndex = 0;
                    for (citizen i : citizenList) {
                        if (i.getUniquenumID() == uniqueID) {
                            citizenIndex = citizenList.indexOf(i);
                            checker = true;
                        }
                    }
                    if (!checker) {
                        System.out.println("Unique ID not in citizen data base! Please enter correct ID or register on covin data base");
                        break;
                    }
                    if (citizenList.get(citizenIndex).getCitizenVaccinestatus().equalsIgnoreCase("FULLY VACCINATED")) {
                        System.out.println("Citizen is fully vaccinated!");
                        break;
                    }
                    System.out.println("1. Search by area\n" +
                            "2. Search by Vaccine\n" +
                            "3. Exit");
                    System.out.println("Enter option:");
                    int searchChoice = scan.nextInt();
                    switch (searchChoice) {
                        case 1: //search by area
                            System.out.println("Enter PinCode:");
                            int pincode = scan.nextInt();
                            boolean check1 = false;
                            ArrayList<Integer> storageArray = new ArrayList<Integer>();
                            for (hospital h : hospitalList) {
                                if (h.getHospitalPinCode() == pincode) {
                                    System.out.println(h.getHospitalUID() + " " + h.getHospitalName());
                                    storageArray.add(h.getHospitalUID());
                                    check1 = true;
                                }
                                storageArray.add(0);
                            }
                            if (!check1) {
                                System.out.println("No hospital for this pincode! Please try again with a 6-digit pinCode.");
                                break;
                            }
                            System.out.println("Enter hospital id:");
                            int hID = scan.nextInt();
                            if (!storageArray.contains(hID)) {
                                System.out.println("Please choose hospital from the list of menu of hospitals from you choosen pinCode!");
                                break;
                            }
                            int storageIndex = storageArray.indexOf(hID);
                            ArrayList<slot> icheck = hospitalList.get(storageIndex).getSlotList();
                            ArrayList<Integer> slotchooser = new ArrayList<Integer>();
                            for (int i = 0; i < icheck.size(); i++) {
                                slotchooser.add(i);
                                System.out.println(i + " -> " + "Day: " + icheck.get(i).getSlotdayNumber() + " Available Qty:" + icheck.get(i).getVaccineQuantity() + " Vaccine:" + icheck.get(i).getChoosenVaccine());
                            }
                            System.out.println("Choose Slot: ");
                            int n = scan.nextInt();
                            try {
                                if (!citizenList.get(citizenIndex).getVaccineName().equalsIgnoreCase(icheck.get(n).getChoosenVaccine()) && !(citizenList.get(citizenIndex).getVaccineName().equals(null))) {
                                    System.out.println("You cannot register on a different vaccine");
                                    break;
                                }
                            } catch (Exception e) {
                            }
                            if (!slotchooser.contains(n)) {
                                System.out.println("Please insert correct option from the given menu list. Try again!");
                                break;
                            }
                            if (icheck.get(n).getVaccineQuantity() == 0) {
                                System.out.println("No slots available");
                                break;
                            }
                            int currVaccineIndex = 0;
                            for (vaccine i : vaccineList) {
                                if (i.getVaccineName() == icheck.get(n).getChoosenVaccine()) {
                                    currVaccineIndex = vaccineList.indexOf(i);
                                }
                            }
                            if (icheck.get(n).getSlotdayNumber() == citizenList.get(citizenIndex).getVaccineDueDate()) {
                                System.out.println("You can't book a slot before your due date! Try again!");
                                break;
                            }
                            icheck.get(n).setVaccineQuantity(icheck.get(n).getVaccineQuantity() - 1); //reduce slots by one
                            citizenList.get(citizenIndex).setNoOfDosestaken(citizenList.get(citizenIndex).getNoOfDosestaken() + 1);

                            if (citizenList.get(citizenIndex).getCitizenVaccinestatus().equalsIgnoreCase("REGISTERED")) {
                                citizenList.get(citizenIndex).setCitizenVaccinestatus("PARTIALLY VACCINATED");
                                citizenList.get(citizenIndex).setVaccineName(icheck.get(n).getChoosenVaccine()); //vaccine name updated
                                citizenList.get(citizenIndex).setVaccinePreviousDate(icheck.get(n).getSlotdayNumber()); //previous date
                                citizenList.get(citizenIndex).setVaccineDueDate(vaccineList.get(currVaccineIndex).getGapTime() + icheck.get(n).getSlotdayNumber()); //due date

                            } else if (citizenList.get(citizenIndex).getCitizenVaccinestatus().equalsIgnoreCase("PARTIALLY VACCINATED") && (citizenList.get(citizenIndex).getNoOfDosestaken() == vaccineList.get(currVaccineIndex).getGapTime())) {
                                citizenList.get(citizenIndex).setCitizenVaccinestatus("FULLY VACCINATED");
                            }
                            System.out.println(citizenList.get(citizenIndex).getCitizenName() + " vaccinated with " + icheck.get(n).getChoosenVaccine());
                            break;

                        case 2: //search by vaccine
                            System.out.println("Enter Vaccine name: ");
                            String searchVaccName = scan.next();
                            boolean check2 = false;
                            //check if vaccine name is present in vaccine list (is actually real)
                            ArrayList<Integer> storageArray2 = new ArrayList<Integer>();
                            for (hospital h : hospitalList) {
                                int t = 0;
                                while (t < h.getSlotList().size()) {
                                    if (h.getSlotList().get(t).getChoosenVaccine().equalsIgnoreCase(searchVaccName)) {
                                        System.out.println(h.getHospitalUID() + " " + h.getHospitalName());
                                        storageArray2.add(h.getHospitalUID());
                                        check2 = true;
                                        t++;
                                        continue;
                                    }
                                    t++;
                                    storageArray2.add(0);
                                }
                            }
                            if (!check2) {
                                System.out.println("No hospital for this vaccine! Please try again with a correct vaccine Name .");
                                break;
                            }
                            System.out.println("Enter hospital id:");
                            int hID2 = scan.nextInt();
                            if (!storageArray2.contains(hID2)) {
                                System.out.println("Please choose hospital from the list of menu of hospitals! (enter correct ID)");
                                break;
                            }
                            int storageIndex2 = storageArray2.indexOf(hID2);

                            ArrayList<slot> icheck2 = hospitalList.get(storageIndex2).getSlotList();
                            ArrayList<Integer> slotchooser2 = new ArrayList<Integer>();
                            for (int i = 0; i < icheck2.size(); i++) {
                                slotchooser2.add(i);
                                System.out.println(i + " -> " + "Day: " + icheck2.get(i).getSlotdayNumber() + " Available Qty:" + icheck2.get(i).getVaccineQuantity() + " Vaccine:" + icheck2.get(i).getChoosenVaccine());
                            }
                            System.out.println("Choose Slot: ");
                            int na = scan.nextInt();
                            try {
                                if (!citizenList.get(citizenIndex).getVaccineName().equalsIgnoreCase(icheck2.get(na).getChoosenVaccine()) && !(citizenList.get(citizenIndex).getVaccineName().equals(null))) {
                                    System.out.println("You cannot register on a different vaccine");
                                    break;
                                }
                            } catch (Exception e) {
                            }
                            if (!slotchooser2.contains(na)) {
                                System.out.println("Please insert correct option from the given menu list. Try again!");
                                break;
                            }
                            if (icheck2.get(na).getVaccineQuantity() == 0) {
                                System.out.println("No slots available");
                                break;
                            }
                            int currVaccineIndex2 = 0;
                            for (vaccine i : vaccineList) {
                                if (i.getVaccineName() == icheck2.get(na).getChoosenVaccine()) {
                                    currVaccineIndex2 = vaccineList.indexOf(i);
                                }
                            }
                            if (icheck2.get(na).getSlotdayNumber() == citizenList.get(citizenIndex).getVaccineDueDate()) {
                                System.out.println("You can't book a slot before your due date! Try again!");
                                break;
                            }
                            icheck2.get(na).setVaccineQuantity(icheck2.get(na).getVaccineQuantity() - 1); //reduce slots by one
                            citizenList.get(citizenIndex).setNoOfDosestaken(citizenList.get(citizenIndex).getNoOfDosestaken() + 1);

                            if (citizenList.get(citizenIndex).getCitizenVaccinestatus().equalsIgnoreCase("REGISTERED")) {
                                citizenList.get(citizenIndex).setCitizenVaccinestatus("PARTIALLY VACCINATED");
                                citizenList.get(citizenIndex).setVaccineName(icheck2.get(na).getChoosenVaccine()); //vaccine name updated
                                citizenList.get(citizenIndex).setVaccinePreviousDate(icheck2.get(na).getSlotdayNumber()); //previous date
                                citizenList.get(citizenIndex).setVaccineDueDate(vaccineList.get(currVaccineIndex2).getGapTime() + icheck2.get(na).getSlotdayNumber()); //due date

                            } else if (citizenList.get(citizenIndex).getCitizenVaccinestatus().equalsIgnoreCase("PARTIALLY VACCINATED") && (citizenList.get(citizenIndex).getNoOfDosestaken() == vaccineList.get(currVaccineIndex2).getGapTime())) {
                                citizenList.get(citizenIndex).setCitizenVaccinestatus("FULLY VACCINATED");
                            }
                            System.out.println(citizenList.get(citizenIndex).getCitizenName() + " vaccinated with " + icheck2.get(na).getChoosenVaccine());
                            break;
                        case 3:
                            break;
                        default:
                            System.out.println("Please Choose correct option from menu (1, 2, 3)");

                    }
                    break;
                case 6: //hospital slots
                    System.out.println("Enter hospital id:");
                    int hID2 = scan.nextInt();
                    boolean check3 = false;
                    ArrayList<Integer> storageArray3 = new ArrayList<Integer>();
                    for (hospital h : hospitalList) {
                        if (h.getHospitalUID() == hID2) {
                            storageArray3.add(h.getHospitalUID());
                            check3 = true;
                        }
                        storageArray3.add(0);
                    }
                    if (!check3) {
                        System.out.println("No hospital for this UID! Please try again with a 6-digit UID which was alloted to you.");
                        break;
                    }
                    int storageIndex3 = storageArray3.indexOf(hID2);
                    ArrayList<slot> icheck3;
                    try {
                        icheck3 = hospitalList.get(storageIndex3).getSlotList();
                    } catch (Exception e) {
                        break;
                    }

                    for (int i = 0; i < icheck3.size(); i++) {
                        System.out.println(i + " -> " + "Day: " + icheck3.get(i).getSlotdayNumber() + " Available Qty:" + icheck3.get(i).getVaccineQuantity() + " Vaccine:" + icheck3.get(i).getChoosenVaccine());
                    }
                    break;
                case 7:
                    System.out.println("Unique ID: ");
                    long uniqueID1 = scan.nextLong();
                    boolean checker1 = false;
                    int citizenIndex1 = 0;
                    for (citizen i : citizenList) {
                        if (i.getUniquenumID() == uniqueID1) {
                            citizenIndex1 = citizenList.indexOf(i);
                            checker1 = true;
                        }
                    }
                    if (!checker1) {
                        System.out.println("Unique ID not in citizen data base! Please enter correct ID or register on covin data base");
                        break;
                    }
                    System.out.println(citizenList.get(citizenIndex1).getCitizenVaccinestatus());
                    if (citizenList.get(citizenIndex1).getCitizenVaccinestatus().equalsIgnoreCase("REGISTERED")){
                        break;
                    }
                    System.out.println("Vaccine Given: " + citizenList.get(citizenIndex1).getVaccineName());
                    System.out.println("Number of Doses given: " + citizenList.get(citizenIndex1).getNoOfDosestaken());
                    if (citizenList.get(citizenIndex1).getCitizenVaccinestatus().equalsIgnoreCase("PARTIALLY VACCINATED")) {
                        System.out.println("Next Dose due date: " + citizenList.get(citizenIndex1).getVaccineDueDate());
                    }
                    break;
                case 8: //exit
                    System.out.println("Thank you for using Covin! Good bye :)");
                    bool = false;
                    break;
                default:
                    System.out.println("Please enter the Correct option from the menu!");
            }
            }
        }


    public static void main(String[] args) {
        Menu();
    }
}

