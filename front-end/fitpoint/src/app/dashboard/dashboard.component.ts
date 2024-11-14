// dashboard.component.ts
import { Component, OnInit } from '@angular/core';
import { DashboardService } from '../dashboard.service';

interface User {
  username: string;
  password: string;
  contactNumber: string;
  gender: string;
  height: number;
  weight: number;
  age: number;
  targetweight: number;
  goal: string;
}

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  user: User | null = null;
  activeSection = 'user'; // Default section
  showCalorieTracker: boolean = false;
  constructor(private dashboardService: DashboardService) {}

  ngOnInit(): void {
    const userId = 1; // Set a specific user ID or retrieve dynamically
    this.loadUserData(userId);
  }

  loadUserData(id: number): void {
    this.dashboardService.getUserById(id).subscribe(
      (data: User) => {
        console.log('User data:', data);
        this.user = data; // Assign fetched data to `this.user`
      },
      (error: any) => {
        console.error('Error fetching user data:', error);
      }
    );
  }
  toggleCalorieTracker(): void {
    this.showCalorieTracker = !this.showCalorieTracker; // Toggle the state
  }
  showSection(section: string): void {
    this.activeSection = section;
  }
}
