import { Component, OnInit } from '@angular/core';

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

  // Array to store exercises
  exercises: { exerciseType: string; sets: number; reps: number; weight: number; }[] = [];

  constructor() {
    this.currentDate = new Date(); // Initialize with today's date
  }

  ngOnInit(): void {}

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
        weight: this.weight
      });
      console.log("Exercise added!");
      
      // Reset fields after adding
      this.exerciseType = '';
      this.sets = 0;
      this.reps = 0;
      this.weight = 0;
    } else {
      console.log("Please enter valid values for all fields.");
    }
  }

  showCalories() {
    if (this.sets > 0 && this.reps > 0 && this.weight > 0) {
      this.calories = this.calculateCalories(this.sets, this.reps, this.weight);
      console.log(`Calories calculated: ${this.calories} kcal`);
    } else {
      console.log("Please enter valid values for sets, reps, and weight.");
      this.calories = null; // Reset if invalid input
    }
  }

  calculateCalories(sets: number, reps: number, weight: number): number {
    return sets * reps * weight * 0.1; // Example calculation formula
  }
}
