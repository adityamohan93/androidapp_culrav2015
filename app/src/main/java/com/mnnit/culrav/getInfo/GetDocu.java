package com.mnnit.culrav.getInfo;

import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Vishal Raj on 3/21/2015.
 */
public class GetDocu {
    String[] subEvents = null;
    String[] contactName = null;
    String[] eventDesc = null;
    String[] phone = null;
    String[] email = null;

    public GetDocu(Context c, String name) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(
                    new InputStreamReader(c.getAssets().open(name.toLowerCase() + ".txt"), "UTF-8"));
            subEvents = new String[Integer.parseInt(reader.readLine())];
            eventDesc = new String[subEvents.length];
            for (int i = 0; i < subEvents.length; i++)
                subEvents[i] = reader.readLine();
            contactName = new String[Integer.parseInt(reader.readLine())];
            phone = new String[contactName.length];
            email = new String[contactName.length];
            for (int i = 0; i < contactName.length; i++) {
                contactName[i] = reader.readLine();
                phone[i] = reader.readLine();
                email[i] = reader.readLine();
            }
            for (int i = 0; i < subEvents.length; i++)
                eventDesc[i] = reader.readLine();
        } catch (IOException e) {
            //log the exception
        }
    }

    public String[] getPhone() {
        return phone;
    }

    public String[] getEmail() {
        return email;
    }

    public String[] getcontactName() {
        return contactName;
    }

    public String[] getSubEvents() {
        return subEvents;
    }


    public String[] getEventDesc() {
        return eventDesc;
    }

}
