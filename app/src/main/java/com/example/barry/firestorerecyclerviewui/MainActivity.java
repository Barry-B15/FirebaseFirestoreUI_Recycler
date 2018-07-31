package com.example.barry.firestorerecyclerviewui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 * Part 1: https://youtu.be/ub6mNHWGVHw?list=PLrnPJCHvNZuAXdWxOzsN5rgG2M4uJ8bH1
 * Set up
 * 1. Create new project
 * 2. Connect to Firebase Firestore
 *      - Tools > Firebase > Firestore > Read and write doc > Connect to Firebase >
 *          Select project or create a new project > Ok
 *
 *      - Add Cloud Firestore to app > accept Changes > wait for it to complete (turns green)
 * 3. Update dependences
 *      - Gradle.Project > update to latest: classpath 'com.google.gms:google-services:3.2.0'
 *      - Gradle.app > add
 *              // FirebaseUI for Cloud Firestore
 *              implementation 'com.firebaseui:firebase-ui-firestore:4.1.0'
 *
 *              delete: (the above one takes care of all)
 *              //implementation 'com.google.firebase:firebase-firestore:17.0.4'
 *
 *         - Fix other errors that may arise
 * 4. Add icons to drawable
 *      res > drawable > vector asset > select
 *
 * 5. Create a menu folder
 *      res > new > Android Resourse directory > Change Resource Type to: menu, Dir name: Menu > Ok
 *
 * 6. Create a menu file
 *      - res > right click menu > File name : new_note_menu > Ok
 *      - add the save_note item to it
 *
 * 7. Go to Firestore and create a db
 *      Firestore Console > select project > database > Cloud Firestore DB (not the realtime DB)
 *      > Create database > select Start in test mode since we're not using Auth > Enable
 *====================================================================
 *
 * Part 2: https://youtu.be/RFFu3dP5JDk?list=PLrnPJCHvNZuAXdWxOzsN5rgG2M4uJ8bH1
 * 1. In main.xml, remove the auto-created textView
 *      - Change the root layout to CoordinatorLayout
 *      - add a recyclerView
 *      - add a floating bar button
 * 2. create a new layout view for the recycler items
 *      - make the root a card view
 *
 * 3. create a new java class Note
 *
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
