import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SignupService {

  constructor(private httpclient:HttpClient) { }

  add( username: string ,
    password:string,
    contactNumber: string,
    height: number | null,
    weight: number | null ,
    age: number | null ,
    target: string,
    gender: string,
    goal: string):Observable<any>{
    let url="http://localhost:9000/user/api";
    let jsonRequestBody:any={ userName:username ,password:password,
      contactNumber: contactNumber,
      height: height,
      weight: weight,
      age: age ,
      targetweight:target ,
      gender: gender,
      goal: goal };
      return this.httpclient.post(url,jsonRequestBody);
      


   
  }
}
