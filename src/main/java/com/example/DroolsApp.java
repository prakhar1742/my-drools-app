package com.example;

import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import java.util.*;

import com.example.model.*;

public class DroolsApp {
    public static void main(String[] args) {    
        KieServices ks = KieServices.Factory.get();

        // Create a KieFileSystem and add the DRL file
        KieFileSystem kfs = ks.newKieFileSystem();
        kfs.write("src/main/resources/rules.drl", ks.getResources().newClassPathResource("rules.drl"));

        // Build the KieContainer
        KieBuilder kb = ks.newKieBuilder(kfs);
        kb.buildAll();
        KieContainer kContainer = ks.newKieContainer(kb.getKieModule().getReleaseId());

        // Create a KieSession


        KieSession kSession = kContainer.newKieSession();

        // Insert facts into the session
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter your name");
        String name=sc.next();
        System.out.println("Enter your age");

        int age=sc.nextInt();
        System.out.println("Enter your income");

        long income=sc.nextLong();
        Fact fact=new Fact(name,income,age);
        kSession.insert(fact);

        // Fire the rules
        kSession.fireAllRules();

        // Dispose the session
        kSession.dispose();
        sc.close();

        System.out.println(fact.getName()+" your net tax is "+fact.getTax());
    }
    
}