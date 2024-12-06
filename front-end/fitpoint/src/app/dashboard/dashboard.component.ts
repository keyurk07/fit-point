import { Component, OnInit } from '@angular/core';
import { DashboardService } from '../dashboard.service';

interface User {
  userName: string;
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
  activeTab = 'dashboard';
  totalCaloriesLost = 0;
  caloriesToBurn = 0;
  userId: number | null = null;

  constructor(
    private dashboardService: DashboardService
  ) {}

  ngOnInit(): void {
    // Get the userId from localStorage
    this.userId = this.getUserIdFromLocalStorage();

    if (this.userId) {
      this.loadUserData(this.userId+1);  // Pass userId to load user data
    } else {
      console.error('No userId found');
    }
  }

  // Get the userId from localStorage
  getUserIdFromLocalStorage(): number | null {
    const storedUserId = localStorage.getItem('userId');
    return storedUserId ? parseInt(storedUserId, 10) : null;
  }

  loadUserData(id: number): void {
    this.dashboardService.getUserById(id).subscribe(
      (data: User) => {
        console.log('User data:', data);
        this.user = data;
        this.calculateCalories();
      },
      (error: any) => {
        console.error('Error fetching user data:', error);
      }
    );
  }

  calculateCalories(): void {
    if (this.user) {
      this.caloriesToBurn = 1800 - 1700;  // Dummy calculation, adjust as needed
    }
  }
}
