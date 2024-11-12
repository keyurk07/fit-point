import { Component } from '@angular/core';
import { CardioService } from '../cardio.service';

@Component({
  selector: 'app-cardio',
  templateUrl: './cardio.component.html',
  styleUrls: ['./cardio.component.css']
})
export class CardioComponent {
  currentDate: Date;
  calories: number | null = null; // Store the calculated calories

  exerciseType: string = ''; // Default exercise type for cardio
  distance: number = 0;
  time: number = 0; // Time in minutes

  exercises:{exerciseType:string;distance:number;time:number}[]=[];

  constructor(private cardioservice:CardioService) {
    this.currentDate = new Date(); // Initialize with today's date
    
  }

  ngOnInit(): void {
    // Initial setup or data fetch if required
  }

  // Navigate to previous day
  goToPreviousDay() {
    this.currentDate.setDate(this.currentDate.getDate() - 1);
    this.currentDate = new Date(this.currentDate);
  }

  // Navigate to next day
  goToNextDay() {
    this.currentDate.setDate(this.currentDate.getDate() + 1);
    this.currentDate = new Date(this.currentDate);
  }

  // Add cardio exercise handler
  addExercise() {
    if(this.exerciseType&&this.distance>0&&this.time>0){
      this.exercises.push({
        exerciseType:this.exerciseType,
        distance:this.distance,
        time:this.time
      });
      console.log("exercise added!");
      
      this.cardioservice.add(this.exerciseType, this.distance, this.time);
      this.exerciseType='';
      this.distance=0;
      this.time=0;
    }else{
      console.log("please enter valid details in fields");
    }
  }

  // Show calories handler
  showCalories() {
    // Ensure the inputs are valid
    if (this.distance > 0 && this.time > 0) {
      this.calories = this.calculateCalories(this.distance, this.time);
      console.log(`Calories calculated: ${this.calories} kcal`);
    } else {
      console.log("Please enter valid values for distance and time.");
      this.calories = null; // Reset if invalid input
    }
  }

  // Calculate calories based on inputs
  calculateCalories(distance: number, time: number): number {
    // Example formula: calories = (distance in km * 50) + (time in minutes * 5)
    return (distance * 50) + (time * 5); // Simplified calculation
  }
}
