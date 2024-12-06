import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';


interface LoginResponse {
  userId: number;   // Assuming userId is a number
  token: string;     // Assuming token is a string
}
@Injectable({
  providedIn: 'root'
})



export class LoginService {

  constructor(private httpclient: HttpClient) { }
  private _auth = false;

  get auth(): boolean {
    return this._auth;
  }

  logout() {
    this._auth = false;
  }

  // Define the login method with the proper response type
  login(username: string, password: string): Observable<LoginResponse> {
    const apiurl = "http://localhost:8081/user/login";
    const jsonRequestBody = {
      "username": username,
      "password": password
    };
    this._auth = true;

    // Send the login request and specify the response type
    return this.httpclient.post<LoginResponse>(apiurl, jsonRequestBody, {
      headers: {
        'Content-type': 'application/json'
      }
    });
  }
}
