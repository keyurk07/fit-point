import { Component } from '@angular/core';
import { CardioService } from '../cardio.service';

@Component({
  selector: 'app-cardio',
  templateUrl: './cardio.component.html',
  styleUrls: ['./cardio.component.css']
})
export class CardioComponent {
  currentDate: Date;
  calories: number | null = null;
  exerciseType: string = '';
  distance: number = 0;
  time: number = 0;

  exercises: { exerciseType: string; distance: number; timeSpent: number }[] = [];

  constructor(private cardioservice: CardioService) {
    this.currentDate = new Date();
  }

  ngOnInit(): void {
    this.loadExercises();
  }

  loadExercises(): void {
    this.cardioservice.getAllExercises().subscribe(
      (data) => {
        this.exercises = data;
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
    if (this.exerciseType && this.distance > 0 && this.time > 0) {
      this.exercises.push({
        exerciseType: this.exerciseType,
        distance: this.distance,
        timeSpent: this.time
      });
      console.log("exercise added!");
      
      this.cardioservice.add(this.exerciseType, this.distance, this.time);
      this.exerciseType = '';
      this.distance = 0;
      this.time = 0;
    } else {
      console.log("please enter valid details in fields");
    }
  }

  showCalories() {
    if (this.exerciseType && this.distance > 0 && this.time > 0) {
      this.cardioservice.calc(this.exerciseType, this.distance, this.time).subscribe(
        response => {
          this.calories = response;
          console.log(`Calories calculated: ${this.calories} kcal`);
        },
        error => {
          console.error("Error calculating calories", error);
        }
      );
    } else {
      console.log("Please enter valid values for exercise type, distance, and time.");
      this.calories = null;
    }
  }
}
