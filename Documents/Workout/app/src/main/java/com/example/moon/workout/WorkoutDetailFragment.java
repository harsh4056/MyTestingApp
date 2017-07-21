package com.example.moon.workout;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


public class WorkoutDetailFragment extends Fragment {

    private long workoutId;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if(savedInstanceState!=null){
        //    workoutId=savedInstanceState.getLong("workoutId");
            }
        return inflater.inflate(R.layout.fragment_workout_detail, container, false);
    }

    @Override
    public void onStart(){
        Toast.makeText(getContext(),"onStart method executed"+workoutId,Toast.LENGTH_SHORT).show();
        super.onStart();


        View view =getView();
        if(view!=null){
            TextView title =  view.findViewById(R.id.textTitle);
            Workout workout = Workout.workouts[(int) workoutId];
            title.setText(workout.getName());
            TextView description = view.findViewById(R.id.textDescription);
            description.setText(workout.getDescription());
        }






    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
     //   savedInstanceState.putLong("workoutId",workoutId);
    }
    public void setWorkoutId(long workoutId) {

        Toast.makeText(getContext(),"Setting Id method executed" + workoutId,Toast.LENGTH_SHORT).show();
        this.workoutId = workoutId;
    }
}
