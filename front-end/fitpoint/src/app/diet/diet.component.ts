import { Component } from '@angular/core';

@Component({
  selector: 'app-diet',
  templateUrl: './diet.component.html',
  styleUrls: ['./diet.component.css']
})
export class DietComponent {
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


}
