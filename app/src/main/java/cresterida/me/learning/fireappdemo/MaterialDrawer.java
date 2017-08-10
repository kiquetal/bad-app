package cresterida.me.learning.fireappdemo;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;

import it.neokree.materialnavigationdrawer.MaterialNavigationDrawer;
import it.neokree.materialnavigationdrawer.elements.MaterialAccount;
import it.neokree.materialnavigationdrawer.elements.MaterialSection;
import it.neokree.materialnavigationdrawer.elements.listeners.MaterialSectionListener;

/**
 * Created by kiquetal on 8/9/17.
 */

public class MaterialDrawer extends MaterialNavigationDrawer {
    @Override
    public void init(Bundle savedInstanceState) {

        MaterialSection section = newSection("Extintores", BitmapFactory.decodeResource(getResources(),R.drawable.fire_extinguisher), new FragmentFake());


        MaterialAccount account3 = new MaterialAccount(this.getResources(),"Example","example@example.com",R.drawable.guru,R.drawable.mat2);
        this.addAccount(account3);


        MaterialSection sectionCodes=newSection("Códigos",BitmapFactory.decodeResource(getResources(),R.drawable.radio),new Intent(this,MainActivity.class));
        sectionCodes.setSectionColor(Color.parseColor("#03a9f4"));
        addSection(section);
        addSection(sectionCodes);
        this.addAccountSection(newSection("Account settings",R.drawable.fire_extinguisher,new MaterialSectionListener() {
            @Override
            public void onClick(MaterialSection section) {
                Toast.makeText(MaterialDrawer.this,"Account settings clicked",Toast.LENGTH_SHORT).show();

                // for default section is selected when you click on it
                section.unSelect(); // so deselect the section if you want
            }
        }));


    }
}
