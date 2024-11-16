import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

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
  login(username:string,password:string){
    let apiurl="http://localhost:8081/user/login";
    let jsonRequestBody={
      "username":username,
      "password":password
    }
    this._auth=true;
    return this.httpclient.post(apiurl,jsonRequestBody,{headers:{
      'Content-type':'application/json'
    }});
  }

  
}
