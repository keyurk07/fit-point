import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from '../login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  username: string = '';
  password: string = '';

  constructor(
    private loginservice: LoginService,
    private router: Router
  ) {}

  onSubmit() {
    console.log('Username:', this.username);
    console.log('Password:', this.password);

    // Call login service to authenticate user
    this.loginservice.login(this.username, this.password).subscribe({
      next: (response) => {
        // Login successful, store userId and token in localStorage
        console.log('Login successful');
        console.log('Login Response:', response);

        // Store userId and token in localStorage
        if (response && response.userId) {
          localStorage.setItem('userId', response.userId.toString()); // Convert userId to string
        }

        if (response && response.token) {
          localStorage.setItem('token', response.token); // Store token as string
        }

        // Navigate to the dashboard
        this.router.navigate(['/dashboard']);
      },
      error: (error) => {
        // Handle error and show an alert
        console.log('Login failed');
        console.log(error);
        alert('Invalid username or password');
      },
    });
  }

  // Retrieve the userId from localStorage (as a fallback method if needed)
  getUserId(): number | null {
    const storedUserId = localStorage.getItem('userId');
    return storedUserId ? parseInt(storedUserId, 10) : null;
  }
}
