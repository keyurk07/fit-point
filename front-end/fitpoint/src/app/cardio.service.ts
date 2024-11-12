import { Injectable } from '@angular/core';
import {HttpClient,HttpHeaders} from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class CardioService {

  constructor(private http: HttpClient) { }
  add(exerciseType:string,distance:number,time:number){
    let url="http://localhost:9001/api/cardio-exercises";
    let jsonRequestBody:any={exerciseType:exerciseType,distance:distance,timeSpent:time};


    this.http.post(url,jsonRequestBody).subscribe(
      response=>{
        console.log("cardio-exercise added",response);
      },
      error=>{
        console.error("error!!- try adding again",error);
      }
    )

  }
}
