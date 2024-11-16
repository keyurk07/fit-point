import { Component } from '@angular/core';

@Component({
  selector: 'app-diet',
  templateUrl: './diet.component.html',
  styleUrls: ['./diet.component.css']
})
export class DietComponent {
  currentDate: Date;
  constructor() {
    this.currentDate = new Date();
    
  }
  goToPreviousDay() {
    this.currentDate.setDate(this.currentDate.getDate() - 1);
    this.currentDate = new Date(this.currentDate);
  }

  
  goToNextDay() {
    this.currentDate.setDate(this.currentDate.getDate() + 1);
    this.currentDate = new Date(this.currentDate);
  }
  mealType: string = 'Breakfast';  // Default meal type
  dishName: string = '';
  amount: number | null = null;
  noOfItems: number | null = null;
  meals: { dishName: string, calories: number }[] = [];  // Store meals data

  // Set the meal type (Breakfast, Lunch, or Dinner)
  setMealType(type: string) {
    this.mealType = type;
    this.dishName = '';
    this.amount = null;
    this.noOfItems = null;
  }

  // Calculate calories (simple example: calories = amount * 0.2 for each item)
  calculateCalories(): number {
    if (this.amount && this.noOfItems) {
      return this.amount * this.noOfItems * 0.2;  // You can change the formula as needed
    }
    return 0;
  }

  // Add meal entry and display it on the right
  addMeal() {
    if (this.dishName && this.amount && this.noOfItems) {
      const calories = this.calculateCalories();
      this.meals.push({
        dishName: this.dishName,
        calories: calories
      });

      // Clear form after submission
      this.dishName = '';
      this.amount = null;
      this.noOfItems = null;
    }
  }

}
