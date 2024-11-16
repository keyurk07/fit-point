
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

  constructor(private dashboardService: DashboardService) {}

  ngOnInit(): void {
    const userId = 1; 
    this.loadUserData(userId);
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
    
      this.caloriesToBurn = 1800 - 1700;
    }
  }
}
