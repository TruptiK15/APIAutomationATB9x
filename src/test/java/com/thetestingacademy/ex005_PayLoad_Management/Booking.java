package com.thetestingacademy.ex005_PayLoad_Management;

import java.util.LinkedHashMap;
import java.util.Map;

public class Booking {

    //POJO will have only Attributes and getter setters
    //for reusability
    private String firstname;
    private String lastname;
    private int totalprice;
    private boolean depositpaid;
    private String additonalneeds;
    private BookingDates bookingdates;   //class

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getAdditonalneeds() {
        return additonalneeds;
    }

    public void setAdditonalneeds(String additonalneeds) {
        this.additonalneeds = additonalneeds;
    }

    public boolean isDepositpaid() {
        return depositpaid;
    }

    public void setDepositpaid(boolean depositpaid) {
        this.depositpaid = depositpaid;
    }

    public int getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(int totalprice) {
        this.totalprice = totalprice;
    }

    public String getLastname() {
        return lastname;
    }

    public BookingDates getBookingdates() {
        return bookingdates;
    }

    public void setBookingdates(BookingDates bookingdates) {
        this.bookingdates = bookingdates;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;


    }
}
