import { Component } from '@angular/core';

@Component({
  selector: 'app-diet',
  templateUrl: './diet.component.html',
  styleUrls: ['./diet.component.css']
})
export class DietComponent {
  currentDate: Date = new Date();
  selectedMeal: string = 'breakfast'; // Default meal is breakfast
  calories: number = 0;
  mealEntries: any[] = [];
  showEntries: boolean = false; // Flag to toggle meal entries display
  
  // This method will allow navigating to the previous day
  goToPreviousDay(): void {
    this.currentDate.setDate(this.currentDate.getDate() - 1);
  }

  // This method will allow navigating to the next day
  goToNextDay(): void {
    this.currentDate.setDate(this.currentDate.getDate() + 1);
  }

  // This method is used to select a meal (Breakfast, Lunch, or Dinner)
  selectMeal(meal: string): void {
    this.selectedMeal = meal;
    this.calories = 0; // Reset calories when meal is changed
  }

  // This method adds a new meal entry to the mealEntries array
  addMeal(): void {
    const foodName = (document.getElementById('food-name') as HTMLInputElement).value;
    const quantity = parseFloat((document.getElementById('quantity') as HTMLInputElement).value);
    const items = parseInt((document.getElementById('items') as HTMLInputElement).value, 10);

    if (foodName && quantity && items) {
      const caloriesPerUnit = this.calculateCaloriesBasedOnMeal(foodName, quantity, items);
      const newMeal = {
        meal: this.selectedMeal,
        foodName,
        quantity,
        items,
        calories: caloriesPerUnit
      };
      this.mealEntries.push(newMeal);
      this.showEntries = true; // Show meal entries after adding a new meal
    }
  }

  // This method calculates the calories based on food, quantity, and items
  calculateCaloriesBasedOnMeal(foodName: string, quantity: number, items: number): number {
    let calorieCount = 0;
    
    if (foodName.toLowerCase() === 'oatmeal') {
      calorieCount = 100 * quantity * items; // Example, 100 calories per unit
    } else if (foodName.toLowerCase() === 'banana') {
      calorieCount = 90 * quantity * items; // Example, 90 calories per unit
    }
    
    return calorieCount;
  }

  // This method calculates the total calories for the selected meal
  calculateCalories(): void {
    const foodName = (document.getElementById('food-name') as HTMLInputElement).value;
    const quantity = parseFloat((document.getElementById('quantity') as HTMLInputElement).value);
    const items = parseInt((document.getElementById('items') as HTMLInputElement).value, 10);

    if (foodName && quantity && items) {
      this.calories = this.calculateCaloriesBasedOnMeal(foodName, quantity, items);
    }
  }
}
