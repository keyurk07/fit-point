import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { SignupService } from '../signup.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent {
  constructor(private signupservice:SignupService) { }

  username: string = '';
  password:string='';
  contactNumber: string = '';
  height: number | null = null;
  weight: number | null = null;
  age: number | null = null;
  target: string = '';  
  gender: string = '';
  goal: string = '';

  onSubmit() {
    console.log('User Name:', this.username);
    console.log('password:', this.password);
    console.log('contact Number:', this.contactNumber);
    console.log('Height:', this.height);
    console.log('Weight:', this.weight);
    console.log('Age:', this.age);
    console.log('target :',this.target);
    console.log('Gender:', this.gender);
    console.log('Goal:', this.goal);
    this.signupservice.add(this.username, this.password, this.contactNumber,this.height,this.weight,this.age,this.target,this.gender,this.goal);

   
    // Here you can add code to handle form submission, like sending data to a backend service
  }

}
