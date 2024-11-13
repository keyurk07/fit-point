import { Injectable } from '@angular/core';
import {HttpClient,HttpHeaders} from '@angular/common/http';
import { Observable } from 'rxjs';
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
  calc(exerciseType: string, distance: number, time: number): Observable<number> {
    const urlcalc = "http://localhost:9001/api/cardio-exercises/calculate-calories";
    const jsonRequestBody = { exerciseType, distance, timeSpent: time };

    return this.http.post<number>(urlcalc, jsonRequestBody); // Return observable without subscribing
  }
  getAllExercises(): Observable<any >{
    const url = "http://localhost:9001/api/cardio-exercises"; // Replace with your actual endpoint
    return this.http.get<any>(url); // Returns an observable list of exercises
  }

  }
    

   


    

