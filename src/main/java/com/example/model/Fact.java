package com.example.model;

public class Fact {
    private String name;
    private long income;
    private int age;
    private long tax;

    public String getName(){
        return name;
    }
    public long getIncome(){
        return income;
    }
    public int getAge(){
        return age;
    }
    public long getTax(){
        return tax;
    }
    public void setTax(long tax){
        this.tax=tax;
    }
    public Fact(String name, long income, int age){
        this.name=name;
        this.income=income;
        this.age=-age;
    }

}

