import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private httpclient: HttpClient) { }

  login(username:string,password:string){
    let apiurl="http://localhost:8081/user/login";
    let jsonRequestBody={
      "username":username,
      "password":password
    }
    return this.httpclient.post(apiurl,jsonRequestBody,{headers:{
      'Content-type':'application/json'
    }});
  }

  
}
