package com.example.barry.firestorerecyclerviewui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

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
 *      res > new > Android Resourse directory > Change Resource Type to: menu, Dir name: menu > Ok
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
 * 2. create a new layout view "note_item.xml" for the recycler items
 *      - make the root a card view
 *
 * 3. create a new java class Note
 * ==================================================================
 *
 * Part 3: Create a Recycler view adapter
 * https://youtu.be/lAGI6jGS4vs?list=PLrnPJCHvNZuAXdWxOzsN5rgG2M4uJ8bH1
 * dependences : https://github.com/firebase/FirebaseUI-Android
 *
 *1. Create a new java class: The adapter is what gets our data from the data source into our recycler
 *      - Name "NoteAdapter"
 *      - Superclass: have it extend "FirestoreRecycleAdapter" (start typing in the space and select)
 *      - Ok
 *
 * 2. Ignore the error for now,
 *      Create the ViewHolder class "NoteHolder" inside the NoteAdapter class
 *      Have it extend RecyclerView.ViewHolder
 *      alt + enter > create superclass to fix the new redline
 *
 * 3. Declare the views in the "public class NoteHolder" viewHolder
 *
 * 4. Assign this variables in the constructor of our viewHolder:
 *      public NoteHolder(View itemView)
 *
 * ......
 * 8. Come back here to MainActivity and connect our Adapter to our RecyclerView
 *      declare the var FirebaseFirestore db, CollectionReference noteRef, NoteAdapter adapter
 *
 * 9. Create a method "setUpRecyclerView()" to connect our Adapter to RecyclerView
 *      and call the method in onCreate()
 *
 * 10. Tell the recycler when to start and when to stop
 *      - create onStart()
 *      - and onStop()
 *      check at github for more other things we can do
 *
 */
public class MainActivity extends AppCompatActivity {

    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference notebookRef =  db.collection("Notebook");

    private NoteAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //9.0 call the method to connect our Adapter to RecyclerView
        setUpRecyclerView();
    }

    //9.1 create the method to connect our Adapter to RecyclerView
    private void setUpRecyclerView() {

        Query query = notebookRef.orderBy("priority", Query.Direction.DESCENDING);

        // get the query in to the adapter
        FirestoreRecyclerOptions<Note> options = new FirestoreRecyclerOptions.Builder<Note>()
                .setQuery(query, Note.class)
                .build();

        // pass the options to the adapter
        adapter = new NoteAdapter(options);

        // ref our recycler view
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true); // for performance reasons
        recyclerView.setLayoutManager(new LinearLayoutManager(this));  // pass layout mgr
        recyclerView.setAdapter(adapter); // set the adapter to the recycler view
    }

    @Override
    protected void onStart() { // when app goes to foreground it starts listening,
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() { // when app goes to background it stops listening, saves resources
        super.onStop();
        adapter.stopListening();
    }
}
