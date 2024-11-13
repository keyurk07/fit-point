import { Component, OnInit } from '@angular/core';
import { WeightService } from '../weight.service';

@Component({
  selector: 'app-weight',
  templateUrl: './weight.component.html',
  styleUrls: ['./weight.component.css']
})
export class WeightComponent implements OnInit {
  currentDate: Date;
  calories: number | null = null;
  
  exerciseType: string = '';
  sets: number = 0;
  reps: number = 0;
  weight: number = 0;
 

  // Array to store exercises\nulkl
  exercises: { exerciseType: string; sets: number; reps: number; weight: number; calories:number|null }[] = [];

  constructor(private weightservice: WeightService) {
    this.currentDate = new Date(); // Initialize with today's date
  }

  ngOnInit(): void {
   
this.loadExercises();
  }
  loadExercises(): void {
    this.weightservice.getAllExercises().subscribe(
      (data) => {
        this.exercises = data;  // Populate exercises array with fetched data
        console.log('Fetched exercises:', this.exercises);
      },
      (error) => {
        console.error('Error fetching exercises', error);
      }
    );
  }

  goToPreviousDay() {
    this.currentDate.setDate(this.currentDate.getDate() - 1);
    this.currentDate = new Date(this.currentDate);
  }

  goToNextDay() {
    this.currentDate.setDate(this.currentDate.getDate() + 1);
    this.currentDate = new Date(this.currentDate);
  }

  addExercise() {
    if (this.exerciseType && this.sets > 0 && this.reps > 0 && this.weight > 0) {
      // Add exercise to the list
      this.exercises.push({
        exerciseType: this.exerciseType,
        sets: this.sets,
        reps: this.reps,
        weight: this.weight,
        calories:this.calories
      });
      console.log("Exercise added!");
      

      this.weightservice.add(this.exerciseType, this.sets, this.reps,this.weight);
      this.exerciseType = '';
      this.sets = 0;
      this.reps = 0;
      this.weight = 0;

      if (this.exerciseType && this.sets > 0 && this.reps > 0 && this.weight > 0) {
        this.weightservice.calc(this.exerciseType, this.sets, this.reps, this.weight).subscribe(
          response => {
            this.calories = response;
          },
          error => {
            console.error("Error calculating calories", error);
          }
        );
      } else {
        console.log("Please enter valid values for exercise type, distance, and time.");
        this.calories = null;
      }
    } else {
      console.log("Please enter valid values for all fields.");
    }
  }

  showCalories() {
    if (this.exerciseType && this.sets > 0 && this.reps > 0 && this.weight > 0) {
      this.weightservice.calc(this.exerciseType, this.sets, this.reps, this.weight).subscribe(
        response => {
          this.calories = response; // Set the calories value based on response
          console.log(`Calories calculated: ${this.calories} kcal`);
        },
        error => {
          console.error("Error calculating calories", error);
        }
      );
    } else {
      console.log("Please enter valid values for exercise type, distance, and time.");
      this.calories = null; // Reset if invalid input
    }
  }

  // calculateCalories(sets: number, reps: number, weight: number): number {
  //   return sets * reps * weight * 0.1; 
  // }
}
