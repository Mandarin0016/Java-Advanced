package workout;

import java.util.ArrayList;
import java.util.List;

public class Workout {
    private String type;
    private int exerciseCount;
    private List<Exercise> exercises;

    public Workout(String type, int exerciseCount) {
        this.type = type;
        this.exerciseCount = exerciseCount;
        this.exercises = new ArrayList<>();
    }

    public void addExercise(Exercise exercise) {
        if (this.exercises.size() < exerciseCount) {
            this.exercises.add(exercise);
        }
    }

    public boolean removeExercise(String name, String muscle) {
        for (Exercise currentExercise : this.exercises) {
            if (currentExercise.getName().equals(name) && currentExercise.getMuscle().equals(muscle)) {
                this.exercises.remove(currentExercise);
                return true;
            }
        }
        return false;
    }

    public Exercise getExercise(String name, String muscle) {
        for (Exercise currentExercise : this.exercises) {
            if (currentExercise.getName().equals(name) && currentExercise.getMuscle().equals(muscle)) {
                return currentExercise;
            }
        }
        return null;
    }

    public Exercise getMostBurnedCaloriesExercise() {
        if (!this.exercises.isEmpty()) {
            Exercise mostBurnedCalExercise = this.exercises.get(0);
            for (Exercise currentExercise : this.exercises) {
                if (currentExercise.getBurnedCalories() > mostBurnedCalExercise.getBurnedCalories()) {
                    mostBurnedCalExercise = currentExercise;
                }
            }
            return mostBurnedCalExercise;
        }
        return null;
    }

    public int getExerciseCount(){
        return this.exercises.size();
    }

    public String getStatistics(){
        StringBuilder result = new StringBuilder();
        result.append(String.format("Workout type: %s", this.type));
        this.exercises.forEach(exercise -> result.append(System.lineSeparator()).append(exercise));
        return result.toString();
    }

}
