import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

interface LeaderboardEntry {
  username: string;
  totalCaloriesBurned: number;
}

@Component({
  selector: 'app-reports',
  templateUrl: './reports.component.html',
  styleUrls: ['./reports.component.css']
})
export class ReportsComponent implements OnInit {
  ngOnInit(): void {
    throw new Error('Method not implemented.');
  }
  
}
