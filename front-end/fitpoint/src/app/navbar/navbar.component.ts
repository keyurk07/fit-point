
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { navItems } from './navData';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent {
  // constructor(private router: Router) { }
  menuOpen = false; 
  navItems = navItems;

  toggleMenu() {
    this.menuOpen = !this.menuOpen;
  }
 
}