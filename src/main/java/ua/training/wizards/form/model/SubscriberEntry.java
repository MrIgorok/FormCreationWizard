package ua.training.wizards.form.model;

import java.util.Date;

public class SubscriberEntry {
    private String surname;
    private String firstName;
    private String patronymic;
    private String fullName;
    private String nickname;
    private String comment;
    private SubscriberGroup group;
    private String phoneNumberHome;
    private String phoneNumberMobile;
    private String phoneNumberMobileSecond;
    private String email;
    private String skypeName;
    private Address address;
    private String fullAddress;
    private Date timestampEntryCreation;
    private Date timestampLastModification;

    public SubscriberEntry() {

    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public SubscriberGroup getGroup() {
        return group;
    }

    public void setGroup(SubscriberGroup group) {
        this.group = group;
    }

    public String getPhoneNumberHome() {
        return phoneNumberHome;
    }

    public void setPhoneNumberHome(String phoneNumberHome) {
        this.phoneNumberHome = phoneNumberHome;
    }

    public String getPhoneNumberMobile() {
        return phoneNumberMobile;
    }

    public void setPhoneNumberMobile(String phoneNumberMobile) {
        this.phoneNumberMobile = phoneNumberMobile;
    }

    public String getPhoneNumberMobileSecond() {
        return phoneNumberMobileSecond;
    }

    public void setPhoneNumberMobileSecond(String phoneNumberMobileSecond) {
        this.phoneNumberMobileSecond = phoneNumberMobileSecond;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSkypeName() {
        return skypeName;
    }

    public void setSkypeName(String skypeName) {
        this.skypeName = skypeName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getFullAddress() {
        return fullAddress;
    }

    public void setFullAddress(String fullAddress) {
        this.fullAddress = fullAddress;
    }

    public Date getTimestampEntryCreation() {
        return timestampEntryCreation;
    }

    public void setTimestampEntryCreation(Date timestampEntryCreation) {
        this.timestampEntryCreation = timestampEntryCreation;
    }

    public Date getTimestampLastModification() {
        return timestampLastModification;
    }

    public void setTimestampLastModification(Date timestampLastModification) {
        this.timestampLastModification = timestampLastModification;
    }
}
