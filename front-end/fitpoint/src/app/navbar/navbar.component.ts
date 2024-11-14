// navbar.component.ts
import { Component } from '@angular/core';
import { navItems } from './navData';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent {
  // constructor(private router: Router) { }
  menuOpen = false; // For the hamburger menu toggle
  navItems = navItems;

  toggleMenu() {
    this.menuOpen = !this.menuOpen;
  }
 
}
