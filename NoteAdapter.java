package com.example.barry.firestorerecyclerviewui;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

/**1. create this Adapter
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
 * 5. add angular bracket < > to the 1st line with the red
 *      in a normal recyclerclass we will pass the class name of the view holder here but,
 *      in the Firestore recycler, we pass the name of our model class:
 *      "Note" (the one with our package name), and "NoteHolder"
 *
 *      - implement the method and this will create
 *              onBindViewHolder() and NoteHolder onCreateViewHolder()
 *
 *      - alt enter the red line again > create matching constructor
 *      - may delete the comment accompaying the super class
 *
 * 6. In the onBindView holder we tell the adapter what we want to put in each view in our card layout
 *      say: holder.textViewTitle.settext(model.getTitle())
 *      tell the adapter to put the title of our Note into the textViewTitle view
 *
 * 7. In onCreateViewHolder "NoteHolder onCreateViewHolder", we tell the adapter which layout to inflate
 *
 * 8. Go to MainActivity and connect our Adapter to our RecyclerView
 */
public class NoteAdapter extends FirestoreRecyclerAdapter<Note, NoteAdapter.NoteHolder> {


    public NoteAdapter(@NonNull FirestoreRecyclerOptions<Note> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull NoteHolder holder, int position, @NonNull Note model) {

        //6. tell the adapter to put the "title" (data) of our Note into the textViewTitle (views)
        holder.textViewTitle.setText(model.getTitle());
        holder.textViewDescription.setText(model.getDescription());
        holder.textViewPriority.setText(String.valueOf(model.getPriority()));
    }

    @NonNull
    @Override
    public NoteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        // 7. tell the adapter which layout to inflate
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.note_item,
                parent, false);
        return new NoteHolder(v);
        //return null;
    }

    //2. Create the ViewHolder class "NoteHolder", have it extend RecyclerView.ViewHolder
    class NoteHolder extends RecyclerView.ViewHolder {

        // 3. Declare the views
        TextView textViewTitle;
        TextView textViewDescription;
        TextView textViewPriority;

        //2.1 fix for red line
        public NoteHolder(View itemView) {
            super(itemView);

            //4. Assign this variables in the constructor of our viewHolder:
            textViewTitle = itemView.findViewById(R.id.text_view_title);
            textViewDescription = itemView.findViewById(R.id.text_view_description);
            textViewPriority = itemView.findViewById(R.id.text_view_priority);
        }
    }

}
