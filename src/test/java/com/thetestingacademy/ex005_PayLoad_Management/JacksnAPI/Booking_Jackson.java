package com.thetestingacademy.ex005_PayLoad_Management.JacksnAPI;
import java.util.LinkedHashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonPropertyOrder({
            "firstname",
            "lastname",
            "totalprice",
            "depositpaid",
            "bookingdates",
            "additionalneeds"
    })
    public class Booking_Jackson {

        @JsonProperty("firstname")
        private String firstname;
        @JsonProperty("lastname")
        private String lastname;
        @JsonProperty("totalprice")
        private Integer totalprice;
        @JsonProperty("depositpaid")
        private Boolean depositpaid;
        @JsonProperty("bookingdates")
        private Bookingdates_Jackson bookingdates_jack;
        @JsonProperty("additionalneeds")
        private String additionalneeds;
        @JsonIgnore
        private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

        @JsonProperty("firstname")
        public String getFirstname() {
            return firstname;
        }

        @JsonProperty("firstname")
        public void setFirstname(String firstname) {
            this.firstname = firstname;
        }

        @JsonProperty("lastname")
        public String getLastname() {
            return lastname;
        }

        @JsonProperty("lastname")
        public void setLastname(String lastname) {
            this.lastname = lastname;
        }

        @JsonProperty("totalprice")
        public Integer getTotalprice() {
            return totalprice;
        }

        @JsonProperty("totalprice")
        public void setTotalprice(Integer totalprice) {
            this.totalprice = totalprice;
        }

        @JsonProperty("depositpaid")
        public Boolean getDepositpaid() {
            return depositpaid;
        }

        @JsonProperty("depositpaid")
        public void setDepositpaid(Boolean depositpaid) {
            this.depositpaid = depositpaid;
        }

        @JsonProperty("bookingdates")
        public Bookingdates_Jackson getBookingdates() {
            return bookingdates_jack;
        }

        @JsonProperty("bookingdates")
        public void setBookingdates(Bookingdates_Jackson bookingdates_jack) {
            this.bookingdates_jack = bookingdates_jack;
        }

        @JsonProperty("additionalneeds")
        public String getAdditionalneeds() {
            return additionalneeds;
        }

        @JsonProperty("additionalneeds")
        public void setAdditionalneeds(String additionalneeds) {
            this.additionalneeds = additionalneeds;
        }

        @JsonAnyGetter
        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        @JsonAnySetter
        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }
}
