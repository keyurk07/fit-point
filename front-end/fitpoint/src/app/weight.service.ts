import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';

@Injectable({
  providedIn: 'root'
})
export class WeightService {

  constructor(private http: HttpClient) { }
  add(exerciseType:string,sets:number,reps:number,weight:number){
    let url="http://localhost:9001/api/weight-exercise";
    let jsonRequestBody:any={exerciseType:exerciseType,sets:sets,reps:reps,weight:weight};


    this.http.post(url,jsonRequestBody).subscribe(
      response=>{
        console.log("weight-exercise added",response);
      },
      error=>{
        console.error("error!!- try adding again",error);
      }
    )
  }
  calc(exerciseType:string,sets:number,reps:number,weight:number): Observable<number> {
    const urlcalc = "http://localhost:9001/api/weight-exercise/calculateCalories";
    let jsonRequestBody:any={exerciseType:exerciseType,sets:sets,reps:reps,weight:weight};

    return this.http.post<number>(urlcalc, jsonRequestBody); // Return observable without subscribing
  }
  getAllExercises(): Observable<any >{
    const url = "http://localhost:9001/api/weight-exercises"; // Replace with your actual endpoint
    return this.http.get<any>(url); // Returns an observable list of exercises
  }

}
