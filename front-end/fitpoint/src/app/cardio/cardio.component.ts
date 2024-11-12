import { Component } from '@angular/core';

@Component({
  selector: 'app-cardio',
  templateUrl: './cardio.component.html',
  styleUrls: ['./cardio.component.css']
})
export class CardioComponent {
  currentDate: Date;

  constructor() {
    this.currentDate = new Date(); // Set the initial date to today's date
  }
  ngOnInit(): void {
    throw new Error('Method not implemented.');
  }

  // Navigate to the previous day
  goToPreviousDay() {
    this.currentDate.setDate(this.currentDate.getDate() - 1);
    this.currentDate = new Date(this.currentDate); // Reassign to trigger Angular's change detection
  }

  // Navigate to the next day
  goToNextDay() {
    this.currentDate.setDate(this.currentDate.getDate() + 1);
    this.currentDate = new Date(this.currentDate); // Reassign to trigger Angular's change detection
  }

  // Method to handle "Add Exercise" button click
  addExercise() {
    // Implement the logic for adding an exercise
    console.log("Exercise added!");
  }

  // Method to handle "Show Calories" button click
  showCalories() {
    // Implement the logic for showing calories burned
    console.log("Calories displayed!");
  }

}
