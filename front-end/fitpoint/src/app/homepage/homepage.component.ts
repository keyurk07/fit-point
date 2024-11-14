import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.css']
})
export class HomepageComponent {
  constructor(private router: Router) { }
  menuOpen: boolean = false;  // Flag to toggle menu visibility

  // Toggle menu visibility when hamburger icon is clicked
  toggleMenu() {
    this.menuOpen = !this.menuOpen;
  }

  
  // Method to navigate to the 'food' route when the clickable area is clicked
  navigateToFood() {
    this.router.navigate(['/food']);
  }
  navigateToExercise() {
    this.router.navigate(['/exercise']);
  }

  navigateToReport() {
    this.router.navigate(['/report']);
  }


}
