import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent {
  constructor(private router: Router) { }

  firstName: string = '';
  lastName: string = '';
  phoneNumber: string = '';
  height: number | null = null;
  weight: number | null = null;
  age: number | null = null;
  gender: string = '';
  goal: string = '';

  onSubmit() {
    console.log('First Name:', this.firstName);
    console.log('Last Name:', this.lastName);
    console.log('Phone Number:', this.phoneNumber);
    console.log('Height:', this.height);
    console.log('Weight:', this.weight);
    console.log('Age:', this.age);
    console.log('Gender:', this.gender);
    console.log('Goal:', this.goal);
    // Here you can add code to handle form submission, like sending data to a backend service
  }

}
