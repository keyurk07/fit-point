import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-exercise',
  templateUrl: './exercise.component.html',
  styleUrls: ['./exercise.component.css']
})
export class ExerciseComponent {
  constructor(private router: Router) { }
  addCardioExercise() {
    
    console.log("Adding a new cardio exercise");
  }

}
