import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from '../login.service';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  constructor(private loginservice:LoginService, private router: Router) { }
  
  username: string = '';
  password: string = '';

  onSubmit() {
    console.log('Username:', this.username);
    console.log('Password:', this.password);
    this.loginservice.login(this.username, this.password).subscribe(
      {next:(response) => {
        console.log('login successful'),
        this.router.navigate(['/dashboard'])},
      error:(error) => {
        console.log(error)
        console.log('login failed'),
        alert('Invalid username or password')
      }}
    )
  }
}
