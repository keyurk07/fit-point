import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.css']
})
export class HomepageComponent {
  constructor(private router: Router) { }
  menuOpen: boolean = false;  
  toggleMenu() {
    this.menuOpen = !this.menuOpen;
  }

  
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
